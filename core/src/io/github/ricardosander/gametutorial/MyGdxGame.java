package io.github.ricardosander.gametutorial;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MyGdxGame extends ApplicationAdapter {

    private ShapeRenderer shape;
    private Ball ball;
    private Paddle paddle;
    private List<Block> blocks;
    private final Random random = new Random();

    @Override
    public void create() {
        int windowWidth = Gdx.graphics.getWidth();
        int windowHeight = Gdx.graphics.getHeight();

        shape = new ShapeRenderer();
        ball = new Ball(
                random.nextInt(Gdx.graphics.getWidth()),
                random.nextInt(20, Gdx.graphics.getHeight() / 4),
                10,
                5 * (random.nextInt(2) == 0 ? 1 : -1),
                5 * (random.nextInt(2) == 0 ? 1 : -1)
        );
        paddle = new Paddle(10, 20);

        blocks = new ArrayList<>();

        int blockWidth = 63;
        int blockHeight = 20;
        int blockSpacing = 10;

        int blockHorizontalSpace = blockWidth + blockSpacing;
        int blockVerticalSpace = blockHeight + blockSpacing;

        for (int blockX = 0; blockX < windowWidth; blockX += blockHorizontalSpace) {
            for (int blockY = windowHeight / 2; blockY < windowHeight; blockY += blockVerticalSpace) {
                blocks.add(new Block(blockX, blockY, blockWidth, blockHeight));
            }
        }
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        shape.begin(ShapeRenderer.ShapeType.Filled);

        ball.update();
        paddle.update();

        ball.checkCollision(paddle);
        blocks.forEach(block -> {
            ball.checkCollision(block);
        });
        blocks = blocks.stream().filter(block -> !block.isDestroyed()).collect(Collectors.toList());

        ball.draw(shape);
        paddle.draw(shape);

        blocks.forEach(block -> block.draw(shape));

        shape.end();
    }
}
