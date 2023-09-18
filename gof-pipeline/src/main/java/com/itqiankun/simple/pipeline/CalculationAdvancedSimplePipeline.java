package com.itqiankun.simple.pipeline;

/**
 * @author: ma_qiankun
 * @date: 2023/9/15
 **/
public class CalculationAdvancedSimplePipeline implements SimplePipeline {


	@Override
	public void invoke() {
		System.out.println("CalculationPipeline invoke execute");

	}
}
