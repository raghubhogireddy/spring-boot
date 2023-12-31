package spring.io.dev.game;

import org.springframework.stereotype.Component;

@Component
public class ContraGame implements GameConsole {
    public void up() {
        System.out.println("Contra moving -> up");
    }

    public void right() {
        System.out.println("Contra moving -> right");
    }

    public void bottom() {
        System.out.println("Contra moving -> bottom");
    }

    public void left() {
        System.out.println("Contra moving -> left");
    }
}
