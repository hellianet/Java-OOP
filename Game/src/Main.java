import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.text.Text;

import java.awt.event.KeyEvent;

public class Main extends Application{

    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {

        stage.getIcons().add(new Image("https://habrastorage.org/getpro/geektimes/post_images/ec4/57c/185/ec457c1850803b39dd5a099a12c17160.jpg"));
        // установка надписи
        Text text = new Text("Hello from JavaFX!");
        text.setLayoutY(80);    // установка положения надписи по оси Y
        text.setLayoutX(100);   // установка положения надписи по оси X

        Group group = new Group(text);
        Scene scene = new Scene(group);
        stage.setScene(scene);
        stage.setTitle("Snake");
        int width = 800; //800
        int height = 400; //400
        stage.setWidth(width);
        stage.setHeight(height);
        Game game = new Game(15);
        View v = new View(game, stage);
        v.menu();
        Controller con = new Controller(v,game);
        con.initInputImage();
        stage.show();
    }
}