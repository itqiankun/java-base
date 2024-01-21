package com.itqiankun.statistics.time;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author: ma_qiankun
 * @date: 2023/11/29
 **/
@Slf4j
public class LocalDateTimeToLocalDateDemo {
	@Test
	public void it_qk(){

		LocalDateTime now = LocalDateTime.now();
		LocalDate localDate = now.toLocalDate();
		LocalTime localTime = now.toLocalTime();
		System.out.println(localDate);
		System.out.println(localTime);


	}


}
