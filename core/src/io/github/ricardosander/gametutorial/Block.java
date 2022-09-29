package io.github.ricardosander.gametutorial;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Block implements Collidable {
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private boolean destroyed;

    public Block(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.destroyed = false;
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
        this.destroyed = true;
    }

    public boolean isDestroyed() {
        return destroyed;
    }
}
