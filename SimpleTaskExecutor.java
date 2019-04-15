package edu.utdallas.taskExecutorImpl;

import edu.utdallas.taskExecutor.Task;
import edu.utdallas.taskExecutor.TaskExecutor;

public class SimpleTaskExecutor implements TaskExecutor{
	
	
	@Override
	public void addTask(Task task) {
		
		// TODO Complete the implementation
		/*
		 * while(true) { synchronized (this) { if(TaskExecutorImpl.put -
		 * TaskExecutorImpl.pop < TaskExecutorImpl.threadCount) {
		 * TaskExecutorImpl.taskArray[TaskExecutorImpl.put%100] = task;
		 * TaskExecutorImpl.put++; } }
		 * 
		 * }
		 */
	}

}
