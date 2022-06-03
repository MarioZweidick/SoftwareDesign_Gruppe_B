package at.compus02.swd.ss2022.game.Commands;
import at.compus02.swd.ss2022.game.factories.interfaces.ICommand;
import at.compus02.swd.ss2022.game.factories.interfaces.MoveableObject;
import at.compus02.swd.ss2022.game.gameobjects.GameObject;

public class MoveRightCommand implements ICommand {

    private MoveableObject object;

    public MoveRightCommand(MoveableObject object) {
        this.object = object;
    }

    @Override
    public void execute() {
        object.move(1,0);
    }
}
