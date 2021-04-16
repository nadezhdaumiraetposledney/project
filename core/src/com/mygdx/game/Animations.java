package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Animations {
    private static final int FRAME_COLS = 2;
    private static final int FRAME_ROWS = 2;
    private int currentAnimations;
    private float stateTime = 0.0F;
    private Animation<TextureRegion> walkingAnimation;
    private static final int Width=0;
    private TextureRegion[] walkingFrames;
    private TextureRegion currentFrame;
    private int stepIndex = 0;
    private Texture walkSheet;

    //private TextureRegion[][] tmp;

    public void setWalkSheet(Texture walkSheet) {
        this.walkSheet=walkSheet;
        TextureRegion[][] tmp = TextureRegion.split(this.walkSheet, this.walkSheet.getWidth() / 2, this.walkSheet.getHeight() / 2);
        this.walkingFrames = new TextureRegion[4];
        int index = 0;

        for(int i = 0; i < 2; ++i) {
            for(int j = 0; j < 2; ++j) {
                this.walkingFrames[index++] = tmp[i][j];
            }
        }

        this.walkingAnimation = new Animation(0.05F, this.walkingFrames);
        this.walkingAnimation.setPlayMode(Animation.PlayMode.LOOP);
        //int[] animations = new int[]{0};
        this.setCurrentAnimations(0);
    }

    public Animations(Texture walkSheet) {
       setWalkSheet(walkSheet);
    }

    public int getCurrentAnimations() {
        return this.currentAnimations;
    }

    public void setCurrentAnimations(int currentAnimations) {
        this.currentAnimations = currentAnimations;
        this.stateTime = 0.0F;
        this.stepIndex = 0;
    }

    public void update(SpriteBatch batch, float x, float y) {
        this.stateTime += Gdx.graphics.getDeltaTime();
        if (this.walkingAnimation.getKeyFrameIndex(this.stateTime) != this.stepIndex && (this.walkingAnimation.getKeyFrameIndex(this.stateTime) == 0 || this.walkingAnimation.getKeyFrameIndex(this.stateTime) == 12)) {
            this.stepIndex = this.walkingAnimation.getKeyFrameIndex(this.stateTime);
        }

        this.currentFrame = (TextureRegion)this.walkingAnimation.getKeyFrame(this.stateTime, true);
        batch.draw(this.currentFrame, x, y,
                new Texture(Gdx.files.internal("pengst.png")).getWidth()*2.1f,new Texture(Gdx.files.internal("pengst.png")).getHeight()*2.1f);
    }
}
