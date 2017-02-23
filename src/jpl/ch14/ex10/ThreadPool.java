/*
 * Copyright (C) 2012, 2013, 2016 RICOH Co., Ltd. All rights reserved.
 */
package jpl.ch14.ex10;

import java.util.LinkedList;

/**
 * Simple Thread Pool class.
 *
 * This class can be used to dispatch an Runnable object to
 * be exectued by a thread.
 *
 * [Instruction]
 *  Implement one constructor and three methods.
 *  Don't forget to write a Test program to test this class.
 *  Pay attention to @throws tags in the javadoc.
 *  If needed, you can put "synchronized" keyword to methods.
 *  All classes for implementation must be private inside this class.
 *  Don't use java.util.concurrent package.
 */
public class ThreadPool {
	private final int f_thread_num;
	private final PoolWorker[] f_threads;
	private final LinkedList<Runnable> f_queue;
	private Boolean f_started = false;
    /**
     * Constructs ThreadPool.
     *
     * @param queueSize the max size of queue
     * @param numberOfThreads the number of threads in this pool.
     *
     * @throws IllegalArgumentException if either queueSize or numberOfThreads
     *         is less than 1
     */
    public ThreadPool(int queueSize, int numberOfThreads) {
    	if (queueSize < 1 || numberOfThreads < 1)
    		throw new IllegalArgumentException();
    	f_thread_num = numberOfThreads;
    	f_queue = new LinkedList<Runnable>();
    	f_threads = new PoolWorker[f_thread_num];
    	for (int i=0; i<f_thread_num; i++) {
    		f_threads[i] = new PoolWorker();
    	}
    }

    /**
     * Starts threads.
     *
     * @throws IllegalStateException if threads has been already started.
     */
    public void start() {
    	if (f_started)
    		throw new IllegalStateException();
    	for (int i=0; i<f_thread_num; i++) {
    		f_threads[i].start();
    	}
    	f_started = true;
    }

    /**
     * Stop all threads and wait for their terminations.
     *
     * @throws IllegalStateException if threads has not been started.
     */
    public void stop() {
    	if (!f_started)
    		throw new IllegalStateException();
    	for (int i=0; i<f_thread_num; i++) {
    		f_threads[i].stop();
    	}
    	f_started = false;
    }

    /**
     * Executes the specified Runnable object, using a thread in the pool.
     * run() method will be invoked in the thread. If the queue is full, then
     * this method invocation will be blocked until the queue is not full.
     *
     * @param runnable Runnable object whose run() method will be invoked.
     *
     * @throws NullPointerException if runnable is null.
     * @throws IllegalStateException if this pool has not been started yet.
     */
    public synchronized void dispatch(Runnable runnable) {
    	if (runnable == null)
    		throw new NullPointerException();
    	if (!f_started)
    		throw new IllegalStateException();
    	synchronized (f_queue) {
    		f_queue.addLast(runnable);
    		f_queue.notify();
    	}
    }

    private class PoolWorker extends Thread {
        public void run() {
            Runnable r;
            while (true) {
                synchronized(f_queue) {
                    while (f_queue.isEmpty()) {
                        try
                        {
                        	f_queue.wait();
                        }
                        catch (InterruptedException ignored)
                        {
                        }
                    }
                    r = (Runnable) f_queue.removeFirst();
                }
                // If we don't catch RuntimeException, // the pool could leak threads
                try {
                    r.run();
                }
                catch (RuntimeException e) {
                    // You might want to log something here
                }
            }
        }
    }
}
