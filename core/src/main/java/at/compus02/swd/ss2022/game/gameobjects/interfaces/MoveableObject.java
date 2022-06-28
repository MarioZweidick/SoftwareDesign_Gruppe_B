package at.compus02.swd.ss2022.game.gameobjects.interfaces;

import at.compus02.swd.ss2022.game.gameobjects.MoveableGameObjects;
import at.compus02.swd.ss2022.game.movement.Direction;
import at.compus02.swd.ss2022.game.repository.Tile;
import com.badlogic.gdx.graphics.g2d.Sprite;

public interface MoveableObject {
    float getSpriteSize();
    void setDirection(Direction direction);
    Direction getDirection();
    MoveableGameObjects getGameObjectType();
    void setSprite(Sprite sprite);

}