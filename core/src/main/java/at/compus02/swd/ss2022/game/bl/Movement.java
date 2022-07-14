package at.compus02.swd.ss2022.game.bl;

import at.compus02.swd.ss2022.game.gameobjects.interfaces.MoveableObject;
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

    public Pair<Float,Float> getNextXYPosition(MoveableObject moveableobject, Direction direction){

        float yPosition;
        float xPosition;

        System.out.println("CurrentX"+ moveableobject.getXPosition());
        switch (direction){
            case UP:
                yPosition = moveableobject.getYPosition() + moveableobject.getSpriteSize();
                xPosition = moveableobject.getXPosition();
                break;
            case DOWN:
                yPosition = moveableobject.getYPosition() - moveableobject.getSpriteSize();
                xPosition = moveableobject.getXPosition();
                break;
            case LEFT:
                yPosition = moveableobject.getYPosition();
                xPosition = moveableobject.getXPosition() - moveableobject.getSpriteSize();
                break;
            case RIGHT:
                yPosition = moveableobject.getYPosition();
                xPosition = moveableobject.getXPosition() + moveableobject.getSpriteSize();
                break;
            default:
                yPosition = moveableobject.getYPosition();
                xPosition = moveableobject.getXPosition();
        }

        return new Pair<>(xPosition,yPosition);
    }

    public void moveObject(MoveableObject moveableobject, Direction direction){
        float yPosition;
        float xPosition;

        switch (direction){
            case UP:
                moveableobject.setDirection(Direction.UP);
                break;
            case DOWN:
                moveableobject.setDirection(Direction.DOWN);
                break;
            case LEFT:
                moveableobject.setDirection(Direction.LEFT);
                break;
            case RIGHT:
                moveableobject.setDirection(Direction.RIGHT);
                break;
        }

        Pair<Float,Float> positions = getNextXYPosition(moveableobject,direction);
        xPosition = positions.getFirst();
        yPosition = positions.getSecond();

        if(Movable.canMove(xPosition,yPosition, moveableobject.getGameObjectType())){
            moveableobject.setPosition(xPosition,yPosition);
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
