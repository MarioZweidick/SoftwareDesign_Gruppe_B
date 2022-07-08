package at.compus02.swd.ss2022.game.bl;

import at.compus02.swd.ss2022.game.gameobjects.interfaces.GameObject;
import at.compus02.swd.ss2022.game.gameobjects.interfaces.MoveableObject;
import at.compus02.swd.ss2022.game.movement.Direction;
import at.compus02.swd.ss2022.game.observer.ConsoleObserver;
import at.compus02.swd.ss2022.game.observer.LogFileObserver;
import at.compus02.swd.ss2022.game.observer.interfaces.GameObservable;
import at.compus02.swd.ss2022.game.observer.interfaces.GameObserver;

import java.util.ArrayList;

public class Movement  implements GameObservable
{
    private static Movement movement = new Movement();
    private ArrayList<GameObserver> observers;

    private Movement()
    {
        observers = new ArrayList<>();
        registerObserver(LogFileObserver.getInstance());
        registerObserver(ConsoleObserver.getInstance());
    }

    public static  Movement getInstance(){return movement;}

    public void moveObject(MoveableObject moveableobject, Direction direction){
        float yPosition;
        float xPosition;
        GameObject gameObject = (GameObject)moveableobject;

        switch (direction){
            case UP:
                yPosition = gameObject.getYPosition() + moveableobject.getSpriteSize();
                xPosition = gameObject.getXPosition();
                moveableobject.setDirection(Direction.UP);
                break;
            case DOWN:
                yPosition = gameObject.getYPosition() - moveableobject.getSpriteSize();
                xPosition = gameObject.getXPosition();
                moveableobject.setDirection(Direction.DOWN);
                break;
            case LEFT:
                yPosition = gameObject.getYPosition();
                xPosition = gameObject.getXPosition() - moveableobject.getSpriteSize();
                moveableobject.setDirection(Direction.LEFT);
                break;
            case RIGHT:
                yPosition = gameObject.getYPosition();
                xPosition = gameObject.getXPosition() + moveableobject.getSpriteSize();
                moveableobject.setDirection(Direction.RIGHT);
                break;
            default:
                yPosition = gameObject.getYPosition();
                xPosition = gameObject.getXPosition();
        }

        if(Moveable.canMove(xPosition,yPosition, moveableobject.getGameObjectType())){
            gameObject.setPosition(xPosition,yPosition);
            notifyObserverOnAction(true, direction, moveableobject);
        }
        else
            notifyObserverOnAction(false, direction, moveableobject);

        MovementSprite.changeSprite(moveableobject,direction);
    }

    @Override
    public void registerObserver(GameObserver observer)
    {
        observers.add(observer);
    }

    @Override
    public void notifyObserverOnAction(boolean successful, Direction direction, MoveableObject moveableObject)
    {
        for (GameObserver observer : observers)
        {
            observer.onObjectMoved(successful, direction, moveableObject);
        }
    }
}
