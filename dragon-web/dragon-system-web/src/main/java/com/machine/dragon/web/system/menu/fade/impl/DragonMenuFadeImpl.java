package com.machine.dragon.web.system.menu.fade.impl;

import com.machine.dragon.common.tool.jackson.DragonJsonUtil;
import com.machine.dragon.service.system.menu.resource.DragonMenuResource;
import com.machine.dragon.service.system.menu.resource.outvo.DragonMenuDetailOutVO;
import com.machine.dragon.service.system.menu.resource.outvo.DragonMenuListOutVO;
import com.machine.dragon.web.system.menu.contoller.response.DragonMenuDetailResponse;
import com.machine.dragon.web.system.menu.contoller.response.DragonMenuTreeResponse;
import com.machine.dragon.web.system.menu.fade.DragonMenuFade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Slf4j
@Component
public class DragonMenuFadeImpl implements DragonMenuFade {

    @Autowired
    private DragonMenuResource dragonMenuResource;

    @Override
    public DragonMenuDetailResponse queryMenuDetail(Long menuId) {
        DragonMenuDetailOutVO detailOutVO = dragonMenuResource.getByMenuId(menuId);
        return DragonJsonUtil.copy(detailOutVO, DragonMenuDetailResponse.class);
    }

    @Override
    public List<DragonMenuTreeResponse> queryMenuTree() {
        List<DragonMenuListOutVO> outVOList = dragonMenuResource.selectMenuList();
        if (CollectionUtils.isEmpty(outVOList)) {
            return Collections.emptyList();
        }
        return convertList2Tree(outVOList);
    }

    private List<DragonMenuTreeResponse> convertList2Tree(List<DragonMenuListOutVO> outVOList) {
        List<DragonMenuTreeResponse> responses = new ArrayList<>();

        List<DragonMenuTreeResponse> _temps = new ArrayList<>();
        for (DragonMenuListOutVO a : outVOList) {
            DragonMenuTreeResponse _response = DragonJsonUtil.copy(a, DragonMenuTreeResponse.class);
            _response.setHasChildren(false);
            _temps.add(_response);
        }

        //生成id<-->value 集合,用于判断
        Map<Long, DragonMenuTreeResponse> menuOutBoMap = new HashMap<>(_temps.size());
        for (DragonMenuTreeResponse b : _temps) {
            menuOutBoMap.put(b.getMenuId(), b);
        }

        //组装tree
        for (DragonMenuTreeResponse c : _temps) {
            if (!menuOutBoMap.containsKey(c.getParentId())) {
                //parentId没找到,是顶级菜单
                responses.add(c);
            } else {
                DragonMenuTreeResponse p = menuOutBoMap.get(c.getParentId());
                p.setHasChildren(true);
                List<DragonMenuTreeResponse> children = p.getChildren();
                if (CollectionUtils.isEmpty(children)) {
                    children = new ArrayList<>();
                    p.setChildren(children);
                    children.add(c);
                } else {
                    //插入排序,插入数据
                    boolean added = false;
                    for (int i = 0; i < children.size(); i++) {
                        DragonMenuTreeResponse _response = children.get(i);
                        if (c.getSort() > _response.getSort()) {
                            children.add(i, c);
                            added = true;
                            break;
                        }
                    }
                    if (!added) {
                        children.add(c);
                    }
                }
            }
        }

        responses.sort(Comparator.comparing(DragonMenuTreeResponse::getSort).reversed());
        return responses;
    }

}
