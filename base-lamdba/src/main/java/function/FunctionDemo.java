package function;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.function.Function;

/**
 * author: ma_qiankun
 * date:  2023/12/16
 **/
@Slf4j
public class FunctionDemo {

	@Test
	public void it_qk(){
		// 示例1：将字符串转换为整数
		Function<String, Integer> strToInt = str->{
			return Integer.valueOf(str);
		};
		int result1 = strToInt.apply("123");
		System.out.println("Result: " + result1);
	}

}
