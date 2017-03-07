/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch16.ex05;

import jpl.ch16.ex04.BugsFixed;

public class ColorAttr extends Attr {
	private ScreenColor myColor; //変換された色

	@BugsFixed ({"457605", "532456"})
	public ColorAttr(String name, Object value) {
		super(name, value);
		decodeColor();
	}

	@BugsFixed ({"457605", "532456"})
	public ColorAttr(String name) {
		this(name, "transparent");
	}

	@BugsFixed ({"457605", "532456"})
	public ColorAttr(String name, ScreenColor value) {
		super(name, value.toString());
		myColor = value;
	}

	@BugsFixed ({"457605", "532456"})
	public Object setValue(Object newValue) {
		//スーパークラスのsetValueを最初に行う
		Object retval = super.setValue(newValue);
		decodeColor();
		return retval;
	}

	//値を記述ではなくScreenColorに設定する
	@BugsFixed ({"457605", "532456"})
	public ScreenColor setValue(ScreenColor newValue) {
		//スーパークラスのsetValueを最初に行う
		super.setValue(newValue.toString());
		ScreenColor oldValue = myColor;
		myColor = newValue;
		return oldValue;
	}

	//変換されたScreenColorオブジェクトを返す
	@BugsFixed ({"457605", "532456"})
	public ScreenColor getColor() {
		return myColor;
	}

	//getValue()で得られる記述からScreenColorを設定する
	@BugsFixed ({"457605", "532456"})
	protected void decodeColor() {
		if (getValue() == null)
			myColor = null;
		else
			myColor = new ScreenColor(getValue());
	}

	//equalsをオーバーライド
	@BugsFixed ({"457605", "532456"})
	public boolean equals(Object obj) {
		if (this.getValue() == obj)
			return true;
		else
			return false;
	}

	//hashCodeをオーバーライド
	@BugsFixed ({"457605", "532456"})
	public int hashCode() {
		return getValue().hashCode();
	}
}
