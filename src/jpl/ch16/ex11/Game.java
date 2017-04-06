/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package jpl.ch16.ex11;

public class Game {
	public static void main(String[] args) {
		String name;	//クラス名
		while ( (name = getNextPlayer()) != null) {
			try {
				PlayerLoader loader = new PlayerLoader();
				Class<? extends Player> classOf =
						loader.loadClass(name).asSubclass(Player.class);
				Player player = classOf.newInstance();
				Game game = new Game();
				player.play(game);
				game.reportScore(name);
			} catch (Exception e){
				reportException(name, e);
			}
		}
	}

	private static String getNextPlayer() {
		//プレイヤーの取得
		return null;
	}

	private void reportScore(String name) {
		//結果の出力
	}

	private static void reportException(String name, Exception e) {
		//例外の出力
	}
}
