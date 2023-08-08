/**
 * @author: ma_qiankun
 * @date: 2023/8/7
 **/

import groovy.lang.GroovyShell;

public class LGroovyShell {


	public static void main(String[] args) throws Exception {

		StepTimeMark stepTimeMark = new StepTimeMark(0);
		String script = "def add(a, b) {\n" +
				"    return a + b\n" +
				"}\n" +
				"add(a,b)";
		GroovyShell groovyShell = new GroovyShell();

		groovyShell.setProperty("a", 1);
		groovyShell.setProperty("b", 2);
		stepTimeMark.mark();
		ss();
		stepTimeMark.mark();
		Object evaluate = groovyShell.evaluate(script);
		System.out.println(evaluate);
		stepTimeMark.end("step time", 0);
	}

	public static void ss () throws Exception {
		for(int i = 0 ; i < 2000; ++i) {
			for(int j = 0 ; j < 2000; ++j) {
				System.out.println(i * j);
			}
		}
	}
}

