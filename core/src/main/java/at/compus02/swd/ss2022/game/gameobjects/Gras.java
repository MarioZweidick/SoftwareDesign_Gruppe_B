package at.compus02.swd.ss2022.game.gameobjects;

import at.compus02.swd.ss2022.game.factories.interfaces.GameObject;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Gras implements GameObject {
    private Texture image;
    private Sprite sprite;

    public Gras() {
        image = new Texture("tile_gras.png");
        sprite = new Sprite(image);
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
    public boolean isAccessable() {
        return true;
    }
    @Override
    public float getSpriteWidth() {
        return sprite.getWidth();
    }
    @Override
    public float getSpriteHeight() {return sprite.getHeight();}
}
