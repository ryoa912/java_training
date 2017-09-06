/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package specialclock.components;

import java.io.IOException;

public class VoiceroidPlayer {
	private String voiceroid_path = "src\\specialclock\\lib\\echoseika.exe";
	private String voiceroid_name = "TAMMY_EX";
	private String wave_file_path = "src\\specialclock\\voice";

	private Runtime rt = Runtime.getRuntime();

	// VOICEROID実行ファイルのパスを変更する
	public void changeVoiceroidPath(String path) {
		voiceroid_path = path;
	}
	// VOICEROID名を変更する
	public void changeVoiceroidName(String cv) {
		voiceroid_name = cv;
	}
	// VOICEROIDに音声データの保存ファイルパスを設定する
	public void setWavFilePath(String path) {
		wave_file_path = path;
	}

	// VOICEROIDに発声するテキストを設定し、発声させる
	public void setAndPlay(String talkText) throws IOException, InterruptedException {
		String[] str = new String[]{voiceroid_path,
				"-cv", voiceroid_name, talkText};
		Process p = rt.exec(str);
		p.waitFor();    // プロセスが終了するまで待機する
		p.destroy();    // プロセスを明示的に終了させ、資源を回収できるようにする
	}
	/*
	public void setTalkText(String talkText);			// VOICEROIDに発声するテキストを設定する
	public void play();									// VOICEROIDを発声させる
	public void save();									// VOICEROIDを発声させずに音声データを保存する
	public void playAndSave();							// VOICEROIDを発声させ、音声データを保存する
	public void setAndPlayAndSave(String talkText);		// VOICEROIDに発生するテキストを設定し、発声させ、音声データを保存する
*/
}