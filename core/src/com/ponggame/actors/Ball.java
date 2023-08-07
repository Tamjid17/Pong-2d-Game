package com.ponggame.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.ponggame.Constants;
import com.ponggame.Pong;

public class Ball {
    SpriteBatch batch;
    Sprite ballSprite;
    Rectangle rectangleP1;
    Rectangle rectangleP2;
    Rectangle rectangleBall;
    Sound hit, cheer, whistle;
    private float ballPosX = Constants.SCREEN_WIDTH/2;
    private float ballPosY = Constants.SCREEN_HEIGHT/2;
    public float ballDirectionX, ballDirectionY;
     boolean moving = true;
    public Ball(SpriteBatch batch){
        this.batch = batch;
        ballSprite = new Sprite(new Texture(Gdx.files.internal("pongBall.png")));
        ballDirectionX = ballDirectionY = Constants.BALL_DIRECTION;
        hit = Gdx.audio.newSound(Gdx.files.internal("PongBall.mp3"));
        cheer = Gdx.audio.newSound(Gdx.files.internal("Cheers.mp3"));
        whistle = Gdx.audio.newSound(Gdx.files.internal("Whistle.mp3"));
    }
    public void render(){
        if (moving) {
            if((!Pong.paused())) {
                run();
            }
            else{

            }
            collision();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            Whistle();
            moving = true;
        }
        batch.draw(ballSprite, ballPosX, ballPosY);
    }
    private void run(){
        ballPosX += ballDirectionX;
        ballPosY += ballDirectionY;
        if(ballPosY < 0 || ballPosY > Constants.SCREEN_HEIGHT - ballSprite.getHeight())
            ballDirectionY = -ballDirectionY;
    }
    protected void collision(){
        rectangleP1 = new Rectangle(Player1.p1posX, Player1.p1posY, Player1.getWidth(), Player1.getHeight());
        rectangleP2 = new Rectangle(Player2.p2posX, Player2.p2posY, Player2.getWidth(), Player2.getHeight());
        rectangleBall = new Rectangle(ballPosX, ballPosY, ballSprite.getWidth(), ballSprite.getHeight());
        if(rectangleBall.overlaps(rectangleP1) || rectangleBall.overlaps(rectangleP2)){
            hit();
            ballDirectionX = -ballDirectionX;
        }
        if(ballPosX < 0) {
            Cheers();
            moving = false;
            ballDirectionX = -ballDirectionX;
            ballPosY = Constants.SCREEN_HEIGHT/2f;
            ballPosX = Constants.SCREEN_WIDTH/2f;
        }
         if(ballPosX > Constants.SCREEN_WIDTH - ballSprite.getWidth()){
             Cheers();
             moving = false;
             ballDirectionX = -ballDirectionX;
             ballPosY = Constants.SCREEN_HEIGHT/2f;
             ballPosX = Constants.SCREEN_WIDTH/2f-14.8f;
        }
    }
    public void hit(){
        hit.play(1.5f);
    }
    public void Cheers(){
        cheer.play(1.5f);
    }
    public void Whistle(){
        whistle.play(1.5f);
    }
}