/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch17.ex04;

public interface Resource {
	void use(Object key, Object... args);
	void release();
}
