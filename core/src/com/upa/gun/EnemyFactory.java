package com.upa.gun;

class EnemyFactory {
    private Enemy prototype;

    EnemyFactory(Enemy prototype) {
        this.prototype = prototype;
    }

    void spawn(float x, float y) {
        GunWorld.enemies.add(prototype.create(x, y));
    }
}
