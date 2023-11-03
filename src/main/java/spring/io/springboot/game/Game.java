package spring.io.springboot.game;

public class Game {
    public static void main(String[] args) {
        GameRunner  runner = new GameRunner(new PacManGame());
        runner.run();

    }
}

interface GameConsole {
    void up();
    void right();
    void bottom();
    void left();
}

