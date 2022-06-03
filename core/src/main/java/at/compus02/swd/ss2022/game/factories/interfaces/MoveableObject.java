package at.compus02.swd.ss2022.game.factories.interfaces;

import at.compus02.swd.ss2022.game.gameobjects.GameObject;

public interface MoveableObject {
    void move(int x, int y);
    float getSpriteSize();
}