package com.itqiankun.bitmap;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.BitSet;

/**
 * author: ma_qiankun
 * date:  2023/12/21
 **/
@Slf4j
public class BitSetDemo {
	@Test
	public void it_qk(){
		BitSet bitSet = new BitSet();
		bitSet.set(100);
		System.out.println(bitSet.get(100));
		System.out.println(bitSet.get(11));

	}
	@Test
	public void it_qk1(){
		System.out.println(10 % 10);
	}

}
