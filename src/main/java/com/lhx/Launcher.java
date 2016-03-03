package com.lhx;

import java.util.Map;
import java.util.Set;

public class Launcher {
	public static void main(String[] args) {
		Master master = new Master(new PlusWorker(), 5);
		for (int i = 0; i < 1000; i++) {
			master.submit(i);
		}
		master.execute();
		int re = 0;
		Map<String, Object> resultMap = master.getResult();
		while (resultMap.size() > 0 || !master.isComplete()) {
			Set<String> keys = resultMap.keySet();
			String key = null;
			for (String k : keys) {
				key = k;
				break;
			}
			Integer i = null;
			if (key != null)
				i = (Integer) resultMap.get(key);
			if (i != null)
				re += i;
			if (key != null)
				resultMap.remove(key);
		}
		System.out.println("计算结果="+re);
	}
}
