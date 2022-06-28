package at.compus02.swd.ss2022.game.bl;

import at.compus02.swd.ss2022.game.gameobjects.interfaces.GameObject;
import at.compus02.swd.ss2022.game.gameobjects.interfaces.MoveableObject;
import at.compus02.swd.ss2022.game.observer.ConsoleObserver;
import at.compus02.swd.ss2022.game.observer.LogFileObserver;
import at.compus02.swd.ss2022.game.observer.interfaces.GameObservable;
import at.compus02.swd.ss2022.game.observer.interfaces.GameObserver;
import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;

public class EnemyControl implements GameObservable {

    private static final EnemyControl instance = new EnemyControl();
    private ArrayList<MoveableObject> enemies;
    private ArrayList<GameObserver> observers;

    private EnemyControl(){
        enemies = new ArrayList<>();
        registerObserver(ConsoleObserver.getInstance());
        registerObserver(LogFileObserver.getInstance());
    }

    public static EnemyControl getInstance(){return instance;}

    public void registerEnemies(Array<GameObject> enemies){
        enemies.forEach(n -> this.enemies.add((MoveableObject)n));
        observers = new ArrayList<>();
    }

    public ArrayList<MoveableObject> getEnemies(){return enemies;}
    
    public void registerEnemy(MoveableObject enemy){enemies.add(enemy);}

    @Override
    public void registerObserver(GameObserver observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObserverOnAction(boolean successful) {
        for (GameObserver observer : observers) {
            //do something


        }
    }
}
