package com.inovia.magnifier.database;

/**
 * it represents a database comment
 */
public class Comment {
	public static final String TRIGGER_TYPE  = "trigger";
	public static final String FUNCTION_TYPE = "function";
	public static final String VIEW_TYPE     = "view";
	public static final String TABLE_TYPE    = "table";
	
	private String schemaName;
	private String entityName;
	private String entityType;
	private String content;
	
	/**
	 * @param schemaName The name of the schema containing the commented entity
	 * @param entityName The name of the commented entity
	 * @param content    The text of the comment
	 * @param entityType The type of the commented entity ({@link Comment}})
	 */
	public Comment(String schemaName, String entityName, String content, String entityType) {
		this.schemaName = schemaName;
		this.entityName = entityName;
		this.content    = content;
		this.entityType = entityType;
	}
	
	public String getSchemaName() {
		return schemaName;
	}
	
	public String getEntityName() {
		return entityName;
	}

	public String getEntityType() {
		return entityType;
	}

	public String getContent() {
		return content;
	}
}
