package at.compus02.swd.ss2022.game.factories.interfaces;

import at.compus02.swd.ss2022.game.movement.Direction;

public interface MoveableObject {
    float getSpriteSize();
    void moveUp(int y);
    void moveDown(int y);
    void moveLeft(int x);
    void moveRight(int x);
    Direction getDirection();
}