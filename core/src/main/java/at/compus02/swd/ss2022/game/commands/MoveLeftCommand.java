package at.compus02.swd.ss2022.game.commands;

import at.compus02.swd.ss2022.game.BL.Moveable;
import at.compus02.swd.ss2022.game.factories.interfaces.ICommand;
import at.compus02.swd.ss2022.game.factories.interfaces.MoveableObject;
import at.compus02.swd.ss2022.game.factories.interfaces.GameObject;
import at.compus02.swd.ss2022.game.observer.ConsoleObserver;
import at.compus02.swd.ss2022.game.observer.LogFileObserver;
import at.compus02.swd.ss2022.game.observer.interfaces.GameObservable;
import at.compus02.swd.ss2022.game.observer.interfaces.GameObserver;

import java.util.ArrayList;

public class MoveLeftCommand implements ICommand, GameObservable
{

    private MoveableObject object;
    private ArrayList<GameObserver> observers;

    //Observers
    private String path = "C:\\Users\\mario\\IdeaProjects\\SoftwareDesign_Gruppe_B\\logs\\gamelog.log";
    LogFileObserver logger ;
    ConsoleObserver consoleObserver;

    public MoveLeftCommand(MoveableObject object) {
        this.object = object;
        this.observers = new ArrayList<>();
        this.logger = new LogFileObserver(path);
        this.consoleObserver = new ConsoleObserver();

        registerObserver(logger);
        registerObserver(consoleObserver);
    }

    @Override
    public void execute() {
        float nextPosition = ((GameObject)object).getXPosition() - object.getSpriteSize();
        float yPosition = ((GameObject)object).getYPosition();
        if(Moveable.canMove(nextPosition, yPosition)){
            object.move(-1,0);
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
            observer.onPlayerMovedLeft(successful);
        }
    }
}
