package io.github.ricardosander.gametutorial;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Random;

public class MyGdxGame extends ApplicationAdapter {

    private ShapeRenderer shape;
    private Ball ball;
    private Paddle paddle;
    private final Random random = new Random();

    @Override
    public void create() {
        shape = new ShapeRenderer();
        ball = new Ball(
//                Gdx.graphics.getWidth() / 2,
                random.nextInt(Gdx.graphics.getWidth()),
//                Gdx.graphics.getHeight() / 2,
                random.nextInt(Gdx.graphics.getHeight()),
                20,
//                0,
                5,
//                0
                5
        );
        paddle = new Paddle(10, 20);
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        shape.begin(ShapeRenderer.ShapeType.Filled);

        ball.update();
        paddle.update();

        ball.checkCollision(paddle);

        ball.draw(shape);
        paddle.draw(shape);

        shape.end();
    }
}
