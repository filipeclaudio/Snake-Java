package org.academiadecodigo.ramsters.snake.snake;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardManager implements KeyboardHandler {

    private Keyboard keyboard;
    private int key;

    public KeyboardManager() {
        keyboard = new Keyboard(this);
        keyboardEvents();
    }

    public void keyboardEvents() {
        KeyboardEvent up = new KeyboardEvent();
        KeyboardEvent down = new KeyboardEvent();
        KeyboardEvent left = new KeyboardEvent();
        KeyboardEvent right = new KeyboardEvent();
        KeyboardEvent restart = new KeyboardEvent();
        KeyboardEvent quit = new KeyboardEvent();

        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        restart.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        quit.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        up.setKey(KeyboardEvent.KEY_UP);
        down.setKey(KeyboardEvent.KEY_DOWN);
        left.setKey(KeyboardEvent.KEY_LEFT);
        right.setKey(KeyboardEvent.KEY_RIGHT);
        restart.setKey(KeyboardEvent.KEY_R);
        quit.setKey(KeyboardEvent.KEY_Q);

        keyboard.addEventListener(up);
        keyboard.addEventListener(down);
        keyboard.addEventListener(left);
        keyboard.addEventListener(right);
        keyboard.addEventListener(restart);
        keyboard.addEventListener(quit);
    }

    public int getKey() {
        return key;
    }

    @Override
    public void keyPressed(KeyboardEvent event) {
        key = event.getKey();
    }

    @Override
    public void keyReleased(KeyboardEvent event) {

    }
}
