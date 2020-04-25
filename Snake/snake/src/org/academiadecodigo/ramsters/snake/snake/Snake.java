package org.academiadecodigo.ramsters.snake.snake;

import org.academiadecodigo.ramsters.snake.Food;
import org.academiadecodigo.ramsters.snake.Position;
import org.academiadecodigo.ramsters.snake.field.Field;
import org.academiadecodigo.ramsters.snake.field.Status;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.ArrayList;

public class Snake {

    private Rectangle headSnake;
    private KeyboardManager keyboard;
    private SnakeMovement nextMove;
    private ArrayList<Rectangle> snakeBody;
    private Position pos;
    private boolean dead;

    public Snake() {
        pos = new Position(10, 10, Field.getCellSize(), Field.getCellSize());
        headSnake = new Rectangle(pos.getX(), pos.getY(), pos.getWidth(), pos.getHeight());
        headSnake.setColor(Color.BLACK);
        headSnake.fill();
        keyboard = new KeyboardManager();
        nextMove = new SnakeMovement(this);
        snakeBody = new ArrayList<>();
        snakeBody.add(headSnake);
    }

    public Position getPos() {
        return pos;
    }

    public KeyboardManager getKeyboard() {
        return keyboard;
    }

    public void move() {
        nextMove.chooseDirection();
    }

    public ArrayList<Rectangle> getSnakeBody() {
        return snakeBody;
    }

    public void moveSnake(int x, int y) {
        int lastPositionX = snakeBody.get(snakeBody.size()-1).getX();
        int lastPositionY = snakeBody.get(snakeBody.size()-1).getY();

        for (int i = snakeBody.size()-1; i >= 0; i--) {
            if (i == 0) { continue; }
            int saveX = snakeBody.get(i-1).getX();
            int saveY = snakeBody.get(i-1).getY();
            snakeBody.get(i).translate(saveX-snakeBody.get(i).getX(), saveY-snakeBody.get(i).getY());
            snakeBody.get(i).fill();
        }

        headSnake.translate(x, y);

        if (snakeBody.get(0).getX() == Food.getX() && snakeBody.get(0).getY() == Food.getY()) {
            Food.removeFood();
            eatFood();
            Status.setScorePoints();
            snakeBody.add(new Rectangle(lastPositionX, lastPositionY, Field.getCellSize(), Field.getCellSize()));
            snakeBody.get(snakeBody.size()-1).setColor(Color.GREEN);
            snakeBody.get(snakeBody.size()-1).fill();
        }
    }

    public void eatFood() {
        Food food = new Food();
        while(!food.checkCollisionSnake(snakeBody)) {
            Food.removeFood();
            food = new Food();
        }
    }

    public void killSnake() {
        dead = true;
        for (Rectangle body: snakeBody) {
            body.setColor(Color.RED);
            body.fill();
        }
        System.out.println("Snake dead");
    }

    public boolean isDead() {
        return dead;
    }
}
