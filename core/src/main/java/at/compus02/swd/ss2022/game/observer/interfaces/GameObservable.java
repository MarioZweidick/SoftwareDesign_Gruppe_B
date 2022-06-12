package at.compus02.swd.ss2022.game.observer.interfaces;

public interface GameObservable
{
  public void registerObserver(GameObserver observer);
  public void notifyObserverOnAction(boolean successful);
}