package at.compus02.swd.ss2022.game.repository;

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
        textures.add(new Pair<>(Tile.CharacterUp, new Texture("character1/characterUp.png")));
        textures.add(new Pair<>(Tile.CharacterDown, new Texture("character1/characterDown.png")));
        textures.add(new Pair<>(Tile.CharacterLeft, new Texture("character1/characterLeft.png")));
        textures.add(new Pair<>(Tile.CharacterRight, new Texture("character1/characterRight.png")));
        //EnemyRed
        textures.add(new Pair<>(Tile.EnemyRedUp, new Texture("monster1/monster1Up.png")));
        textures.add(new Pair<>(Tile.EnemyRedDown, new Texture("monster1/monster1Down.png")));
        textures.add(new Pair<>(Tile.EnemyRedLeft, new Texture("monster1/monster1Left.png")));
        textures.add(new Pair<>(Tile.EnemyRedRight, new Texture("monster1/monster1Right.png")));

        //EnemyGreen
        textures.add(new Pair<>(Tile.EnemyGreenUp, new Texture("monster2/monster2Up.png")));
        textures.add(new Pair<>(Tile.EnemyGreenDown, new Texture("monster2/monster2Down.png")));
        textures.add(new Pair<>(Tile.EnemyGreenLeft, new Texture("monster2/monster2Left.png")));
        textures.add(new Pair<>(Tile.EnemyGreenRight, new Texture("monster2/monster2Right.png")));
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
