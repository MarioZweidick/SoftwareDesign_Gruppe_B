package at.compus02.swd.ss2022.game.factories;

import at.compus02.swd.ss2022.game.factories.interfaces.GameObjectFactory;
import at.compus02.swd.ss2022.game.gameobjects.*;
import com.badlogic.gdx.utils.Array;


import java.util.ArrayList;

public class TileFactory implements GameObjectFactory
{
    private int TILE_SIZE = 32;
    private int START_X = -160;
    private int START_Y = -160;


    private GameObject createBushTile()
    {
        return new Bush();
    }

    private GameObject createBridgeTile()
    {
        return new Bridge();
    }

    private GameObject createRouteTile()
    {
        return new Route();
    }
    private GameObject createSignTile()
    {
        return new Sign();
    }
    private GameObject createStoneTile()
    {
        return new Stone();
    }

    private GameObject createWaterTile()
    {
        return new Bush();
    }

    private GameObject createGrasTile()
    {
        return new Gras();
    }

    @Override
    public Array<GameObject> createStartObjects(int numberOfTiles)
    {
        Array<GameObject> gameTiles = new Array<>();
        int posX = START_X;
        int posY = START_Y;

        for (int i = 0; i < numberOfTiles ; i++)
        {
            GameObject gras = createGrasTile();
            if(i % 10 == 0)
            {
                posY+=TILE_SIZE;
                posX=START_X;
            }

            gras.setPosition(posX, posY);
            posX+= TILE_SIZE;
            gameTiles.add(gras);
        }

        return gameTiles;
    }
}
