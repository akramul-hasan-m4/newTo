package com.mf.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Repository;

import com.mf.model.TodoItem;
import com.mf.model.TodoModel;

@Repository
public class ToDoDAo {

	static List<TodoModel> list=new ArrayList<>();
	
	static {
		list.add(new TodoModel(1,"Akram vai",TodoItem.TODO));
	}
	
	public boolean saveData(TodoModel model) throws NullPointerException{
		if(model ==null) {
			return false;
		}
		if(model.getId()==0) {
			model.setId(new Random().nextLong());
			model.setItem(TodoItem.TODO);
			list.add(model);
			return true;
		}
		else if(model.getItem()==TodoItem.TODO){
			model.setItem(TodoItem.INPROGRESS);
			return true;
		}
		else {
			model.setItem(TodoItem.DONE);
			return true;
		}
		
		
	}
	
	public boolean move(long id) {
	//	List<TodoModel> model=list.stream().filter(a->a.getId().equals(id)).collect(Collector.toList);
		for(TodoModel model:list) {
			if(model.getId()==id) {
				if(model.getItem()==TodoItem.TODO){
					model.setItem(TodoItem.INPROGRESS);
					break;
					//return true;
				}
				else {
					model.setItem(TodoItem.DONE);
					//return true;
					break;
				}
			}
		}
		return true;
	}
	public List<TodoModel> getAll(){
		return list;
	}
	
}
