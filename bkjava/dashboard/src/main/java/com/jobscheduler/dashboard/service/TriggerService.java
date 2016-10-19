package com.jobscheduler.dashboard.service;

import com.jobscheduler.dashboard.model.Trigger;

import java.util.List;

/**
 * TriggerService :
 *
 * @author wuhuachuan712@163.com
 * @date 16/10/9
 */
public interface TriggerService {
    List<Trigger> findTriggers();

    Trigger findTriggerByTriggerName(final String triggerName);
}
