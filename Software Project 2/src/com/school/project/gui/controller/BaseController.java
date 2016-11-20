package com.school.project.gui.controller;

import java.util.Observer;

import com.school.project.gui.view.BaseView;

public abstract class BaseController<T extends BaseView> implements Observer{
	protected T view;
	
	public BaseController(T view) {
		this.view = view;
	}
	
	public T getBaseView() {
		return view;
	}
}
