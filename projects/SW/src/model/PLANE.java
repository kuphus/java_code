package model;

//import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import java.io.File;

import javafx.scene.image.ImageView;

public enum PLANE{

  BLUE("view/resources/planes/planeBlue1.png", "src/sound/resources/engineSound.mp3", 1, 5),
  GREEN("view/resources/planes/planeGreen1.png", "src/sound/resources/engineSound.mp3", 1, 10),
  RED("view/resources/planes/planeRed1.png", "src/sound/resources/engineSound.mp3", 1, 25),
  YELLOW("view/resources/planes/planeYellow1.png", "src/sound/resources/engineSound.mp3", 1, 100);

  private int bombCapacity;
  private double maxSpeed;

  //--
  private ImageView planeImage;
  private String planeURL;
  private int yCoordinate;
  private double currVertSpeed;
  private double currHorSpeed;
  private int angle;



  private boolean engineOn = false;
  private boolean airborne = false;
  private boolean crashed = false;


  private AudioClip enginePlayer;
  private AudioClip crashPlayer;


  private PLANE(String planeURL, String planeSoundURL, double maxSpeed, int bombCapacity){
    planeImage = new ImageView(planeURL);
    this.bombCapacity = bombCapacity;
    this.planeURL = planeURL;
    this.maxSpeed = maxSpeed;
    angle = 0;
    try{
      File engineFile = new File(planeSoundURL);
      enginePlayer = new AudioClip(engineFile.toURI().toString());
      enginePlayer.setCycleCount(AudioClip.INDEFINITE);
      File crashFile = new File("src/sound/resources/crash.mp3");
      crashPlayer = new AudioClip(crashFile.toURI().toString());
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }

  //Getters and setters
  public int getBombCapacity() {
    return this.bombCapacity;
  }

  public double getSpeed(){
    return this.maxSpeed;
  }



  public String getURL(){
    return this.planeURL;
  }

  public ImageView getPlaneImage(){
    return planeImage;
  }

  public int getYCoordinate(){
    return yCoordinate;
  }

  public void setYCoordinate(int y){
    yCoordinate = y;
  }

  public double getCurrVertSpeed(){
    return currVertSpeed;
  }

  public void setCurrVertSpeed(double currVertSpeed){
    this.currVertSpeed = currVertSpeed;
  }

  public double getCurrHorSpeed() {
    return currHorSpeed;
  }

  public void setCurrHorSpeed(double currHorSpeed){
    this.currHorSpeed = currHorSpeed;
  }

  public int getAngle(){
    return angle;
  }

  public void setAngle(int angle){
    this.angle = angle;
  }



  public boolean isEngineOn(){
    return engineOn;
  }
  
  public void setEngineOnOff(boolean onOff){
    engineOn = onOff;
  }

  public boolean isAirborne() {
    return airborne;
  }

  public void setAirborne(boolean airborne){
    this.airborne = airborne;
  }

  public boolean isCrashed(){
    return crashed;
  }

  public void setCrashed(boolean crashed){
    this.crashed = crashed;
  }



  // Sound methods
  public void playEngine(){
    this.enginePlayer.play();
  }

  public void stopEngine(){
    this.enginePlayer.stop();
  }

  public void playCrash(){
    this.crashPlayer.play();
  }

}