package at.compus02.swd.ss2022.game.bl;

import at.compus02.swd.ss2022.game.gameobjects.interfaces.GameObject;
import at.compus02.swd.ss2022.game.gameobjects.interfaces.MoveableObject;
import at.compus02.swd.ss2022.game.movement.Direction;

public class Movement {

    /*
    implements GameObservable
    private static Movement instance = new Movement();
    private final ArrayList<GameObserver> observers;
    private Movement(){
        observers = new ArrayList<>();
        registerObserver(ConsoleObserver.getInstance());
        registerObserver(LogFileObserver.GetInstance());
    }

    public static Movement getInstance(){return instance;}

    @Override
    public void registerObserver(GameObserver observer) {observers.add(observer);}

    @Override
    public void notifyObserverOnAction(boolean successful) {

    }
     */

    public static void moveObject(MoveableObject moveableobject, Direction direction){
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
        }
        MovementSprite.changeSprite(moveableobject,direction);
    }
}
