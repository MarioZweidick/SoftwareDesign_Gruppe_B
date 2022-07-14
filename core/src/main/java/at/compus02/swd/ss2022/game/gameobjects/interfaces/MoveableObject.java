package at.compus02.swd.ss2022.game.gameobjects.interfaces;

import at.compus02.swd.ss2022.game.gameobjects.MovableGameObjects;
import at.compus02.swd.ss2022.game.movement.Direction;
import com.badlogic.gdx.graphics.g2d.Sprite;

public interface MoveableObject extends GameObject {
    float getSpriteSize();
    void setDirection(Direction direction);
    Direction getDirection();
    MovableGameObjects getGameObjectType();
    void setSprite(Sprite sprite);

}