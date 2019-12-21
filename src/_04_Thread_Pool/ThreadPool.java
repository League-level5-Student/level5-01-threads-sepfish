package _04_Thread_Pool;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ThreadPool {
	Thread[] threads;
	ConcurrentLinkedQueue<Task> taskQ;
	
	ThreadPool(int t) {
		threads = new Thread[t];
		taskQ = new ConcurrentLinkedQueue<Task>();
		for (Thread a: threads) {
			//help put something in here :((((( ================================================================
		}
	}
	
	void addTask(Task t) {
		taskQ.add(t);
	}
	
	void start() {
		for (Thread t: threads) {
			t.run();
		}
		for (Thread t: threads) {
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
