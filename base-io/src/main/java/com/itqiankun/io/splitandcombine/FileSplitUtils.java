package com.itqiankun.io.splitandcombine;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author: ma_qiankun
 * @date: 2023/10/11
 **/

public class FileSplitUtils {

	/**
	 * 默认切割大小
	 */
	public static final int DEFAULT_SIZE = 1024 * 1024 * 10;

	public static void split(File srcFile, String outputDir) throws IOException {
		split(srcFile, outputDir, DEFAULT_SIZE);
	}

	public static void split(File srcFile, String outputDir, int size) throws IOException {
		try (
				FileInputStream inputStream = FileUtils.openInputStream(srcFile);
		) {

			File temp = null;
			byte[] buffer = new byte[size];
			int len = 0;

			// IOUtils.read(inputStream, buffer) 读取完后，再读取则返回值为0
			for (int i = 1; (len = IOUtils.read(inputStream, buffer)) > 0; i++) {
				temp = FileUtils.getFile(outputDir, String.valueOf(i));
				FileUtils.writeByteArrayToFile(temp, buffer, 0, len);
			}

		}
	}

	public static void combinateFormChips(String inputDir, File destFile) throws IOException {
		File inputPath = FileUtils.getFile(inputDir);
		String[] files = inputPath.list();

		try (
				FileOutputStream outputStream = FileUtils.openOutputStream(destFile);
		) {

			// 按文件名排序
			Arrays.sort(files);
			for (String fileName : files) {
				File file = FileUtils.getFile(inputPath, fileName);
				byte[] data = FileUtils.readFileToByteArray(file);

				IOUtils.write(data, outputStream);
			}
		}
	}

	public static void main(String[] args) {
		try {
			File srcFile = FileUtils.getFile("/Users/mqk/Desktop/splitandcombine/hello.om");
			String chipsDir = "/Users/mqk/Desktop/splitandcombine/split";
			FileSplitUtils.split(srcFile, chipsDir);

			File destFile = FileUtils.getFile("/Users/mqk/Desktop/splitandcombine/combine/combine.om");
			FileSplitUtils.combinateFormChips(chipsDir, destFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
