package at.compus02.swd.ss2022.game.factories.interfaces;

import at.compus02.swd.ss2022.game.movement.Direction;

public interface MoveableObject {
    float getSpriteSize();
    void moveUp(int x);
    void moveDown(int x);
    void moveLeft(int y);
    void moveRight(int y);
    Direction getDirection();
}