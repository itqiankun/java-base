package com.itqiankun.onetomany;

import lombok.Data;
import lombok.Setter;

/**
 * @author: ma_qiankun
 * @date: 2023/8/15
 **/
@Setter
public class Grade {
	private String subject;
	private Double score;

	public Grade(String subject, Double score) {
		this.subject = subject;
		this.score = score;
	}
}
