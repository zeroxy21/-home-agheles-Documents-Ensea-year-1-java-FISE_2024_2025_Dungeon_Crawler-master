import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameEngine implements Engine, KeyListener {
    DynamicSprite hero;
    DynamicSprite charizard;
    public GameEngine(DynamicSprite hero, DynamicSprite charizard) {
        this.hero = hero;
        this.charizard = charizard;
    }
    @Override
    public void update() {
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP :
                hero.setDirection(Direction.NORTH);
                break;
            case KeyEvent.VK_DOWN:
                hero.setDirection(Direction.SOUTH);
                break;
            case KeyEvent.VK_LEFT:
                hero.setDirection(Direction.WEST);
                break;
            case KeyEvent.VK_RIGHT:
                hero.setDirection(Direction.EAST);
                break;
            case KeyEvent.VK_ENTER:
                RenderEngine.setGameStatus(RenderEngine.GameStatus.GAME.ordinal());
                break;
            case KeyEvent.VK_ESCAPE:
                hero.decreaseHealth(10);
                System.out.println(hero.getHealth());
                break;
            case KeyEvent.VK_Z:
                charizard.setDirection(Direction.EAST);
                break;
            case KeyEvent.VK_Q:
                charizard.setDirection(Direction.WEST);
                break;
            case KeyEvent.VK_S:
                charizard.setDirection(Direction.SOUTH);
                break;
            case KeyEvent.VK_D:
                charizard.setDirection(Direction.NORTH);
                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
