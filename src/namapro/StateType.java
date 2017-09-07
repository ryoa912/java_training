/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package namapro;

public enum StateType {
	// 列挙定数を増やすと扱えるアニメーションが増える
    NORMAL(3000,
            new Frame(0, "/namapro/sd_eye1.png"),
            new Frame(100, "/namapro/sd_eye2.png"),
            new Frame(200, "/namapro/sd_eye1.png"),
            new Frame(300, "/namapro/sd_eye0.png"),
            new Frame(3000, "/namapro/sd_eye0.png")),
    DRAG(Integer.MAX_VALUE,
            new Frame(1, "/namapro/sd04.png")),
    SPEECH(3000,
            new Frame(0, "/namapro/sd_mouth1.png"),
            new Frame(200, "/namapro/sd_mouth2.png"),
            new Frame(400, "/namapro/sd_mouth1.png"),
            new Frame(600, "/namapro/sd_mouth0.png"));

    private State state;

    StateType(int rate, Frame... frames) {
        state = new State(rate, frames);
    }

    public State getState() {
        return state;
    }
}
