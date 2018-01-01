package com.mf.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mf.dao.ToDoDAo;
import com.mf.model.TodoModel;

@Service
public class TodoService {

	@Autowired
	ToDoDAo dao;
	
		public boolean saveData(TodoModel model) {
		return dao.saveData(model);
	}
		public boolean Move(long id) {
			 return dao.move(id);
		}
		public List<TodoModel> getAll(){
			return dao.getAll();
		}
		
}
