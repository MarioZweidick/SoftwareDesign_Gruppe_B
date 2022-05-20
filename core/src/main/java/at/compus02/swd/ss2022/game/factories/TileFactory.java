package at.compus02.swd.ss2022.game.factories;

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
    private GameObject createTulpisTile()
    {
        return new Tulips();
    }
    private GameObject createBridgeTile()
    {
        return new Jetty();
    }
    private GameObject createHouseTile()
    {
        return new House();
    }
    private GameObject createBridge2Tile()
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
        gameTiles.addAll(createGrasObjects(numberOfTiles, posX, posY));
        gameTiles.addAll(createWater(numberOfTiles,posY,posX));
        gameTiles.addAll(createBridgeObjects(NUMBER_OF_BRIDGE_TILES, 103, 3));
        gameTiles.addAll(createBridge2Objects(NUMBER_OF_BRIDGE_TILES, 20, -10));
        gameTiles.addAll(createBush());
        gameTiles.addAll(createTulpis());
        gameTiles.addAll(createBush());
        gameTiles.add(createHouse(-148,85));
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

    private GameObject createBridgeObjects(int numberOfBridgeTiles, int posX, int posY)
    {
        Array<GameObject> bridgeTiles = new Array<>();

            GameObject bridge = createBridgeTile();
            bridge.setPosition(posX, posY);

            bridgeTiles.add(bridge);


        return bridge;
    }

    private GameObject createBridge2Objects(int numberOfBridgeTiles, int posX, int posY)
    {
        Array<GameObject> bridgeTiles = new Array<>();

        GameObject bridge = createBridge2Tile();
        bridge.setPosition(posX, posY);

        bridgeTiles.add(bridge);


        return bridge;
    }


    private Array<GameObject> createWater(int numberOfTiles, int posY, int posX )
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
            GameObject bush= new Bush();
            bush.setPosition(x, -130);
            bushTiles.add(bush);

            GameObject bush2= new Bush();
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


    private Array<GameObject> createTulpis()
    {
        Array<GameObject> tulpisTiles = new Array<>();

        int x=-125;
        for (int i=0;i<5;i++)
        {
            GameObject bush= new Tulips();
            bush.setPosition(x, -125);
            tulpisTiles.add(bush);

            GameObject bush2= new Tulips();
            bush2.setPosition(x, 165);
            tulpisTiles.add(bush2);

            x=x+64;
        }

        return tulpisTiles;
    }

}
