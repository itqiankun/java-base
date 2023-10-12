package com.itqiankun.objectbyte;

import com.alibaba.fastjson.JSONObject;
import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import org.apache.lucene.util.RamUsageEstimator;

/**
 * @author: ma_qiankun
 * @date: 2023/10/12
 **/
public class ObjectByteDemo {
	public static void main(String[] args) {


		String str="{\n" +
				"    \"isNormalEffect\": true,\n" +
				"    \"bbox\": [\n" +
				"        [\n" +
				"            {\n" +
				"                \"bbox\": [\n" +
				"                    1402,\n" +
				"                    324,\n" +
				"                    1450,\n" +
				"                    361\n" +
				"                ],\n" +
				"                \"conf\": [\n" +
				"                    \"0.71\"\n" +
				"                ],\n" +
				"                \"label\": [\n" +
				"                    \"未戴口罩\"\n" +
				"                ],\n" +
				"                \"match_id\": \"\",\n" +
				"                \"matched\": false,\n" +
				"                \"status\": false\n" +
				"            }\n" +
				"        ]\n" +
				"    ],\n" +
				"    \"colorStyle\": 1,\n" +
				"    \"imgCallbackList\": [\n" +
				"        \"http://115.236.176.154:30000/webdav/om/huizhi/photo/callback/20231012/1712336608134430720.jpg\"\n" +
				"    ],\n" +
				"    \"label\": [],\n" +
				"    \"isNormalRun\": true,\n" +
				"    \"labelSelect\": [],\n" +
				"    \"imgList\": [\n" +
				"        \"http://115.236.176.154:30000/webdav//data/img/20231012/orgIdmu_100074/videoId18086/1712332271559639040.jpg\"\n" +
				"    ]\n" +
				"}";
		JSONObject jsonObject = JSONObject.parseObject(str);

		System.out.println(str.getBytes().length);
		System.out.println(RamUsageEstimator.sizeOf(jsonObject));
		System.out.println(ObjectSizeCalculator.getObjectSize(jsonObject));

		System.out.println(RamUsageEstimator.shallowSizeOf(jsonObject));
		System.out.println(RamUsageEstimator.shallowSizeOf(Integer.valueOf(str.getBytes().length)));
		System.out.println(RamUsageEstimator.shallowSizeOf(Double.valueOf(str.getBytes().length)));

	}
}
