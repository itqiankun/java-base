package com.itqiankun.classadaptee;

/**
 * @author: ma_qiankun
 * @date: 2023/8/25
 **/
public class AudioPlayerAdapterTwo extends NewAudioPlayerTwo implements OldAudioPlayerTwo {
	@Override
	public void playMp3(String filename) {

		super.playWav(filename);
	}
}
