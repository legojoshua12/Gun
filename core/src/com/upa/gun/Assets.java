package com.upa.gun;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;

import java.util.ArrayList;
import java.util.List;

public class Assets {
    public static Texture backgroundRoom1;

    public static TextureAtlas playerAtlas;
    public static List<Animation<TextureRegion>> playerAnimations;
    public static Sprite[] playerIdleSprites;

    public static Texture bullets;
    public static TextureRegion bulletBasic;

    public static BitmapFont menuFont;

    public static Texture loadTexture(String filepath) {
        return new Texture(Gdx.files.internal(filepath));
    }

    public static void load() {
        backgroundRoom1 = loadTexture("sprites/background1.png");

        playerAtlas = new TextureAtlas(Gdx.files.internal("sprites/player.atlas"));
        playerAnimations = new ArrayList<Animation<TextureRegion>>();
        loadPlayerAnimations("Front");
        loadPlayerAnimations("Back");
        loadPlayerAnimations("Left");
        loadPlayerAnimations("Right");

        playerIdleSprites = new Sprite[4];
        loadPlayerIdleSprite(Player.FRONT, "Front");
        loadPlayerIdleSprite(Player.BACK, "Back");
        loadPlayerIdleSprite(Player.LEFT, "Left");
        loadPlayerIdleSprite(Player.RIGHT, "Right");

        bullets = loadTexture("sprites/laserBullet.png");

        bulletBasic = new TextureRegion(bullets, 0, 0, 33, 14);

        menuFont = new BitmapFont();
    }

    private static void loadPlayerAnimations(String direction) {
        playerAnimations.add(new Animation<TextureRegion>(0.25f,
                Assets.playerAtlas.findRegions("player" + direction), Animation.PlayMode.LOOP));
    }

    private static void loadPlayerIdleSprite(int index, String direction) {
        playerIdleSprites[index] = new Sprite(Assets.playerAtlas.findRegion("player" + direction + "-idle"));
    }
}