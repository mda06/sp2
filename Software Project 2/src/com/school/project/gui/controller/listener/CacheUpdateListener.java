package com.school.project.gui.controller.listener;

public interface CacheUpdateListener<T> {
	void added(T t);
	void removed(T t);
}
