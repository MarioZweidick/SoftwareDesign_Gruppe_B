package at.compus02.swd.ss2022.game.factories;

import at.compus02.swd.ss2022.game.factories.interfaces.GameObject;
import at.compus02.swd.ss2022.game.factories.interfaces.GameObjectFactory;
import at.compus02.swd.ss2022.game.gameobjects.Enemy;
import com.badlogic.gdx.utils.Array;

public class EnemyFactory implements GameObjectFactory {

    private Array<GameObject> enemies = new Array<>();

    private Enemy createEnemy(){return new Enemy();}
    @Override
    public Array<GameObject> createStartObjects(int numberOfTiles) {

        return enemies;
    }
}
