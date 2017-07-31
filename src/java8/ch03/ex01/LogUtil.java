/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch03.ex01;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogUtil extends Logger {
	public LogUtil(String name, String resource) {
		super(name, resource);
		setParent(Logger.getLogger(name, resource));
		setUseParentHandlers(true);
		setLevel(Level.ALL);
	}
	public void logIf(Level level, BooleanSupplier condition, Supplier<String> msg) {
		if (isLoggable(level) && condition.getAsBoolean()) {
			log(level, msg);
		}
	}
}
