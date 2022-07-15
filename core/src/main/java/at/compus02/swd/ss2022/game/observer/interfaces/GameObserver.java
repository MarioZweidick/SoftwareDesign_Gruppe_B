package at.compus02.swd.ss2022.game.observer.interfaces;

import at.compus02.swd.ss2022.game.gameobjects.interfaces.MovableObject;
import at.compus02.swd.ss2022.game.movement.Direction;

public interface GameObserver
{
    void onObjectMoved(boolean successful, Direction direction, MovableObject movableObject);
    void onHitEnemy(MovableObject enemy);
    void atGameStart(String message);
}