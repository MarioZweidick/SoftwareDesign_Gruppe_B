package at.compus02.swd.ss2022.game.input;

import at.compus02.swd.ss2022.game.commands.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

public class GameInput extends InputAdapter
{
    private final MoveDownCommand downCommand;
    private final MoveUpCommand upCommand;
    private final MoveRightCommand rightCommand;
    private final MoveLeftCommand leftCommand;
    private final HitCommand hitCommand;

    public GameInput() {
        this.downCommand = new MoveDownCommand();
        this.upCommand = new MoveUpCommand();
        this.rightCommand = new MoveRightCommand();
        this.leftCommand = new MoveLeftCommand();
        this.hitCommand = new HitCommand();
    }
    @Override
    public boolean keyDown(int keycode) {
        if(Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT))
        {
            rightCommand.execute();
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT))
        {
            leftCommand.execute();
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.DPAD_UP))
        {
            upCommand.execute();
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.DPAD_DOWN))
        {
            downCommand.execute();
        } else if (Gdx.input.isKeyPressed(Input.Keys.SPACE))
        {
            hitCommand.execute();
        }
        return true;
    }
}
