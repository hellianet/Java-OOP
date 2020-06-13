import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.util.HashMap;


public class Controller {

    private View view;
    private Game game;
    private HashMap<Player, UserController> players;
    public Controller(View v, Game g){
        view = v;
        game = g;
        players = new HashMap<>();
    }

    public void initInputImage(){
        view.getInputImage().addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {

            String name = view.getEnterName().getText();
            Player pl = game.logIn(name);
            UserController userCr = new UserController(view, game, pl);
            userCr.Move();
            players.put(pl,userCr);
            view.game();
            view.initialization();
            game.run();
        });

    }

}
