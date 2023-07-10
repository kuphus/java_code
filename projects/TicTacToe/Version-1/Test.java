// test class voor alle andere classen

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;


class Test{
  public static void main(String[] args){

    //maak een cell
    cell testCell = new cell();
    System.out.println("test cell aangemaakt");

    boolean bool1 = testCell.isSet();
    System.out.println("Is test cell geSet?: "+ bool1);

    testCell.setState("X");
    System.out.println("test cell is op waarde X gezet");
    
    bool1 = testCell.isSet();
    System.out.println("Is test cell nu geSet?: "+ bool1);

    System.out.println("Test cell heeft de waarde: "+ testCell.getState());
  }
}