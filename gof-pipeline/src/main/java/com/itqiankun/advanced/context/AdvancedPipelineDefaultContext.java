package com.itqiankun.advanced.context;

import com.itqiankun.advanced.pipeline.AdvancedPipeline;

import java.util.List;

/**
 * @author: ma_qiankun
 * @date: 2023/9/15
 **/
public class AdvancedPipelineDefaultContext implements AdvancedPipelineContext {

	public List<AdvancedPipeline> pipelines;

	public Integer index = -1;

	@Override
	public void proceed() {
		if(pipelines.size() - 1 == index){
			System.out.println("链路执行完毕");
		} else {
			index++;
			AdvancedPipeline pipeline = pipelines.get(index);
			pipeline.invoke(this);
		}
	}


	public void setPipelines(List<AdvancedPipeline> pipelines) {
		this.pipelines = pipelines;
	}
}
