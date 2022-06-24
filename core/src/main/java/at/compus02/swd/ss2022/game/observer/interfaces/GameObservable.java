package at.compus02.swd.ss2022.game.observer.interfaces;

public interface GameObservable
{
  void registerObserver(GameObserver observer);
  void notifyObserverOnAction(boolean successful);
}