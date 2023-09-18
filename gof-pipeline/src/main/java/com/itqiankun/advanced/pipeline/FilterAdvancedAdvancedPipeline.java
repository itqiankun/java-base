package com.itqiankun.advanced.pipeline;

import com.itqiankun.advanced.context.AdvancedPipelineContext;

/**
 * @author: ma_qiankun
 * @date: 2023/9/15
 **/
public class FilterAdvancedAdvancedPipeline implements AdvancedPipeline {


	@Override
	public void invoke(AdvancedPipelineContext contextPipeline) {
		System.out.println("FilterPipeline invoke execute");
		contextPipeline.proceed();
	}
}
