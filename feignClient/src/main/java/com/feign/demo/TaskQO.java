package com.feign.demo;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Data
public class TaskQO extends TestQO {
    @NotBlank(
            message = "任务标题不能为空"
    )
    private String taskTitle;
    @NotNull(
            message = "合作方id不能为空"
    )
    private Integer partnerId;
    @NotNull(
            message = "品牌id不能为空"
    )
    private Integer brandId;
    @NotNull(
            message = "类目id不能为空"
    )
    private Integer categoryId;
    private Integer modelId;
    @NotNull(
            message = "任务类型不能为空"
    )
    private Integer taskType;
    @NotNull(
            message = "任务优先级不能为空"
    )
    private Integer taskPriority;
    private Integer taskStatus;
    private Integer[] spiderPlatformId;
    private String[] spiderSortType;
    private String[] spiderKeyword;
    private String cleanKeyword;
    private Integer userId;
    private String remark;
    private Integer timedRuleType;
    private Integer timedDimension;
    private Integer dimensionValue;
    private Integer hour;
    private String startTime;
    private String endTime;
    private String runTime;
    private Date runTimeDate;
    private String saveKeyword;
    private Integer crawlerType;
    private Integer cleanPriceType;
    private String cleanPrice;
    private String savePrice;
    private Integer dataIntegrity;
    private Integer platformId;
    private String sortType;
    private String keyword;
    private Integer source;
    String linkQoList;
}

