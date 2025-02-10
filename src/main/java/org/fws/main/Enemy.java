package org.fws.main;

public class Enemy extends Character {
    public int playerExperience;

    public Enemy(String name, int playerExperience) {
        // Appel au constructeur de la classe mère
        super(name, (int) (Math.random() * playerExperience + (double) playerExperience / 3 + 5), (int) (Math.random() * ((double) playerExperience / 4 + 2) + 1));
        this.playerExperience = playerExperience;
    }

    public int getMaxHealth(int experience) {
        return (int) (Math.random() * experience + (double) experience / 3 + 5);
    }

    public int getExperience(int experience) {
        return (int) (Math.random() * ((double) experience / 4 + 2) + 1);
    }

    @Override
    public int attack() {
        return (int) (Math.random() * ((double) playerExperience / 4 + 1) + (double) experience / 4 + 3);
    }

    @Override
    public int defend() {
        return (int) (Math.random() * ((double) playerExperience / 4 + 1) + (double) experience / 4 + 3);
    }
}
