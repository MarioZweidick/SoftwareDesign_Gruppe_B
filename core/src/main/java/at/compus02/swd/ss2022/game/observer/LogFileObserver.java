package at.compus02.swd.ss2022.game.observer;

import at.compus02.swd.ss2022.game.observer.enums.GameLogLevel;
import at.compus02.swd.ss2022.game.observer.interfaces.GameObserver;
import jdk.jfr.internal.LogLevel;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class LogFileObserver implements GameObserver
{
    //Defined or fixed values;
    String PLAY_ACTION_SUCCESS = "Player moved";
    String PLAY_ACTION_FAIL = "Player did not move";

    String path;
    BufferedWriter writer;


    public LogFileObserver(String path)
    {
        this.path = path;
        try
        {
            this.writer = new BufferedWriter(new FileWriter(path, true));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onPlayerMovedUp(boolean successful)
    {
        if(successful)
            writeLogEntry(buildMessage(GameLogLevel.INFO.toString(), PLAY_ACTION_SUCCESS + " up"));
        else
            writeLogEntry(buildMessage(GameLogLevel.WARNING.toString(), PLAY_ACTION_FAIL + " up"));
    }

    @Override
    public void onPlayerMovedDown(boolean successful)
    {
        if(successful)
            writeLogEntry(buildMessage(GameLogLevel.INFO.toString(), PLAY_ACTION_SUCCESS + " down"));
        else
            writeLogEntry(buildMessage(GameLogLevel.WARNING.toString(), PLAY_ACTION_FAIL + " down"));
    }

    @Override
    public void onPlayerMovedRight(boolean successful)
    {
        if(successful)
            writeLogEntry(buildMessage(GameLogLevel.INFO.toString(), PLAY_ACTION_SUCCESS + " right"));
        else
            writeLogEntry(buildMessage(GameLogLevel.WARNING.toString(), PLAY_ACTION_FAIL + " right"));
    }

    @Override
    public void onPlayerMovedLeft(boolean successful)
    {
        if(successful)
            writeLogEntry(buildMessage(GameLogLevel.INFO.toString(), PLAY_ACTION_SUCCESS + " left"));
        else
            writeLogEntry(buildMessage(GameLogLevel.WARNING.toString(), PLAY_ACTION_FAIL + " left"));
    }

    @Override
    public void onError(String message)
    {
        writeLogEntry(buildMessage(GameLogLevel.ERROR.toString(), message));
    }

    @Override
    public void atGameStart(String message)
    {
        writeLogEntry(buildMessage(GameLogLevel.INFO.toString(), message));
    }

    public String buildMessage(String logLevel, String message)
    {
        Date date = new Date();

        return date.toString() + " | " + logLevel + " | " + message;
    }

    public void writeLogEntry(String builtMessage)
    {
        try
        {
            writer.write(builtMessage);
            writer.newLine();
            writer.flush();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
