package at.compus02.swd.ss2022.game.observer.interfaces;

import at.compus02.swd.ss2022.game.gameobjects.interfaces.MovableObject;
import at.compus02.swd.ss2022.game.movement.Direction;

public interface GameObservable
{
  void registerObserver(GameObserver observer);
  void notifyObserverOnAction(boolean successful, Direction direction, MovableObject movableObject);
}