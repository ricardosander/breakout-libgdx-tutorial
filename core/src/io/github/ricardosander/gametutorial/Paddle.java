package io.github.ricardosander.gametutorial;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle implements Collidable {

    private int x;
    private final int y;
    private final int width;
    private final int height;

    public Paddle(int x, int y) {
        this.x = x;
        this.y = y;
        width = 100;
        height = 10;
    }

    public void update() {
        x = Gdx.input.getX() - width / 2;
        if (x < 10) {
            x = 10;
        }
        if (x > Gdx.graphics.getWidth() - width - 10) {
            x = Gdx.graphics.getWidth() - width - 10;
        }
    }

    public void draw(ShapeRenderer shapeRenderer) {
        shapeRenderer.rect(x, y, width, height);
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void effect() {

    }
}
