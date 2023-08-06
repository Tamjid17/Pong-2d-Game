package com.ponggame.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ponggame.Constants;

public class Player1 {
    SpriteBatch batch;
    static Sprite p1Sprite;
    public static float p1posX;
    public static float p1posY;
    public final float p1Speed = Constants.PADDLE_SPEED;
    public Player1(SpriteBatch batch){
        this.batch = batch;
        p1Sprite = new Sprite(new Texture(Gdx.files.internal("0.png")));
        p1posX = 10f;
        p1posY = Constants.SCREEN_HEIGHT/2f;
    }
    public void control(){
        if(Gdx.input.isKeyPressed(Input.Keys.W))
            p1posY += p1Speed;
        if(Gdx.input.isKeyPressed(Input.Keys.S))
            p1posY -= p1Speed;
        if(p1posY < 0)
            p1posY += p1Speed;
        else if(p1posY > Constants.SCREEN_HEIGHT - p1Sprite.getHeight())
            p1posY -= p1Speed;
    }
    public void render(){
        control();
        batch.draw(p1Sprite, p1posX, p1posY);
    }
    public static float getWidth(){
        return p1Sprite.getWidth();
    }
    public static float getHeight(){
        return p1Sprite.getHeight();
    }
}
