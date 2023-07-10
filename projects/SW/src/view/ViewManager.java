package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


import javafx.scene.layout.*;                   //for AnchorPane, Background, BackgroundImage, BackgroundPosition, BackgroundRepeat, HBox
import javafx.scene.*;                          //for Scene
import javafx.stage.*;                          //for Stage
import javafx.scene.image.Image;                //for Image
import javafx.scene.image.ImageView;            //for ImageView
import javafx.scene.text.Font;                  //for Font
import javafx.scene.text.Text;                  //for Text
import javafx.event.*;                          //for EventHandler and ActionEvent
import javafx.scene.input.MouseEvent;
import java.util.*;                             //for List and ArrayList
import javafx.scene.control.ComboBox;           //for ComboBox
import javafx.collections.FXCollections;        //for content of ComboBox
import javafx.scene.control.CheckBox;           //for CheckBox

import model.GameButton;                        //for selfmade GameButton
import model.MenuSubScene;                      //for selfmade MenuSubScene
import model.InfoLabel;                         //for selfmade InfoLabel
import model.PlanePicker;                       //for selfmade PlanePicker
import model.PLANE;                             //for selfmade PLANE enum

import map.MapReader;


public class ViewManager{

  private static final int HEIGHT = 768;
  private static final int WIDTH = 1024;
  private AnchorPane mainPane;                  //LayoutManager
  private Scene mainScene;                      //Scene Graph with Root Node
  private Stage mainStage;                      //Top-Level Window Frame
  
  private final static int MENU_BUTTONS_START_X = 100;
  private final static int MENU_BUTTONS_START_Y = 150;
  
  private MenuSubScene singleSubScene;
  private MenuSubScene multiSubScene;
  private MenuSubScene settingsSubScene;
  private MenuSubScene creditsSubScene;
  private ComboBox<String> allMaps;
  private CheckBox infBombs;

  private MenuSubScene currentDisplay;

  List<GameButton> gameButtonList;
  List<PlanePicker> planeList;
  private PLANE chosenPlane;

  public ViewManager(){
    gameButtonList = new ArrayList<>();
    mainPane = new AnchorPane();
    mainScene = new Scene(mainPane, WIDTH, HEIGHT);
    mainStage = new Stage();
    mainStage.setScene(mainScene);

    // give the stage a title
    mainStage.setTitle("Sopwith");
    createSubScenes();
    createButtons();
    createBackground();
    createLogo();
  }
  
  public Stage getMainStage(){
    return mainStage;
  }
  
  private void createSubScenes(){
    createSingleSubScene();
    createMultiSubScene();
    createSettingsSubScene();
    createCreditsSubScene();
  }
  
  private void createSingleSubScene(){
    singleSubScene = new MenuSubScene();
    mainPane.getChildren().add(singleSubScene);

    String[] maps = MapReader.listAllFiles("src/map/maps/");
    allMaps = new ComboBox<String>(FXCollections.observableArrayList(maps));
    allMaps.setPromptText("Choose a map");
    allMaps.setLayoutX(250);
    allMaps.setLayoutY(260);

    infBombs = new CheckBox("Unlimited Bombs");
    infBombs.setLayoutX(130);
    infBombs.setLayoutY(263);

    InfoLabel planeChooseLabel = new InfoLabel("Choose your plane");
    planeChooseLabel.setLayoutX(110);
    planeChooseLabel.setLayoutY(25);
    singleSubScene.getPane().getChildren().add(planeChooseLabel);
    singleSubScene.getPane().getChildren().add(allMaps);
    singleSubScene.getPane().getChildren().add(infBombs);
    singleSubScene.getPane().getChildren().add(createPlanesToChoose());
    singleSubScene.getPane().getChildren().add(createButtonToStart());
  }
  
  private HBox createPlanesToChoose(){
    HBox box = new HBox();
    box.setSpacing(20);
    planeList = new ArrayList<>();
    for(PLANE plane: PLANE.values()){
      PlanePicker planeToPick = new PlanePicker(plane);
      planeList.add(planeToPick);
      box.getChildren().add(planeToPick);
      planeToPick.setOnMouseClicked(new EventHandler<MouseEvent>(){
        @Override
        public void handle(MouseEvent event){
          for(PlanePicker plane: planeList){
            plane.setIsCircleChosen(false);
          }
          planeToPick.setIsCircleChosen(true);
          chosenPlane = planeToPick.getPlane();
        }
      });
    }
    box.setLayoutX(110);
    box.setLayoutY(100);
    return box;
  }
  
  private GameButton createButtonToStart(){
    GameButton startButton = new GameButton("START");
    startButton.setLayoutX(350);
    startButton.setLayoutY(300);
    
    startButton.setOnAction(new EventHandler<ActionEvent>(){
      
      @Override
      public void handle(ActionEvent event){
        if(chosenPlane != null && allMaps.getValue() != null){
          GameViewManager gameManager = new GameViewManager(allMaps.getValue());
          gameManager.createNewGame(mainStage, chosenPlane, infBombs.isSelected());
        }
      }
    });

    return startButton;
  }
  
  private void createMultiSubScene(){
    multiSubScene = new MenuSubScene();
    mainPane.getChildren().add(multiSubScene);
    
    InfoLabel multiLabel = new InfoLabel("Multiplayer");
    multiLabel.setLayoutX(110);
    multiLabel.setLayoutY(25);
    multiSubScene.getPane().getChildren().add(multiLabel);
    //text field
    Text t = new Text();
    t.setWrappingWidth(450);
    t.setText("Multiplayer will have to wait until I know enough :p");
    try{
      t.setFont(Font.loadFont(new FileInputStream("model/resources/vintage.ttf"), 20));
    }
    catch(FileNotFoundException e){
      t.setFont(Font.font("Verdana", 23));
    }
    t.setLayoutX(50);
    t.setLayoutY(120);
    multiSubScene.getPane().getChildren().add(t);
  }
  
  private void createSettingsSubScene(){
    settingsSubScene = new MenuSubScene();
    mainPane.getChildren().add(settingsSubScene);
    
    InfoLabel settingsLabel = new InfoLabel("Settings");
    settingsLabel.setLayoutX(110);
    settingsLabel.setLayoutY(25);
    settingsSubScene.getPane().getChildren().add(settingsLabel);
  }
  
  private void createCreditsSubScene(){
    creditsSubScene = new MenuSubScene();
    mainPane.getChildren().add(creditsSubScene);
    
    InfoLabel creditsLabel = new InfoLabel("Credits");
    creditsLabel.setLayoutX(110);
    creditsLabel.setLayoutY(25);
    creditsSubScene.getPane().getChildren().add(creditsLabel);
    //text field
    Text t = new Text();
    t.setWrappingWidth(450);
    t.setText("Javacraving for the tutorial: https://www.youtube.com/watch?v=DkIuA5ZEZ_U&list=PL4wcbt63yAbdtY-GOeuRjIePfUsukSJZ9\n\n Kenney.nl for the sprites.");
    try{
      t.setFont(Font.loadFont(new FileInputStream("model/resources/vintage.ttf"), 20));
    }
    catch(FileNotFoundException e){
      t.setFont(Font.font("Verdana", 23));
    }
    t.setLayoutX(50);
    t.setLayoutY(120);
    creditsSubScene.getPane().getChildren().add(t);
  }
  
  private void showSubScene(MenuSubScene sub){
    if(currentDisplay != null){
      currentDisplay.moveSubScene();
    }
    sub.moveSubScene();
    currentDisplay = sub;
  }
  
  private void addMenuButton(GameButton button){
    button.setLayoutX(MENU_BUTTONS_START_X);
    button.setLayoutY(MENU_BUTTONS_START_Y + gameButtonList.size() * 100);
    gameButtonList.add(button);
    mainPane.getChildren().add(button);
  }

  private void createButtons(){
    createStartButton();
    createMultiButton();
    createHelpButton();
    createCreditsButton();
    createExitButton();
  }
  
  private void createStartButton(){
    GameButton singleButton = new GameButton("SINGLE");
    addMenuButton(singleButton);
    
    singleButton.setOnAction(new EventHandler<ActionEvent>(){
      @Override
      public void handle(ActionEvent event){
        showSubScene(singleSubScene);
      }
    });
  }
  
  private void createMultiButton(){
    GameButton multiButton = new GameButton("MULTI");
    addMenuButton(multiButton);
        
    multiButton.setOnAction(new EventHandler<ActionEvent>(){
      @Override
      public void handle(ActionEvent event){
        showSubScene(multiSubScene);
      }
    });
  }
  
  private void createHelpButton(){
    GameButton settingsButton = new GameButton("SETTINGS");
    addMenuButton(settingsButton);
        
    settingsButton.setOnAction(new EventHandler<ActionEvent>(){
      @Override
      public void handle(ActionEvent event){
        showSubScene(settingsSubScene);
      }
    });
  }
  
  private void createCreditsButton(){
    GameButton creditsButton = new GameButton("CREDITS");
    addMenuButton(creditsButton);
    
    creditsButton.setOnAction(new EventHandler<ActionEvent>(){
      @Override
      public void handle(ActionEvent event){
        showSubScene(creditsSubScene);
      }
    });
  }
  
  private void createExitButton(){
    GameButton exitButton = new GameButton("EXIT");
    addMenuButton(exitButton);
    
    exitButton.setOnAction(new EventHandler<ActionEvent>(){
      @Override
      public void handle(ActionEvent event){
        mainStage.close();
      }
    });
  }
  
  private void createBackground(){
    Image backgroundImage = new Image("view/resources/grey-bg.jpg", 256,256, false, true);
    BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
    mainPane.setBackground(new Background(background));
  }
  
  private void createLogo(){
    int xValue = 400;
    int yValue = 50;
    // Letter s
    Image image = new Image("view/resources/letterS.png");
    ImageView s = new ImageView(image);
    s.setLayoutX(xValue);
    s.setLayoutY(yValue);
    mainPane.getChildren().add(s);
    // Letter o
    xValue = (int)(xValue + image.getWidth() + 5);
    image = new Image("view/resources/letterO.png");
    ImageView o = new ImageView(image);
    o.setLayoutX(xValue);
    o.setLayoutY(yValue);
    mainPane.getChildren().add(o);
    // Letter p
    xValue = (int)(xValue + image.getWidth() + 5);
    image = new Image("view/resources/letterP.png");
    ImageView p = new ImageView(image);
    p.setLayoutX(xValue);
    p.setLayoutY(yValue);
    mainPane.getChildren().add(p);
    // Letter w
    xValue = (int)(xValue + image.getWidth() + 5);
    image = new Image("view/resources/letterW.png");
    ImageView w = new ImageView(image);
    w.setLayoutX(xValue);
    w.setLayoutY(yValue);
    mainPane.getChildren().add(w);
    // Letter i
    xValue = (int)(xValue + image.getWidth() + 5);
    image = new Image("view/resources/letterI.png");
    ImageView i = new ImageView(image);
    i.setLayoutX(xValue);
    i.setLayoutY(yValue);
    mainPane.getChildren().add(i);
    // Letter t
    xValue = (int)(xValue + image.getWidth() + 5);
    image = new Image("view/resources/letterT.png");
    ImageView t = new ImageView(image);
    t.setLayoutX(xValue);
    t.setLayoutY(yValue);
    mainPane.getChildren().add(t);
    // Letter h
    xValue = (int)(xValue + image.getWidth() + 5);
    image = new Image("view/resources/letterH.png");
    ImageView h = new ImageView(image);
    h.setLayoutX(xValue);
    h.setLayoutY(yValue);
    mainPane.getChildren().add(h);
  }


}