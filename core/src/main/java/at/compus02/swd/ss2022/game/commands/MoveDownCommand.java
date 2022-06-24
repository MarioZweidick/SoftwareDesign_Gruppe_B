package at.compus02.swd.ss2022.game.Commands;
import at.compus02.swd.ss2022.game.BL.Moveable;
import at.compus02.swd.ss2022.game.factories.interfaces.ICommand;
import at.compus02.swd.ss2022.game.factories.interfaces.MoveableObject;
import at.compus02.swd.ss2022.game.factories.interfaces.GameObject;
import at.compus02.swd.ss2022.game.observer.ConsoleObserver;
import at.compus02.swd.ss2022.game.observer.LogFileObserver;
import at.compus02.swd.ss2022.game.observer.interfaces.GameObservable;
import at.compus02.swd.ss2022.game.observer.interfaces.GameObserver;

import java.util.ArrayList;

public class MoveDownCommand implements ICommand, GameObservable
{
    private MoveableObject object;
    private ArrayList<GameObserver> observers;

    public MoveDownCommand(MoveableObject object) {
        this.object = object;
        this.observers = new ArrayList<>();

        registerObserver(ConsoleObserver.getInstance());
        registerObserver(LogFileObserver.GetInstance());
    }

    @Override
    public void execute() {
        float nextPosition = ((GameObject)object).getYPosition() - object.getSpriteSize();
        float xPosition = ((GameObject)object).getXPosition();
        if(Moveable.canMove(xPosition,nextPosition)){
            object.move(0,-1);
            notifyObserverOnAction(true);
        }
        else
            notifyObserverOnAction(false);
    }

    @Override
    public void registerObserver(GameObserver observer)
    {
      observers.add(observer);
    }

    @Override
    public void notifyObserverOnAction(boolean successful)
    {
        for (GameObserver observer : observers)
        {
            observer.onPlayerMovedDown(successful);
        }
    }
}
