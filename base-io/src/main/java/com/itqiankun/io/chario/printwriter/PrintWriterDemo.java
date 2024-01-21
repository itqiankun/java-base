package com.itqiankun.io.chario.printwriter;

import org.junit.Test;

import java.io.*;

/**
 * @author: ma_qiankun
 * @date: 2023/8/14
 **/
public class PrintWriterDemo {
	@Test
	public void it_qk_print_writer_out_file() throws Exception {
		PrintWriter printWriter = new PrintWriter("it_qk_print_writer_out_file.txt");
		printWriter.write("dataSourceKey: defaultDS\n" +
				"destination: example\n" +
				"groupId: g1\n" +
				"outerAdapterKey: mysql1\n" +
				"concurrent: true\n" +
				"dbMapping:\n" +
				"  database: huizhi\n" +
				"  table: tb_video_task_result_alarm_1001\n" +
				"  targetTable: tb_video_task_result_alarm_1001\n" +
				"  targetPk:\n" +
				"    id: id\n" +
				"  mapAll: true\n" +
				"  commitBatch: 3000 # 批量提交的大小\n");
		printWriter.close();
	}
}
