package com.example.textadventuregame.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
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
    private TextView playerInfo;
    private ImageButton menuButton;
    private ImageButton inventoryButton;
    private ImageButton levelUpButton;
    private Button eventButton;

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
        locationText.setTextSize(15);
        locationText.setTextColor(Color.WHITE);
        locationText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        menuButton = findViewById(R.id.menuBtn);
        menuButton.setOnClickListener(view -> {
            //showMenu();
        });

        playerInfo = findViewById(R.id.playerInfo);
        playerInfo.setTextColor(Color.YELLOW);
        playerInfo.setTextSize(15);
        playerInfo.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        inventoryButton = findViewById(R.id.inventoryBtn);
        inventoryButton.setOnClickListener(view -> {
            //openInventory();
        });

        levelUpButton = findViewById(R.id.levelUpBtn);
        levelUpButton.setOnClickListener(view -> {
            //levelUp();
        });
        eventButton = findViewById(R.id.eventBtn);
        eventButton.setTextSize(15);
        eventButton.setTextColor(Color.WHITE);
        eventButton.setOnClickListener(view -> {
            // doEvent();
        });
    }

    private void renderScreen() {
        renderLocationImage();
        renderLocationText();
        renderPlayerInfo();
        renderInventoryImage();
        renderLevelUpButton();
        renderEventButton();
    }



    private void renderLocationImage(){
        String imageFileName = gameController.getLocationImageName();
        int imageResourceId = getResources().getIdentifier(imageFileName, "drawable", getPackageName());
        locationImage.setImageResource(imageResourceId);
    }
    private void renderLocationText() {
        locationText.setText(gameController.getLocationText());
    }
    private void renderPlayerInfo() {
          playerInfo.setText(gameController.getPlayerInfoText());
    }
    private void renderInventoryImage() {
        inventoryButton.setImageResource(R.drawable.inventory_icon);
    }
    private void renderLevelUpButton() {
        levelUpButton.setImageResource(R.drawable.levelup);
        if(gameController.checkLevelUp()) {
            levelUpButton.setEnabled(true);
            levelUpButton.setFocusable(true);
            levelUpButton.setVisibility(View.VISIBLE);
        } else{
            levelUpButton.setEnabled(false);
            levelUpButton.setFocusable(false);
            levelUpButton.setVisibility(View.INVISIBLE);
        }
    }
    private void renderEventButton() {
        if(gameController.roomWithEvent()) {
            eventButton.setEnabled(true);
            eventButton.setFocusable(true);
            eventButton.setVisibility(View.VISIBLE);
            eventButton.setText(gameController.roomEventHandleText());
        } else{
            eventButton.setEnabled(false);
            eventButton.setFocusable(false);
            eventButton.setVisibility(View.INVISIBLE);
        }
    }
}