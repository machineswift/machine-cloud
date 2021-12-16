package com.machine.dragon.common.core.bean.page;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@Data
@ApiModel
@NoArgsConstructor
public class DragonPage<T> {

    public DragonPage(Long current, Long size) {
        this(current, size, 0L);
    }

    public DragonPage(Long current, Long size, Long total) {
        this.current = current;
        this.size = size;
        this.total = total;
    }

    public DragonPage(Long current, Long size, Long total, List records) {
        this.current = current;
        this.size = size;
        this.total = total;
        this.records = records;
    }

    public static <T> DragonPage<T> convert2DragonPage(IPage<T> page) {
        return new DragonPage(page.getCurrent(), page.getSize(), page.getTotal(), page.getRecords());
    }

    @ApiModelProperty(name = "current", value = "当前页", dataType = "int", position = 10, required = true)
    private Long current;

    @ApiModelProperty(name = "current", value = "每页的数量", dataType = "int", position = 20, required = true)
    private Long size;

    @ApiModelProperty(name = "total", value = "总数", dataType = "int", position = 30, required = true)
    private Long total;

    @ApiModelProperty(name = "records", value = "查询数据列表", dataType = "list", position = 40, required = true)
    protected List<T> records = Collections.emptyList();

}
