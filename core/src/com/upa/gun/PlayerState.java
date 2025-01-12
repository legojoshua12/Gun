package com.upa.gun;

/**
 * Returns current state of player and handles updates
 */
public abstract class PlayerState implements Updatable {

    static GunGame game; //for use in dying state

    boolean controllable; //if the player can control the character

    boolean vulnerable;
    float iframeTime;

    public float timeElapsed; //counts ticks
    float rotation; //player rotation
    float opacity; //player opacity

    static PlayerIdleState idle; //when the player is not moving
    static PlayerMovingState moving; //when the player is using arrow keys
    static PlayerDyingState dying; //when the player dies

    /*
     * sets static variables
     */
    static {
        idle = new PlayerIdleState();
        moving = new PlayerMovingState();
        dying = new PlayerDyingState();
    }

    /**
     * Constructor
     */
    PlayerState() {
        timeElapsed = 0.0f;
        rotation = 0.0f;
        opacity = 1.0f;
        controllable = true;
        vulnerable = true;
        iframeTime = 0f;
    }

    /**
      * @return Whether the player can take damage in this state
     */
    boolean isVulnerable() {
        return vulnerable;
    }

    /**
     * Resets the tick counter every time state changes
     */
    void resetState() { //should reset timer every time state changes?
        timeElapsed = 0.0f;
        rotation = 0.0f;
        opacity = 1.0f;
    }

    /**
     * Sets the GunGame for use in the dying state
     */
    void setGame(GunGame game) {
        PlayerState.game = game;
    }

    /**
     * Sets the state and resets state variables
     * @param newState
     */
    void setState(PlayerState newState) {
        resetState();
        game.world.player.state = newState;
    }

    /**
     * Returns the state of player
     * @return SpriteState - returns SpriteState enum
     */
    public SpriteState getTextureState() {
        return SpriteState.IDLE;
    }
}