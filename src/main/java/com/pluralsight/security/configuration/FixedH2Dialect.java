package com.pluralsight.security.configuration;

import org.hibernate.dialect.H2Dialect;

import java.sql.Types;

/**
 * Resolves an issue with column types in H2, especially around new time apis. 
 */
public class FixedH2Dialect extends H2Dialect {

	public FixedH2Dialect() {
		super();
		registerColumnType(Types.FLOAT, "real");
		registerColumnType(Types.BINARY, "varbinary");
	}
}
