/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch03.ex22;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class MyFlatMapper {
	public static void main(String[] args) {
		Optional<String> optional = Optional.of("test");
		Optional<Integer> result = optional.flatMap(s -> Optional.of(s.length()));
		System.out.println("result=" + result.get());
		CompletableFuture<String> completableFuture = new CompletableFuture<>();
		//CompletableFutureに対するflatMap操作は存在しない。
		System.out.println(completableFuture.toString());
	}
}
