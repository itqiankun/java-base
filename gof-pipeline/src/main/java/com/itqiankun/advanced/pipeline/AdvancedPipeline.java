package com.itqiankun.advanced.pipeline;

import com.itqiankun.advanced.context.AdvancedPipelineContext;

/**
 * @author: ma_qiankun
 * @date: 2023/9/15
 **/
public interface AdvancedPipeline {
	void invoke(AdvancedPipelineContext contextPipeline);
}
