package com.ponggame.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ponggame.Constants;

public class Player2 {
    SpriteBatch batch;
    static Sprite p2Sprite;
    public static float p2posX;
    public static float p2posY;
    public final float p2Speed = Constants.PADDLE_SPEED;
    public Player2(SpriteBatch batch){
        this.batch = batch;
        p2Sprite = new Sprite(new Texture(Gdx.files.internal("1.png")));
        p2posX = 770f;
        p2posY = Constants.SCREEN_HEIGHT/2f;
    }
    public void control(){
        if(Gdx.input.isKeyPressed(Input.Keys.UP))
            p2posY += p2Speed;
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
            p2posY -= p2Speed;
        if(p2posY < 0)
            p2posY += p2Speed;
        else if(p2posY > Constants.SCREEN_HEIGHT - p2Sprite.getHeight())
            p2posY -= p2Speed;
    }
    public void render(){
        control();
        batch.draw(p2Sprite, p2posX, p2posY);
    }
    public static float getWidth(){
        return p2Sprite.getWidth();
    }
    public static float getHeight(){
        return p2Sprite.getHeight();
    }
}
