package _04_Thread_Pool;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ThreadPool {

	Thread[] threads;
	public ConcurrentLinkedQueue<Task> taskQueue;
	int totalThreads;

	public ThreadPool(int totalThreads) {

		this.totalThreads=totalThreads;
		
		taskQueue = new ConcurrentLinkedQueue<Task>();
		threads = new Thread[totalThreads];

		for (int i = 0; i < totalThreads; i++) {

			threads[i] = new Thread(new Worker(taskQueue));
			
		}

	}

	public void addTask(Task task) {

		taskQueue.add(task);

	}

	public void start() {

		for (int i = 0; i < totalThreads; i++) {
			threads[i].start();
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
