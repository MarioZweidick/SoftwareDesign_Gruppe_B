package at.compus02.swd.ss2022.game.Commands;

import at.compus02.swd.ss2022.game.factories.interfaces.ICommand;
import at.compus02.swd.ss2022.game.factories.interfaces.MoveableObject;
import at.compus02.swd.ss2022.game.gameobjects.GameObject;

public class MoveUpCommand implements ICommand {

    private MoveableObject object;

    public MoveUpCommand(MoveableObject object) {
        this.object = object;
    }

    @Override
    public void execute() {
        object.move(0,1);
    }
}
