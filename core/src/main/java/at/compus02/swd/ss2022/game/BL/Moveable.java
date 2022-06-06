package at.compus02.swd.ss2022.game.BL;

import at.compus02.swd.ss2022.game.factories.interfaces.GameObject;
import com.badlogic.gdx.utils.Array;

public class Moveable {
    private static Array<GameObject> noneMoveableObjects = new Array<>();
    public static void setNonMoveableObjects(Array<GameObject> list)
    {
        noneMoveableObjects.addAll(list);
    }

    public static boolean canMove(float nextXPosition, float nextYPosition){
        boolean canMove = true;
        System.out.println("nextXPosition: "+nextXPosition+" nextYPosition "+nextYPosition);

        if(noneMoveableObjects == null){
            return true;
        }
        if(!checkBorder(nextXPosition, nextYPosition))
        {
            return false;
        }

        for (GameObject noneMovableObject : noneMoveableObjects) {
            float x = noneMovableObject.getXPosition();
            float y = noneMovableObject.getYPosition();
            float width = x+noneMovableObject.getSpriteWidth();
            float height = y+noneMovableObject.getSpriteHeight();

            if((x<=nextXPosition && nextXPosition <= width) &&
                    (y<=nextYPosition && nextYPosition <= height))
            {
                System.out.println("Position x:"+x+" Position y:"+y);
                System.out.println("Position x:"+width+" Position y:"+height);
                System.out.println("---------------");

                canMove = noneMovableObject.isAccessable();
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
