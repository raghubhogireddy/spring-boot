package spring.io.springboot.dev.game;

import org.springframework.stereotype.Component;

@Component
public class MarioGame implements GameConsole {
    public void up() {
        System.out.println("Mario moving -> up");
    }

    public void right() {
        System.out.println("Mario moving -> right");
    }

    public void bottom() {
        System.out.println("Mario moving -> bottom");
    }

    public void left() {
        System.out.println("Mario moving -> left");
    }
}
