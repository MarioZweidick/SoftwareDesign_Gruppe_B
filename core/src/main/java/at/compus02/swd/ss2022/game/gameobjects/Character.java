package at.compus02.swd.ss2022.game.gameobjects;

import at.compus02.swd.ss2022.game.factories.interfaces.MoveableObject;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Character implements GameObject, MoveableObject {
    private Texture image;
    private Sprite sprite;

    public Character() {
        image = new Texture("character.png");
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
    public void move(int x, int y) {
        sprite.translateX(x);
        sprite.translateY(y);
    }
}
