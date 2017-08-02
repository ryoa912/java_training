/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch03.ex18;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Uncheck {
	public static <T> Supplier<T> unchecked(Callable<T> f) {
		return () -> {
			try {
				return f.call();
			}
			catch (Exception e) {
				throw new RuntimeException(e);
			}
			catch (Throwable t) {
				throw t;
			}
		};
	}

	public static void main(String[] args) {
		Supplier<String> s = Uncheck.unchecked(() -> new String(Files.readAllBytes(
				Paths.get("/etc/passwd")), StandardCharsets.UTF_8));
		System.out.println(s.toString());
	}
}
