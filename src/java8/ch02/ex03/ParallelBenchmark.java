/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package java8.ch02.ex03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelBenchmark {
	public static void run(Path path, int length) throws IOException {
        String contents = Files.readAllLines(path).stream().collect(Collectors.joining());
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        // Metrics run
        long p_start_time = System.nanoTime();
        long p_count = countParallel(words, length);
        long p_end_time = System.nanoTime();
        long n_start_time = System.nanoTime();
        long n_count = countSequential(words, length);
        long n_end_time = System.nanoTime();
        System.out.println("Parallel Stream:   " + n2m(p_end_time - p_start_time));
        System.out.println("Normal Stream: " + n2m(n_end_time - n_start_time));
    }

    private static long countParallel(List<String> words, int length) {
        return words.parallelStream().filter(w -> w.length() > length).count();
    }

    private static long countSequential(List<String> words, int length) {
        return words.stream().filter(w -> w.length() > length).count();
    }

    private static double n2m(long nano) {
        return nano / 1000000.0;
}
}
