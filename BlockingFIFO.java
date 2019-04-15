package edu.utdallas.taskExecutorImpl;

import edu.utdallas.taskExecutor.Task;

public class BlockingFIFO {

	public static Task[] taskArray;
	public static int arraySize;

	public static Object notFull = new Object();
	public static Object notEmpty = new Object();

	public static int put = 0;
	public static int pop = 0;

	public BlockingFIFO(int arraySize) {
		BlockingFIFO.arraySize = arraySize;
		BlockingFIFO.taskArray = new Task[BlockingFIFO.arraySize];
	}



	public void addTask(Task task)
	{		


		synchronized (notFull) {				
			if(put - pop == BlockingFIFO.arraySize) {
				try {
					notFull.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
			}
			if(put - pop < BlockingFIFO.arraySize) {
				BlockingFIFO.taskArray[put%BlockingFIFO.arraySize] = task;
				put +=1;
				try {
					notEmpty.notify();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
			}

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

		}

	}


	public void getTask() {

		synchronized (notEmpty) {
			if(put - pop == 0) {
				try {
					notEmpty.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}

			}
			if(pop<put) {
				Task t = BlockingFIFO.taskArray[pop%BlockingFIFO.arraySize];
				System.out.println("Hello From Thread: " + Thread.currentThread().getName() + " Task: " + t.getName() + ":: numOfActivations: " + pop);
				pop +=1;
				try {
					notFull.notify();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}

				/*
				 * try { Thread.sleep(50); } catch (InterruptedException e) { // TODO
				 * Auto-generated catch block e.printStackTrace(); }
				 */
			}
		}
	}
}
