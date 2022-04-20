package sound;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class BGM {
  public BGM() {
	try {
		AudioInputStream ais = AudioSystem.getAudioInputStream(new File("sound/bgm.way"));
		Clip clip = AudioSystem.getClip();
		clip.open(ais);
		//소리 설정
		FloatControl control = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
		//볼륨 조절
		control.setValue(-40.0f);//접미사 사용
		clip.start();
	} catch (Exception e) {
		
		e.printStackTrace();
	}
}
}
