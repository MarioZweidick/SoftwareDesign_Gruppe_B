package at.compus02.swd.ss2022.game.BL;

import at.compus02.swd.ss2022.game.gameobjects.GameObject;

import com.badlogic.gdx.utils.Array;

public class Moveable {

    private static Array<GameObject> moveableObjects = new Array<>();

    public static void setNonMoveableObjects(Array<GameObject> list)
    {
        moveableObjects.addAll(list);
    }
    public static boolean canMove(float nextXPosition, float nextYPosition){
        if(moveableObjects == null){
            return false;
        }

        boolean canMove = false;

       // float objectX = object.getXPosition();


        for (GameObject moveableObject : moveableObjects) {


            float x = moveableObject.getXPosition();
            float y = moveableObject.getYPosition();


        }
        
        return true;
    }

    private boolean CheckBorder(float x, float y){
        return true;
    }

}
