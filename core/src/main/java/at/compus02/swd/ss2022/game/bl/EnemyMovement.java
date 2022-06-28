package at.compus02.swd.ss2022.game.bl;

import at.compus02.swd.ss2022.game.gameobjects.interfaces.GameObject;
import at.compus02.swd.ss2022.game.gameobjects.interfaces.MoveableObject;
import at.compus02.swd.ss2022.game.movement.Direction;

public class EnemyMovement {
    public static void MoveEnemyToPlayer(GameObject enemy, GameObject player){

        Direction xDirection = enemy.getXPosition() > player.getXPosition() ? Direction.LEFT : Direction.RIGHT;
        Direction yDirection = enemy.getYPosition() > player.getYPosition() ? Direction.DOWN : Direction.UP;

        if(enemy.getXPosition() == player.getXPosition()){
            System.out.println("hallo");
        }

        Movement.moveObject((MoveableObject)enemy,xDirection);
        Movement.moveObject((MoveableObject)enemy,yDirection);
    }

    public static void MoveDummyEnemy(GameObject enemy){

        MoveableObject moveableObject = (MoveableObject)enemy;

        Movement.moveObject(moveableObject,Direction.RIGHT);

    }
}
