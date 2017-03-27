/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch17.ex03;

public class ResourceImpl implements Resource {
	int keyHash;
	boolean needsRelease = false;

	ResourceImpl(Object key) {
		keyHash = System.identityHashCode(key);

		//外部リソースの設定

		needsRelease = true;
	}

	public void use(Object key, Object... args) {
		if (System.identityHashCode(key) != keyHash)
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
