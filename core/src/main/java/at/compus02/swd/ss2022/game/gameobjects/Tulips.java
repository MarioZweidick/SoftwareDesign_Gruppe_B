package at.compus02.swd.ss2022.game.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tulips implements GameObject {
    private Texture image;
    private Sprite sprite;

    public Tulips() {
        image = new Texture("tile_tulpis.png");
        sprite = new Sprite(image);
        sprite.setSize(22,22);


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
}
