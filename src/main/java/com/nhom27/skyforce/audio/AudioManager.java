package com.nhom27.skyforce.audio;

import com.nhom27.skyforce.utils.AssetManager;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class AudioManager {
    private static AudioManager instance;
    private boolean isMuted = false;
    private MediaPlayer mediaPlayer;

    private AudioManager() {
        Media media = AssetManager.getMusic("background_home_music");
        mediaPlayer = new MediaPlayer(media);
        // Vòng lặp âm thanh vô hạn
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

    public static AudioManager getInstance() {
        if (instance == null)
            instance = new AudioManager();
        return instance;
    }

    public void toggleMute() {
        isMuted = !isMuted;
        if (mediaPlayer != null) {
            mediaPlayer.setMute(isMuted);
        }
    }

    public boolean isMuted() {
        return isMuted;
    }
}
