package com.inovia.magnifier.database.postgresql;

import com.inovia.magnifier.database.objects.*;

public class PGForeignKey implements ForeignKey {
	private PGTable table;
	private String columnName;
	private String foreignSchemaName;
	private String foreignTableName;
	private String foreignColumnName;
	
	public PGForeignKey(PGTable table, String columnName, String foreignSchemaName, String foreignTableName, String foreignColumnName) {
		this.table = table;
		this.columnName = columnName;
		this.foreignSchemaName = foreignSchemaName;
		this.foreignTableName = foreignTableName;
		this.foreignColumnName = foreignColumnName;
	}
	
	public String getSchemaName() {
		return table.getSchemaName();
	}
	
	public Table getTable() {
		return table;
	}
	
	public String getColumnName() {
		return columnName;
	}
	
	public String getForeignSchemaName() {
		return foreignSchemaName;
	}
	
	public String getForeignTableName() {
		return foreignTableName;
	}
	
	public String getForeignColumnName() {
		return foreignColumnName;
	}
	
	public String toString() {
		return table + "." + columnName + " -> " + foreignSchemaName + "." + foreignTableName + "." + foreignColumnName;
	}

	public String getEntityDescription() {
		return table + "." + columnName;
	}
}