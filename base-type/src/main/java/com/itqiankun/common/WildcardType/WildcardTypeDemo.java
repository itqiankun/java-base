package com.itqiankun.common.WildcardType;

import java.util.Map;

/**
 * @author: ma_qiankun
 * @date: 2023/9/6
 **/
public class WildcardTypeDemo <T, V>{
    public  WildcardTypeDemo <String,Number> demo;

	public Map<? super String, ? extends Number> mapWithWildcard;

}
