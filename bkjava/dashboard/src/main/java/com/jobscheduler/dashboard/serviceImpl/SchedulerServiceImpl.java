package com.jobscheduler.dashboard.serviceImpl;

import com.jobscheduler.dashboard.dao.SchedulerDao;
import com.jobscheduler.dashboard.service.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * SchedulerServiceImpl :
 *
 * @author wuhuachuan712@163.com
 * @date 16/10/9
 */

@Service
public class SchedulerServiceImpl implements SchedulerService {

    @Autowired
    private SchedulerDao schedulerDao;
}
