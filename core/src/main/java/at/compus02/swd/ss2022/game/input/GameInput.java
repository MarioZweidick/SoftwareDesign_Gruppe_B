package at.compus02.swd.ss2022.game.input;

import at.compus02.swd.ss2022.game.commands.MoveDownCommand;
import at.compus02.swd.ss2022.game.commands.MoveLeftCommand;
import at.compus02.swd.ss2022.game.commands.MoveRightCommand;
import at.compus02.swd.ss2022.game.commands.MoveUpCommand;
import at.compus02.swd.ss2022.game.factories.interfaces.MoveableObject;
import at.compus02.swd.ss2022.game.observer.ConsoleObserver;
import at.compus02.swd.ss2022.game.observer.LogFileObserver;
import at.compus02.swd.ss2022.game.observer.interfaces.GameObservable;
import at.compus02.swd.ss2022.game.observer.interfaces.GameObserver;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

import java.util.ArrayList;

public class GameInput extends InputAdapter implements GameObservable
{
    private MoveDownCommand downCommand;
    private MoveUpCommand upCommand;
    private MoveRightCommand rightCommand;
    private MoveLeftCommand leftCommand;

    private ArrayList<GameObserver> observers;

    //Observers
    private String path = "C:\\Users\\mario\\IdeaProjects\\SoftwareDesign_Gruppe_B\\logs\\gamelog.log";
    LogFileObserver logger ;
    ConsoleObserver consoleObserver;

    public GameInput(MoveableObject gameObject) {
        this.downCommand = new MoveDownCommand(gameObject);
        this.upCommand = new MoveUpCommand(gameObject);
        this.rightCommand = new MoveRightCommand(gameObject);
        this.leftCommand = new MoveLeftCommand(gameObject);
        this.observers = new ArrayList<>();
        this.logger = new LogFileObserver(path);
        this.consoleObserver = new ConsoleObserver();

        registerObserver(logger);
        registerObserver(consoleObserver);

        //Write message, once game is started --> GameStart should work
        notifyObserverOnAction(true);
    }
    @Override
    public boolean keyDown(int keycode) {
        if(Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT))
        {
            rightCommand.execute();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT))
        {
            leftCommand.execute();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DPAD_UP))
        {
            upCommand.execute();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DPAD_DOWN))
        {
            downCommand.execute();
        }
        return true;
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
            if(successful)
                observer.atGameStart("------GAME START------");
            else
                observer.atGameStart("------ERROR DURING GAME START"); //Ask professor for possible use case
        }
    }

}
