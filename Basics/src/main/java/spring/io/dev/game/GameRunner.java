package spring.io.dev.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {

    @Autowired
    @Qualifier("contraGame")
    GameConsole game;


    public GameRunner(GameConsole game) {  // can add @Qualifier("contraGame") here too..
        this.game = game;
    }

    public void run() {
        game.up();
        game.right();
        game.bottom();
        game.left();
    }
}
