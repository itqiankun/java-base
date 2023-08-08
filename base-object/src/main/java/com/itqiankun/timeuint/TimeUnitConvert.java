package com.itqiankun.timeuint;

import java.util.concurrent.TimeUnit;

/**
 * @author: ma_qiankun
 * @date: 2023/6/11
 **/
public class TimeUnitConvert {
	public static void main(String[] args) {
		//1天转24个小时
		System.out.println( TimeUnit.DAYS.toHours( 1 ) );

		//把3天转化成小时
		System.out.println( TimeUnit.DAYS.toHours(3) );

		//1小时有3600秒
		System.out.println( TimeUnit.HOURS.toSeconds( 1 ));
	}
}
