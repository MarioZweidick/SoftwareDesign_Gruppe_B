package at.compus02.swd.ss2022.game.input;

import at.compus02.swd.ss2022.game.factories.interfaces.MoveableObject;
import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

public class GameInput extends InputAdapter {

    private MoveableObject object;

    public GameInput(MoveableObject object) {
        this.object = object;
    }

    @Override
    public boolean keyDown(int keycode) {

        if(Gdx.input.isKeyJustPressed(Input.Keys.DPAD_RIGHT)){
            object.move(1,0);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT)){
            object.move(-1,0);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DPAD_UP)){
            object.move(0,1);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DPAD_DOWN)){
            object.move(0,-1);
        }

        return true;
    }
}
