package com.itqiankun;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * author: ma_qiankun
 * date:  2023/12/14
 **/
public class ArrayListSubListDemo {

	@Test
	public void it_qk(){
		List<String> strings = Lists.newArrayList();
		strings.add("hello");
		strings.add("world");
		strings.add("world1");
		strings.add("world2");
		strings.add("world3");
		strings.add("world4");
		List<String> strings1 = strings.subList(1, 3);
		System.out.println(strings1);
		strings.add("new");
		System.out.println(strings1);
	}

}
