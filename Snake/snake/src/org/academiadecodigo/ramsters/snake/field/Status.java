package org.academiadecodigo.ramsters.snake.field;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class Status {
    private int x = Field.getWidth()+Field.getCellSize();
    private int y = Field.getMinY();
    private int width = Field.getWidth()/5;
    private int heigth = Field.getHeight();
    private static Text scorePoints;
    private static int score;

    public Status() {
        Rectangle status = new Rectangle(x, y, width, heigth);
        status.setColor(Color.BLACK);
        status.fill();

        Text scoreLabel = new Text(Field.getWidth()+(width/2), heigth/2, "Score");
        scoreLabel.setColor(Color.RED);
        scoreLabel.draw();
        score = 0;

        scorePoints = new Text(Field.getWidth()+(width/2), heigth/2 + Field.getCellSize(), "   "+score);
        scorePoints.setColor(Color.RED);
        scorePoints.draw();

    }

    public static void setScorePoints() {
        score += 5;
        scorePoints.setText("   "+score);
    }
}
