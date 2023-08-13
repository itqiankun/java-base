package com.itqiankun.finaldemo;

import lombok.Data;

/**
 * @author: ma_qiankun
 * @date: 2023/8/11
 **/
@Data
public final class FatherFinal {

	public String name;

	public void hello(){
		System.out.println("hello");
	}

	public static void main(String[] args) {
		System.out.println("hello");
	}
}
