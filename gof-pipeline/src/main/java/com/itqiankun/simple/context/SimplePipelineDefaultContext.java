package com.itqiankun.simple.context;

import com.itqiankun.advanced.context.AdvancedPipelineContext;
import com.itqiankun.simple.pipeline.SimplePipeline;

import java.util.List;

/**
 * @author: ma_qiankun
 * @date: 2023/9/15
 **/
public class SimplePipelineDefaultContext implements AdvancedPipelineContext {

	public List<SimplePipeline> pipelines;


	@Override
	public void proceed() {
		for (int i = 0; i < pipelines.size(); i++) {
			SimplePipeline simplePipeline = pipelines.get(i);
			simplePipeline.invoke();
		}
	}


	public void setPipelines(List<SimplePipeline> pipelines) {
		this.pipelines = pipelines;
	}
}
