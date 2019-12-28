package _04_Thread_Pool;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ThreadPool {
	Thread[] threads;
	ConcurrentLinkedQueue<Task> taskQ;
	
	ThreadPool(int t) {
		threads = new Thread[t];
		taskQ = new ConcurrentLinkedQueue<Task>();
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new Worker(taskQ));
		}
	}
	
	//there are 4 threads in the thread pool
	
	void addTask(Task t) {
		taskQ.add(t);
	}
	
	void start() {
		for (Thread t: threads) {
			t.run();
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
