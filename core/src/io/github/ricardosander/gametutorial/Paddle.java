package io.github.ricardosander.gametutorial;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle {

    int x;
    int y;
    final int width;
    final int height;

    public Paddle(int x, int y) {
        this.x = x;
        this.y = y;
        width = 100;
        height = 10;
    }

    public void update() {
        x = Gdx.input.getX() - width / 2;
//        y = Gdx.graphics.getHeight() - Gdx.input.getY();
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
}
