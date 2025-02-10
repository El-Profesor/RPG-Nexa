package org.fws.main;

public class Enemy extends Character {
    private int playerExperience;

    public Enemy(String name, int playerExperience) {
        // Appel au constructeur de la classe mère
        super(name,  (int) (Math.random() * playerExperience + (double) playerExperience / 3 + 5), (int) (Math.random() * ((double) playerExperience / 4 + 2) + 1));
        this.playerExperience = playerExperience;
    }

    public String getName() {
        return this.name;
    }

    public int getExperience() {
        return this.experience;
    }

    public int getHealth() {
        return  this.health;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    // FIXME How to use that inside constructor ?
    public int getMaxHealth(int experience) {
        return (int) (Math.random() * experience + (double) experience / 3 + 5);
    }

    // FIXME How to use that inside constructor ?
    public int getExperience(int experience) {
        return (int) (Math.random() * ((double) experience / 4 + 2) + 1);
    }

    @Override
    public int attack() {
        return (int) (Math.random()*((double) playerExperience / 4 + 1) + (double) experience / 4 + 3);
    }

    @Override
    public int defend() {
        return (int) (Math.random()*((double) playerExperience / 4 + 1) + (double) experience / 4 + 3);
    }
}
