package at.compus02.swd.ss2022.game.input;

import at.compus02.swd.ss2022.game.Commands.MoveDownCommand;
import at.compus02.swd.ss2022.game.Commands.MoveLeftCommand;
import at.compus02.swd.ss2022.game.Commands.MoveRightCommand;
import at.compus02.swd.ss2022.game.Commands.MoveUpCommand;
import at.compus02.swd.ss2022.game.factories.interfaces.MoveableObject;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

public class GameInput extends InputAdapter {
    private MoveDownCommand downCommand;
    private MoveUpCommand upCommand;
    private MoveRightCommand rightCommand;
    private MoveLeftCommand leftCommand;
    public GameInput(MoveableObject gameObject) {
        downCommand = new MoveDownCommand(gameObject);
        upCommand = new MoveUpCommand(gameObject);
        rightCommand = new MoveRightCommand(gameObject);
        leftCommand = new MoveLeftCommand(gameObject);
    }
    @Override
    public boolean keyDown(int keycode) {
        if(Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT)){
            rightCommand.execute();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT)){
            leftCommand.execute();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DPAD_UP)){
            upCommand.execute();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DPAD_DOWN)){
            downCommand.execute();
        }
        return true;
    }
}
