package com.inovia.magnifier.database.objects;

public interface Comment extends Entity {
	public String getSchemaName();
	public String getEntityType();
	public String getEntityName();
	public String toString();
}
