package edu.utdallas.taskExecutorImpl;

import edu.utdallas.taskExecutor.Task;
import edu.utdallas.taskExecutor.TaskExecutor;

public class TaskExecutorImpl implements TaskExecutor
{
	private int arraySize = 100;
	int threadCount = 0;
	
	BlockingFIFO fifo;
	
	
	public TaskExecutorImpl(int no) {
		this.threadCount = no;
		//this.queueSize = 10*threadCount;
		fifo  = new BlockingFIFO(arraySize);
		//TaskExecutorImpl.taskArray = new Task[arraySize];
		for(int i = 0; i<no; i++) {
			Thread th = new Thread(new TaskExecutorThread(fifo));
			th.start();
		}
	}
	@Override
	public void addTask(Task task)
	{
		// TODO Complete the implementation
		//try { Thread.sleep(50); } catch (InterruptedException e) {  e.printStackTrace(); }
			fifo.addTask(task);
		
/*
		synchronized (this) {

			if(TaskExecutorImpl.put - TaskExecutorImpl.pop == BlockingFIFO.arraySize) {
				try {
					notFull.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				
			
			if(TaskExecutorImpl.put - TaskExecutorImpl.pop < BlockingFIFO.arraySize) {
				BlockingFIFO.taskArray[TaskExecutorImpl.put%BlockingFIFO.arraySize] = task;
				TaskExecutorImpl.put +=1;
				notEmpty.notify();
			}
			/*
			/*
			while(TaskExecutorImpl.put-TaskExecutorImpl.pop == BlockingFIFO.arraySize) {
				//System.out.println("Inside continue");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				continue;
			}
			*/
		
	//	}
	
	}
	
}

/*
class FIFO{
	public void getTask() {
		synchronized (this) {
			if(TaskExecutorImpl.pop<TaskExecutorImpl.put) {
				Task t = BlockingFIFO.taskArray[TaskExecutorImpl.pop%TaskExecutorImpl.arraySize];
				 System.out.println("Hello From Thread: " + Thread.currentThread().getName() + " Task: " + t.getName() + ":: numOfActivations: " + TaskExecutorImpl.pop);
				 TaskExecutorImpl.pop +=1;
				 try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
}
}
*/
/*
public class TaskExecutorThread implements Runnable {

	FIFO fifo;
	public TaskExecutorThread(FIFO fifo) {
		this.fifo = fifo;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub

		while(true) {
			fifo.getTask();

		}
	}

}
*/