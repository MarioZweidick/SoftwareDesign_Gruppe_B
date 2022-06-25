package at.compus02.swd.ss2022.game.BL;

import at.compus02.swd.ss2022.game.Repository.AssetRepository;
import at.compus02.swd.ss2022.game.Repository.Tile;
import at.compus02.swd.ss2022.game.factories.interfaces.MoveableObject;
import at.compus02.swd.ss2022.game.movement.Direction;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Movement {

    public static void moveObject(MoveableObject object, Direction direction){
       /*
        switch (direction){
            case Direction.LEFT:
        }

        */

    }

    private void changeSprite(Tile tile){
        /*
        Texture image = AssetRepository.getInstance().getTexture(tile);
        Sprite tmp = new Sprite(image);
        tmp.setPosition(getXPosition(),getYPosition());
        sprite = tmp;

         */
    }
}
