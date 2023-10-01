import java.util.ArrayList;
import java.util.List;

/**
 * @author: ma_qiankun
 * @date: 2023/10/1
 **/
public class HelloTest {
	public static void main(String[] args) {
		String[] strings = new String[16];
		System.out.println(strings.length);

		List<String> objects = new ArrayList<>(16);
		System.out.println(objects.size());
		objects.add("ddd");
		System.out.println(objects.size());

	}
}
