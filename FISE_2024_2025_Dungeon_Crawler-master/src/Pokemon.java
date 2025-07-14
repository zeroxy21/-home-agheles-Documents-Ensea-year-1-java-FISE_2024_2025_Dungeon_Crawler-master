import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Pokemon extends DynamicSprite {

    public Pokemon(double x, double y, Image image, double width, double height,int life,int damage,int defense) {
        super(x, y, image, width, height,life,damage,defense,4);
        this.setScaleFactor(0.4);
        this.setDirection(Direction.WEST);
    }


}
