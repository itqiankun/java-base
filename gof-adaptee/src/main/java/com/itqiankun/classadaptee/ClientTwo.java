package com.itqiankun.classadaptee;

import com.itqiankun.objectadaptee.OldAudioPlayer;

/**
 * @author: ma_qiankun
 * @date: 2023/8/25
 **/
public class ClientTwo {
	public static void main(String[] args) {
		// 创建新的音频播放器对象
		OldAudioPlayerTwo audioPlayerAdapterTwo = new AudioPlayerAdapterTwo();

		// 使用适配器播放 MP3 文件
		audioPlayerAdapterTwo.playMp3("song.mp3");
	}
}
