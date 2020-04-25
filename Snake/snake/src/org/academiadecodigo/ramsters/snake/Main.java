package org.academiadecodigo.ramsters.snake;

public class Main {

    private static Game game;

    public static void main(String[] args) {
        game = new Game(20, 20);
        game.init();
        //test
    }
    public static void gameReset() {
        game = new Game(30, 30);
        game.init();
    }
}
