package model;

import javafx.scene.image.ImageView;

import javafx.scene.media.AudioClip;
import java.io.File;

public class Explosion {


    String[] ExplosionURLs = new String[] {"view/resources/explosie5.png"};
    private ImageView explosionImage;
    private int countDown = 40;

    private int xCoordinate;
    private int yCoordinate;

    private AudioClip explosionPlayer;

    public Explosion(int x){
        explosionImage = new ImageView(ExplosionURLs[x]);
        //this.countDown = 25;
        File explosionFile = new File("src/sound/resources/explosion.mp3");
        explosionPlayer = new AudioClip(explosionFile.toURI().toString());
    }

    public int getCountDown(){
        return countDown;
    }

    public void setCountDown(int countDown){
        this.countDown = countDown;
    }

    public ImageView getImage() {
        return explosionImage;
    }

    public int getXCoordinate(){
        return xCoordinate;
    }

    public void setXCoordinate(int x){
        xCoordinate = x;
    }

    public int getYCoordinate(){
        return yCoordinate;
    }

    public void setYCoordinate(int y){
        yCoordinate = y;
    }

    public void playExplosion(){
        this.explosionPlayer.play();
    }

}
