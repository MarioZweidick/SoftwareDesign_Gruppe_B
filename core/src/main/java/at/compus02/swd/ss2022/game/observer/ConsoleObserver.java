package at.compus02.swd.ss2022.game.observer;

import at.compus02.swd.ss2022.game.gameobjects.interfaces.MoveableObject;
import at.compus02.swd.ss2022.game.movement.Direction;
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
    public void onObjectMoved(boolean successful, Direction direction, MoveableObject moveableObject)
    {
        if(successful)
            System.out.println(buildMessage(PLAY_ACTION_SUCCESS, direction, moveableObject));
        else
            System.out.println(buildMessage(PLAY_ACTION_FAIL, direction, moveableObject));
    }

    @Override
    public void onHitEnemy(MoveableObject moveableObject)
    {
        System.out.println("Player hit " + moveableObject.getGameObjectType().toString());
    }

    @Override
    public void atGameStart(String message)
    {
        System.out.println(buildMessage(message));
    }

    private String buildMessage(String message)
    {
        Date date = new Date();

        return date.toString() + " - " + message;
    }

    private String buildMessage(String message, Direction direction, MoveableObject moveableObject)
    {
        Date date = new Date();

        return date.toString() + " | " + moveableObject.getGameObjectType().toString() + " " + message
                + direction.toString().toLowerCase(Locale.ROOT) + "!";
    }
}
