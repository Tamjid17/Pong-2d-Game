package com.ponggame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

public class MenuManager extends Game {

    @Override
    public void create() {
        setScreen(new Menu(this));
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keycode) {
                // Handle key events (e.g., back button, menu button, etc.)
                if (keycode == Input.Keys.BACK) {
                    // Implement back button functionality if needed
                    return true;
                }
                return false;
            }
        });
    }
    @Override
    public void render(){
        super.render();
    }
}
