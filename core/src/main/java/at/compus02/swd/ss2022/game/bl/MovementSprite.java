package at.compus02.swd.ss2022.game.bl;

import at.compus02.swd.ss2022.game.gameobjects.interfaces.MovableObject;
import at.compus02.swd.ss2022.game.movement.Direction;
import at.compus02.swd.ss2022.game.repository.AssetRepository;
import at.compus02.swd.ss2022.game.repository.Tile;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class MovementSprite {

    public static void changeSprite(MovableObject object, Direction direction){
        Tile tile = null;
        switch (object.getGameObjectType()){
            case Character:
                switch (direction){
                    case UP: tile = Tile.CharacterUp;break;
                    case DOWN: tile = Tile.CharacterDown;break;
                    case LEFT: tile = Tile.CharacterLeft;break;
                    case RIGHT: tile = Tile.CharacterRight;break;
                    default: return;
                }break;
            case EnemyRed:
                switch (direction){
                    case UP: tile = Tile.EnemyRedUp;break;
                    case DOWN: tile = Tile.EnemyRedDown;break;
                    case LEFT: tile = Tile.EnemyRedLeft;break;
                    case RIGHT: tile = Tile.EnemyRedRight;break;
                    default: return;
                }break;
            case EnemyGreen:
                switch (direction){
                    case UP: tile = Tile.EnemyGreenUp;break;
                    case DOWN: tile = Tile.EnemyGreenDown;break;
                    case LEFT: tile = Tile.EnemyGreenLeft;break;
                    case RIGHT: tile = Tile.EnemyGreenRight;break;
                    default: return;
                }break;
        }

        Texture image = AssetRepository.getInstance().getTexture(tile);
        Sprite tmp = new Sprite(image);
        object.setSprite(tmp);
    }

    public static void setObjectInvisible(MovableObject object){
        object.setPosition(100,100);
        Texture image = AssetRepository.getInstance().getTexture(Tile.Gras);
        Sprite tmp = new Sprite(image);
        object.setSprite(tmp);
    }
}
