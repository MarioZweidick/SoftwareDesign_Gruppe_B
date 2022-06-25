package at.compus02.swd.ss2022.game.Commands;
import at.compus02.swd.ss2022.game.BL.Moveable;
import at.compus02.swd.ss2022.game.factories.interfaces.ICommand;
import at.compus02.swd.ss2022.game.factories.interfaces.MoveableObject;
import at.compus02.swd.ss2022.game.factories.interfaces.GameObject;

public class MoveDownCommand implements ICommand {
    private MoveableObject object;

    public MoveDownCommand(MoveableObject object) {
        this.object = object;
    }

    @Override
    public void execute() {
        float nextPosition = ((GameObject)object).getYPosition() - object.getSpriteSize();
        float xPosition = ((GameObject)object).getXPosition();
        if(Moveable.canMove(xPosition,nextPosition)){
            object.moveDown(-1);
        }
    }
}
