package com.itqiankun.objectadaptee;

/**
 * @author: ma_qiankun
 * @date: 2023/8/25
 **/
public class AudioPlayerAdapter implements OldAudioPlayer {
	private NewAudioPlayer newAudioPlayer;

	public AudioPlayerAdapter(NewAudioPlayer newAudioPlayer) {
		this.newAudioPlayer = newAudioPlayer;
	}

	@Override
	public void playMp3(String filename) {
		// 将 playMp3 方法转换为 playWav 方法
		newAudioPlayer.playWav(filename);
	}
}
