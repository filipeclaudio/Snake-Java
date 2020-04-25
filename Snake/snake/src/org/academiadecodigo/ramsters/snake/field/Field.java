package org.academiadecodigo.ramsters.snake.field;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Field {
    private static int rows;
    private static int columns;
    private static int minX;
    private static int minY;
    private static int width;
    private static int height;
    private static final int PADDING = 10;
    private static final int cellSize = 20;
    private Status status;

    public Field(int cols, int rows) {
        this.rows = rows;
        this.columns = cols;
        this.minX = 10;
        this.minY = 10;
        width = cols*cellSize;
        height = rows*cellSize;

        Rectangle floor = new Rectangle(minX, minY, width, height);
        floor.setColor(Color.LIGHT_GRAY);
        floor.fill();
        status = new Status();
    }

    public static int getMinX() {
        return minX;
    }

    public static int getMinY() {
        return minY;
    }

    public static int getCellSize() {
        return cellSize;
    }

    public static int getPadding() { return PADDING; }

    public static int getWidth() { return width;  }

    public static int getHeight() { return height; }

    public static int getRows() {
        return rows;
    }

    public static int getColumns() {
        return columns;
    }

    public static boolean verifyX(int x) {
        if (x < minX || x > width) {
            return false;
        }
        return true;
    }

    public static boolean verifyY(int y) {
        if (y > height || y < minY) {
            return false;
        }
        return true;
    }
}
