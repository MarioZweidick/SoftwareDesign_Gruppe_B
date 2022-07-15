package at.compus02.swd.ss2022.game.bl;

import at.compus02.swd.ss2022.game.gameobjects.interfaces.Fighting;
import at.compus02.swd.ss2022.game.gameobjects.interfaces.MovableObject;
import at.compus02.swd.ss2022.game.movement.Direction;
import at.compus02.swd.ss2022.game.observer.ConsoleObserver;
import at.compus02.swd.ss2022.game.observer.LogFileObserver;
import at.compus02.swd.ss2022.game.observer.interfaces.GameObservable;
import at.compus02.swd.ss2022.game.observer.interfaces.GameObserver;
import at.compus02.swd.ss2022.game.repository.Pair;

import java.util.ArrayList;

public class FightControl implements GameObservable {
    private final ArrayList<GameObserver> observers;
    private static final FightControl instance = new FightControl();

    private FightControl() {
        this.observers = new ArrayList<>();
        registerObserver(ConsoleObserver.getInstance());
        registerObserver(LogFileObserver.getInstance());
    }

    public static FightControl getInstance() {
        return instance;
    }

    public void BeginFight(MovableObject player){
        Pair<Float,Float> nextPositions = Movement.getInstance().getNextXYPosition(player, player.getDirection());
        Fighting enemy = (Fighting) Movable.getMovableObjectAt(nextPositions.getFirst(),nextPositions.getSecond());
        if(enemy == null){
            notifyObserverOnAction(false,player.getDirection(),null);
        }
        else{
            Fight.fightEnemy((Fighting) player,enemy);
            notifyObserverOnAction(true,player.getDirection(),(MovableObject)enemy);
        }
    }

    @Override
    public void registerObserver(GameObserver observer) {observers.add(observer);}

    @Override
    public void notifyObserverOnAction(boolean successful, Direction direction, MovableObject enemy) {
        for (GameObserver observer : observers) {
            observer.onHitEnemy(enemy);
        }
    }
}
