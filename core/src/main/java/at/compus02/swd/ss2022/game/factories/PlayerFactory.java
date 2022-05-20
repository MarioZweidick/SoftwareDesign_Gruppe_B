package at.compus02.swd.ss2022.game.factories;

import at.compus02.swd.ss2022.game.factories.interfaces.GameObjectFactory;
import at.compus02.swd.ss2022.game.gameobjects.Character;
import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import com.badlogic.gdx.utils.Array;

public class PlayerFactory implements GameObjectFactory {
    Array<GameObject> gameTiles = new Array<>();


    private GameObject createPlayer() {
        return new Character();
    }

    @Override
    public Array<GameObject> createStartObjects(int numberOfTiles)
    {
        GameObject player= createPlayer();
        player.setPosition(50,100);
        gameTiles.add(player);
   return gameTiles;
    }

}
