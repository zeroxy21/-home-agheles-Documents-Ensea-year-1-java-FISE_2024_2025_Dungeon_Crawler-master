import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class DynamicSprite extends SolidSprite {
    public ArrayList<Sprite> enemyList;
    public ArrayList<Sprite> pokemonList;
    private Direction direction = Direction.EAST;
    double speed = 5;
    private double timeBetweenFrame = 250;
    private boolean isWalking =true;
    private final int spriteSheetNumberOfColumn;
    private final int startlife=100;
    private int health;
    private int defense;
    private int damage;

    public DynamicSprite(double x, double y, Image image, double width, double height,int health,int damage,int defense, int spriteSheetNumberOfColumn) {
        super(x, y, image, width, height);
        this.health=health;
        this.damage=damage;
        this.defense=defense;
        this.spriteSheetNumberOfColumn=spriteSheetNumberOfColumn;

    }


    public int getHealth() {
        return health;
    }
    public void hero_crossing(SolidSprite pokemon){
        if(this.intersect(pokemon.getHitBox())){
            this.decreaseHealth(1);
        }
    }
    public void decreaseHealth(int damage){
        this.health=this.health-damage;
        if (this.health<=0){
            this.health=0;
            RenderEngine.setGameStatus(RenderEngine.GameStatus.DEAD.ordinal());
        }
    }
    boolean isMovingPossible(ArrayList<Sprite> environment){
        Rectangle2D.Double moved = new Rectangle2D.Double();
        switch(direction){
            case EAST: moved.setRect(super.getHitBox().getX()+speed,super.getHitBox().getY(),
                                    super.getHitBox().getWidth(), super.getHitBox().getHeight());
                break;
            case WEST:  moved.setRect(super.getHitBox().getX()-speed,super.getHitBox().getY(),
                    super.getHitBox().getWidth(), super.getHitBox().getHeight());
                break;
            case NORTH:  moved.setRect(super.getHitBox().getX(),super.getHitBox().getY()-speed,
                    super.getHitBox().getWidth(), super.getHitBox().getHeight());
                break;
            case SOUTH:  moved.setRect(super.getHitBox().getX(),super.getHitBox().getY()+speed,
                    super.getHitBox().getWidth(), super.getHitBox().getHeight());
                break;
        }

        for (Sprite s : environment){
            if ((s instanceof SolidSprite) && (s!=this)){
                if (((SolidSprite) s).intersect(moved)){
                    return false;
                }
            }
        }
        return true;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    private void move(){
        switch (direction){
            case NORTH -> {
                this.y-=speed;
            }
            case SOUTH -> {
                this.y+=speed;
            }
            case EAST -> {
                this.x+=speed;
            }
            case WEST -> {
                this.x-=speed;
            }
        }

    }

    public void moveIfPossible(ArrayList<Sprite> environment){
        if (isMovingPossible(environment)){
            move();
        }

    }

    public void setScaleFactor(double scaleFactor) {
        if (scaleFactor>0) this.scaleFactor = scaleFactor;
    }

    @Override
    public void draw(Graphics g) {
        int index= (int) (System.currentTimeMillis()/timeBetweenFrame%spriteSheetNumberOfColumn);
        g.setColor(Color.black);
        g.fillRect((int)(x),(int)(y-5), (int)(width*scaleFactor), 5);
        g.setColor(Color.RED);
        g.fillRect((int)(x),(int)(y-5), (int)((width*health/startlife)*scaleFactor),5);
        g.drawImage(image,(int) x, (int) y, (int) (x+width*this.scaleFactor),(int) (y+height*this.scaleFactor),
                (int) (index*this.width), (int) (direction.getFrameLineNumber()*height),
                (int) ((index+1)*this.width), (int)((direction.getFrameLineNumber()+1)*this.height),null);
    }
}
