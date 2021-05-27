package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Animations extends Sprite {
    private static final int FRAME_COLS = 2;
    private static final int FRAME_ROWS = 2;
    private int currentAnimations;
    private float stateTime = 0.0F;
    private Animation<TextureRegion> walkingAnimationRight;
    private Animation<TextureRegion> walkingAnimationLeft;
    private TextureRegion[] walkingFramesRight;
    private TextureRegion[] walkingFramesLeft;
    private TextureRegion currentFrame;
    private int stepIndex = 0;
    private Texture walkSheet;
    private Animation [] animations;

    float dx,dy;

    public void setdXY(float dx,float dy) {
        this.dx = dx;
        this.dy = dy;
    }

    @Override
    public void setSize(float width, float height) {
        super.setSize(width, height);
    }

    @Override
    public void setPosition(float x, float y) {
        super.setPosition(super.getX()+x, super.getY()+y);
    }

    //private TextureRegion[][] tmp;


    public Animations(Texture walkSheet) {
        this.walkSheet=walkSheet;
        dx=0;
        dy=0;
        super.setPosition(0,0);
        TextureRegion[][] tmp = TextureRegion.split(this.walkSheet, this.walkSheet.getWidth() / 4, this.walkSheet.getHeight() / 2);
        this.walkingFramesRight = new TextureRegion[4];
        this.walkingFramesLeft = new TextureRegion[4];
        int index = 0;

        for(int j = 0; j < 4; j++) {
            this.walkingFramesRight[index] = tmp[0][j];
            this.walkingFramesLeft[index] = tmp[1][j];
            index++;
        }


        this.walkingAnimationRight = new Animation(0.05F, this.walkingFramesRight);
        this.walkingAnimationRight.setPlayMode(Animation.PlayMode.LOOP);
        this.walkingAnimationLeft = new Animation(0.05F, this.walkingFramesLeft);
        this.walkingAnimationLeft.setPlayMode(Animation.PlayMode.LOOP);

        animations = new Animation[2];
        animations[0] = walkingAnimationRight;
        animations[1] = walkingAnimationLeft;
        this.setCurrentAnimations(0);
    }

    public int getCurrentAnimations() {
        return this.currentAnimations;
    }

    public void setCurrentAnimations(int currentAnimations) {
        this.currentAnimations = currentAnimations;
        this.stateTime = 0;
        this.stepIndex = 0;
    }

    public void update(SpriteBatch batch) {
        this.stateTime += Gdx.graphics.getDeltaTime();
        if (animations[currentAnimations].getKeyFrameIndex(this.stateTime) != this.stepIndex &&
                (animations[currentAnimations].getKeyFrameIndex(this.stateTime) == 0 || animations[currentAnimations].getKeyFrameIndex(this.stateTime) == 12)) {
            this.stepIndex = animations[currentAnimations].getKeyFrameIndex(this.stateTime);
        }

        currentFrame = (TextureRegion) animations[currentAnimations].getKeyFrame(this.stateTime, true);
        batch.draw(currentFrame, super.getX()-dx, super.getY()-dy, super.getWidth(), super.getHeight());
    }
}
