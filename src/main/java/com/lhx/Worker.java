package com.lhx;

import java.util.Map;
import java.util.Queue;

public class Worker implements Runnable {

	protected Queue<Object> workQueue;
	protected Map<String, Object> resultMap;

	public void setWorkQueue(Queue<Object> workQueue) {
		this.workQueue = workQueue;
	}

	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}

	// 子任务处理的逻辑,在子类中实现具体的逻辑
	public Object handle(Object input) {
		return input;
	}

	public void run() {
		while (true) {
			Object input = workQueue.poll();
			if (input == null)
				break;
			Object re = handle(input);
			resultMap.put(Integer.toString(re.hashCode()), re);
		}
	}

}
