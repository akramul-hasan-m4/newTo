package com.mf.model;


import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;


@Component
public class TodoModel {
	

	
	private long id;
	@NotEmpty
	private String todoDescription;
	private TodoItem item;
	public TodoModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TodoModel(long id, @NotEmpty String todoDescription, TodoItem item) {
		super();
		this.id = id;
		this.todoDescription = todoDescription;
		this.item = item;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTodoDescription() {
		return todoDescription;
	}
	public void setTodoDescription(String todoDescription) {
		this.todoDescription = todoDescription;
	}
	public TodoItem getItem() {
		return item;
	}
	public void setItem(TodoItem item) {
		this.item = item;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TodoModel [id=");
		builder.append(id);
		builder.append(", todoDescription=");
		builder.append(todoDescription);
		builder.append(", item=");
		builder.append(item);
		builder.append("]");
		return builder.toString();
	}
	
	

}
