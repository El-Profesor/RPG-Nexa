package org.fws.main;

public class Player extends Character {
    private static final int MAX_HEALTH = 100;
    private static final int EXPERIENCE = 0;
    private static final int SKILLS_NUMBER = 0;
    private static final int COINS_INIT_VAL = 5;
    private static final int ELIXIRS_INIT_VAL = 0;
    private static final int RESTS_INIT_VAL = 1;

    private String[] attackSkills = {"Strength", "Power", "Might", "Godlike Strength"};
    private String[] defenseSkills = {"Heavy Bones", "Stoneskin", "Scale Armor", "Holy Aura"};
    private int attackSkillsNumber, defenseSkillsNumber;
    private int coins, elixirs, rests;

    public Player(String name) {
        // Appel au constructeur de la classe mère
        super(name, Player.MAX_HEALTH, Player.EXPERIENCE);
        // Initialisation du nombre de compétences (attaque / défense)
        this.attackSkillsNumber = this.defenseSkillsNumber = Player.SKILLS_NUMBER;
        // Initialisation des spécificités additionnelles
        this.coins = Player.COINS_INIT_VAL;
        this.elixirs = Player.ELIXIRS_INIT_VAL;
        this.rests = Player.RESTS_INIT_VAL;
        // Initialisation des compétences (choix effectué par le joueur)
        this.chooseSkills();
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

    public int getAttackSkillsNumber() {
        return this.attackSkillsNumber;
    }

    public int getDefenseSkillsNumber() {
        return this.defenseSkillsNumber;
    }

    public String getAttackSkill() {
        return this.attackSkills[attackSkillsNumber - 1];
    }

    public String getDefenseSkill() {
        return this.defenseSkills[defenseSkillsNumber - 1];
    }

    public int getCoins() {
        return this.coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getElixirs() {
        return this.elixirs;
    }

    public void setElixirs(int elixirs) {
        this.elixirs = elixirs;
    }

    public int getRests() {
        return this.rests;
    }

    public void setRests(int rests) {
        this.rests = rests;
    }

    @Override
    public int attack() { // Définition de l'attaque du point de vue du joueur
        return (int) (Math.random()*((double) experience / 4 + attackSkillsNumber * 3 + 3) + (double) experience / 10 + attackSkillsNumber * 2 + defenseSkillsNumber + 1);
    }

    @Override
    public int defend() { // Définition de la défense du point de vue du joueur
        return (int) (Math.random()*((double) experience / 4 + defenseSkillsNumber * 3 + 3) + (double) experience / 10 + defenseSkillsNumber * 2 + attackSkillsNumber + 1);
    }

    public void chooseSkills() {
        GameLogic.cleanOutput(true);
        GameLogic.mainMessage("Veuillez choisir une compétence :", null, true);
        System.out.println("[1] " + this.attackSkills[this.attackSkillsNumber]);
        System.out.println("[2] " + this.defenseSkills[this.defenseSkillsNumber]);
        int choice = GameLogic.readChoiceInt(">>> ", 2);
        GameLogic.cleanOutput(true);
        switch (choice) {
            case 1:
                GameLogic.mainMessage("Vous disposez désormais de la compétence « " + this.attackSkills[this.attackSkillsNumber] + " ».", null, true);
                this.attackSkillsNumber++;
                break;
            case 2:
                GameLogic.mainMessage("Vous disposez désormais de la compétence « " + this.defenseSkills[this.defenseSkillsNumber] + " ».", null, true);
                this.defenseSkillsNumber++;
                break;
            default:
                // TODO To be implemented if necessary
                break;
        }
        GameLogic.waitForInput();

    }
}
