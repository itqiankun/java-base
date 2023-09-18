package com.itqiankun;

import com.google.common.collect.Lists;
import com.itqiankun.advanced.context.AdvancedPipelineDefaultContext;
import com.itqiankun.advanced.pipeline.CalculationAdvancedAdvancedPipeline;
import com.itqiankun.advanced.pipeline.FilterAdvancedAdvancedPipeline;
import com.itqiankun.advanced.pipeline.AdvancedPipeline;
import com.itqiankun.simple.context.SimplePipelineDefaultContext;
import com.itqiankun.simple.pipeline.CalculationAdvancedSimplePipeline;
import com.itqiankun.simple.pipeline.FilterAdvancedSimplePipeline;
import com.itqiankun.simple.pipeline.SimplePipeline;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;

/**
 * @author: ma_qiankun
 * @date: 2023/9/15
 **/
@Slf4j
public class Client {

	@Test
	public void it_qk_advanced(){
		AdvancedPipelineDefaultContext defaultContextPipeline = new AdvancedPipelineDefaultContext();

		List<AdvancedPipeline> pipelines = Lists.newArrayList();
		pipelines.add(new FilterAdvancedAdvancedPipeline());
		pipelines.add(new CalculationAdvancedAdvancedPipeline());

		defaultContextPipeline.setPipelines(pipelines);

		defaultContextPipeline.proceed();
	}

	@Test
	public void it_qk_simple(){
		SimplePipelineDefaultContext defaultContextPipeline = new SimplePipelineDefaultContext();

		List<SimplePipeline> pipelines = Lists.newArrayList();
		pipelines.add(new FilterAdvancedSimplePipeline());
		pipelines.add(new CalculationAdvancedSimplePipeline());

		defaultContextPipeline.setPipelines(pipelines);

		defaultContextPipeline.proceed();


	}
}
