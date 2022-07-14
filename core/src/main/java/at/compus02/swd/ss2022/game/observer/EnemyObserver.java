package at.compus02.swd.ss2022.game.observer;

import at.compus02.swd.ss2022.game.bl.MovableObjectControl;
import at.compus02.swd.ss2022.game.gameobjects.interfaces.MoveableObject;
import at.compus02.swd.ss2022.game.movement.Direction;
import at.compus02.swd.ss2022.game.observer.interfaces.GameObserver;

import java.util.Random;

public class EnemyObserver implements GameObserver
{
    //Defined or fixed values;
    private final String PLAY_ACTION_SUCCESS = "moved ";
    private final String PLAY_ACTION_FAIL = "did not move ";
    private static EnemyObserver enemyObserver;
    private EnemyObserver(){}

    public static EnemyObserver getInstance()
    {
        if(enemyObserver == null)
            enemyObserver = new EnemyObserver();
        return enemyObserver;
    }

    @Override
    public void onObjectMoved(boolean successful, Direction direction, MoveableObject moveableObject)
    {
        //Tell All Enemies that the player has moved
        /*
        for (MoveableObject enemy : MoveableObjectControl.getInstance().getEnemies())
        {
            //Randomly move to or away from player
            if(bMoveToPlayer())
                EnemyMovement.moveDummyEnemy((GameObject) enemy);
            //else
                //EnemyMovement.MoveEnemyToPlayer((GameObject) enemy, player?);
        }
        MoveableObjectControl.getInstance().getEnemies();

         */
    }

    @Override
    public void onHitEnemy(MoveableObject moveableObject)
    {
        //Deduct live points by X points!
    }

    @Override
    public void atGameStart(String message)
    {
        System.out.println(MovableObjectControl.getInstance().getEnemies().size() + " enemies generated");
    }


    //Decides ramdomly, if enemy moves to or away from player
    private boolean bMoveToPlayer()
    {
        Random random = new Random();
        return random.nextBoolean();
    }

    private boolean bIsEnemyDead(MoveableObject moveableObject)
    {
        //If Enemy.getLivePoints == Dead....remove from static EnemyList
        return true;
    }
}
