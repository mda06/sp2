package com.school.project.model.price;

import java.util.HashMap;
import java.util.Map;

// http://stackoverflow.com/questions/3422673/evaluating-a-math-expression-given-in-string-form
public class Formula {
	private Map<String, Double> variables;
	private String str;
	private int pos = -1, ch;
	
	public Formula() {
		this.str = "";
		this.variables = new HashMap<>();
	}

	public void addVar(String key, Double val) {
		variables.put(key, val);
	}
	
	public void removeVar(String key) {
		variables.remove(key);
	}
	
	private void nextChar() {
		ch = (++pos < str.length()) ? str.charAt(pos) : -1;
	}

	private boolean eat(int charToEat) {
		while (ch == ' ')
			nextChar();
		if (ch == charToEat) {
			nextChar();
			return true;
		}
		return false;
	}

	public double parse(String str) {
		this.str = str;
		pos = -1;
		nextChar();
		double x = parseExpression();
		if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char) ch);
		return x;
	}

	// Grammar:
	// expression = term | expression `+` term | expression `-` term
	// term = factor | term `*` factor | term `/` factor
	// factor = `+` factor | `-` factor | `(` expression `)`
	// | number | functionName factor | factor `^` factor

	private double parseExpression() {
		double x = parseTerm();
		for (;;) {
			if (eat('+')) x += parseTerm(); // addition
			else if (eat('-')) x -= parseTerm(); // subtraction
			else return x;
		}
	}

	private double parseTerm() {
		double x = parseFactor();
		for (;;) {
			if (eat('*')) x *= parseFactor(); // multiplication
			else if (eat('/')) x /= parseFactor(); // division
			else return x;
		}
	}

	private double parseFactor() {
		if (eat('+')) return parseFactor(); // unary plus
		if (eat('-')) return -parseFactor(); // unary minus

		double x;
		int startPos = this.pos;

		if (eat('(')) { // parentheses
			x = parseExpression();
			eat(')');
		} else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
			while ((ch >= '0' && ch <= '9') || ch == '.')
				nextChar();
			x = Double.parseDouble(str.substring(startPos, this.pos));
		} else if (ch >= 'a' && ch <= 'z') { // functions
			while (ch >= 'a' && ch <= 'z')
				nextChar();
			String func = str.substring(startPos, this.pos);
			if(variables.containsKey(func))
				x = variables.get(func);
			else {
				x = parseFactor();
				if (func.equals("sqrt")) x = Math.sqrt(x);
				else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
				else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
				else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
				else throw new RuntimeException("Unknown function: " + func);
			}
		} else {
			throw new RuntimeException("Unexpected: " + (char) ch);
		}

		if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

		return x;
	}
}
