package org.academiadecodigo.ramsters.snake;

import org.academiadecodigo.ramsters.snake.field.Field;
import org.academiadecodigo.ramsters.snake.snake.Snake;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

import java.util.ArrayList;

public class Game {
    private Field field;
    private Snake snake;
    private Food food;

    public Game(int cols, int rows){
        field = new Field(cols, rows);
        snake = new Snake();
    }

    public void init() {
        Text endGame = new Text(Field.getMinX()+Field.getPadding(), Field.getHeight()-Field.getPadding(), "Press R to Restart game or Q to quit.");
        endGame.setColor(Color.BLACK);
        endGame.draw();
        start();
    }

    public void start() {
        System.out.println("Start Game!");
        food = new Food();

        while(!snake.isDead()) {
            snake.move();
            verifyColision();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void verifyColision() {
        ArrayList<Rectangle> snakeBody = snake.getSnakeBody();
        for (Rectangle body: snakeBody) {
            for (Rectangle bodyCompare: snakeBody) {
                if(body.equals(bodyCompare)) {
                    continue;
                }
                if (body.getX() == bodyCompare.getX() && body.getY() == bodyCompare.getY()) {
                    snake.killSnake();
                }
            }
        }
    }
}
