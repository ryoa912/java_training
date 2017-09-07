/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package specialclock.components;

import java.io.IOException;

public class VoiceroidPlayer {
	private static String voiceroid_path = "C:\\Program Files (x86)\\AHS\\VOICEROID+\\TamiyasuEX\\VOICEROID.exe";
	private static String echoseika_path = "src\\specialclock\\lib\\echoseika.exe";
	private static String voiceroid_name = "TAMMY_EX";
	private static String wave_file_path = "src\\specialclock\\voice";

	private static Runtime rt = Runtime.getRuntime();

	// VOICEROIDを起動する
	public static void startVoiceroid() throws IOException, InterruptedException {
		String[] str = new String[]{voiceroid_path};
		asyncProcess(str);
	}

	// VOICEROIDに現在時刻を発声させる
	public static void playTime() throws IOException, InterruptedException {
		setAndPlay(Clock.getDateTalk() + " " + Clock.getTimeTalk() + "です。");
	}

	// VOICEROIDに発声するテキストを設定し、発声させる
	public static void setAndPlay(String talkText) throws IOException, InterruptedException {
		String[] str = new String[]{echoseika_path,
				"-cv", voiceroid_name, talkText};
		syncProcess(str);
	}

	// VOICEROIDを発声させずに音声データを保存する
	public static void save(String talkText) throws IOException, InterruptedException {
		String[] str = new String[]{echoseika_path,
				"-wav", wave_file_path + "\\" + talkText, talkText};
		syncProcess(str);
	}

	// 同期プロセスを実行する
	private static void syncProcess(String[] str) throws IOException, InterruptedException {
		Process p = rt.exec(str);
		p.waitFor();    // プロセスが終了するまで待機する
		p.destroy();    // プロセスを明示的に終了させ、資源を回収できるようにする
	}

	// 非同期プロセスを実行する
	private static void asyncProcess(String[] str) throws IOException, InterruptedException {
		rt.exec(str);
	}
}
