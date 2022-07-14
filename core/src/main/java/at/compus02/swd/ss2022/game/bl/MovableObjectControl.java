package at.compus02.swd.ss2022.game.bl;

import at.compus02.swd.ss2022.game.gameobjects.interfaces.GameObject;
import at.compus02.swd.ss2022.game.gameobjects.interfaces.MoveableObject;
import at.compus02.swd.ss2022.game.movement.Direction;
import at.compus02.swd.ss2022.game.observer.ConsoleObserver;
import at.compus02.swd.ss2022.game.observer.LogFileObserver;
import at.compus02.swd.ss2022.game.observer.interfaces.GameObservable;
import at.compus02.swd.ss2022.game.observer.interfaces.GameObserver;
import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;

public class MovableObjectControl implements GameObservable {

    private static MovableObjectControl instance;
    private GameObject player;
    private ArrayList<MoveableObject> enemies;
    private ArrayList<GameObserver> observers;

    private MovableObjectControl(){
        enemies = new ArrayList<>();
        observers = new ArrayList<>();
        registerObserver(ConsoleObserver.getInstance());
        registerObserver(LogFileObserver.getInstance());
    }

    public static MovableObjectControl getInstance(){
        if(instance == null)
            instance = new MovableObjectControl();

        return instance;
    }

    public void registerEnemies(Array<GameObject> enemies){
        enemies.forEach(n -> this.enemies.add((MoveableObject)n));
        Movable.setNoneStandOnObjectsForPlayer(enemies);
        observers = new ArrayList<>();
    }
    public void registerPlayer(GameObject player){
        this.player = player;
        Movable.setNoneMovableObject(player);
    }

    public ArrayList<MoveableObject> getEnemies(){return enemies;}

    public void movePlayer(Direction direction){
        Movement.getInstance().moveObject((MoveableObject) player, direction);

        for (MoveableObject enemy : enemies) {
            switch (enemy.getGameObjectType()){
                case EnemyGreen:
                    EnemyMovement.moveEnemyToPlayer(enemy,player);break;
                case EnemyRed:
                    EnemyMovement.moveDummyEnemy(enemy);break;
            }
        }
    }

    public void hit(){
        Fight.fightEnemy((MoveableObject) player);
    }

    public void enemyDefeated(MoveableObject enemy){
        enemies.remove(enemy);
    }
    @Override
    public void registerObserver(GameObserver observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObserverOnAction(boolean successful, Direction direction, MoveableObject moveableObject) {
        for (GameObserver observer : observers) {
            //do something
        }
    }
}
