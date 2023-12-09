package spring.io.springboot.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PacManGame implements GameConsole {
    public void up() {
        System.out.println("PacMan moving -> up");
    }

    public void right() {
        System.out.println("PacMan moving -> right");
    }

    public void bottom() {
        System.out.println("PacMan moving -> bottom");
    }

    public void left() {
        System.out.println("PacMan moving -> left");
    }
}
