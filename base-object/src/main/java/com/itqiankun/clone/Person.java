package com.itqiankun.clone;

import lombok.Getter;
import lombok.Setter;

/**
 * author: ma_qiankun
 * date:  2023/12/25
 **/
@Setter
@Getter
public class Person implements Cloneable{
	private String name;
	private City city;

	@Override
	public Person clone() throws CloneNotSupportedException {

		return (Person) super.clone();
	}

}
