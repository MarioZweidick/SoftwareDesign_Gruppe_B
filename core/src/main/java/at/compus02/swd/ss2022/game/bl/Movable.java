package at.compus02.swd.ss2022.game.bl;

import at.compus02.swd.ss2022.game.gameobjects.interfaces.GameObject;
import at.compus02.swd.ss2022.game.gameobjects.MovableGameObjects;
import at.compus02.swd.ss2022.game.gameobjects.interfaces.MovableObject;
import com.badlogic.gdx.utils.Array;

public class Movable {

    private static final Array<GameObject> noneMovableObjects = new Array<>();
    private static final Array<GameObject> noneStandOnObjectsForPlayer = new Array<>();
    public static void setNoneMovableObjects(Array<GameObject> list)
    {
        noneMovableObjects.addAll(list);
    }
    public static void setNoneMovableObject(GameObject gameObject)
    {
        noneMovableObjects.add(gameObject);
    }
    public static void setNoneStandOnObjectsForPlayer(Array<GameObject>list){noneStandOnObjectsForPlayer.addAll(list);}

    public static void removeNoneStandOnObjectsForPlayer(GameObject object){
        noneStandOnObjectsForPlayer.removeValue(object,true);
    }

    public static boolean canMove(float nextXPosition, float nextYPosition, MovableGameObjects objectType){
        boolean canMove;

        if(noneMovableObjects.isEmpty()){
            return true;
        }
        if(!checkBorder(nextXPosition, nextYPosition))
        {
            return false;
        }

        //Prüft, ob der Player einen Gegner überdeckt.
        //Falls ja, darf der Player sich nicht dorthin bewegen.
        if(objectType == MovableGameObjects.Character){
            canMove =  checkList(noneStandOnObjectsForPlayer, nextXPosition, nextYPosition);
            if(!canMove){
                return false;
            }
        }

        canMove = checkList(noneMovableObjects, nextXPosition, nextYPosition);
        return canMove;
    }

    private static boolean checkList(Array<GameObject> objectList, float nextX, float nextY){
        boolean canMove = true;

        for (GameObject noneMovableObject : objectList) {
            float x = noneMovableObject.getXPosition();
            float y = noneMovableObject.getYPosition();
            float width = x+noneMovableObject.getSpriteWidth();
            float height = y+noneMovableObject.getSpriteHeight();

            if((x<=nextX && nextX <= width) &&
                    (y<=nextY && nextY <= height))
            {
                canMove = noneMovableObject.isAccessible();
            }
        }
        return canMove;
    }

    private static boolean checkBorder(float xPosition, float yPosition){
        return (xPosition > -160 && xPosition <= 150) &&
                (yPosition > -140 && yPosition <= 180);
    }

    public static MovableObject getMovableObjectAt(float xPosition, float yPosition){

        for (GameObject noneMovableObject : noneStandOnObjectsForPlayer) {
            float x = noneMovableObject.getXPosition()-10;
            float y = noneMovableObject.getYPosition()-10;
            float width = x+noneMovableObject.getSpriteWidth();
            float height = y+noneMovableObject.getSpriteHeight();

            if((x<=xPosition && xPosition <= width) &&
                    (y<=yPosition && yPosition <= height))
            {
                return (MovableObject) noneMovableObject;
            }
        }
        return null;
    }
}
