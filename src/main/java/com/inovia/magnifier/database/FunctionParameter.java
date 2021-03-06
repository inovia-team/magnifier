package com.inovia.magnifier.database;

/**
 * it represents a database function parameter 
 */
public class FunctionParameter {
	private Function function;
	private String name;
	private String mode;
	
	/**
	 * @param function The function processing this parameter
	 * @param name     The name of the parameter;
	 * @param mode     The mode of the parameter (IN, OUT, ...)
	 */
	public FunctionParameter(Function function, String name, String mode) {
		this.function = function;
		this.name = name;
		this.mode = mode;
	}

	public Function getFunction() {
		return function;
	}

	public String getName() {
		return name;
	}

	public String getMode() {
		return mode;
	}
}
