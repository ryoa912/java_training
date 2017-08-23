/**
 * Copyright © 2017 Ryoh Aruga, All Rights Reserved.
 */
package specialclock.components;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundFilePlayer {
	public static void play(String filePath) {
		try {
            System.out.println("Sound Start");
            final AudioInputStream ais =
                    AudioSystem.getAudioInputStream(new File(filePath));
            ais.getFormat();
            final Clip line = AudioSystem.getClip();
            line.open(ais);
            line.start();
            System.out.println("Playing...");
            Thread.sleep(1);
            line.drain();
            line.stop();
            line.close();
            System.out.println("Sound End");
        } catch (final Exception e) {
            System.out.println(e);
        }
	}
}
