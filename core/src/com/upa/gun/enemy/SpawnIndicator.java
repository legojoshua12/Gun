package com.upa.gun.enemy;

import com.upa.gun.Updatable;

public class SpawnIndicator implements Updatable {
    public float x, y;
    float timeElapsed;
    float timeUntilSpawn;
    EnemyFactory factory;
    public boolean markedForDeletion;

    SpawnIndicator(float x, float y, float timeElapsed, float timeUntilSpawn, EnemyFactory factory) {
        this.x = x;
        this.y = y;
        this.timeElapsed = timeElapsed;
        this.timeUntilSpawn = timeUntilSpawn;
        this.factory = factory;
        markedForDeletion = false;
    }

    @Override
    public void update(float delta) {
        timeElapsed += delta;
    }

    public boolean shouldSpawn() {
        return timeElapsed >= timeUntilSpawn;
    }

    void createSpawn() {
        factory.spawn(x, y);
    }
}