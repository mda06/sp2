package com.school.project.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface BaseDAO<T> {
	public T getByResultSet(ResultSet res) throws SQLException;
	public void add(T obj);
	public List<T> getAll();
	public T get(int id);
	public void update(T obj);
	public void delete(T obj);
}
