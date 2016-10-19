package com.jobscheduler.dashboard.dao;

import com.jobscheduler.dashboard.model.Trigger;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
            "JOB_NAME as jobName " +
            "from QRTZ_TRIGGERS")
    List<Trigger> findAll();

    @Select("select " +
            "SCHED_NAME as schedName," +
            "TRIGGER_NAME as triggerName," +
            "TRIGGER_GROUP as triggerGroup," +
            "JOB_NAME as jobName," +
            "NEXT_FIRE_TIME as nextFireTime," +
            "PREV_FIRE_TIME as prevFireTime," +
            "TRIGGER_STATE as triggerState " +
            "from QRTZ_TRIGGERS " +
            "where TRIGGER_NAME = #{triggerName}")
    Trigger findTriggerByTriggerName(@Param("triggerName") final String triggerName);

    @Select("select " +
            "SCHED_NAME as schedName," +
            "TRIGGER_NAME as triggerName," +
            "TRIGGER_GROUP as triggerGroup," +
            "JOB_NAME as jobName," +
            "NEXT_FIRE_TIME as nextFireTime," +
            "PREV_FIRE_TIME as prevFireTime," +
            "TRIGGER_STATE as triggerState " +
            "from QRTZ_TRIGGERS " +
            "where JOB_NAME = #{jobName}")
    List<Trigger> findTriggerByJobName(@Param("jobName") final String jobName);
}
