package com.example.textadventuregame.view;

import android.content.Context;
import android.media.MediaPlayer;

import com.example.textadventuregame.R;

public class MusicPlayer extends MediaPlayer {
    public static MusicPlayer musicPlayer;
    private MusicPlayer(){
    }
    public static synchronized MusicPlayer getInstance(Context ctx) {
        if (musicPlayer == null) {
            musicPlayer = (MusicPlayer) MediaPlayer.create(ctx, R.raw.startwindow);
        }
        return musicPlayer;
    }
    public void startMusic() {
        musicPlayer.start();
        musicPlayer.setOnCompletionListener(mp -> musicPlayer.start());
    }
    public void stopMusic() {
        musicPlayer.stop();
    }
}
