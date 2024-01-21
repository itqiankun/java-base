package com.itqiankun;

import java.lang.instrument.Instrumentation;

/**
 * author: ma_qiankun
 * date:  2023/12/31
 **/
public class PreDemo {
	public static void premain(String args, Instrumentation inst) throws Exception{
		System.out.println(args);
		inst.addTransformer(new CostTransformer(), true);

	}
}
