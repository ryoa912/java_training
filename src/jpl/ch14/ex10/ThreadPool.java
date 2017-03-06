/*
 * Copyright (C) 2012, 2013, 2016 RICOH Co., Ltd. All rights reserved.
 */
package jpl.ch14.ex10;

import java.util.LinkedList;
import java.util.NoSuchElementException;

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
	private final int queue_size;
	private final int thread_num;
	private PoolWorker[] threads;
	private LinkedList<Runnable> queue;
	private Boolean started = false;
	private static final int INTERVAL_MSEC = 100;
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
    	queue_size = queueSize;
    	thread_num = numberOfThreads;
    }

    /**
     * Starts threads.
     *
     * @throws IllegalStateException if threads has been already started.
     */
    public void start() {
    	if (started)
    		throw new IllegalStateException();
    	queue = new LinkedList<Runnable>();
    	threads = new PoolWorker[thread_num];
    	for (int i=0; i<thread_num; i++) {
    		threads[i] = new PoolWorker();
    		threads[i].start();
    	}
    	started = true;
    }

    /**
     * Stop all threads and wait for their terminations.
     *
     * @throws IllegalStateException if threads has not been started.
     */
    public void stop() {
    	if (!started)
    		throw new IllegalStateException();
    	for (int i=0; i<thread_num; i++) {
			threads[i].stopThread();
			try {
				threads[i].join();
				Thread.sleep(INTERVAL_MSEC * 2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}
    	started = false;
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
    	if (!started)
    		throw new IllegalStateException();
    	synchronized (queue) {
    		queue.addLast(runnable);
    		queue.notify();
    	}
    }

    private class PoolWorker extends Thread {
    	private boolean isActive = true;
    	public void run() {
            Runnable r;
            while (this.isActive) {
            	synchronized(queue) {
            		try {
            			r = (Runnable) queue.removeFirst();
            			try {
                            r.run();
                        }
                        catch (RuntimeException e) {
                        	// Nothing.
                        }
            		} catch (NoSuchElementException e) {
            			//Nothing.
            		}
            	}
            	try {
    				Thread.sleep(INTERVAL_MSEC);
    			} catch (InterruptedException e) {
    				e.printStackTrace();
    			}
            }
        }

    	public void stopThread() {
    		isActive = false;
    	}
    }
}
