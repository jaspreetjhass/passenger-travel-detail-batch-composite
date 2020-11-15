package org.jp.passenger.travel.batch.scheduler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.jp.passenger.travel.batch.utility.ApplicationConstant;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@EnableScheduling
public class TravelDetailJobScheduler {

	@Autowired
	private JobLauncher jobLauncher;
	@Autowired
	private Job job;

	@Scheduled(cron = ApplicationConstant.CRON_EXPRESSION)
	public void schedule() throws JobExecutionAlreadyRunningException, JobRestartException,
			JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		log.info("enter into schedule method. ");
		final Map<String, JobParameter> config = new HashMap<>();
		config.put(ApplicationConstant.JOB_KEY, new JobParameter(new Date().getTime()));
		final JobParameters jobParameters = new JobParameters(config);
		job.getJobParametersIncrementer().getNext(jobParameters);
		jobLauncher.run(job, jobParameters);
		log.info("exit from schedule method. ");
	}

}
