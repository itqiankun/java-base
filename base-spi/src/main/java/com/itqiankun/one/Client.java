package com.itqiankun.one;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author: ma_qiankun
 * @date: 2023/11/8
 **/
@Slf4j
public class Client {

	@Test
	public void testSpi() {
		ServiceLoader<SpiService> serviceLoader = ServiceLoader.load(SpiService.class);
		Iterator<SpiService> iterator = serviceLoader.iterator();
		while (iterator.hasNext()) {
			SpiService spiService = iterator.next();
			spiService.hello();
		}
	}




}
