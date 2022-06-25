package at.compus02.swd.ss2022.game.commands;

import at.compus02.swd.ss2022.game.bl.Moveable;
import at.compus02.swd.ss2022.game.factories.interfaces.ICommand;
import at.compus02.swd.ss2022.game.factories.interfaces.MoveableObject;
import at.compus02.swd.ss2022.game.factories.interfaces.GameObject;

public class MoveUpCommand implements ICommand {

    private MoveableObject object;

    public MoveUpCommand(MoveableObject object) {
        this.object = object;
    }

    @Override
    public void execute() {
        float nextPosition = ((GameObject)object).getYPosition() + object.getSpriteSize();
        float xPosition = ((GameObject)object).getXPosition();
        if(Moveable.canMove(xPosition,nextPosition)){
            object.moveUp(1);
        }
    }
}
