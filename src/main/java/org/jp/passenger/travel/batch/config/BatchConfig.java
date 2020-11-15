package org.jp.passenger.travel.batch.config;

import org.jp.passenger.travel.batch.tasklet.LoadDBData;
import org.jp.passenger.travel.batch.utility.ApplicationConstant;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersIncrementer;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchConfig {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	public JobParametersIncrementer jobParametersIncrementer() {
		return new RunIdIncrementer();
	}

	@Bean
	public Job job(final JobParametersIncrementer jobParametersIncrementer, final Step step) {
		return jobBuilderFactory.get(ApplicationConstant.TRAVEL_DETAIL_JOB).incrementer(jobParametersIncrementer)
				.start(step).build();
	}

	@Bean
	public Step step(final LoadDBData loadDBData) {
		return stepBuilderFactory.get(ApplicationConstant.FETCH_DETAIL_STEP).tasklet(loadDBData).build();
	}

}
