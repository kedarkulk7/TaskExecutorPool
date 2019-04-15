package edu.utdallas.taskExecutorImpl;

public class TaskExecutorThread implements Runnable {

	BlockingFIFO fifo;
	public TaskExecutorThread(BlockingFIFO fifo) {
		this.fifo = fifo;
	}
	@Override
	public void run() {
		while(true) {
			try { Thread.sleep(5); } catch (InterruptedException e) {  e.printStackTrace(); }
					fifo.getTask();
				}

			}
		}