package com.machine.dragon.sdk.isc.rabbit.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 注意:
 * 这边单独第线程池处理任务,涉及到租户Id以及相关从ThreadLocal获取信息的要自己处理
 * demo参考:https://www.cnblogs.com/jice/p/9606579.html
 */
@Slf4j
@Component
public class DragonRabbitCommitExecutor extends TransactionSynchronizationAdapter implements Executor {
    private final ThreadLocal<List<Runnable>> RUNNABLES = new ThreadLocal<>();
    private ExecutorService threadPool = new ThreadPoolExecutor(3, 10, 0L,
            TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());

    @Override
    public void execute(Runnable runnable) {
        if (log.isDebugEnabled()) {
            log.debug("Submitting new runnable {} to run after commit", runnable);
        }
        if (!TransactionSynchronizationManager.isSynchronizationActive()) {
            if (log.isDebugEnabled()) {
                log.debug("Transaction synchronization is NOT ACTIVE. Executing right now runnable {}", runnable);
            }
            runnable.run();
            return;
        }
        List<Runnable> threadRunnables = RUNNABLES.get();
        if (threadRunnables == null) {
            threadRunnables = new ArrayList<>();
            RUNNABLES.set(threadRunnables);
            TransactionSynchronizationManager.registerSynchronization(this);
        }
        threadRunnables.add(runnable);
    }

    @Override
    public void afterCommit() {
        List<Runnable> threadRunnables = RUNNABLES.get();
        if (log.isDebugEnabled()) {
            log.debug("Transaction successfully committed, executing {} runnables", threadRunnables.size());
        }
        for (int i = 0; i < threadRunnables.size(); i++) {
            Runnable runnable = threadRunnables.get(i);
            if (log.isDebugEnabled()) {
                log.debug("Executing runnable {}", runnable);
            }
            try {
                threadPool.execute(runnable);
            } catch (RuntimeException e) {
                log.error("Failed to execute runnable " + runnable, e);
            }
        }
    }

    @Override
    public void afterCompletion(int status) {
        if (log.isDebugEnabled()) {
            log.debug("Transaction completed with status {}", status == STATUS_COMMITTED ? "COMMITTED" : "ROLLED_BACK");
        }
        RUNNABLES.remove();
    }

}