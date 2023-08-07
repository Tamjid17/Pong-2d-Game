package com.ponggame;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Menu implements Screen {
    private Game game;
    SpriteBatch batch;
    Texture menuTexture;

    public Menu(Game game){
        this.game = game;
    }
    public void show() {
        batch = new SpriteBatch();
        menuTexture = new Texture(Gdx.files.internal("PingMenu.png"));
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    public void render(float delta) {
        ScreenUtils.clear(1, 0, 0, 1);
        batch.begin();
        batch.draw(menuTexture, 0, 0);
        batch.end();

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            // Transition to the game screen
            game.setScreen(new Pong(game));
        }
    }

    public void dispose() {
        menuTexture.dispose();
    }
}
