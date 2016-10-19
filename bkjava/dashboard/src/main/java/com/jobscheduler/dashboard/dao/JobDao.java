package com.jobscheduler.dashboard.dao;

import com.jobscheduler.dashboard.model.Job;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * JobDao :
 *
 * @author wuhuachuan712@163.com
 * @date 16/10/9
 */

@Mapper
public interface JobDao {
    @Select("select " +
            "JOB_NAME as jobName," +
            "JOB_CLASS_NAME as jobClassName," +
            "IS_NONCONCURRENT as isNonConcurrent " +
            "from QRTZ_JOB_DETAILS")
    List<Job> findAll();

    @Select("select " +
            "SCHED_NAME as schedName," +
            "JOB_NAME as jobName," +
            "JOB_GROUP as jobGroup," +
            "JOB_CLASS_NAME as jobClassName," +
            "IS_DURABLE as isDurable," +
            "IS_NONCONCURRENT as isNonConcurrent," +
            "REQUESTS_RECOVERY as requestsRecovery " +
            "from QRTZ_JOB_DETAILS " +
            "where JOB_NAME = #{jobName}")
    Job findJobByJobName(final String jobName);
}
