/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch17.ex05;

import java.lang.ref.WeakReference;

public class ResourceImpl implements Resource{
	private final WeakReference<Object> keyRef;
	boolean needsRelease = false;

	public ResourceImpl(Object key) {
		keyRef = new WeakReference<>(key);
		//外部リソースの設定
		needsRelease = true;
	}

	public void use(Object key, Object... args) {
		if (keyRef.get() != key)
			throw new IllegalArgumentException("wrong key");
		//リソースの使用
	}

	public synchronized void release() {
		if (needsRelease) {
			needsRelease = false;
			//リソースの解放
		}
	}
}
