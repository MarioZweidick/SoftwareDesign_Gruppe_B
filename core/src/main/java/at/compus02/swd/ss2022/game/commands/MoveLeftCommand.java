package at.compus02.swd.ss2022.game.commands;

import at.compus02.swd.ss2022.game.bl.MovableObjectControl;
import at.compus02.swd.ss2022.game.factories.interfaces.Command;
import at.compus02.swd.ss2022.game.movement.Direction;

public class MoveLeftCommand implements Command {
    @Override
    public void execute() {
        MovableObjectControl.getInstance().movePlayer(Direction.LEFT);}
}
