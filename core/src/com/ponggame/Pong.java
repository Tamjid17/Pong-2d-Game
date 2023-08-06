package com.ponggame;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.ponggame.actors.Ball;
import com.ponggame.actors.Player1;
import com.ponggame.actors.Player2;

public class Pong implements Screen {
	private Game game;
	SpriteBatch batch;
	Texture img;
	Ball ball;
	Player1 p1;
	Player2 p2;

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
		batch.end();
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
}
