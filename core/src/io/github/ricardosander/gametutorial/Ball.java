package io.github.ricardosander.gametutorial;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball {

    private int x;
    private int y;
    private int radius;
    private int xSpeed;
    private int ySpeed;
    private Color color = Color.WHITE;

    public Ball(int x, int y, int radius, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public void update() {
        x += xSpeed;
        y += ySpeed;

        if (x < radius || x > Gdx.graphics.getWidth() - radius) {
            xSpeed = -xSpeed;
        }

        if (y < radius || y > Gdx.graphics.getHeight() - radius) {
            ySpeed = -ySpeed;
        }
    }

    public void draw(ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(color);
        shapeRenderer.circle(x, y, radius);
    }

    public void checkCollision(Paddle paddle) {
        if (collidesWith(paddle)) {
            ySpeed = -ySpeed;
            return;
        }
//        color = Color.WHITE;
    }

    private boolean collidesWith(Paddle paddle) {
        if (y + radius < paddle.y) {
            return false;
        }

        if (y - radius > paddle.y + paddle.height) {
            return false;
        }

        if (x - radius > paddle.x + paddle.width) {
            return false;
        }


        if (x + radius < paddle.x) {
            return false;
        }

        return true;
    }
}
