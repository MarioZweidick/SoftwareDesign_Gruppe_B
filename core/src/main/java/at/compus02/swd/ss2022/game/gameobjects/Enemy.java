package at.compus02.swd.ss2022.game.gameobjects;

import at.compus02.swd.ss2022.game.Repository.AssetRepository;
import at.compus02.swd.ss2022.game.Repository.Tile;
import at.compus02.swd.ss2022.game.factories.interfaces.GameObject;
import at.compus02.swd.ss2022.game.factories.interfaces.MoveableObject;
import at.compus02.swd.ss2022.game.movement.Direction;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Enemy implements GameObject, MoveableObject {

    private Sprite sprite;
    private Direction direction;

    public Enemy(){
        Texture image = AssetRepository.getInstance().getTexture(Tile.EnemyDown);
        sprite = new Sprite(image);
        direction = Direction.DOWN;
    }
    @Override
    public float getSpriteSize() {
        return sprite.getWidth()/3;
    }


    private void changeSprite(Tile tile){
        Texture image = AssetRepository.getInstance().getTexture(tile);
        Sprite tmp = new Sprite(image);
        tmp.setPosition(getXPosition(),getYPosition());
        sprite = tmp;
    }
    @Override
    public void moveUp(int x) {
        sprite.translateX(x*sprite.getHeight()/3);
        changeSprite(Tile.CharacterUp);
    }
    @Override
    public void moveDown(int x) {
        sprite.translateX(x*sprite.getHeight()/3);
        changeSprite(Tile.CharacterDown);
    }
    @Override
    public void moveLeft(int y) {
        sprite.translateY(y*sprite.getWidth()/3);
        changeSprite(Tile.CharacterLeft);
    }
    @Override
    public void moveRight(int y) {
        sprite.translateY(y*sprite.getWidth()/3);
        changeSprite(Tile.CharacterRight);
    }
    @Override
    public Direction getDirection() {return direction; }

    @Override
    public void setPosition(float x, float y) {
        sprite.setPosition(x, y);
    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }

    @Override
    public void act(float delta) {}

    @Override
    public float getXPosition() {
        return sprite.getX();
    }

    @Override
    public float getYPosition() {
        return sprite.getY();
    }

    @Override
    public float getSpriteWidth() {
        return sprite.getWidth();
    }

    @Override
    public float getSpriteHeight() {
        return sprite.getHeight();
    }

    @Override
    public boolean isAccessible() {
        return false;
    }
}
