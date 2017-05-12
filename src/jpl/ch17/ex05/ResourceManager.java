/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch17.ex05;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Map;

public class ResourceManager {
	final ReferenceQueue<Object> queue;
	final Map<Reference<?>, Resource> refs;
	boolean shutdown = false;

	public ResourceManager() {
		queue = new ReferenceQueue<Object>();
		refs = new HashMap<Reference<?>, Resource>();
		//...リソースの初期化...
	}

	public synchronized void shutdown() {
		if (!shutdown) {
			shutdown = true;
			releaseResource();
		}
	}

	public synchronized Resource getResource(Object key) {
		if (shutdown)
			throw new IllegalStateException();
		Resource res = (Resource) new ResourceImpl(key);
		Reference<?> ref = new PhantomReference<Object>(key, queue);
		refs.put(ref, res);

		//get時にもResourceを解放する必要あり

		return res;
	}

	public void releaseResource() {
		while (true) {
			Reference<?> ref = queue.poll();
			if (ref == null)
				break;
			Resource res = refs.get(ref);
			refs.remove(ref);
			res.release();
			ref.clear();
		}

		//ループさせてキューに積むところもやる
	}
}
