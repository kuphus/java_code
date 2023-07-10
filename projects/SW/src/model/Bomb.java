package model;

import javafx.application.Platform;

import javafx.scene.image.ImageView;

//import javafx.scene.media.AudioClip;
import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.net.URI;

public class Bomb{
  
  String[] BombURLs = new String[] {"view/resources/bomb.png"};

  private int currentDropSpeed;
  private ImageView bombImage;
  //private boolean exploded;
  private int xCoordinate;
  private int yCoordinate;
  private int gameloopTicks;

  private boolean faceRight = true;

  private int angle;

  private MediaPlayer fallingPlayer;



  public Bomb(int x){
    bombImage = new ImageView(BombURLs[x]);
    currentDropSpeed = 1;
    //exploded = false;
    File fallingFile = new File("src/sound/resources/Falling_effect2.mp3");
    Media falling = new Media(fallingFile.toURI().toString());
    fallingPlayer = new MediaPlayer(falling);
  }


  public ImageView getImage(){
    return bombImage;
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

  public int getGameloopTicks() { return gameloopTicks;}

  public void setGameloopTicks(int gameloopTicks){ this.gameloopTicks = gameloopTicks;}

  public boolean isFaceRight() {
    return faceRight;
  }

  public void setFaceRight(boolean faceRight){ this.faceRight = faceRight;}

  public int getSpeed(){
    return currentDropSpeed;
  }

  public void setSpeed(int speed){
    if(speed >= 0){
      currentDropSpeed = speed;
    }
  }

  public int getAngle(){
    return angle;
  }

  public void setAngle(int angle){
    this.angle = angle;
  }
  
  public void startFallNoise(){
    this.fallingPlayer.play();
  }

  public void stopFallNoise(){
    this.fallingPlayer.stop();
  }


}