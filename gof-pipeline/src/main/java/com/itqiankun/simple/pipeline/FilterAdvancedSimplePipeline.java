package com.itqiankun.simple.pipeline;

/**
 * @author: ma_qiankun
 * @date: 2023/9/15
 **/
public class FilterAdvancedSimplePipeline implements SimplePipeline {


	@Override
	public void invoke() {
		System.out.println("FilterPipeline invoke execute");

	}
}
