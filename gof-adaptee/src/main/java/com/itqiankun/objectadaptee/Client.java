package com.itqiankun.objectadaptee;

/**
 * @author: ma_qiankun
 * @date: 2023/8/25
 **/
public class Client {
	public static void main(String[] args) {
		// 创建新的音频播放器对象
		NewAudioPlayer newAudioPlayer = new NewAudioPlayer();

		// 创建适配器对象
		OldAudioPlayer audioPlayerAdapter = new AudioPlayerAdapter(newAudioPlayer);

		// 使用适配器播放 MP3 文件
		audioPlayerAdapter.playMp3("song.mp3");
	}
}
