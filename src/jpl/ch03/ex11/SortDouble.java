package jpl.ch03.ex11;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

abstract public class SortDouble {
	private double[] values;
	private final SortMetrics curMetrics = new SortMetrics();
	Lock lock = new ReentrantLock();

	/** 全ソートをするために呼び出される */
	public final SortMetrics sort(double[] data) {
		//ソート実行中に不正にソートが呼ばれてMetricsが改ざんされないようにロックする。
		try {
			lock.lock(); // ロック
			curMetrics.init();
			//nullチェックを追加
			if (null == data) {
				return getMetrics();
			}
			values = data;
			doSort();
			return getMetrics();
		} finally {
			lock.unlock(); // アンロック
		}
	}

	public final SortMetrics getMetrics() {
		return curMetrics.clone();
	}

	/** 拡張したクラスが要素の数をしるため */
	protected final int getDataLength() {
		return values.length;
	}

	/** 拡張したクラスが要素を調べるため */
	protected final double probe(int i) {
		curMetrics.probeCnt++;
		return values[i];
	}

	/** 拡張したクラスが要素を比較するため */
	protected final int compare(int i, int j) {
		curMetrics.compareCnt++;
		double d1 = values[i];
		double d2 = values[j];
		if (d1 == d2)
			return 0;
		else
			return (d1 < d2 ? -1 : 1);
	}

	/** 拡張したクラスが要素を交換するため */
	protected final void swap(int i, int j) {
		curMetrics.swapCnt++;
		double tmp = values[i];
		values[i] = values[j];
		values[j] = tmp;
	}

	/** 拡張したクラスが実装する --ソートするのに使用される */
	protected abstract void doSort();
}
