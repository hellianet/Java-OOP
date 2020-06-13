import javafx.application.Platform;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class View implements Observer {

    private int countFruit;
    private ArrayList<Cell> fruit;
    private Game game;
    private Stage stage;
    private Map<Player,Snake> userList;
    private Rectangle [][] rects;
    private HashMap<Player, Label> labels;
    private HashMap<Player, Color> colorSnake;
    private HashMap<Player, Cell> snakeTail;
    private GridPane labelsGrid;
    private double rectWidth = 0;
    private double rectHeight = 0;
    private  ImageView input;
    private  ImageView winnerExit;
    private  ImageView loserExit;
    private  TextField enterName;
    public View(Game game, Stage st){
        this.game = game;
        this.stage = st;
        this.game.registerObserver(this);
        userList = new HashMap<>();
        fruit = new ArrayList<>();
        labels = new HashMap<>();
        rects = new Rectangle[game.sizeField()][game.sizeField()];
    }

    public TextField getEnterName() {
        return enterName;
    }

    public ImageView getInputImage(){
        return input;
    }

    public ImageView getWinnerExitImage(){
        return winnerExit;
    }

    public ImageView getLoserExitImage(){
        return loserExit;
    }

    public void menu(){
        Label label = new Label("Enter your name");
        label.setFont(new Font("Algerian",18));
        input = new ImageView(new Image("https://www.pngarts.com/files/3/Play-Now-Button-Transparent-Background-PNG.png",180, 45, false, false));
        enterName = new TextField();
        enterName.setPrefColumnCount(1);
        FlowPane root = new FlowPane(Orientation.VERTICAL, 0, 6, label, enterName, input);
        root.setAlignment(Pos.BOTTOM_CENTER);
        root.setBackground(new Background(new BackgroundImage(new Image("https://cdn02.nintendo-europe.com/media/images/10_share_images/games_15/nintendo_switch_download_software_1/H2x1_NSwitchDS_SnakePass_image1600w.jpg", 800,400, false,false),null,null,null,null)));
        Scene scene = new Scene(root, 150, 150);
        stage.setScene(scene);
    }

    public void game(){
        int width = 600;
        int height = 620;
        stage.setWidth(width);
        stage.setHeight(height);
        GridPane gridpane = new GridPane();
        GridPane gp = new GridPane();
        labelsGrid = new GridPane();
        rectWidth = (double) width / game.sizeField();
        rectHeight = (double) width / game.sizeField();
        for(int i = 0; i < game.sizeField(); ++i) {
            for (int k = 0; k < game.sizeField(); ++k) {
                Rectangle rectangle = new Rectangle(rectWidth,rectHeight, Color.YELLOW);
                gridpane.add(rectangle, i, k);
                rects[i][k] = rectangle;
            }
        }
        gp.add(labelsGrid, 0, 0);
        gp.add(gridpane, 0, 1);

        Scene scene = new Scene(gp, width, height);
        stage.sizeToScene();
        stage.setScene(scene);
   }

    public void win(){
        Label end = new Label("Game over");
        end.setFont(new Font("Algerian",50));
        Label youIs = new Label("You won!!!");
        youIs.setFont(new Font("Algerian",45));
        winnerExit = new ImageView(new Image("https://lh3.googleusercontent.com/proxy/QOdOUE6FeIeTj7kGwzqj0KOedbmCStbU8Ze_q1TflGipzDLrLSW7Fkc7SucDzcZwg10mXI9eH5QRmFNp0viciv-LcC1J0T9Dw-Lq71yZNczkTUFTHW0",180, 45, false, false));
        FlowPane root = new FlowPane(Orientation.VERTICAL, 0, 10, end,youIs, winnerExit);
        root.setAlignment(Pos.BOTTOM_CENTER);
        root.setBackground(new Background(new BackgroundImage(new Image("https://ak.picdn.net/shutterstock/videos/23904325/thumb/1.jpg", 800,400, false,false),null,null,null,null)));
        Scene scene = new Scene(root, 800, 400);
        stage.sizeToScene();
        stage.setScene(scene);
    }

    public void lose(){
        Label end = new Label("Game over");
        end.setFont(new Font("Algerian",30));
        Label youIs = new Label("You lose...");
        youIs.setFont(new Font("Algerian",25));
        Label wishPart1 = new Label("Do not give up,");
        Label wishPart2 = new Label("you will succeed!");
        wishPart1.setFont(new Font("Algerian",25));
        wishPart2.setFont(new Font("Algerian",25));
        loserExit = new ImageView(new Image("https://lh3.googleusercontent.com/proxy/QOdOUE6FeIeTj7kGwzqj0KOedbmCStbU8Ze_q1TflGipzDLrLSW7Fkc7SucDzcZwg10mXI9eH5QRmFNp0viciv-LcC1J0T9Dw-Lq71yZNczkTUFTHW0",180, 45, false, false));
        FlowPane root = new FlowPane(Orientation.VERTICAL, 0, 8, end,youIs,wishPart1,wishPart2, loserExit);
        root.setAlignment(Pos.BOTTOM_CENTER);
        root.setBackground(new Background(new BackgroundImage(new Image("http://d3aeoi5a6g6m4p.cloudfront.net/userblog/201909212136063263/cover/cover-maxresdefault-1-.jpg", 800,400, false,false),null,null,null,null)));
        Scene scene = new Scene(root, 800, 400);
        stage.sizeToScene();
        stage.setScene(scene);
    }

    public Stage getStage() {
        return stage;
    }

    public void exit(){
        stage.close();
    }

    public void addNameAndSizeSnake(Player pl){
        Label l = new Label(pl.getName() + ": " + userList.get(pl).sizeSnake());
        labels.put(pl, l);
        l.setFont(new Font(14));
        labelsGrid.add(l, 0, 0);
        labelsGrid.setGridLinesVisible(true);
    }

    public Color newColor(Player pl){
        Color cl =Color.RED;// Color.rgb((int)(Math.random() % 256), (int)(Math.random() % 256), (int)(Math.random() %256));
        colorSnake.put(pl,cl);
        return cl;
    }

    public void removeTail(Player pl){
        rects[snakeTail.get(pl).getX()][snakeTail.get(pl).getY()].setFill(Color.YELLOW);
    }

    public void addFieldCoordinate(Cell cl){
        rects[cl.getX()][cl.getY()].setFill(Color.YELLOW);
    }

    public void addFruitCoordinate(){
        for(int i = 0; i < game.getCountFruit(); ++i){
            rects[fruit.get(i).getX()][fruit.get(i).getY()].setFill(Color.BLUE);
    }
    }


    public void addSnakeCoordinate(Player pl,  Color cl){
        if(game.getHeadSnake(pl).getX() < game.sizeField() && game.getHeadSnake(pl).getX() >= 0 && game.getHeadSnake(pl).getY() < game.sizeField() && game.getHeadSnake(pl).getY() >= 0) {
            rects[game.getHeadSnake(pl).getX()][game.getHeadSnake(pl).getY()].setFill(cl);
            rects[game.getTailSnake(pl).getX()][game.getTailSnake(pl).getY()].setFill(cl);
            snakeTail.put(pl, game.getTailSnake(pl));

        }

    }

    public void initialization(){
        colorSnake = new HashMap<>();
        snakeTail = new HashMap<>();
        userList = game.getUserList();
        fruit = game.getFruit();
        Set<Player> players = userList.keySet();
        for (Player pl: players){
            labelsGrid.getColumnConstraints().add(new ColumnConstraints((double)600/userList.size()));
            addNameAndSizeSnake(pl);
            addSnakeCoordinate(pl, newColor(pl));
        }
        addFruitCoordinate();
    }


    @Override
    public void update() {
        display();

    }

   public void display(){
       Set<Player> players = userList.keySet();
       Set<Player> playersInLabel = labels.keySet();
       for (Player pl: players){
           if(labels.containsKey(pl)){
               if(game.snakeIsEat(pl)){

                   Platform.runLater(() -> labels.get(pl).setText(pl.getName() + ": " + userList.get(pl).sizeSnake()));
                   addFruitCoordinate();
                   addSnakeCoordinate(pl,colorSnake.get(pl));
               }
               else{
                   removeTail(pl);
                   addSnakeCoordinate(pl,colorSnake.get(pl));

               }
           }
           else{
               addNameAndSizeSnake(pl);
               addSnakeCoordinate(pl, newColor(pl));
           }
       }

       for(Player pl: playersInLabel){
           if(!players.contains(pl)){
                if(!game.snakeIsFruitNow(pl)){
                    for(int i = 0; i < game.getSizeEmptySnake(); ++i){
                        addFieldCoordinate(game.getEmptySnake(i));
                    }
                }
               // labelsGrid.getChildren().remove(labels.get(pl));
                labels.remove(pl);
                snakeTail.remove(pl);
                colorSnake.remove(pl);
                game.clearEmptySnake();
           }
       }
       addFruitCoordinate();
   }

}
