import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class RenderEngine extends JPanel implements Engine{
    private ArrayList<Displayable> renderList;
    public enum GameStatus{STARTING,GAME,DEAD};
    public static GameStatus gameStatus = GameStatus.STARTING;
    public RenderEngine(JFrame jFrame) {
        renderList = new ArrayList<>();
    }

    public static GameStatus getGameStatus() {
        return gameStatus;
    }

    public static void setGameStatus(int gameStatus) {
        RenderEngine.gameStatus = GameStatus.values()[gameStatus];
    }

    public void addToRenderList(Displayable displayable){
        if (!renderList.contains(displayable)){
            renderList.add(displayable);
        }
    }


    public void addToRenderList(ArrayList<Displayable> displayable){
        if (!renderList.contains(displayable)){
            renderList.addAll(displayable);
        }
    }

    @Override
    public void paint(Graphics g) {
        switch (gameStatus){
            case STARTING:  try {
                BufferedImage welcomeim = ImageIO.read(new File("img/Welcome1.png"));
                Image welcome_s = welcomeim.getScaledInstance(400,600,Image.SCALE_SMOOTH);
                g.drawImage(welcome_s.getScaledInstance( 400,600,Image.SCALE_SMOOTH ),0,0,null);
            } catch (Exception e) {
                System.out.println("Problem loading Welcome Image");
            }
                break;
            case GAME:super.paint(g);
                for (Displayable renderObject:renderList) {
                    renderObject.draw(g);
                }
                break;
            case DEAD:
                try {
                BufferedImage over = ImageIO.read(new File("img/Over.png"));
                Image over_scaled = over.getScaledInstance(400, 600, Image.SCALE_SMOOTH);
                g.drawImage(over_scaled.getScaledInstance(400, 600, Image.SCALE_SMOOTH), 0, 0, null);
            } catch (Exception e) {
                System.out.println("Problem loading Over Image");
            }
                break;
        }

    }

    @Override
    public void update(){
        this.repaint();
    }
}
