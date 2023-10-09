package com.itqiankun.threaddemo;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author: ma_qiankun
 * @date: 2023/10/8
 **/
@Slf4j
public class ThreadTest {

	@Test
	public void it_qk_test(){
		Thread thread = Thread.currentThread();
		log.info("当前线程命令:{}", thread.getName());
		log.info("当前线程优先级:{}", thread.getPriority());
	}

	public static void main(String[] args) {
		String str ="{\n" +
				"    \"isFast\": false,\n" +
				"    \"processConfig\": [\n" +
				"        {\n" +
				"            \"parallelEndType\": \"ALL\",\n" +
				"            \"list\": [\n" +
				"                {\n" +
				"                    \"dependonBizIds\": \"-1\",\n" +
				"                    \"input\": \"@meta\",\n" +
				"                    \"versionId\": \"1.0.0\",\n" +
				"                    \"isWarning\": true,\n" +
				"                    \"bizName\": \"人员计数\",\n" +
				"                    \"bizId\": \"OD210_210_001835_008_RFjS5fhx\"\n" +
				"                }\n" +
				"            ]\n" +
				"        }\n" +
				"    ],\n" +
				"    \"warningConfig\": [\n" +
				"        {\n" +
				"            \"nodeName\": \"告警节点\",\n" +
				"            \"dependonBizIds\": \"OD210_210_001835_008_RFjS5fhx\",\n" +
				"            \"preId\": \"OD210_210_001835_008_RFjS5fhx\",\n" +
				"            \"conditions\": [\n" +
				"                {\n" +
				"                    \"dependonBizIds\": \"OD210_210_001835_008_RFjS5fhx\",\n" +
				"                    \"warningScopes\": [],\n" +
				"                    \"warningLabel\": [],\n" +
				"                    \"conditionType\": \"ANY\",\n" +
				"                    \"list\": [\n" +
				"                        {\n" +
				"                            \"imgId\": \"@OD210_210_001835_008_RFjS5fhx.subResult[idx].requestResult.results.RESOURCE_59489[idx].id\",\n" +
				"                            \"compareSymbol\": 12,\n" +
				"                            \"value\": \"false\",\n" +
				"                            \"key\": \"@OD210_210_001835_008_RFjS5fhx.subResult[idx].requestResult.results.RESOURCE_59489[idx].status\"\n" +
				"                        }\n" +
				"                    ],\n" +
				"                    \"desc\": \"注意！当前画面出现告警，请关注！\"\n" +
				"                }\n" +
				"            ],\n" +
				"            \"warningEndStrategy\": \"END\"\n" +
				"        }\n" +
				"    ],\n" +
				"    \"callbackInfo\": \"https://fos.fjecloud.com/callback//callback/task\",\n" +
				"    \"tbAbilityArrangeSchedulerBaseUrl\": \"http://218.207.177.28:32674/om/new/hz/v1/task/addProcessTask\",\n" +
				"    \"dest\": {\n" +
				"        \"linkage\": {\n" +
				"            \"bucketName\": \"omeye\",\n" +
				"            \"password\": \"YjlQMFBKVFNtVlN5SmRGSQ==\",\n" +
				"            \"url\": \"https://fos.fjecloud.com:8888/minio/\",\n" +
				"            \"username\": \"VisionOS\"\n" +
				"        },\n" +
				"        \"destType\": \"webdav\"\n" +
				"    },\n" +
				"    \"aiConfig\": {\n" +
				"        \"OD210_210_001835_008_RFjS5fhx\": {\n" +
				"            \"kwargs\": {\n" +
				"                \"displayAllBboxes\": true,\n" +
				"                \"coldActivation\": {\n" +
				"                    \"includeClasses\": \"[]\",\n" +
				"                    \"type\": \"\"\n" +
				"                },\n" +
				"                \"bigModelQueryPositive\": [],\n" +
				"                \"displayScore\": true,\n" +
				"                \"classesNeeded\": \"[]\",\n" +
				"                \"boxEnlargeSize\": \"1\",\n" +
				"                \"yBMZhaRqXOXBJmjJ\": 0.5,\n" +
				"                \"bigModelIncludeCoincideRatio\": [],\n" +
				"                \"task_id\": 2532,\n" +
				"                \"isStart\": false,\n" +
				"                \"polygon_regions\": [],\n" +
				"                \"includeCoincideRatio\": \"[]\",\n" +
				"                \"polygon_regions_label\": [],\n" +
				"                \"LC_CP_num_person_thresh\": 7,\n" +
				"                \"encodingFilter\": {\n" +
				"                    \"indexId\": \"od210_210_001835_008_rfjs5fhx\",\n" +
				"                    \"threshold\": 0.9,\n" +
				"                    \"videoId\": 59489,\n" +
				"                    \"orgId\": \"mu_100170\"\n" +
				"                },\n" +
				"                \"startTime\": \"00:00:00\",\n" +
				"                \"interval\": 5,\n" +
				"                \"endTime\": \"23:59:59\",\n" +
				"                \"bigModelQueryNegative\": [],\n" +
				"                \"excludeCoincideRatio\": \"[]\",\n" +
				"                \"bigModelExcludeCoincideRatio\": [],\n" +
				"                \"classesThreshold\": 0.5,\n" +
				"                \"video_id\": 59489\n" +
				"            },\n" +
				"            \"associatedList\": [],\n" +
				"            \"abilityConfig\": {\n" +
				"                \"shieldValueHighH\": 0,\n" +
				"                \"positionsHandle\": 0,\n" +
				"                \"shieldValueW\": 0,\n" +
				"                \"shieldValueHighW\": 0,\n" +
				"                \"positions\": [],\n" +
				"                \"ignoreTimeList\": [],\n" +
				"                \"shieldValueH\": 0,\n" +
				"                \"isIntersect\": 1,\n" +
				"                \"ratio\": 90\n" +
				"            }\n" +
				"        }\n" +
				"    },\n" +
				"    \"taskOrder\": \"0\",\n" +
				"    \"cancelCallbackInfo\": \"https://fos.fjecloud.com/callback//callback/appSourceId/handler\",\n" +
				"    \"videoList\": [\n" +
				"        {\n" +
				"            \"videoId\": 59489,\n" +
				"            \"abilityList\": [\n" +
				"                {\n" +
				"                    \"selectedRegions\": [],\n" +
				"                    \"videoValidation\": 3676,\n" +
				"                    \"abilityCode\": \"OD210_210_001835_008_RFjS5fhx\",\n" +
				"                    \"imageList\": [\n" +
				"                        {\n" +
				"                            \"orderType\": 0,\n" +
				"                            \"imageId\": 507624486,\n" +
				"                            \"isFast\": false,\n" +
				"                            \"data\": \"/app/resources/frame/20231008/07/04a4ccf7def442259b77c424e7d2f2c9.jpg\",\n" +
				"                            \"eventTime\": \"2023-10-08 07:45:10\",\n" +
				"                            \"kwargs\": {\n" +
				"                                \"taskType\": \"detect\",\n" +
				"                                \"startTime\": \"00:00:00\",\n" +
				"                                \"endTime\": \"23:59:00\",\n" +
				"                                \"isStart\": false,\n" +
				"                                \"isEnd\": false\n" +
				"                            },\n" +
				"                            \"appSourceId\": \"17108034859397898240002\",\n" +
				"                            \"orgId\": \"mu_100205\",\n" +
				"                            \"taskId\": 2532\n" +
				"                        }\n" +
				"                    ]\n" +
				"                }\n" +
				"            ],\n" +
				"            \"srcType\": \"local\"\n" +
				"        }\n" +
				"    ],\n" +
				"    \"kwargs\": {\n" +
				"        \"taskType\": \"detect\"\n" +
				"    },\n" +
				"    \"appSourceId\": \"17108034859397898240002\",\n" +
				"    \"taskId\": 2532,\n" +
				"    \"callbackType\": 1\n" +
				"}";

		JSONObject jsonObject = JSONObject.parseObject(str);

		String string = jsonObject.toString(SerializerFeature.DisableCircularReferenceDetect);
		System.out.println(string);
	}
}
