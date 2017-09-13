package javaTest;

import java.util.*;
public class TestThread implements Runnable {
	private List<String> list = new ArrayList<String>();
	@Override
	public void run() {
		for(int i = 0; i<100; i++){
			add(String.valueOf(Math.random()));
		}
		for (String element : list) {
			System.out.println(element);
		}
	}
	public synchronized void add(String i){
		list.add(i);
	}
	public synchronized List<String> getList(){
		return list;
	}
	
}
