package at.compus02.swd.ss2022.game.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Jetty implements GameObject {
    private Texture image;
    private Sprite sprite;

    public Jetty() {
        image = new Texture("tile_jetty.png");
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
}