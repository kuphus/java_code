package view;

import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;

import javafx.scene.shape.Rectangle; /////////////
import javafx.scene.paint.Color;//////////////////

import map.MapLoader;
import model.*;


public class GameViewManager{
  
  private static final int HEIGHT = 768;
  private static final int WIDTH = 1024;
  private static final int PLANE_START_X = 500;
  private static final int PLANE_START_Y = 590;


  private AnchorPane gamePane;                  //LayoutManager
  private Scene gameScene;                      //Scene Graph with Root Node
  private Stage gameStage;                      //Top-Level Window Frame
  
  private Stage menuStage;
  
  //private int[] horizon;
  private boolean[][] map;
  
  private ImageView plane;
  private PLANE chosenPlane;

  private boolean bombKeyReleased;
  private ImageView bombImage;
  private int bombAmount;
  private boolean infiniteBomb;
  private List<Bomb> bombList = new ArrayList<Bomb>();
  private List<ImageView> bombImageList = new ArrayList<ImageView>();
  
  private ImageView explosionImage;
  private List<Explosion> explosionList = new ArrayList<Explosion>();
  private List<ImageView> explosionImageList = new ArrayList<ImageView>();

  private boolean isUpPressed;
  private boolean isDownPressed;
  private AnimationTimer gameTimer;
  private boolean falldown;
  private boolean stall;
  
  private GameSubScene scene1;
  private GameSubScene background1;
  private String mapPath;
  private ImageView buildingImage;
  private InfoLabel gameLabel;

  private ImageView[] playerLifes;
  private int playerLife;
  private int points;

  private Rectangle box;////////////////////////////////

//-------Constructor and corresponding methods----------------------------------------------------------
  
  public GameViewManager(String mapPath){
    this.mapPath = mapPath;
    initializeStage();
    createKeyListeners();
    this.bombKeyReleased=true;
  }

  private void initializeStage(){
    gamePane = new AnchorPane();
    gameScene = new Scene(gamePane, WIDTH, HEIGHT);
    gameStage = new Stage();
    gameStage.setScene(gameScene);
    try{
        this.map = MapLoader.loadMap(mapPath);
    }
    catch(FileNotFoundException e){
      System.out.println("map not loaded");
      e.printStackTrace();
    }
  }

  private void createKeyListeners(){
    gameScene.setOnKeyPressed(new EventHandler<KeyEvent>(){
      @Override
      public void handle(KeyEvent event){
        if(!stall) {
          if (event.getCode() == KeyCode.E) {
            chosenPlane.setEngineOnOff(!chosenPlane.isEngineOn());
            if (chosenPlane.isEngineOn()) {
              chosenPlane.playEngine();
              falldown = false;
            } else {
              if (!chosenPlane.isEngineOn() && chosenPlane.isAirborne()) {
                falldown = true;
              }
              chosenPlane.stopEngine();
            }
          } else if (event.getCode() == KeyCode.UP) {
            isUpPressed = true;
          } else if (event.getCode() == KeyCode.DOWN) {
            isDownPressed = true;
          } else if (event.getCode() == KeyCode.B) {
            if ((infiniteBomb || bombAmount > 0) && bombKeyReleased) {
                bombKeyReleased = false;
                dropBomb();
                bombAmount--;
            }
          } else if (event.getCode() == KeyCode.SPACE) {
            gameLabel.setText("Shooting");
          } else if (event.getCode() == KeyCode.R) {
            if (plane.getScaleY() == (-1)) {
              plane.setScaleY(1);
            } else if (plane.getScaleY() == 1) {
              plane.setScaleY(-1);
            }
          }
        }
      }
    });
    gameScene.setOnKeyReleased(new EventHandler<KeyEvent>(){
      @Override
      public void handle(KeyEvent event){
        if (event.getCode() == KeyCode.UP){
          isUpPressed = false;
        }
        else if (event.getCode() == KeyCode.DOWN){
          isDownPressed = false;
        }
        else if (event.getCode() == KeyCode.B){
          bombKeyReleased = true;
        }
        }
    });
  }

//--------Initiation methods-----------------------------------------------------------------------------

  public void createNewGame(Stage menuStage, PLANE chosenPlane, boolean infiniteBomb){
    this.menuStage = menuStage;
    this.menuStage.hide();
    this.chosenPlane = chosenPlane;
    this.bombAmount = chosenPlane.getBombCapacity();
    this.infiniteBomb = infiniteBomb;
    this.points = 0;
    this.stall=false;
    createGameSubScene();
    createGameLabel();
    createPlane(chosenPlane);
    createGameElements(chosenPlane);
    createGameLoop();
    gameStage.show();
  }

  private void createGameSubScene(){
    background1 = new GameSubScene("map/resources/background.png", 6144, 768);
    gamePane.getChildren().add(background1);

    scene1 = new GameSubScene(mapPath.substring(4), 5120, 768);
    gamePane.getChildren().add(scene1);
    //loadBuildings();

    createBuildings(1);
  }

  private void createBuildings(int amount){
    for(int index = 0; index <= amount; index++) {
      Building building = new Building(0);
      buildingImage = building.getImage();
      buildingImage.setPreserveRatio(true);
      buildingImage.setFitWidth(50);
      building.setxCoordinate(PLANE_START_X-150);
      buildingImage.setLayoutX(building.getxCoordinate());
      buildingImage.setLayoutY(570);
      gamePane.getChildren().add(buildingImage);
    }
  }

  private void createGameLabel(){
    gameLabel = new InfoLabel("Score: " + points);
    gameLabel.setLayoutX(25);
    gameLabel.setLayoutY(25);
    gamePane.getChildren().add(gameLabel);
  }
  
  private void createPlane(PLANE chosenPlane){
    //--plane = new ImageView(chosenPlane.getURL());
    /*
    plane image heeft 4 coordinaten:
     int height = 30;
    int width = 36;
    plane_start_x, plane_start_y voor linksboven
    plane_start_x + 30, plane_start_y voor linksonder
    plane_start_x, plane_start_y + 36 voor rechtsboven
    plane_start_x + 30, plane_start_y + 36 voor rechtsonder

    */
    box = new Rectangle(PLANE_START_X,PLANE_START_Y,36,30);
    box.setFill(Color.WHITE);
    gamePane.getChildren().add(box);


    plane = chosenPlane.getPlaneImage();
    plane.setPreserveRatio(true);
    plane.setFitHeight(30);
    plane.setLayoutX(PLANE_START_X);
    plane.setLayoutY(PLANE_START_Y);
    plane.setRotationAxis(Rotate.Z_AXIS);
    gamePane.getChildren().add(plane);

    chosenPlane.setYCoordinate(PLANE_START_Y);
  }

  private void createGameElements(PLANE chosenPlane){
    playerLife = 2;
    playerLifes = new ImageView[3];
    for(int i=0; i < playerLifes.length; i++){
      ImageView tempIm = new ImageView( chosenPlane.getURL() );
      tempIm.setPreserveRatio(true);
      tempIm.setFitHeight(20);
      playerLifes[i] = tempIm;
      playerLifes[i].setLayoutX(25 + (i * 30));
      playerLifes[i].setLayoutY(80);
      gamePane.getChildren().add(playerLifes[i]);
    }
  }

  private void createGameLoop(){
    gameTimer = new AnimationTimer(){

      @Override
      public void handle(long now){
        if(chosenPlane.getYCoordinate()<45){
          gameLabel.setText("STALL Warning!");
          if(chosenPlane.getYCoordinate()<15){
            gameLabel.setText("STALL");
            falldown=true;
            stall = true;
            falldown();
          }
        }
        else{
          gameLabel.setText("Score: " + points);
        }
        if(chosenPlane.isCrashed()){
          try{
            Thread.sleep(4000);
          }
          catch(InterruptedException e){
            e.printStackTrace();
            gameStage.close();
            gameTimer.stop();
            menuStage.show();
          }
          reset();
        }
        if(falldown){
          falldown();
        }
        else {
          if (chosenPlane.isEngineOn()) {
            movePlane();
          }
          rotatePlane();
        }
        if(!bombList.isEmpty()){
          moveBombs();
        }
        if (!explosionImageList.isEmpty()){
          moveExplosions();
        }

        if(checkPlaneCollision()){
          chosenPlane.playCrash();
          chosenPlane.stopEngine();
          chosenPlane.setCrashed(true);
          gameLabel.setText("CRASH!!!");
        }
        box.setX((int)plane.getLayoutX());
        box.setY((int)plane.getLayoutY());
        calculateCoordinates();
      }
    };
    gameTimer.start();
  }





//--------Loop methods-----------------------------------------------------------------------------



  // handles plane (image) rotation
  private void rotatePlane(){
    if (isUpPressed && !isDownPressed){
      if(chosenPlane.isEngineOn()){
        chosenPlane.setAngle(chosenPlane.getAngle()-5);
        chosenPlane.setAirborne(true);
        if(chosenPlane.getAngle() < 0){
          chosenPlane.setAngle(chosenPlane.getAngle()+360);
        }
        plane.setRotationAxis(Rotate.Z_AXIS);
        plane.setRotate(chosenPlane.getAngle());
      }
    }
    if (!isUpPressed && isDownPressed){
      if(chosenPlane.isEngineOn() && chosenPlane.isAirborne()){
        chosenPlane.setAngle(chosenPlane.getAngle()+5);
        if(chosenPlane.getAngle() > 360){
          chosenPlane.setAngle(chosenPlane.getAngle()-360);
        }
        plane.setRotationAxis(Rotate.Z_AXIS);
        plane.setRotate(chosenPlane.getAngle());
      }
    }
  }

  private void calculateCoordinates(){
    /*
    // cx, cy - center of square coordinates
    // x, y - coordinates of a corner point of the square
    // theta is the angle of rotation

    // translate point to origin
    float tempX = x - cx;
    float tempY = y - cy;

    // now apply rotation
    float rotatedX = tempX*cos(theta) - tempY*sin(theta);
    float rotatedY = tempX*sin(theta) + tempY*cos(theta);

    // translate back
    x = rotatedX + cx;
    y = rotatedY + cy;
    */
    //--------------------------------------------------
    int Cx = (int)plane.getLayoutX() + 18;      // the coordinates of your center point in world coordinates
    int Cy = (int)plane.getLayoutY() + 15;      // the coordinates of your center point in world coordinates
    int W  = 36;                                // the width of your rectangle
    int H  = 30;                                 // the height of your rectangle
    int tempAngle = chosenPlane.getAngle();     // the angle you wish to rotate

    //The offset of a corner in local coordinates (i.e. relative to the pivot point)
    //(which corner will depend on the coordinate reference system used in your environment)
    float Ox = (int)(scene1.getGameSceneLayoutX()* -1) + (int)plane.getLayoutX();
    float Oy = (int)plane.getLayoutY();

    //The rotated position of this corner in world coordinates
    double Rx = Cx + (Ox  * Math.cos(tempAngle)) - (Oy * Math.sin(tempAngle));
    double Ry = Cy + (Ox  * Math.sin(tempAngle)) + (Oy * Math.cos(tempAngle));

    System.out.println("newX: " + (int)Rx + " and newY: " + (int)Ry);
    int leftX = (int)(scene1.getGameSceneLayoutX()* -1) + (int)plane.getLayoutX();
    int topY = (int)plane.getLayoutY();
    System.out.println("oldX: " + leftX + " and oldY: " + topY);
  }


  /* 0 - 90  dus 5 / 90 per graad op X as en 3 / 90 per graad op y as
   *
   * Dus op 0 is het 90*(5/90) en 0*(3/90)        Dus voor sub is het (90 - angle)* (5/90) en voor plane is het angle * (3/90)
   * Op 90 is het 0*(5/90) en 90*(3/90)
   *
   * 90 - 180
   * subangle = angle - 90
   *
   * Dus op 0 is het 0*(5/90) en 90*(3/90)   Dus voor sub is het angle * (5/90) en voor plane is het (90-angle) * (3/90)
   * Op 90 is het 90*(5/90) en 0*(3/90)
   *
   * 180 - 270
   * dus op 0 is het 90
   */
  private void movePlane(){
    if(chosenPlane.getAngle() >= 0 && chosenPlane.getAngle() <= 90){
      chosenPlane.setCurrHorSpeed(-((90 - chosenPlane.getAngle()) * (5D/90D)));          // * chosenPlane.getSpeed()
      chosenPlane.setCurrVertSpeed(chosenPlane.getAngle() * (5D/90D));       // * chosenPlane.getSpeed()
      sideMove(chosenPlane.getCurrHorSpeed());
      chosenPlane.setYCoordinate((int)(plane.getLayoutY() + (int)(Math.round(chosenPlane.getCurrVertSpeed()))));
      plane.setLayoutY(chosenPlane.getYCoordinate());
    }
    else if(chosenPlane.getAngle() > 90 && chosenPlane.getAngle() <=180){
      chosenPlane.setCurrHorSpeed((chosenPlane.getAngle() - 90) * (5D/90D));
      chosenPlane.setCurrVertSpeed((90 - (chosenPlane.getAngle() - 90)) * (5D/90D));
      sideMove(chosenPlane.getCurrHorSpeed());
      chosenPlane.setYCoordinate((int)(plane.getLayoutY() + (int)(Math.round(chosenPlane.getCurrVertSpeed()))));
      plane.setLayoutY(chosenPlane.getYCoordinate());
    }
    else if(chosenPlane.getAngle() > 180 && chosenPlane.getAngle() <=270){
      chosenPlane.setCurrHorSpeed((90 - (chosenPlane.getAngle() - 180)) * (5D/90D));
      chosenPlane.setCurrVertSpeed(-((chosenPlane.getAngle()-180) * (3D/90D)));
      sideMove(chosenPlane.getCurrHorSpeed());
      chosenPlane.setYCoordinate((int)(plane.getLayoutY() + (int)(Math.round(chosenPlane.getCurrVertSpeed()))));
      plane.setLayoutY(chosenPlane.getYCoordinate());
    }
    else if(chosenPlane.getAngle() > 270 && chosenPlane.getAngle() <=360){
      chosenPlane.setCurrHorSpeed(-((chosenPlane.getAngle()-270) * (5D/90D)));
      chosenPlane.setCurrVertSpeed(-((90 - (chosenPlane.getAngle()-270)) * (3D/90D)));
      sideMove(chosenPlane.getCurrHorSpeed());
      chosenPlane.setYCoordinate((int)(plane.getLayoutY() + (int)(Math.round(chosenPlane.getCurrVertSpeed()))));
      plane.setLayoutY(chosenPlane.getYCoordinate());
    }
  }

  private void falldown(){
    // speed
    chosenPlane.setCurrVertSpeed(chosenPlane.getCurrVertSpeed()+0.1);
    chosenPlane.setYCoordinate((int)(plane.getLayoutY() + (int)(Math.round(chosenPlane.getCurrVertSpeed()))));
    plane.setLayoutY(chosenPlane.getYCoordinate());

    //still do some horizontal movement
    sideMove(chosenPlane.getCurrHorSpeed());

    // rotate down
    if(chosenPlane.getAngle() > 360){
      chosenPlane.setAngle(chosenPlane.getAngle()-360);
    }
    if(chosenPlane.getAngle() < 90 || chosenPlane.getAngle() >= 270){
      chosenPlane.setAngle(chosenPlane.getAngle()+5);
      plane.setRotationAxis(Rotate.Z_AXIS);
      plane.setRotate(chosenPlane.getAngle());
    }
    else if (chosenPlane.getAngle() > 90 || chosenPlane.getAngle() < 270) {
      chosenPlane.setAngle(chosenPlane.getAngle() - 5);
      plane.setRotationAxis(Rotate.Z_AXIS);
      plane.setRotate(chosenPlane.getAngle());
    }
  }

  private void sideMove(double distance){
    scene1.moveSubScene(distance);
  }

  // adds a new bomb to the end of the list (higher index equals higher altitude)
  private void dropBomb(){
    Bomb bomb = new Bomb(0);
    bomb.setXCoordinate((int)(scene1.getGameSceneLayoutX()* -1) + (int)plane.getLayoutX()+9);
    bombImage = bomb.getImage();
    bombImage.setPreserveRatio(true);
    bombImage.setFitWidth(25);
    bombImage.setLayoutX(plane.getLayoutX() + 9);
    bombImage.setLayoutY(plane.getLayoutY() + 28);
    if(chosenPlane.getAngle() < 270 & chosenPlane.getAngle() > 90 ){
      bombImage.setScaleX(-1);
      bomb.setFaceRight(false);
    }
    bombList.add(bomb);
    bombImageList.add(bombImage);
    gamePane.getChildren().add(bombImage);
    bomb.startFallNoise();
  }
  
  private void moveBombs(){
    for(int index = 0; index < bombImageList.size(); index++){
      if(!checkBombCollision(bombImageList.get(index))){
        // set Y coordinate, the dropdown
        bombImageList.get(index).setLayoutY(bombImageList.get(index).getLayoutY() + 2);

        // set X coordinate, the horizontal movement
        if(bombList.get(index).getGameloopTicks()>30){
          bombImageList.get(index).setLayoutX(bombImageList.get(index).getLayoutX() + chosenPlane.getCurrHorSpeed());
        }
        bombList.get(index).setGameloopTicks(bombList.get(index).getGameloopTicks()+1);
      }
      else if(checkBombCollision(bombImageList.get(index))){
        bombList.get(index).stopFallNoise();
        explosion(bombImageList.get(index).getLayoutX(),bombImageList.get(index).getLayoutY());
        gamePane.getChildren().remove(bombImageList.get(index));
        bombList.remove(index);
        bombImageList.remove(index);
      }
    }
  }

  private void moveExplosions(){
    for(int index = 0; index < explosionList.size(); index++) {
      if(explosionList.get(index).getCountDown() == 0){
        gamePane.getChildren().remove(explosionImageList.get(index));
        explosionList.remove(index);
        explosionImageList.remove(index);
      }
      else {
        explosionList.get(index).setCountDown(explosionList.get(index).getCountDown() - 1);
      }
    }
    for(int index = 0; index < explosionImageList.size(); index++){
      double newX = explosionImageList.get(index).getLayoutX() + chosenPlane.getCurrHorSpeed();
      if(newX >= 0 | newX <= (5000)){
        explosionImageList.get(index).setLayoutX(newX);
      }
    }
  }

  private void reset(){
    gamePane.getChildren().remove(playerLifes[playerLife]);
    chosenPlane.setEngineOnOff(false);
    chosenPlane.setCrashed(false);
    chosenPlane.setAirborne(false);
    falldown=false;
    stall=false;
    chosenPlane.setAngle(0);
    bombAmount = chosenPlane.getBombCapacity();
    plane.setRotate(0);
    plane.setScaleY(1);
    plane.setLayoutX(PLANE_START_X);
    plane.setLayoutY(PLANE_START_Y);
    chosenPlane.setYCoordinate(PLANE_START_Y);
    gameLabel.setText("Score: " + points);
    bombList.clear();
    bombImageList.clear();
    explosionList.clear();
    explosionImageList.clear();
    scene1.reset();
    playerLife--;
    if(playerLife < 0){
      gameStage.close();
      gameTimer.stop();
      menuStage.show();
    }
  }

  // if any side of the plane ImageView collides with a non-flyable pixel of the map, will return true.
  private boolean checkPlaneCollision(){
    // height and width of the plane ImageView
    int height = 30; //(int)plane.fitHeightProperty()-1;
    int width = 36;  //(int)plane.fitWidthProperty()-1;

    // determine the X and Y corners of the plane ImageView
    int leftX = (int)(scene1.getGameSceneLayoutX()* -1) + (int)plane.getLayoutX();
    int rightX = leftX + width;
    int topY = (int)plane.getLayoutY();
    int bottomY = topY + height;

    //check left side   X = same
    for(int index = topY; index <= bottomY; index++){
      if(map[leftX][index] == false){
        return true;
      }
    }
    //check right side   X = same
    for(int index = topY; index <= bottomY; index++){
      if(map[rightX][index] == false){
        return true;
      }
    }
    //check top side   Y = same
    for(int index = leftX; index <= rightX; index++){
      if(map[index][topY] == false){
        return true;
      }
    }
    //check bottom side   Y = same
    for(int index = leftX; index <= rightX; index++){
      if(map[index][bottomY] == false){
        return true;
      }
    }
    return false;
  }
  
  private boolean checkBombCollision(ImageView bomb){
    int width = 25;
    int height = 17;
    
    // determine the X and Y corners of the plane ImageView
    int leftX = (int)(scene1.getGameSceneLayoutX()* -1) + (int)bomb.getLayoutX();
    int rightX = leftX + width;
    int topY = (int)bomb.getLayoutY();
    int bottomY = topY + height;

    //check left side   X = same
    for(int index = topY; index <= bottomY; index++){
      if(map[leftX][index] == false){
        return true;
      }
    }
    //check right side   X = same
    for(int index = topY; index <= bottomY; index++){
      if(map[rightX][index] == false){
        return true;
      }
    }
    //check top side   Y = same
    for(int index = leftX; index <= rightX; index++){
      if(map[index][topY] == false){
        return true;
      }
    }
    //check bottom side   Y = same
    for(int index = leftX; index <= rightX; index++){
      if(map[index][bottomY] == false){
        return true;
      }
    }
    return false;
  }

  private void explosion(double x, double y){
    Explosion explosion = new Explosion(0);
    explosionImage = explosion.getImage();
    explosionImage.setPreserveRatio(true);
    explosionImage.setFitWidth(60);
    explosionImage.setLayoutX(x-20D);
    explosionImage.setLayoutY(y-56D);
    explosionList.add(explosion);
    explosionImageList.add(explosionImage);
    gamePane.getChildren().add(explosionImage);
    explosion.playExplosion();
  }

  private double calculateDistance(double x1, double x2, double y1, double y2){
    return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
  }

}