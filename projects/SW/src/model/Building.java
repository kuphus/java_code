package model;

import javafx.scene.image.ImageView;

public class Building {

    String[] BuildingURLs = new String[] {"model/resources/buildings/building1.png"};

    private ImageView buildingImage;
    private int xCoordinate;

    public Building(int x) {
        buildingImage = new ImageView(BuildingURLs[x]);
    }

    public ImageView getImage(){
        return buildingImage;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }
}
