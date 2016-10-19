package com.jobscheduler.dashboard.serviceImpl;

import com.jobscheduler.dashboard.dao.TriggerDao;
import com.jobscheduler.dashboard.model.Trigger;
import com.jobscheduler.dashboard.service.TriggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TriggerServiceImpl :
 *
 * @author wuhuachuan712@163.com
 * @date 16/10/9
 */

@Service
public class TriggerServiceImpl implements TriggerService{

    @Autowired
    private TriggerDao triggerDao;

    @Override
    public List<Trigger> findTriggers() {
        return triggerDao.findAll();
    }

    @Override
    public Trigger findTriggerByTriggerName(final String triggerName) {
        return triggerDao.findTriggerByTriggerName(triggerName);
    }

    @Override
    public List<Trigger> findTriggerByJobName(final String jobName) {
        return triggerDao.findTriggerByJobName(jobName);
    }
}
