package org.fws.main;

// Classe abstraite (car non instantiable) imposant un « contrat » pour les classes dérivées
public abstract class Character {
    // Attributs communs à l'ensemble des classes filles
    protected String name;
    protected int health;
    protected int maxHealth;
    protected int experience;

    // Constructeur : définit l'état initial d'un personnage
    public Character(String name, int maxHealth, int experience) {
        this.name = name;
        this.health = this.maxHealth = maxHealth;
        this.experience = experience;
    }

    // Méthodes liées à l'action de « combattre »
    public abstract int attack();
    public abstract int defend();
}
