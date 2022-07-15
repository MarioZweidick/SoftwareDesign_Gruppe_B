package at.compus02.swd.ss2022.game.observer;

import at.compus02.swd.ss2022.game.gameobjects.interfaces.Fighting;
import at.compus02.swd.ss2022.game.gameobjects.interfaces.MovableObject;
import at.compus02.swd.ss2022.game.movement.Direction;
import at.compus02.swd.ss2022.game.observer.enums.GameLogLevel;
import at.compus02.swd.ss2022.game.observer.interfaces.GameObserver;


import java.util.Date;
import java.util.Locale;

public class ConsoleObserver implements GameObserver
{
    //Defined or fixed values;
    private final String PLAY_ACTION_SUCCESS = "moved ";
    private final String PLAY_ACTION_FAIL = "did not move ";
    private static ConsoleObserver consoleObserver;
    private ConsoleObserver(){}

    public static ConsoleObserver getInstance()
    {
        if(consoleObserver == null)
            consoleObserver = new ConsoleObserver();
        return consoleObserver;
    }


    @Override
    public void onObjectMoved(boolean successful, Direction direction, MovableObject movableObject)
    {
        if(successful)
            System.out.println(buildMessage(PLAY_ACTION_SUCCESS, direction, movableObject));
        else
            System.out.println(buildMessage(PLAY_ACTION_FAIL, direction, movableObject));
    }

    @Override
    public void onHitEnemy(MovableObject movableObject)
    {
        if(movableObject == null){
            System.out.println("Player doesn't hit a enemy");
        }
        else {
            String output = "Player hit " + movableObject.getGameObjectType().toString()+". ";
            output += "Enemy health: "+((Fighting)movableObject).getHealth();
            System.out.println(output);
        }
    }

    @Override
    public void atGameStart(String message)
    {
        System.out.println(buildMessage(message));
    }

    private String buildMessage(String message)
    {
        return GameLogLevel.INFO.toString() + " - " + message;
    }

    private String buildMessage(String message, Direction direction, MovableObject movableObject)
    {
        return GameLogLevel.INFO + " | " + movableObject.getGameObjectType().toString() + " " + message
                + direction.toString().toLowerCase(Locale.ROOT) + "!";
    }
}
