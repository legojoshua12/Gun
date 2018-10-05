package com.upa.gun;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.Map;

public abstract class Enemy extends Entity {
    float timeElapsed;
    float timeSinceAttack;
    boolean dying;
    boolean markedForDeletion;
    AttackRotation rotation;
    float opacity;
    private Map<SpriteState, Map<Direction, Animation<TextureRegion>>> sprite;
    SpriteState state;

    Enemy(float x, float y, float width, float height) {
        super(x, y, width, height, 0, 0);
        timeElapsed = 20.0f;
        dying = false;
        markedForDeletion = false;
        sprite = loadSprite();
        state = SpriteState.IDLE;
        opacity = 1f;
    }

    abstract Map<SpriteState, Map<Direction, Animation<TextureRegion>>> loadSprite();

    Map<SpriteState, Map<Direction, Animation<TextureRegion>>> sprite() {
        return sprite;
    }

    SpriteState getState() {
        return state;
    }

    abstract Enemy create(float x, float y);

    public void update(float delta) {
        super.update(delta);
        timeElapsed += delta;
        rotation.cycle(delta);
    }

    public void setDying(boolean dying) {
        this.dying = dying;
    }
}
