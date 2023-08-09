package com.itqiankun.statistics.time;

import cn.hutool.core.date.StopWatch;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author: ma_qiankun
 * @date: 2023/8/9
 **/
@Slf4j
public class StopWatchDemo {

	@Test
	public void it_qk_statistic_time() throws InterruptedException {
		StopWatch stopWatch = new StopWatch("任务名称");
		// 任务1
		stopWatch.start("任务一");
		Thread.sleep(1000);
		stopWatch.stop();
		// 任务2
		stopWatch.start("任务一");
		Thread.sleep(2000);
		stopWatch.stop();
		// 打印出耗时
		log.info("打印时间:{}", stopWatch.prettyPrint());
	}

}
