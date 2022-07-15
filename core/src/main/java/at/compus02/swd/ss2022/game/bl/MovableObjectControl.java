package at.compus02.swd.ss2022.game.bl;

import at.compus02.swd.ss2022.game.bl.interfaces.Disposable;
import at.compus02.swd.ss2022.game.gameobjects.interfaces.GameObject;
import at.compus02.swd.ss2022.game.gameobjects.interfaces.MovableObject;
import at.compus02.swd.ss2022.game.movement.Direction;
import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;

public class MovableObjectControl implements Disposable {

    private static MovableObjectControl instance;
    private GameObject player;
    private ArrayList<MovableObject> enemies;

    private MovableObjectControl(){
        enemies = new ArrayList<>();
    }

    public static MovableObjectControl getInstance(){
        if(instance == null)
            instance = new MovableObjectControl();

        return instance;
    }

    public void registerEnemies(Array<GameObject> enemies){
        enemies.forEach(n -> this.enemies.add((MovableObject)n));
        Movable.setNoneStandOnObjectsForPlayer(enemies);
    }
    public void registerPlayer(GameObject player){
        this.player = player;
        Movable.setNoneMovableObject(player);
    }

    public ArrayList<MovableObject> getEnemies(){return enemies;}

    public void movePlayer(Direction direction){
        Movement.getInstance().moveObject((MovableObject) player, direction);

        for (MovableObject enemy : enemies) {
            switch (enemy.getGameObjectType()){
                case EnemyGreen:
                    EnemyMovement.moveEnemyToPlayer(enemy,player);break;
                case EnemyRed:
                    EnemyMovement.moveDummyEnemy(enemy);break;
            }
        }
    }

    public void hit(){
        FightControl.getInstance().BeginFight((MovableObject) player);
    }

    public void enemyDefeated(MovableObject enemy){
        enemies.remove(enemy);
    }
    @Override
    public void dispose() {
        enemies.forEach(n -> Movable.removeNoneStandOnObjectsForPlayer(n));
        enemies= null;
        player = null;
    }
}
