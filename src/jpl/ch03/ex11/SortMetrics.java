package jpl.ch03.ex11;

final public class SortMetrics implements Cloneable{
	public long	probeCnt,
					compareCnt,
					swapCnt;

	public void init() {
		probeCnt = swapCnt = compareCnt = 0;
	}

	public String toString() {
		return probeCnt + " propbes, " + compareCnt + "compares, " + swapCnt + " swaps";
	}

	/** このクラスはcloneをサポートしている */
	public SortMetrics clone() {
		try {
			//デフォルトの仕組みで十分
			return (SortMetrics) super.clone();
		} catch (CloneNotSupportedException e) {
			//起こり得ない。このクラスとObjectは複製できる
			throw new InternalError(e.toString());
		}
	}
}
