package com.inovia.magnifier.database;

/**
 * The class PGFunctionParameter deals with the PostgreSql
 * implementation of the FunctionParameter interface
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

	public String getEntityDescription() {
		String result = function.getSchemaName() + "." + function.getName() + "(";
		for(FunctionParameter fp : function.getParameters()) {
			result = result + (fp.getName() != null ? fp.getName() : "<noname>") + " " + fp.getMode();
		}
		result = result + ")";
		
		return result;
	}
	
	public String toString() {
		return name + " " + mode;
	}

	public String getName() {
		return name;
	}

	public String getMode() {
		return mode;
	}
}