import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class UserController {

    private View view;
    private Game game;
    private Player player;
    public UserController(View v, Game g, Player pl){
        view = v;
        game = g;
        player = pl;
    }

    public void Move(){
        EventHandler<KeyEvent> eventHandler = new EventHandler<>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode().equals(KeyCode.UP)) {
                    game.makeMove(player, Movement.UP);
                }
                if (keyEvent.getCode().equals(KeyCode.DOWN)) {
                    game.makeMove(player, Movement.DOWN);
                }
                if (keyEvent.getCode().equals(KeyCode.RIGHT)) {
                    game.makeMove(player, Movement.RIGHT);
                }
                if (keyEvent.getCode().equals(KeyCode.LEFT)) {
                    game.makeMove(player, Movement.LEFT);
                }
                check(this);
            }
        };
        view.getStage().addEventHandler(KeyEvent.KEY_PRESSED, eventHandler);
    }

    private void check(EventHandler eventHandler){
        if(game.getIsLose().contains(player)){
            loserExit();
            view.getStage().removeEventHandler(KeyEvent.KEY_PRESSED, eventHandler);
        }

        if(game.getIsWin().contains(player)){
            winnerExit();
            view.getStage().removeEventHandler(KeyEvent.KEY_PRESSED, eventHandler);
        }

    }

    public void loserExit(){
        view.lose();
        view.getLoserExitImage().addEventHandler(MouseEvent.MOUSE_CLICKED, e -> view.exit());
    }

    public void winnerExit(){
        view.win();
        view.getWinnerExitImage().addEventHandler(MouseEvent.MOUSE_CLICKED, e -> view.exit());
    }

}
