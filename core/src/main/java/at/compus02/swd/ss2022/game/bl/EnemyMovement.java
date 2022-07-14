package at.compus02.swd.ss2022.game.bl;

import at.compus02.swd.ss2022.game.gameobjects.interfaces.GameObject;
import at.compus02.swd.ss2022.game.gameobjects.interfaces.MoveableObject;
import at.compus02.swd.ss2022.game.movement.Direction;

public class EnemyMovement {
    public static void moveEnemyToPlayer(GameObject enemy, GameObject player){

        Direction xDirection = enemy.getXPosition() > player.getXPosition() ? Direction.LEFT : Direction.RIGHT;
        Direction yDirection = enemy.getYPosition() > player.getYPosition() ? Direction.DOWN : Direction.UP;

        Movement.getInstance().moveObject((MoveableObject)enemy,xDirection);
        Movement.getInstance().moveObject((MoveableObject)enemy,yDirection);
    }

    public static void moveDummyEnemy(GameObject enemy){
        Direction xDirection = (Math.floor(Math.random() * 2) + 1) == 1 ? Direction.RIGHT : Direction.LEFT;
        Direction yDirection = (Math.floor(Math.random() * 2) + 1) == 1 ? Direction.UP : Direction.DOWN;
        Movement.getInstance().moveObject((MoveableObject)enemy,xDirection);
        Movement.getInstance().moveObject((MoveableObject)enemy,yDirection);
    }
}
