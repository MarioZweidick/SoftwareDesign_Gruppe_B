package at.compus02.swd.ss2022.game.Commands;
import at.compus02.swd.ss2022.game.BL.Moveable;
import at.compus02.swd.ss2022.game.factories.interfaces.ICommand;
import at.compus02.swd.ss2022.game.factories.interfaces.MoveableObject;
import at.compus02.swd.ss2022.game.gameobjects.GameObject;

public class MoveDownCommand implements ICommand {
    private MoveableObject object;

    public MoveDownCommand(MoveableObject object) {
        this.object = object;
    }

    @Override
    public void execute() {
        float nextPosition = ((GameObject)object).getXPosition() + object.getSpriteSize();
        float yPosition = ((GameObject)object).getYPosition();
        if(Moveable.canMove(nextPosition,yPosition)){
            object.move(0,-1);
        }
    }
}
