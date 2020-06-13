import java.util.ArrayList;

public class Snake {
    private ArrayList<Cell> snake;
    private Movement prevDir = Movement.DOWN;
    public Snake(Cell cell){
        snake = new ArrayList<>();
        snake.add(cell);
    }

    public Cell getHead(){
        return snake.get(0);
    }

    public void removeTail(){
        snake.remove(snake.size() - 1);
    }

    public void removeCoordinate(int number){
        snake.remove(number);
    }

    public Cell getTail(){
        return snake.get(snake.size() - 1);
    }

    public int sizeSnake(){
        return snake.size();
    }

    public Cell getSnakeCoordinate(int number){
        return snake.get(number);
    }

    public boolean isBody(Cell point) {
        for (int i = 1; i < snake.size(); ++i) {
            if (snake.get(i).getX() == point.getX() && snake.get(i).getY() == point.getY()) {
                return true;
            }
        }
        return false;
    }

    public Movement getPrevDir() {
        return prevDir;
    }

    public void traffic(Movement move){
        int x = 0;
        int y = 0;
        if(move == Movement.DOWN){
            y++;
        }
        if(move == Movement.UP){
            y--;
        }
        if(move == Movement.LEFT){
            x--;
        }
        if(move == Movement.RIGHT){
            x++;
        }
        prevDir = move;
        Cell newHead = new Cell(snake.get(0).getX() + x, snake.get(0).getY() + y);
        snake.add(0, newHead);

    }
}
