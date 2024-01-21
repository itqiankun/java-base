package com.itqiankun.demo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * author: ma_qiankun
 * date:  2023/12/25
 **/

public class Hello {
	public static void main(String[] args) {
		int[] ints = new int[10];


	}

	@Test
	public void it_qk_1(){
		int aa[] = {2,9,7,44,555,49,38,34,303,17,27,24};
		int min=Integer.MAX_VALUE;
		int max=Integer.MIN_VALUE;
		for (int i = 0; i < aa.length; i++) {
			if(aa[i]<min){
				min=aa[i];
			}
			if(aa[i]>max){
				max=aa[i];
			}
		}

		List[] buckets = new ArrayList[max+1];
		int length = buckets.length;
		for (int i = 0; i < length; i++) {
			buckets[i] = new ArrayList();
		}

		for (int i = 0; i < aa.length; i++) {
			int index = aa[i] % (max+1);
			buckets[index].add(aa[i]);
		}

		// 桶排序打印
		for (int i = 0; i < buckets.length; i++) {
			List bucket = buckets[i];
			for (int j = 0; j < bucket.size(); j++) {
				Integer o = (Integer)bucket.get(j);
				System.out.print(o);
				System.out.print(",");
			}
		}
		System.out.println();


		// 相差最小值
		int minDiff = Integer.MAX_VALUE;
		// 最小值
		int preNum = 0;
		// 最小值所在的索引位置
		int minIndex = 0;
		for (int i = 0; i < buckets.length; i++) {
			List bucket = buckets[i];
			if(bucket.size() !=0){
				preNum=(Integer)bucket.get(0);
				minIndex = preNum;
				break;
			}
		}



		for (int i = 0; i < buckets.length; i++) {
			List bucket = buckets[i];
			for (int j = 0; j < bucket.size(); j++) {
				// 排除最小值不能再进行比较了
				if(minIndex != i){
					Integer currentNum = (Integer)bucket.get(j);
					int currentDiff = currentNum - preNum;
					if(currentDiff<minDiff){
						minDiff=currentDiff;
					}
					preNum = currentNum;
				}
			}
		}
		System.out.println(minDiff);

	}










	@Test
	public void it_qk(){
		int aa[] = {1,8,7,44,42,46,38,34,33,17,15,16,27,28,24};




		List[] buckets = new ArrayList[9];
		int length = buckets.length;
		for (int i = 0; i < length; i++) {
			buckets[i] = new ArrayList();
		}

		for (int i = 0; i < aa.length; i++) {
			int index = aa[i] / 10;
			buckets[index].add(aa[i]);
		}

		for (int i = 0; i < buckets.length; i++) {
			buckets[i].sort(null);
		}


		for (int i = 0; i < buckets.length; i++) {
			List bucket = buckets[i];
			for (int j = 0; j < bucket.size(); j++) {
				Integer o = (Integer)bucket.get(j);
				System.out.print(o);
				System.out.print(",");
			}
		}
		System.out.println();






	}


}
