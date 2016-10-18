package com.jobscheduler.dashboard.dao;

import com.jobscheduler.dashboard.model.Trigger;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * TriggerDao :
 *
 * @author wuhuachuan712@163.com
 * @date 16/10/9
 */

@Mapper
public interface TriggerDao{
    @Select("select " +
            "TRIGGER_NAME as triggerName," +
            "NEXT_FIRE_TIME as nextFireTime," +
            "PREV_FIRE_TIME as prevFireTime," +
            "TRIGGER_STATE as triggerState," +
            "START_TIME as startTime " +
            "from QRTZ_TRIGGERS")
    List<Trigger> findAll();
}
