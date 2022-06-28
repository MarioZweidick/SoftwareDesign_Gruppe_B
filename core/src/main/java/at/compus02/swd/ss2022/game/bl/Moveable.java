package at.compus02.swd.ss2022.game.bl;

import at.compus02.swd.ss2022.game.gameobjects.interfaces.GameObject;
import at.compus02.swd.ss2022.game.gameobjects.MoveableGameObjects;
import com.badlogic.gdx.utils.Array;

public class Moveable {
    private static Array<GameObject> noneMoveableObjects = new Array<>();
    private static Array<GameObject> noneStandOnObjectsForPlayer = new Array<>();
    public static void setNoneMoveableObjects(Array<GameObject> list)
    {
        noneMoveableObjects.addAll(list);
    }
    public static void setNoneStandOnObjectsForPlayer(Array<GameObject>list){noneStandOnObjectsForPlayer.addAll(list);}

    public static boolean canMove(float nextXPosition, float nextYPosition, MoveableGameObjects objecttpye){
        boolean canMove = true;
        System.out.println("nextXPosition: "+nextXPosition+" nextYPosition "+nextYPosition);

        if(noneMoveableObjects == null){
            return true;
        }
        if(!checkBorder(nextXPosition, nextYPosition))
        {
            return false;
        }

        //Prüft, ob der Player einen Gegner überdeckt.
        //Falls ja, darf der Player sich nicht dorthin bewegen.
        if(objecttpye == MoveableGameObjects.Character){
            canMove =  checkList(noneStandOnObjectsForPlayer, nextXPosition, nextYPosition);
            if(!canMove){
                return false;
            }
        }

        canMove = checkList(noneMoveableObjects, nextXPosition, nextYPosition);
        return canMove;
    }

    private static boolean checkList(Array<GameObject> objectlist, float nextX, float nextY){
        boolean canMove = true;

        for (GameObject noneMovableObject : objectlist) {
            float x = noneMovableObject.getXPosition();
            float y = noneMovableObject.getYPosition();
            float width = x+noneMovableObject.getSpriteWidth();
            float height = y+noneMovableObject.getSpriteHeight();

            if((x<=nextX && nextX <= width) &&
                    (y<=nextY && nextY <= height))
            {
                System.out.println("Position x:"+x+" Position y:"+y);
                System.out.println("Position x:"+width+" Position y:"+height);
                System.out.println("---------------");

                canMove = noneMovableObject.isAccessible();
            }
        }
        return canMove;
    }

    private static boolean checkBorder(float xPosition, float yPosition){
        if((xPosition >-160 && xPosition<=150)&&
                (yPosition>-140 && yPosition<=180)){
            return true;
        }
        return false;
    }
}
