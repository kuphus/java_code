
import javafx.application.Application;          //for superclass Application
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.*;                          //for Stage
import javafx.scene.layout.*;                   //for AnchorPane, Background, BackgroundImage, BackgroundPosition, BackgroundRepeat, HBox
import javafx.scene.*;                          //for Scene
import javafx.scene.paint.Color;
import java.util.Random;
import java.util.LinkedList;
import javafx.scene.shape.Line;



public class RayTracing extends Application{

    private static final int HEIGHT = 768;
    private static final int WIDTH = 1024;
    private static final Random random = new Random();
    private static int numLines = 10;
    private static LinkedList<Line> lines;

    private static AnchorPane mainPane;                  //LayoutManager
    private Scene mainScene;                      //Scene Graph with Root Node
    private Stage mainStage;                      //Top-Level Window Frame


    private LinkedList<Line> rays = new LinkedList<>();

    public static void main(String[] args){
        // start the JavaFX application by calling launch()
        launch(args);
    }

    @Override
    public void start(Stage mainStage){
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane, WIDTH, HEIGHT);
        mainScene.setFill(Color.BLACK);
        mainStage = new Stage();
        mainStage.setScene(mainScene);
        mainStage.setTitle("RayTracing demo");
        mainStage.setOnCloseRequest(event -> System.exit(0));
        lines = buildLines();
        for(Line line : lines){
            mainPane.getChildren().add(line);
        }
        mainScene.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                for(Line ray : rays){
                    mainPane.getChildren().remove(ray);
                }
                rays.clear();
                Integer maxDist = 3000;
                rays = calcRays(lines,(int)mouseEvent.getX(),(int)mouseEvent.getY(), 100, maxDist);
                float shortest = maxDist;
                int finalNum = -1;
                for(int num=0; num<rays.size(); num++) {
                    Line ray = rays.get(num);
                    float length = dist((float)ray.getStartX(), (float)ray.getStartY(), (float)ray.getEndX(), (float)ray.getEndY());
                    if (length < shortest){
                        shortest = length;
                        finalNum = num;
                    }
                    /*double rgb1 = random.nextDouble();
                    double rgb2 = random.nextDouble();
                    double rgb3 = random.nextDouble();
                    double rgb4 = random.nextDouble();
                    ray.setStroke(new Color(rgb1,rgb2,rgb3,rgb4));*/
                    ray.setStroke(Color.WHITE);
                    mainPane.getChildren().add(ray);
                }
                if(finalNum != -1){
                    rays.get(finalNum).setStroke(Color.RED);
                }


            }
        });
        mainStage.show();
    }

    private LinkedList<Line> buildLines(){
        LinkedList<Line> lines = new LinkedList<>();
        for(int index = 0; index < numLines; index++){
            int x1 = random.nextInt(WIDTH);
            int y1 = random.nextInt(HEIGHT);
            int x2 = random.nextInt(WIDTH);
            int y2 = random.nextInt(HEIGHT);
            Line line = new Line(x1,y1,x2,y2);
            line.setStroke(Color.GREEN);
            lines.add(line);
        }
        return lines;
    }

    private LinkedList<Line> calcRays(LinkedList<Line> lines, int x, int y, int resolution, int maxDist){
        LinkedList<Line> rays = new LinkedList<>();
        for(int index = 0; index < resolution; index++){
            double dir = (Math.PI * 2) * ((double) index / resolution);
            float minDist = maxDist;
            for(Line line : lines){
                float dist = getRayCast(x, y, x + (float) Math.cos(dir) * maxDist, y + (float) Math.sin(dir) * maxDist, (float)line.getStartX(), (float)line.getStartY(), (float)line.getEndX(), (float)line.getEndY());
                if (dist < minDist && dist > 0){
                    minDist = dist;
                }
            }
            Line ray = new Line(x,y, x + (float) Math.cos(dir) * minDist, y + (float) Math.sin(dir) * minDist);
            rays.add(ray);
        }
        return rays;
    }

    public static float dist(float x1, float y1, float x2, float y2) {
        return (float) Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

    public static float getRayCast(float p0_x, float p0_y, float p1_x, float p1_y, float p2_x, float p2_y, float p3_x, float p3_y) {
        float s1_x, s1_y, s2_x, s2_y;
        s1_x = p1_x - p0_x;
        s1_y = p1_y - p0_y;
        s2_x = p3_x - p2_x;
        s2_y = p3_y - p2_y;

        float s, t;
        s = (-s1_y * (p0_x - p2_x) + s1_x * (p0_y - p2_y)) / (-s2_x * s1_y + s1_x * s2_y);
        t = (s2_x * (p0_y - p2_y) - s2_y * (p0_x - p2_x)) / (-s2_x * s1_y + s1_x * s2_y);

        if (s >= 0 && s <= 1 && t >= 0 && t <= 1) {
            // Collision detected
            float x = p0_x + (t * s1_x);
            float y = p0_y + (t * s1_y);

            return dist(p0_x, p0_y, x, y);
        }

        return -1; // No collision
    }
}