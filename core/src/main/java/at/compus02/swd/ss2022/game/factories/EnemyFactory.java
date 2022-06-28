package at.compus02.swd.ss2022.game.factories;

import at.compus02.swd.ss2022.game.bl.EnemyControl;
import at.compus02.swd.ss2022.game.bl.Moveable;
import at.compus02.swd.ss2022.game.gameobjects.interfaces.GameObject;
import at.compus02.swd.ss2022.game.factories.interfaces.GameObjectFactory;
import at.compus02.swd.ss2022.game.gameobjects.EnemyGreen;
import at.compus02.swd.ss2022.game.gameobjects.EnemyRed;
import at.compus02.swd.ss2022.game.gameobjects.interfaces.IFighting;
import com.badlogic.gdx.utils.Array;

public class EnemyFactory implements GameObjectFactory {

    private Array<GameObject> enemies = new Array<>();

    private EnemyGreen createEnemyBlue(){return new EnemyGreen();}
    private EnemyRed createEnemyRed(){return new EnemyRed();}
    @Override
    public Array<GameObject> createStartObjects(int numberOfTiles) {
        EnemyRed enemyRed = createEnemyRed();
        enemyRed.setPosition(100,100);
        //((IFighting)enemyRed).setHealth(50);
        //((IFighting)enemyRed).setAttackstrength(10);



        EnemyGreen enemyGreen = createEnemyBlue();
        enemyGreen.setPosition(-150,-100);
        //((IFighting)enemyGreen).setHealth(100);
        //((IFighting)enemyGreen).setAttackstrength(100);



        enemies.add(enemyGreen,enemyRed);
        Moveable.setNoneStandOnObjectsForPlayer(enemies);

        EnemyControl.getInstance().registerEnemies(enemies);

        return enemies;
    }
}
