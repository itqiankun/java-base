/**
 * @author: ma_qiankun
 * @date: 2023/8/7
 **/

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StepTimeMark {
	private List<Long> times = new ArrayList<>();

	private int type;
	public long getTime() {
		if (type == 1) {
			return System.nanoTime();
		}
		return System.currentTimeMillis();
	}
	public StepTimeMark(int type) {
		times.add(getTime());
	}
	public void mark() {
		times.add(getTime());
	}
	public void end(String msg, long time) {
		times.add(getTime());
		Long aLong = times.get(0);
		Long aLong1 = times.get(times.size() - 1);
		long stepAllTime = aLong1 - aLong;
		if (stepAllTime >= time) {
			List<Long> setTimes = new ArrayList<>();
			for(int i = 1; i < times.size(); ++i) {
				setTimes.add(times.get(i) - times.get(i - 1));
			}
			String str = setTimes.stream().map(String::valueOf).collect(Collectors.joining("\t"));
			System.out.printf("%s:%s cost time: %s%n", msg, str, stepAllTime);
			System.out.print(msg);
		}
	}

	public static void main(String[] args) throws Exception {
		StepTimeMark stepTimeMark = new StepTimeMark(0);
		Thread.sleep(1200);
		stepTimeMark.mark();
		Thread.sleep(30);
		stepTimeMark.mark();

		Thread.sleep(100);
		stepTimeMark.end("sss", 500 );
	}
}


