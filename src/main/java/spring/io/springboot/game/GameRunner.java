package spring.io.springboot.game;

public class GameRunner {

    GameConsole game;

    public GameRunner(GameConsole game) {
        this.game = game;
    }

    public void run() {
        game.up();
        game.right();
        game.bottom();
        game.left();
    }
}
