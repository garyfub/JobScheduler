package com.jobscheduler.dashboard.model;

import lombok.Data;

/**
 * Trigger :
 *
 * @author wuhuachuan712@163.com
 * @date 16/10/9
 */

@Data
public class Trigger {
    private String schedName;
    private String triggerName;
    private String triggerGroup;
    private String jobName;
    private long nextFireTime;
    private long prevFireTime;
    private String triggerState;
}
