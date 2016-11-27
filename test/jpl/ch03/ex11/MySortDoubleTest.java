package jpl.ch03.ex11;

import org.junit.Test;

public class MySortDoubleTest {
	static double[] testData;

	@Test
	public void testDoSort_10() {
		//10個程度では割り込めない
		final int arraySize = 10;
		testData = createArray(arraySize);

		SortDouble bsort = new MySortDouble();

		System.out.println("メインスレッド");
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("別スレッド開始");
                double[] data2 = {0};
                SortMetrics metrics = bsort.sort(data2);
                System.out.println("別スレッド終了");
            }
        }).start();
		SortMetrics metrics = bsort.sort(testData);


		System.out.println("Metrics: " + metrics);
		for (int i=0; i < testData.length; i++) {
			System.out.println("\t"+ testData[i]);
		}
		System.out.println("Metrics: " + metrics);
	}

	@Test
	public void testDoSort_100() {
		//100個でも割り込まれることがあった（SortDoubleのLockを削除して検証してみること）
		final int arraySize = 100;
		testData = createArray(arraySize);

		SortDouble bsort = new MySortDouble();

		System.out.println("メインスレッド");
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("別スレッド開始");
                double[] data2 = {0};
                SortMetrics metrics = bsort.sort(data2);
                System.out.println("別スレッド終了");
            }
        }).start();
		SortMetrics metrics = bsort.sort(testData);


		System.out.println("Metrics: " + metrics);
		for (int i=0; i < testData.length; i++) {
			System.out.println("\t"+ testData[i]);
		}
		System.out.println("Metrics: " + metrics);
	}

	@Test
	public void testDoSort_1000() {
		//1000個ならほとんどの環境で割り込まれるのでは？（SortDoubleのLockを削除して検証してみること）
		final int arraySize = 1000;
		testData = createArray(arraySize);

		SortDouble bsort = new MySortDouble();

		System.out.println("メインスレッド");
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("別スレッド開始");
                double[] data2 = {0};
                SortMetrics metrics = bsort.sort(data2);
                System.out.println("別スレッド終了");
            }
        }).start();
		SortMetrics metrics = bsort.sort(testData);


		System.out.println("Metrics: " + metrics);
		for (int i=0; i < testData.length; i++) {
			System.out.println("\t"+ testData[i]);
		}
		System.out.println("Metrics: " + metrics);
	}


	public double[] createArray(int arraySize) {
		double[] array = new double[arraySize];
		double d = arraySize;
		for (int i=0; i<array.length; i++) {
			array[i] = arraySize - 0.1 * i;
		}
		return array;
	}
	/*
	//nullを入れられると、子クラスの実装によっては落ちる
	metrics = bsort.sort(null);
	*/

	/*
	//public sortを2回呼ぶと、1回目の記録が上書きされてしまう。
	double[] data2 = {0};
	metrics = bsort.sort(data2);
	*/

	/*
	//public getMetricsで取得した結果が外から書き換えられるのかと思ったけど
	//そうでもなかった。（正しくcloneされていた。）
	SortMetrics metrics2 = metrics.clone();
	metrics2.compareCnt = 100;
	metrics2.probeCnt = 200;
	metrics2.swapCnt = 300;

	System.out.println(metrics.compareCnt + metrics.probeCnt + metrics.swapCnt);
	*/
}
