import java.lang.reflect.Array;
import java.util.ArrayList;

public class PhysicEngine implements Engine {
    private ArrayList<DynamicSprite> movingSpriteList;
    private ArrayList<Sprite> environment;
    private ArrayList<DynamicSprite> enemylist;

    public PhysicEngine() {
        movingSpriteList = new ArrayList<>();
        environment = new ArrayList<>();
        enemylist = new ArrayList<>();
    }

    public void addToEnemyList(Sprite sprite) {
        if (!enemylist.contains(sprite)) {
            enemylist.add((Pokemon) sprite);
        }
    }


    public void addToEnvironmentList(Sprite sprite) {
        if (!environment.contains(sprite)) {
            environment.add(sprite);
        }
    }

    public void setEnvironment(ArrayList<Sprite> environment) {
        this.environment = environment;
    }

    public void addToMovingSpriteList(DynamicSprite sprite) {
        if (!movingSpriteList.contains(sprite)) {
            movingSpriteList.add(sprite);
        }
    }

    @Override
    public void update() {
        for (DynamicSprite dynamicSprite : movingSpriteList) {
            dynamicSprite.moveIfPossible(environment);
            for ( DynamicSprite charizard : enemylist) {
                dynamicSprite.hero_crossing(charizard);
            }

        }
    }
}