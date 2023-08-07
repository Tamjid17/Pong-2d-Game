package com.ponggame;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.ponggame.actors.Ball;
import com.ponggame.actors.Player1;
import com.ponggame.actors.Player2;
import com.badlogic.gdx.Gdx;

public class Pong implements Screen {
	private Game game;
	private static boolean isPaused = false;
	SpriteBatch batch;
	Texture img;
	Ball ball;
	Player1 p1;
	Player2 p2;
	BitmapFont font;
	public Pong(Game game){
		this.game = game;
	}
	@Override
	public void show () {
		batch = new SpriteBatch();
		img = new Texture("pongbg.png");
		ball = new Ball(batch);
		p1 = new Player1(batch);
		p2 = new Player2(batch);
		font = new BitmapFont();
		font.getData().setScale(1, 1);
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

	@Override
	public void render (float delta) {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(img, 0, 0);
		ball.render();
		p1.render();
		p2.render();
		CharSequence player1 = "Player one: " + ball.cnt1;
		CharSequence player2 = "Player two: " + ball.cnt2;
		font.draw(batch, player1, Constants.SCREEN_WIDTH / 6.8f, Constants.SCREEN_HEIGHT - 34.2f);
		font.draw(batch, player2, Constants.SCREEN_WIDTH / 2.0f + 128.8f, Constants.SCREEN_HEIGHT - 34.2f);
		batch.end();
		if (Gdx.input.isKeyJustPressed(Input.Keys.P)) {
			isPaused = true;
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.R)) {
			isPaused = false;
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
			// Transition back to the main menu screen
			game.setScreen(new Menu(game));
		}
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
	public static boolean paused(){
		return isPaused;
	}

}

