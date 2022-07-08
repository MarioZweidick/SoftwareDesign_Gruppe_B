package at.compus02.swd.ss2022.game.input;

import at.compus02.swd.ss2022.game.bl.EnemyControl;
import at.compus02.swd.ss2022.game.bl.EnemyMovement;
import at.compus02.swd.ss2022.game.commands.*;
import at.compus02.swd.ss2022.game.gameobjects.interfaces.GameObject;
import at.compus02.swd.ss2022.game.gameobjects.interfaces.MoveableObject;
import at.compus02.swd.ss2022.game.movement.Direction;
import at.compus02.swd.ss2022.game.observer.ConsoleObserver;
import at.compus02.swd.ss2022.game.observer.LogFileObserver;
import at.compus02.swd.ss2022.game.observer.interfaces.GameObservable;
import at.compus02.swd.ss2022.game.observer.interfaces.GameObserver;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;

public class GameInput extends InputAdapter
{
    private final MoveDownCommand downCommand;
    private final MoveUpCommand upCommand;
    private final MoveRightCommand rightCommand;
    private final MoveLeftCommand leftCommand;
    private final HitCommand hitCommand;
    private final ArrayList<GameObserver> observers;

    private final ArrayList<GameObject> enemies;
    private final MoveableObject player;

    public GameInput(MoveableObject player, Array<GameObject> enemies) {
        this.downCommand = new MoveDownCommand(player);
        this.upCommand = new MoveUpCommand(player);
        this.rightCommand = new MoveRightCommand(player);
        this.leftCommand = new MoveLeftCommand(player);
        this.hitCommand = new HitCommand(player);
        this.observers = new ArrayList<>();
        this.enemies = new ArrayList<>();
        this.enemies.add(enemies.first());
        this.player = player;


    }
    @Override
    public boolean keyDown(int keycode) {
        if(Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT))
        {
            rightCommand.execute();
            update();
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT))
        {
            leftCommand.execute();
            update();
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.DPAD_UP))
        {
            upCommand.execute();
            update();
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.DPAD_DOWN))
        {
            downCommand.execute();
            update();
        } else if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            hitCommand.execute();
        }
        return true;
    }
    private void update(){

        for (GameObject enemy : enemies){
            //EnemyMovement.MoveEnemyToPlayer(enemy, (GameObject) player);
        }
    }

}
