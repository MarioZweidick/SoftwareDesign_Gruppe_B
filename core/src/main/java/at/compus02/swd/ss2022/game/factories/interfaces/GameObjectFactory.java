package at.compus02.swd.ss2022.game.factories.interfaces;

import com.badlogic.gdx.utils.Array;


public interface GameObjectFactory
{
    public abstract Array<GameObject> createStartObjects(int numberOfTiles);
}
