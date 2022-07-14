package at.compus02.swd.ss2022.game.factories;

import at.compus02.swd.ss2022.game.bl.Movable;
import at.compus02.swd.ss2022.game.gameobjects.interfaces.GameObject;
import at.compus02.swd.ss2022.game.factories.interfaces.GameObjectFactory;
import at.compus02.swd.ss2022.game.gameobjects.*;
import com.badlogic.gdx.utils.Array;

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
    private GameObject createTulipsTile()
    {
        return new Tulips();
    }
    private GameObject createJettyTile()
    {
        return new Jetty();
    }
    private GameObject createHouseTile()
    {
        return new House();
    }
    private GameObject createBridgeTile()
    {
        return new Bridge();
    }
    private GameObject createWaterTile()
    {
        return new Water();
    }
    private GameObject createGrasTile()
    {
        return new Gras();
    }

    @Override
    public Array<GameObject> createStartObjects(int numberOfTiles)
    {
        Array<GameObject> gameTiles = new Array<>();
        gameTiles.addAll(createGrasObjects(40, posX, posY));
        gameTiles.addAll(createWater(posY,posX));
        gameTiles.addAll(createGrasObjects(40, posX , posY+ TILE_SIZE*6));
        gameTiles.addAll(createJettyObjects(103, 3));
        gameTiles.addAll(createBridgeObjects(20, -10));
        gameTiles.add(createHouse(-148,85));
        gameTiles.addAll(createTulips());

        Movable.setNoneMovableObjects(gameTiles);

        gameTiles.addAll(createBush());
        gameTiles.addAll(createBush());

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

    private GameObject createJettyObjects(int posX, int posY)
    {
        GameObject bridge = createJettyTile();
        bridge.setPosition(posX, posY);
        return bridge;
    }

    private GameObject createBridgeObjects(int posX, int posY)
    {
        GameObject bridge = createBridgeTile();
        bridge.setPosition(posX, posY);
        return bridge;
    }

    private Array<GameObject> createWater(int posY, int posX )
    {
        Array<GameObject> waterTiles = new Array<>();
        posY=-32;
        for (int i = 0; i < 20 ; i++)
        {
            GameObject water=createWaterTile();
            if(i % 10 == 0)
            {
                posY+=TILE_SIZE;
                posX=START_X;
            }
            water.setPosition(posX, posY);
            posX+= TILE_SIZE;
            waterTiles.add(water);
        }
        return waterTiles;
    }

    private Array<GameObject> createBush()
    {
        Array<GameObject> bushTiles = new Array<>();

        int x=-162;
        for (int i=0;i<5;i++)
        {
            GameObject bush= createBushTile();
            bush.setPosition(x, -130);
            bushTiles.add(bush);

            GameObject bush2= createBushTile();
            bush2.setPosition(x, 162);
            bushTiles.add(bush2);

            x=x+64;
        }
        return bushTiles;
    }

    private GameObject createHouse(int posX, int posY)
    {
        GameObject houseTile = createHouseTile();
        houseTile.setPosition(posX, posY);
        return houseTile;
    }

    private Array<GameObject> createTulips()
    {
        Array<GameObject> tulipsTiles = new Array<>();
        int x=-125;
        for (int i=0;i<5;i++)
        {
            GameObject bush= createTulipsTile();
            bush.setPosition(x, -125);
            tulipsTiles.add(bush);

            GameObject bush2= createTulipsTile();
            bush2.setPosition(x, 165);
            tulipsTiles.add(bush2);
            x=x+64;
        }
        return tulipsTiles;
    }
}
