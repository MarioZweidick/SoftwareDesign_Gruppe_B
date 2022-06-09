package at.compus02.swd.ss2022.game.gameobjects;

import at.compus02.swd.ss2022.game.Repository.AssetRepository;
import at.compus02.swd.ss2022.game.Repository.Tile;
import at.compus02.swd.ss2022.game.factories.interfaces.GameObject;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bridge implements GameObject {
    private Sprite sprite;

    public Bridge() {
        Texture image = AssetRepository.getInstance().getTexture(Tile.Bridge);
        sprite = new Sprite(image);
        sprite.setSize(40,90);
    }
    @Override
    public void act(float delta) {
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
    public float getXPosition() {
        return sprite.getX();
    }
    @Override
    public float getYPosition() {
        return sprite.getY();
    }
    @Override
    public boolean isAccessible() {return true; }
    @Override
    public float getSpriteWidth() {
        return sprite.getWidth()/2;
    }
    @Override
    public float getSpriteHeight() {
        return sprite.getHeight();
    }
}
