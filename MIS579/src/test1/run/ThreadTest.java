package test1.run;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest implements Runnable {
	
	private String threadName;
	
	private static final int SLEEP_TIME=100; //ms
	private static final int LOOP_COUNT=5;
	private static final int THREAD_COUNT=3;
	
	
	public ThreadTest(String threadName){
		this.threadName = threadName;
	}

	public static void main(String[] args) {
		ExecutorService threadExecutor = Executors.newCachedThreadPool();
		for (int i = 0; i < THREAD_COUNT; i++) {
			Thread newThread = new Thread(new ThreadTest("Thread " + (i + 1)));
			//newThread.start();
			threadExecutor.execute( newThread);
		}
	}

	@Override
	public void run() {
		for (int i=0; i< LOOP_COUNT; i++){
			System.out.println(this + " : loop - " + (i+1));
			try {
				if (this.threadName.equalsIgnoreCase("Thread 2")){
					Thread.sleep(SLEEP_TIME*10);
				} else {
					Thread.sleep(SLEEP_TIME);
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public String toString(){
		return "ThreadName = " + this.threadName;
	}

}

