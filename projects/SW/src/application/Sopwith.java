;// main class
import javafx.application.Application;          //for superclass Application
import javafx.stage.*;                          //for Stage
import view.ViewManager;                        //for selfmade ViewManager

public class Sopwith extends Application{

  public static void main(String[] args){
    // start the JavaFX application by calling launch()
    launch(args);
  }

  @Override
  public void start(Stage mainStage){
    ViewManager manager = new ViewManager();
    mainStage = manager.getMainStage();
    

    mainStage.show();
  }
}