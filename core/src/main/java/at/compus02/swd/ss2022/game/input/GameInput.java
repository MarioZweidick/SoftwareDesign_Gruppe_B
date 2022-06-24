package at.compus02.swd.ss2022.game.input;

import at.compus02.swd.ss2022.game.Commands.MoveDownCommand;
import at.compus02.swd.ss2022.game.Commands.MoveLeftCommand;
import at.compus02.swd.ss2022.game.Commands.MoveRightCommand;
import at.compus02.swd.ss2022.game.Commands.MoveUpCommand;
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
    private final MoveDownCommand downCommand;
    private final MoveUpCommand upCommand;
    private final MoveRightCommand rightCommand;
    private final MoveLeftCommand leftCommand;
    private final ArrayList<GameObserver> observers;

    public GameInput(MoveableObject gameObject) {
        this.downCommand = new MoveDownCommand(gameObject);
        this.upCommand = new MoveUpCommand(gameObject);
        this.rightCommand = new MoveRightCommand(gameObject);
        this.leftCommand = new MoveLeftCommand(gameObject);
        this.observers = new ArrayList<>();

        registerObserver(ConsoleObserver.getInstance());
        registerObserver(LogFileObserver.GetInstance());

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
