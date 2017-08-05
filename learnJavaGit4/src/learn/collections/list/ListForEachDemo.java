package learn.collections.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class ListForEachDemo {

	public static void main(String[] args) {
		// Setup
		List<Integer> list = new ArrayList<Integer>();
		int min = 10;
		int max = 99;
		Random random = new Random();
		for (int i = 1; i <= 10; i++)
			list.add(random.nextInt(max + 1 - min) + min);
		
		// Simplest way to display all list elements
		System.out.println(list);
		System.out.println("---------------------------------------------------");
		
		// Using Iterator
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext())
			System.out.println("Using iterator: " + iterator.next());
		System.out.println("---------------------------------------------------");
		
		// Using Foreach implementation by anonymous class
		list.forEach(new Consumer<Integer>() {

			public void accept(Integer value) {
				System.out.println("Using Foreach: " + value);
			}
		});
		System.out.println("---------------------------------------------------");
		
		// Using Foreach implementation by other class
		list.forEach(new MyConsumer());
	}

}

class MyConsumer implements Consumer<Integer> {
	public void accept(Integer value) {
		System.out.println("Using Foreach 2: " + value);
	}
}
