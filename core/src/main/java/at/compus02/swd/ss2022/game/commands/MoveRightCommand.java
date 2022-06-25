package at.compus02.swd.ss2022.game.commands;
import at.compus02.swd.ss2022.game.bl.Moveable;
import at.compus02.swd.ss2022.game.factories.interfaces.ICommand;
import at.compus02.swd.ss2022.game.factories.interfaces.MoveableObject;
import at.compus02.swd.ss2022.game.factories.interfaces.GameObject;

public class MoveRightCommand implements ICommand {

    private MoveableObject object;

    public MoveRightCommand(MoveableObject object) {
        this.object = object;
    }

    @Override
    public void execute() {
        float nextPosition = ((GameObject)object).getXPosition() + object.getSpriteSize();
        float yPosition = ((GameObject)object).getYPosition();
        if(Moveable.canMove(nextPosition, yPosition)){
            object.moveRight(1);
        }
    }
}
