package at.compus02.swd.ss2022.game.gameobjects;

import at.compus02.swd.ss2022.game.factories.interfaces.GameObject;
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
    public float getSpriteSize() {
        return this.sprite.getWidth()/3;
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
        sprite.translateX(x*sprite.getHeight()/3);
        sprite.translateY(y*sprite.getWidth()/3);
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
    public float getSpriteHeight() {
        return sprite.getHeight();
    }
}
