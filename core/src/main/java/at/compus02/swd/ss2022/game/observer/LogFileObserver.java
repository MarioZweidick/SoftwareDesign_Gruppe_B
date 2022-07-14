package at.compus02.swd.ss2022.game.observer;

import at.compus02.swd.ss2022.game.gameobjects.interfaces.MoveableObject;
import at.compus02.swd.ss2022.game.movement.Direction;
import at.compus02.swd.ss2022.game.observer.enums.GameLogLevel;
import at.compus02.swd.ss2022.game.observer.interfaces.GameObserver;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;

public class LogFileObserver implements GameObserver
{
    //Defined or fixed values;
    private static LogFileObserver logFileObserver;
    private final String PLAY_ACTION_SUCCESS = "moved ";
    private final String PLAY_ACTION_FAIL = "did not move ";
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

    public static LogFileObserver getInstance() {
       if(logFileObserver == null)
           logFileObserver = new LogFileObserver();

        return logFileObserver;
    }

    @Override
    public void onObjectMoved(boolean successful, Direction direction, MoveableObject moveableObject)
    {
        if(successful)
            writeLogEntry(buildMessage(GameLogLevel.INFO.toString(),PLAY_ACTION_SUCCESS, direction, moveableObject));
        else
            writeLogEntry(buildMessage(GameLogLevel.INFO.toString(),PLAY_ACTION_FAIL, direction, moveableObject));
    }

    @Override
    public void onHitEnemy(MoveableObject moveableObject)
    {

    }

    @Override
    public void atGameStart(String message)
    {
        writeLogEntry(buildMessage(GameLogLevel.INFO.toString(), message));
    }

    private String buildMessage(String logLevel, String message, Direction direction, MoveableObject moveableObject)
    {
        Date date = new Date();

        return date.toString() + " | " + logLevel + " | " + moveableObject.getGameObjectType().toString() + " " + message
                + direction.toString().toLowerCase(Locale.ROOT) + "!";
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
