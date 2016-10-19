package com.jobscheduler.dashboard.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Job :
 *
 * @author wuhuachuan712@163.com
 * @date 16/10/9
 */

@Data
public class Job {
    private String schedName;
    private String jobName;
    private String jobGroup;
    private String jobClassName;
    private String isDurable;
    private String isNonConcurrent;
    private String requestsRecovery;

    //一个 job 可以对应多个 trigger
    private List<Trigger> triggerList = new ArrayList<>(5);
}
