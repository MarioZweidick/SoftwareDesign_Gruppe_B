package at.compus02.swd.ss2022.game.factories.interfaces;

import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import com.badlogic.gdx.utils.Array;


public interface GameObjectFactory
{
    public abstract Array<GameObject> createStartObjects(int numberOfTiles);
}
