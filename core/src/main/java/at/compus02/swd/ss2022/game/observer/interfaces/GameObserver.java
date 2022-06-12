package at.compus02.swd.ss2022.game.observer.interfaces;

public interface GameObserver
{
    void onPlayerMovedUp(boolean successful);

    void onPlayerMovedDown(boolean successful);

    void onPlayerMovedRight(boolean successful);

    void onPlayerMovedLeft(boolean successful);

    void onError(String message);

    void atGameStart(String message);
}