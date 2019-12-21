package _04_Thread_Pool;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Worker implements Runnable {
	
	ConcurrentLinkedQueue<Task> taskQ;
	
	Worker(ConcurrentLinkedQueue<Task> t) {
		taskQ = t;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (!taskQ.isEmpty()) {
			taskQ.remove().perform();
		}
	}

}
