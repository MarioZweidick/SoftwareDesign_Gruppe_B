package at.compus02.swd.ss2022.game.commands;

import at.compus02.swd.ss2022.game.factories.interfaces.ICommand;
import at.compus02.swd.ss2022.game.gameobjects.interfaces.MoveableObject;

public class HitCommand implements ICommand {

    private MoveableObject object;
    public HitCommand(MoveableObject object) {
        this.object = object;
    }
    @Override
    public void execute() {

    }
}
