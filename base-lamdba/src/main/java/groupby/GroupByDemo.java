package groupby;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author: ma_qiankun
 * @date: 2023/10/20
 **/
@Slf4j
public class GroupByDemo {

	@Test
	public void it_qk_groupby_field(){
		List<Person> persons = Arrays.asList(
				new Person("Alice", 25),
				new Person("Bob", 30),
				new Person("Charlie", 35)
		);

		Map<String, List<Person>> collect = persons.stream()
				.collect(Collectors.groupingBy(Person::getName));

		log.info("result:{}", JSONObject.toJSON(collect));
	}

	@Test
	public void it_qk_groupby_many_field(){
		List<Person> persons = Arrays.asList(
				new Person("Alice", 25),
				new Person("Bob", 30),
				new Person("Charlie", 35)
		);

		Map<String, List<Person>> collect = persons.stream()
				.collect(Collectors.groupingBy(x->x.getName()+x.getAge()));

		log.info("result:{}", JSONObject.toJSON(collect));
	}
	@Test
	public void it_qk_groupby_list_count(){
		List<Person> persons = Arrays.asList(
				new Person("Alice", 25),
				new Person("Bob", 30),
				new Person("Bob", 30),
				new Person("Charlie", 35),
				new Person("Charlie", 35)
		);

		Map<String, Long> collect = persons.stream()
				.collect(Collectors.groupingBy(Person::getName, Collectors.counting()));

		log.info("result:{}", JSONObject.toJSON(collect));
	}
	@Test
	public void it_qk_groupby_list_int_sum(){
		List<Person> persons = Arrays.asList(
				new Person("Alice", 25),
				new Person("Bob", 30),
				new Person("Bob", 30),
				new Person("Charlie", 35),
				new Person("Charlie", 35)
		);

		Map<String, Integer> collect = persons.stream()
				.collect(Collectors.groupingBy(Person::getName, Collectors.summingInt(Person::getAge)));

		log.info("result:{}", JSONObject.toJSON(collect));
	}


	@Test
	public void it_qk_tomap_object(){
		List<Person> persons = Arrays.asList(
				new Person("Alice", 25),
				new Person("Bob", 30),
				new Person("Charlie", 35)
		);

		Map<String, Person> nameToAgeMap = persons.stream()
				.collect(Collectors.toMap(Person::getName, x->x));

		log.info("result:{}", JSONObject.toJSON(nameToAgeMap));
	}
	@Test
	public void it_qk_tomap_object_identity(){
		List<Person> persons = Arrays.asList(
				new Person("Alice", 25),
				new Person("Bob", 30),
				new Person("Charlie", 35)
		);

		Map<String, Person> nameToAgeMap = persons.stream()
				.collect(Collectors.toMap(Person::getName, Function.identity()));

		log.info("result:{}", JSONObject.toJSON(nameToAgeMap));
	}


	@Test
	public void it_qk_tomap_object_double_error(){
		List<Person> persons = Arrays.asList(
				new Person("Alice", 25),
				new Person("Bob", 35),
				new Person("Bob", 225)
		);

		Map<String, Person> nameToAgeMap = persons.stream()
				.collect(Collectors.toMap(Person::getName, x->x));

		log.info("result:{}", JSONObject.toJSON(nameToAgeMap));
	}

	@Test
	public void it_qk_tomap_object_double_error_solve(){
		List<Person> persons = Arrays.asList(
				new Person("Alice", 25),
				new Person("Bob", 35),
				new Person("Bob", 225)
		);

		Map<String, Person> nameToAgeMap = persons.stream()
				.collect(Collectors.toMap(Person::getName, x->x, (i,j)->i));

		log.info("result:{}", JSONObject.toJSON(nameToAgeMap));
	}
	@Test
	public void it_qk_tomap_object_double_error_solve2(){
		List<Person> persons = Arrays.asList(
				new Person("Alice", 25),
				new Person("Bob", 35),
				new Person("Bob", 225)
		);

		Map<String, List<Person>> listMap = persons.stream()
				.collect(Collectors.groupingBy(Person::getName));

		log.info("result:{}", JSONObject.toJSON(listMap));
	}

	@Test
	public void it_qk_tomap_object_(){
		List<Person> persons = Arrays.asList(
				new Person("Alice", 25),
				new Person("Bob", 35),
				new Person("Bob1", 225)
		);

		Map<String, Person> personMap = persons.stream()
				.collect(Collectors.toMap(k->k.getName()+k.getAge(), x->x));

		log.info("result:{}", JSONObject.toJSON(personMap));
	}







}


class Person {
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}