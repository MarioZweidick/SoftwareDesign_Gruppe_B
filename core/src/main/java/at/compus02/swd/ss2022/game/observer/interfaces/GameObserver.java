package at.compus02.swd.ss2022.game.observer.interfaces;

import at.compus02.swd.ss2022.game.gameobjects.interfaces.MoveableObject;
import at.compus02.swd.ss2022.game.movement.Direction;

public interface GameObserver
{
    void onObjectMoved(boolean successful, Direction direction, MoveableObject moveableObject);
    void onHitEnemy(MoveableObject enemy);
    void atGameStart(String message);
}