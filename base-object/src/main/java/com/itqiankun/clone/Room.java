package com.itqiankun.clone;

import lombok.Getter;
import lombok.Setter;

/**
 * author: ma_qiankun
 * date:  2023/12/25
 **/
@Getter
@Setter
public class Room implements Cloneable{
	private String location;

	@Override
	public Room clone() throws CloneNotSupportedException {
		return (Room) super.clone();
	}
}
