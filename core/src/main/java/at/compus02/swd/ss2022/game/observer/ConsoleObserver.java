package at.compus02.swd.ss2022.game.observer;

import at.compus02.swd.ss2022.game.observer.interfaces.GameObserver;


import java.util.Date;

public class ConsoleObserver implements GameObserver
{
    //Defined or fixed values;
    private final String PLAY_ACTION_SUCCESS = "Player moved";
    private final String PLAY_ACTION_FAIL = "Player did not move";
    private static ConsoleObserver consoleObserver = new ConsoleObserver();
    private ConsoleObserver(){}

    public static ConsoleObserver getInstance(){return consoleObserver;}

    @Override
    public void onPlayerMovedUp(boolean successful)
    {
        if(successful)
            System.out.println(buildMessage(PLAY_ACTION_SUCCESS + " up"));
        else
            System.out.println(buildMessage(PLAY_ACTION_FAIL + " up"));
    }

    @Override
    public void onPlayerMovedDown(boolean successful)
    {
        if(successful)
            System.out.println(buildMessage(PLAY_ACTION_SUCCESS + " down"));
        else
            System.out.println(buildMessage(PLAY_ACTION_FAIL + " down"));
    }

    @Override
    public void onPlayerMovedRight(boolean successful)
    {
        if(successful)
            System.out.println(buildMessage(PLAY_ACTION_SUCCESS + " right"));
        else
            System.out.println(buildMessage(PLAY_ACTION_FAIL + " right"));
    }

    @Override
    public void onPlayerMovedLeft(boolean successful)
    {
        if(successful)
            System.out.println(buildMessage(PLAY_ACTION_SUCCESS + " left"));
        else
            System.out.println(buildMessage(PLAY_ACTION_FAIL + " left"));
    }

    @Override
    public void onError(String message)
    {
        System.out.println(buildMessage(message));
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
}
