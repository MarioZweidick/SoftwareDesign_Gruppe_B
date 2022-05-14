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
    private int posX = START_X;
    private int posY = START_Y;
    private int NUMBER_OF_BRIDGE_TILES = 9;


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

        gameTiles.addAll(createGrasObjects(numberOfTiles, posX, posY));
        gameTiles.addAll(createBridgeObjects(NUMBER_OF_BRIDGE_TILES, -32, -32));


        return gameTiles;
    }

    private Array<GameObject> createGrasObjects(int numberOfTiles, int posX, int posY)
    {
        Array<GameObject> grasTiles = new Array<>();

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
            grasTiles.add(gras);
        }

        return grasTiles;
    }

    private Array<GameObject> createBridgeObjects(int numberOfBridgeTiles, int posX, int posY)
    {
        Array<GameObject> bridgeTiles = new Array<>();
        int startX = posX;
        int startY = posY;

        for(int i = 0; i < numberOfBridgeTiles; i++)
        {
            GameObject bridge = createBridgeTile();
            if(i % 3 == 0)
            {
                posY+=TILE_SIZE;
                posX=startX;
            }

            bridge.setPosition(posX, posY);
            posX+= TILE_SIZE;
            bridgeTiles.add(bridge);
        }

        return bridgeTiles;
    }
}
