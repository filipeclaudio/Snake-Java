package org.academiadecodigo.ramsters.snake.snake;

import org.academiadecodigo.ramsters.snake.Main;
import org.academiadecodigo.ramsters.snake.field.Field;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;

public class SnakeMovement {

    public enum Direction {
        LEFT,
        RIGHT,
        UP,
        DOWN
    }

    private Snake snake;
    private KeyboardManager keyboard;
    private Direction currentMove;

    public SnakeMovement(Snake snake) {
        this.snake = snake;
        keyboard = snake.getKeyboard();
    }

    public void chooseDirection() {
        switch (keyboard.getKey()) {
            case KeyboardEvent.KEY_UP:
                if (currentMove != Direction.DOWN) {
                    moveUp();
                    break;
                }
                moveDown();
                break;
            case KeyboardEvent.KEY_DOWN:
                if (currentMove != Direction.UP) {
                    moveDown();
                    break;
                }
                moveUp();
                break;
            case KeyboardEvent.KEY_LEFT:
                if (currentMove != Direction.RIGHT) {
                    moveLeft();
                    break;
                }
                moveRight();
                break;
            case KeyboardEvent.KEY_RIGHT:
                if (currentMove != Direction.LEFT) {
                    moveRight();
                    break;
                }
                moveLeft();
                break;
            case KeyboardEvent.KEY_Q:
                System.exit(0);
                break;
            case KeyboardEvent.KEY_R:
                Main.gameReset();
        }
    }

    public void moveDown() {
        if (Field.verifyY(snake.getPos().getY() + Field.getCellSize())) {
            snake.moveSnake(0, Field.getCellSize());
            snake.getPos().setY(Field.getCellSize());
            currentMove = Direction.DOWN;
            return;
        }
        snake.killSnake();
    }

    public void moveUp() {
        if (Field.verifyY(snake.getPos().getY() - Field.getCellSize())) {
            snake.moveSnake(0, -Field.getCellSize());
            snake.getPos().setY(-Field.getCellSize());
            currentMove = Direction.UP;
            return;
        }
        snake.killSnake();
    }

    public void moveLeft() {
        if (Field.verifyX(snake.getPos().getX() - Field.getCellSize())) {
            snake.moveSnake(-Field.getCellSize(), 0);
            snake.getPos().setX(-Field.getCellSize());
            currentMove = Direction.LEFT;
            return;
        }
        snake.killSnake();
    }

    public void moveRight() {
        if (Field.verifyX(snake.getPos().getX() + Field.getCellSize())) {
            snake.moveSnake(Field.getCellSize(), 0);
            snake.getPos().setX(Field.getCellSize());
            currentMove = Direction.RIGHT;
            return;
        }
        snake.killSnake();
    }
}
