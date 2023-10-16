import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author: ma_qiankun
 * @date: 2023/10/1
 **/
@Slf4j
public class HelloTest {
	public static void main(String[] args) {
		System.out.println(java.security.AccessController.doPrivileged(
				new sun.security.action.GetBooleanAction(
						"java.util.Arrays.useLegacyMergeSort")).booleanValue());

	}

	@Test
	public void it_qk(){
		assert  1>2;
		log.info("hello world");
	}

	@Test
	public void it_qk_two(){
		assert  2>1;
		log.info("hello world");
	}

}
