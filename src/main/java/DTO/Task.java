package DTO;

import java.sql.Date;

public class Task {
	private int taskId;
	private String taskTitle;
	private String taskDescription;
	private String taskPriority;
	private String taskDueDate;
	private int userId;
	public Task(int taskId, String taskTitle, String taskDescription, String taskPriority, String taskDueDate,
			int userId) {
		super();
		this.taskId = taskId;
		this.taskTitle = taskTitle;
		this.taskDescription = taskDescription;
		this.taskPriority = taskPriority;
		this.taskDueDate = taskDueDate;
		this.userId = userId;
	}
	public int getTaskId() {
		return taskId;
	}
	public String getTaskTitle() {
		return taskTitle;
	}
	public String getTaskDescription() {
		return taskDescription;
	}
	public String getTaskPriority() {
		return taskPriority;
	}
	public String getTaskDueDate() {
		return taskDueDate;
	}
	public int getUserId() {
		return userId;
	}
	


}
