package com.inovia.magnifier.database;

/**
 * it represents a database index
 */
public class Index {
	private String schemaName;
	private String tableName;
	private String name;
	
	/**
	 * @param schemaName The name of the schema containing the indexed table
	 * @param tableName  The name of the indexed table
	 * @param name       The name of the index
	 */
	public Index(String schemaName, String tableName, String name) {
		this.schemaName = schemaName;
		this.tableName = tableName;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getSchemaName() {
		return schemaName;
	}

	public String getTableName() {
		return tableName;
	}
}
