package at.compus02.swd.ss2022.game.factories;

import at.compus02.swd.ss2022.game.bl.MovableObjectControl;
import at.compus02.swd.ss2022.game.gameobjects.interfaces.Fighting;
import at.compus02.swd.ss2022.game.gameobjects.interfaces.GameObject;
import at.compus02.swd.ss2022.game.factories.interfaces.GameObjectFactory;
import at.compus02.swd.ss2022.game.gameobjects.EnemyGreen;
import at.compus02.swd.ss2022.game.gameobjects.EnemyRed;
import com.badlogic.gdx.utils.Array;

public class EnemyFactory implements GameObjectFactory {

    private Array<GameObject> enemies = new Array<>();

    private EnemyGreen createEnemyGreen(){return new EnemyGreen();}
    private EnemyRed createEnemyRed(){return new EnemyRed();}
    @Override
    public Array<GameObject> createStartObjects(int numberOfTiles) {
        EnemyRed enemyRed = createEnemyRed();
        enemyRed.setPosition(100,100);
        ((Fighting)enemyRed).setHealth(150);
        ((Fighting)enemyRed).setAttackstrength(10);

        EnemyGreen enemyGreen = createEnemyGreen();
        enemyGreen.setPosition(-150,-100);
        ((Fighting)enemyGreen).setHealth(100);
        ((Fighting)enemyGreen).setAttackstrength(100);

        enemies.add(enemyGreen,enemyRed);
        MovableObjectControl.getInstance().registerEnemies(enemies);

        return enemies;
    }
}
