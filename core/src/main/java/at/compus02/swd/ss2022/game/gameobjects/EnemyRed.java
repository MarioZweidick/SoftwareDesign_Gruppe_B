package at.compus02.swd.ss2022.game.gameobjects;


import at.compus02.swd.ss2022.game.gameobjects.interfaces.Fighting;
import at.compus02.swd.ss2022.game.gameobjects.interfaces.MovableObject;
import at.compus02.swd.ss2022.game.movement.Direction;
import at.compus02.swd.ss2022.game.repository.AssetRepository;
import at.compus02.swd.ss2022.game.repository.Tile;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EnemyRed implements MovableObject, Fighting
{
    private Sprite sprite;
    private Direction direction;
    private float health;
    private float attackstrength;

    public EnemyRed(){
        Texture image = AssetRepository.getInstance().getTexture(Tile.EnemyRedDown);
        sprite = new Sprite(image);
        direction = Direction.DOWN;
    }

    @Override
    public float getSpriteSize() {
        return sprite.getWidth()/4;
    }

    @Override
    public void setDirection(Direction direction) {this.direction = direction; }

    @Override
    public Direction getDirection() {return direction; }

    @Override
    public MovableGameObjects getGameObjectType() {return MovableGameObjects.EnemyRed;}

    @Override
    public void setSprite(Sprite sprite) {
        sprite.setPosition(getXPosition(),getYPosition());
        this.sprite= sprite;
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


    @Override
    public float getHealth() {return this.health;}
    @Override
    public void setHealth(float health) {this.health = health;}
    @Override
    public float getAttackstrength() {return attackstrength;}
    @Override
    public void setAttackstrength(float strength) {attackstrength = strength;}
}
