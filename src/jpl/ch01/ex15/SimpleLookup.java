package jpl.ch01.ex15;

public class SimpleLookup implements Lookup {
	private String[] names;
	private Object[] values;

	@Override
	public Object find(String name) {
		for (int i=0; i < names.length; i++) {
			if (names[i].equals(name)) {
				return values[i];
			}
		}
		return null;
	}

	@Override
	public void add(String name, Object value) {
		int newLength;
		if (names == null) {
			newLength = 1;
		} else {
			newLength = names.length + 1;
		}
		String[] newStrArray = new String[newLength];
        Object[] newValueArray = new Object[newLength];

        for (int i = 0; i < newLength-1; ++i) {
        	newStrArray[i] = names[i];
        	newValueArray[i] = values[i];
        }

        names = newStrArray;
        values = newValueArray;

        names[newLength-1] = name;
        values[newLength-1] = value;

	}

	@Override
	public void remove(String name) {
		for (int i=0; i < names.length; i++) {
			if (names[i].equals(name)) {
				//削除して配列を詰める。
				String[] newStrArray = new String[names.length - 1];
		        Object[] newValueArray = new Object[names.length - 1];

		        for (int j = 0; j < names.length; ++j) {
		        	if (i != j) {
			        	newStrArray[j] = names[j];
			        	newValueArray[j] = values[j];
		        	}
		        }

		        i--;
			}
		}
	}

}
