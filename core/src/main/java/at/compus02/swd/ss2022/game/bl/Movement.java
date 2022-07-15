package at.compus02.swd.ss2022.game.bl;

import at.compus02.swd.ss2022.game.gameobjects.interfaces.MovableObject;
import at.compus02.swd.ss2022.game.movement.Direction;
import at.compus02.swd.ss2022.game.observer.ConsoleObserver;
import at.compus02.swd.ss2022.game.observer.LogFileObserver;
import at.compus02.swd.ss2022.game.observer.interfaces.GameObservable;
import at.compus02.swd.ss2022.game.observer.interfaces.GameObserver;
import at.compus02.swd.ss2022.game.repository.Pair;

import java.util.ArrayList;

public class Movement  implements GameObservable
{
    private static final Movement movement = new Movement();
    private final ArrayList<GameObserver> observers;

    private Movement()
    {
        observers = new ArrayList<>();
        registerObserver(LogFileObserver.getInstance());
        registerObserver(ConsoleObserver.getInstance());
    }

    public static Movement getInstance(){return movement;}

    public Pair<Float,Float> getNextXYPosition(MovableObject movableobject, Direction direction){

        float yPosition;
        float xPosition;

        switch (direction){
            case UP:
                yPosition = movableobject.getYPosition() + movableobject.getSpriteSize();
                xPosition = movableobject.getXPosition();
                break;
            case DOWN:
                yPosition = movableobject.getYPosition() - movableobject.getSpriteSize();
                xPosition = movableobject.getXPosition();
                break;
            case LEFT:
                yPosition = movableobject.getYPosition();
                xPosition = movableobject.getXPosition() - movableobject.getSpriteSize();
                break;
            case RIGHT:
                yPosition = movableobject.getYPosition();
                xPosition = movableobject.getXPosition() + movableobject.getSpriteSize();
                break;
            default:
                yPosition = movableobject.getYPosition();
                xPosition = movableobject.getXPosition();
        }

        return new Pair<>(xPosition,yPosition);
    }

    public void moveObject(MovableObject movableobject, Direction direction){
        float yPosition;
        float xPosition;

        switch (direction){
            case UP:
                movableobject.setDirection(Direction.UP);
                break;
            case DOWN:
                movableobject.setDirection(Direction.DOWN);
                break;
            case LEFT:
                movableobject.setDirection(Direction.LEFT);
                break;
            case RIGHT:
                movableobject.setDirection(Direction.RIGHT);
                break;
        }

        Pair<Float,Float> positions = getNextXYPosition(movableobject,direction);
        xPosition = positions.getFirst();
        yPosition = positions.getSecond();

        if(Movable.canMove(xPosition,yPosition, movableobject.getGameObjectType())){
            movableobject.setPosition(xPosition,yPosition);
            notifyObserverOnAction(true, direction, movableobject);
        }
        else
            notifyObserverOnAction(false, direction, movableobject);

        MovementSprite.changeSprite(movableobject,direction);
    }

    @Override
    public void registerObserver(GameObserver observer)
    {
        observers.add(observer);
    }

    @Override
    public void notifyObserverOnAction(boolean successful, Direction direction, MovableObject movableObject)
    {
        for (GameObserver observer : observers)
        {
            observer.onObjectMoved(successful, direction, movableObject);
        }
    }
}
