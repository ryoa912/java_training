/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch21.ex03;

import java.util.HashMap;
import java.util.Map;

public class WeakValueMap<K, V> extends HashMap<K, V> implements Map<K,V> {
	//値のイテレーションはhasNextがtrueを返した後にnullを返すことが許されるべきか
	//→Yes.どのタイミングでもValueがガーベッジコレクションに回収されることが起こり得るため。

	//値をイテレートしている間は、値は生きているべきか
	//→No.どのタイミングでもValueがガーベッジコレクションに回収されることが起こり得るため。

	//ヒント：AbstructMapを拡張しようとしないこと。
	//代わりに、HashMapに委譲すること。

	public V get(Object key) {
		//設計したgetを実装する。
        return null;
    }
}
