package at.compus02.swd.ss2022.game.commands;
import at.compus02.swd.ss2022.game.bl.Movement;
import at.compus02.swd.ss2022.game.factories.interfaces.ICommand;
import at.compus02.swd.ss2022.game.gameobjects.interfaces.MoveableObject;
import at.compus02.swd.ss2022.game.movement.Direction;

public class MoveRightCommand implements ICommand {

    private MoveableObject object;

    public MoveRightCommand(MoveableObject object) {
        this.object = object;
    }

    @Override
    public void execute() {
        Movement.moveObject(object, Direction.RIGHT);
    }
}
