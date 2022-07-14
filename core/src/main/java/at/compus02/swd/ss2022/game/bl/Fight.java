package at.compus02.swd.ss2022.game.bl;

import at.compus02.swd.ss2022.game.gameobjects.interfaces.Fighting;
import at.compus02.swd.ss2022.game.gameobjects.interfaces.MoveableObject;
import at.compus02.swd.ss2022.game.repository.Pair;

public class Fight {

    public static void fightEnemy(MoveableObject player){

        Pair<Float,Float> nextPositions = Movement.getInstance().getNextXYPosition(player, player.getDirection());
        Fighting enemy = (Fighting) Movable.getMovableObjectAt(nextPositions.getFirst(),nextPositions.getSecond());

        if(enemy == null){
            return;
        }
        float health = enemy.getHealth()-((Fighting)player).getAttackstrength();
        if( health> 0 ){
            enemy.setHealth(Math.min(health,0));
        }
        else {
            MovementSprite.setObjectInvisible((MoveableObject) enemy);
            defeatedEnemy((MoveableObject) enemy);
        }
    }

    public static void defeatedEnemy(MoveableObject enemy){
        Movable.removeNoneStandOnObjectsForPlayer(enemy);
        MovableObjectControl.getInstance().enemyDefeated(enemy);
    }

}
