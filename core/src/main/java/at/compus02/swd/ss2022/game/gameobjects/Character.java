package at.compus02.swd.ss2022.game.gameobjects;

import at.compus02.swd.ss2022.game.gameobjects.interfaces.Fighting;
import at.compus02.swd.ss2022.game.gameobjects.interfaces.MoveableObject;
import at.compus02.swd.ss2022.game.movement.Direction;
import at.compus02.swd.ss2022.game.repository.AssetRepository;
import at.compus02.swd.ss2022.game.repository.Tile;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Character implements MoveableObject, Fighting {
    private Sprite sprite;
    private Direction direction;
    private float health;
    private float attackstrength;

    public Character() {
        Texture image = AssetRepository.getInstance().getTexture(Tile.CharacterDown);
        sprite = new Sprite(image);
        direction = Direction.DOWN;
    }
    @Override
    public void act(float delta) {

    }
    @Override
    public float getSpriteSize() {
        return this.sprite.getWidth()/2;
    }
    @Override
    public void setPosition(float x, float y) {
        sprite.setPosition(x, y);
    }
    @Override
    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }
    @Override
    public Direction getDirection() {return direction; }
    @Override
    public void setDirection(Direction direction) {this.direction = direction;}
    @Override
    public MovableGameObjects getGameObjectType() {
        return MovableGameObjects.Character;
    }

    @Override
    public void setSprite(Sprite sprite) {
        sprite.setPosition(getXPosition(),getYPosition());
        this.sprite= sprite;
    }

    @Override
    public float getXPosition() {
        return sprite.getX();
    }
    @Override
    public float getYPosition() {
        return sprite.getY();
    }
    @Override
    public boolean isAccessible() {
        return true;
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
    public float getHealth() {return this.health;}
    @Override
    public void setHealth(float health) {this.health = health;}
    @Override
    public float getAttackstrength() {return attackstrength;}
    @Override
    public void setAttackstrength(float strength) {attackstrength = strength;}
}
