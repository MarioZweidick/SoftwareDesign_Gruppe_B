package at.compus02.swd.ss2022.game.factories;

import at.compus02.swd.ss2022.game.bl.MovableObjectControl;
import at.compus02.swd.ss2022.game.factories.interfaces.GameObjectFactory;
import at.compus02.swd.ss2022.game.gameobjects.Character;
import at.compus02.swd.ss2022.game.gameobjects.interfaces.GameObject;
import at.compus02.swd.ss2022.game.gameobjects.interfaces.Fighting;
import at.compus02.swd.ss2022.game.input.GameInput;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;

public class PlayerFactory implements GameObjectFactory {
    private Array<GameObject> gameTiles = new Array<>();
    private GameObject createPlayer() {
        return new Character();
    }

    @Override
    public Array<GameObject> createStartObjects(int numberOfTiles)
    {
        GameObject player= createPlayer();
        player.setPosition(50,100);
        ((Fighting)player).setHealth(100);
        ((Fighting)player).setAttackstrength(100);

        MovableObjectControl.getInstance().registerPlayer(player);

        Gdx.input.setInputProcessor(new GameInput());
        gameTiles.add(player);
        return gameTiles;
    }
}
