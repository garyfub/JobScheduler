package com.jobscheduler.dashboard.controller;

import com.jobscheduler.dashboard.model.Trigger;
import com.jobscheduler.dashboard.service.TriggerService;
import com.jobscheduler.dashboard.utils.ReturnTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * TriggerController :
 *
 * @author wuhuachuan712@163.com
 * @date 16/10/9
 */

@Slf4j
@RestController
public class TriggerController {

    @Autowired
    private TriggerService triggerService;

    @RequestMapping(value = "triggers",method = RequestMethod.GET)
    public Object findTriggers(){
        return new ReturnTemplate(triggerService.findTriggers());
    }

    @RequestMapping(value = "/trigger/{triggerName}",method = RequestMethod.GET)
    public Object findTrigger(@PathVariable(name = "triggerName") final String triggerName){
        log.info("triggerName = {}.",triggerName);

        if(!StringUtils.hasText(triggerName)){
            throw new IllegalArgumentException("triggerName is invalid");
        }

        Trigger trigger = triggerService.findTriggerByTriggerName(triggerName);

        return new ReturnTemplate(trigger);
    }
}
