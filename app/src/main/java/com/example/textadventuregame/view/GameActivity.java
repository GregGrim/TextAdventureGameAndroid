package com.example.textadventuregame.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.textadventuregame.R;
import com.example.textadventuregame.controller.GameController;
import com.example.textadventuregame.controller.SaveLoadManager;

import java.io.File;

public class GameActivity extends AppCompatActivity {
    private GameController gameController;

    private ImageView locationImage;
    private TextView locationText;
    private Button menuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Intent intent = getIntent();
        Object parameter = intent.getStringExtra("parameter");
        initData(parameter);
        setupControls();
        renderScreen();
    }

    private void initData(Object obj) {
        if(obj.getClass().equals(String.class)) {
            gameController = new GameController();
            gameController.createGameModel();
            gameController.gameStart((String) obj);
        } else if(obj.getClass().equals(File.class)){
            SaveLoadManager.loadGame(((File) obj).getName());
        }
    }

    private void setupControls() {
        locationImage = findViewById(R.id.locationImage);

        locationText = findViewById(R.id.locationInfo);
        locationText.setText("");
        locationText.setTextSize(15);
        locationText.setTextColor(Color.WHITE);
        menuButton.findViewById(R.id.menuBtn);
        menuButton.setBackgroundColor(Color.GRAY);
        menuButton.setTextSize(18);
        menuButton.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        // TODO event listener
    }

    private void renderScreen() {
        renderLocationImage();
        renderLocationText();

    }



    private void renderLocationImage(){
        String imageFileName = gameController.getLocationImageName();
        int imageResourceId = getResources().getIdentifier(imageFileName, "drawable", getPackageName());
        locationImage.setImageResource(imageResourceId);
    }
    private void renderLocationText() {
        locationText.setText(gameController.getLocationText());
    }
}