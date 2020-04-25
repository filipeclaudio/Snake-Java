package org.academiadecodigo.ramsters.snake;

import org.academiadecodigo.ramsters.snake.field.Field;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.ArrayList;

public class Food {

    private static Rectangle food;

    public Food() {
        food = new Rectangle((Math.floor(Math.random() * Field.getColumns()) * Field.getCellSize() + Field.getPadding()),
                (Math.floor(Math.random() * Field.getRows()) * Field.getCellSize() + Field.getPadding()),
                Field.getCellSize(), Field.getCellSize());
        food.setColor(Color.RED);
        food.fill();
    }

    public static int getX() {
        return food.getX();
    }

    public static int getY() {
        return food.getY();
    }

    public static boolean checkCollisionSnake(ArrayList<Rectangle> bodySnake) {
        for (Rectangle body: bodySnake) {
            if (food.getX() == body.getX() && food.getY() == body.getY()) {
                return false;
            }
        }
        return true;
    }

    public static void removeFood() {
        food.delete();
    }
}
