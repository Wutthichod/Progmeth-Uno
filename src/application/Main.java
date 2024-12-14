package application;

import application.GameLoop;

public class Main {
    public static void main(String[] args) {
        GameLoop gameLoop = GameLoop.getGameInstance();
        gameLoop.start();
    }
}
