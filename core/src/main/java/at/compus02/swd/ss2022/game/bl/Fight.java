package at.compus02.swd.ss2022.game.bl;

import at.compus02.swd.ss2022.game.gameobjects.interfaces.Fighting;
import at.compus02.swd.ss2022.game.gameobjects.interfaces.MovableObject;
import at.compus02.swd.ss2022.game.music.Sounds;

public class Fight {

    public static void fightEnemy(Fighting player, Fighting enemy){

        float health = enemy.getHealth()-(player).getAttackstrength();
        if( health> 0 ){
            enemy.setHealth(health);
        }
        else {
            enemy.setHealth(0);
            MusicControl.getInstance().playSound(Sounds.Enemydefeated);
            MovementSprite.setObjectInvisible((MovableObject) enemy);
            defeatedEnemy((MovableObject) enemy);
        }
    }

    public static void defeatedEnemy(MovableObject enemy){
        Movable.removeNoneStandOnObjectsForPlayer(enemy);
        MovableObjectControl.getInstance().enemyDefeated(enemy);
    }
}
