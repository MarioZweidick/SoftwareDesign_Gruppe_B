package at.compus02.swd.ss2022.game.observer;

import at.compus02.swd.ss2022.game.observer.enums.GameLogLevel;
import at.compus02.swd.ss2022.game.observer.interfaces.GameObserver;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class LogFileObserver implements GameObserver
{
    //Defined or fixed values;
    private static final LogFileObserver logFileObserver = new LogFileObserver();
    private final String PLAY_ACTION_SUCCESS = "Player moved";
    private final String PLAY_ACTION_FAIL = "Player did not move";
    private final String path;
    private BufferedWriter writer;

    private LogFileObserver(){
        String userDir = System.getProperty("user.dir");
        path = userDir+"\\logs\\gamelog.log";

        try
        {
            this.writer = new BufferedWriter(new FileWriter(path, true));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static LogFileObserver GetInstance() {return logFileObserver;}

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

    private String buildMessage(String logLevel, String message)
    {
        Date date = new Date();

        return date.toString() + " | " + logLevel + " | " + message;
    }

    private void writeLogEntry(String builtMessage)
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
