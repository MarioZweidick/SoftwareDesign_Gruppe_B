package at.compus02.swd.ss2022.game.Repository;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

public class AssetRepository {
    private static final AssetRepository repository = new AssetRepository();
    private Array<Pair<Tile,Texture>> textures = new Array<>();
    private AssetRepository(){}

    public static AssetRepository getInstance() {return repository;}
    public void preloadAssets(){
        textures.add(new Pair<>(Tile.Bridge, new Texture("tile_bridge.png")));
        textures.add(new Pair<>(Tile.Bush, new Texture("tile_bush.png")));
        textures.add(new Pair<>(Tile.House, new Texture("tile_house.png")));
        textures.add(new Pair<>(Tile.Jetty, new Texture("tile_jetty.png")));
        textures.add(new Pair<>(Tile.Tulips, new Texture("tile_tulpis.png")));
        textures.add(new Pair<>(Tile.Water, new Texture("tile_water.png")));
        textures.add(new Pair<>(Tile.Gras, new Texture("tile_gras.png")));

        //Character
        textures.add(new Pair<>(Tile.CharacterUp, new Texture("tile_characterUp.png")));
        textures.add(new Pair<>(Tile.CharacterDown, new Texture("tile_characterDown.png")));
        textures.add(new Pair<>(Tile.CharacterLeft, new Texture("tile_characterLeft.png")));
        textures.add(new Pair<>(Tile.CharacterRight, new Texture("tile_characterRight.png")));
        //Enemy
        textures.add(new Pair<>(Tile.EnemyUp, new Texture("character.png")));
        textures.add(new Pair<>(Tile.EnemyDown, new Texture("character.png")));
        textures.add(new Pair<>(Tile.EnemyLeft, new Texture("character.png")));
        textures.add(new Pair<>(Tile.EnemyRight, new Texture("character.png")));
    }
    public Texture getTexture(Tile texture){
        for (Pair<Tile, Texture> texturePair : textures) {
            if(texturePair.getFirst() == texture){
                return texturePair.getSecond();
            }
        }
        return null;
    }
    public void dispose(){
        textures.forEach(n ->
            {
                //texture dispose
                n.getSecond().dispose();
                n.dispose();
            });
        textures = null;
    }
}
