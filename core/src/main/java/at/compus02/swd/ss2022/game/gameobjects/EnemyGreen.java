package at.compus02.swd.ss2022.game.gameobjects;


import at.compus02.swd.ss2022.game.repository.AssetRepository;
import at.compus02.swd.ss2022.game.repository.Tile;
import at.compus02.swd.ss2022.game.gameobjects.interfaces.GameObject;
import at.compus02.swd.ss2022.game.gameobjects.interfaces.MoveableObject;
import at.compus02.swd.ss2022.game.movement.Direction;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EnemyGreen implements GameObject, MoveableObject
{
    private Sprite sprite;
    private Direction direction;
    private int livePoints;

    public EnemyGreen(){
        Texture image = AssetRepository.getInstance().getTexture(Tile.EnemyGreenDown);
        sprite = new Sprite(image);
        direction = Direction.DOWN;
        this.livePoints = 100;
    }

    public void decreaseLivePoints(int value) {livePoints -= value;}


    public int getLivePoints()
    {
        return livePoints;
    }

    @Override
    public float getSpriteSize() {
        return sprite.getWidth()/3;
    }

    @Override
    public void setDirection(Direction direction) {this.direction = direction; }

    @Override
    public Direction getDirection() {return direction; }

    @Override
    public MoveableGameObjects getGameObjectType() {return MoveableGameObjects.EnemyGreen;}

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
}
