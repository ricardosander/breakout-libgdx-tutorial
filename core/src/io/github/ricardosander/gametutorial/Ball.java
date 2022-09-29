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

        int diameter = 2 * radius;
        if (x < diameter || x > Gdx.graphics.getWidth() - diameter) {
            xSpeed = -xSpeed;
        }

        if (y < diameter || y > Gdx.graphics.getHeight() - diameter) {
            ySpeed = -ySpeed;
        }
    }

    public void draw(ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(color);
        shapeRenderer.circle(x, y, radius);
    }

    public void checkCollision(Collidable object) {
        if (collidesWith(object)) {
            ySpeed = -ySpeed;
            object.effect();
            return;
        }
    }

    private boolean collidesWith(Collidable object) {
        if (y + radius < object.getY()) {
            return false;
        }

        if (y - radius > object.getY() + object.getHeight()) {
            return false;
        }

        if (x - radius > object.getX() + object.getWidth()) {
            return false;
        }


        if (x + radius < object.getX()) {
            return false;
        }

        return true;
    }
}
