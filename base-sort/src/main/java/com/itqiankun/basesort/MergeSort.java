package com.itqiankun.basesort;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;

/**
 *
 * 分治排序底层实现
 *
 * @author: ma_qiankun
 * @date: 2023/10/16
 **/
@Slf4j
public class MergeSort {
	public static void merge(int[] a, int low, int mid, int high) {
		int[] temp = new int[high - low + 1];
		int i = low;// 左指针
		int j = mid + 1;// 右指针
		int k = 0;
		// 把较小的数先移到新数组中
		while (i <= mid && j <= high) {
			if (a[i] < a[j]) {
				temp[k++] = a[i++];
			} else {
				temp[k++] = a[j++];
			}
		}
		// 把左边剩余的数移入数组
		while (i <= mid) {
			temp[k++] = a[i++];
		}
		// 把右边边剩余的数移入数组
		while (j <= high) {
			temp[k++] = a[j++];
		}
		// 把新数组中的数覆盖nums数组
		for (int k2 = 0; k2 < temp.length; k2++) {
			a[k2 + low] = temp[k2];
		}
	}

	public static void mergeSort(int[] a, int low, int high) {
		int mid = (low + high) / 2;
		if (low < high) {
			// 左边
			mergeSort(a, low, mid);
			// 右边
			mergeSort(a, mid + 1, high);
			// 左右归并
			merge(a, low, mid, high);
			System.out.println(Arrays.toString(a));
		}

	}

	@Test
	public void it_qk(){
		int a[] = { 50,10,90,30,70,40,80,60,20};
		mergeSort(a, 0, a.length - 1);
		log.info("it_qk result:" + Arrays.toString(a));
	}

	@Test
	public void it_qk_two(){
		int a[] = { 50,10,90,30,70,40,80,60,20, 100};
		mergeSort(a, 0, a.length - 1);
		log.info("it_qk_two result：" + Arrays.toString(a));
	}

}
