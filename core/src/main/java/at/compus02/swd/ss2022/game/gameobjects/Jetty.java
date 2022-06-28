package at.compus02.swd.ss2022.game.gameobjects;

import at.compus02.swd.ss2022.game.repository.AssetRepository;
import at.compus02.swd.ss2022.game.repository.Tile;
import at.compus02.swd.ss2022.game.gameobjects.interfaces.GameObject;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Jetty implements GameObject {
    private Sprite sprite;

    public Jetty() {
        Texture image = AssetRepository.getInstance().getTexture(Tile.Jetty);
        sprite = new Sprite(image);
        sprite.setSize(42,65);
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
    public boolean isAccessible() {
        return false;
    }
    @Override
    public float getSpriteWidth() {
        return sprite.getWidth();
    }
    @Override
    public float getSpriteHeight() {
        return sprite.getHeight();
    }
}
