package com.itqiankun.statistics.time;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author: ma_qiankun
 * @date: 2023/11/29
 **/
@Slf4j
public class LocalDateToString {
	@Test
	public void it_qk(){
		LocalDate localDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate = localDate.format(formatter);
		System.out.println("Formatted String: " +  formattedDate);

		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyyMMdd");
		System.out.println("Formatted String: " +  localDate.format(formatter1));


		System.out.println("default LocalDate String: " +  localDate);
	}


}
