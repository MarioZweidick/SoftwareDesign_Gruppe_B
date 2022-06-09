package at.compus02.swd.ss2022.game.gameobjects;

import at.compus02.swd.ss2022.game.Repository.AssetRepository;
import at.compus02.swd.ss2022.game.Repository.Tile;
import at.compus02.swd.ss2022.game.factories.interfaces.GameObject;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bush implements GameObject {

    private Sprite sprite;

    public Bush() {
        Texture image = AssetRepository.getInstance().getTexture(Tile.Bush);
        sprite = new Sprite(image);
    }

    public void animation(){

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
