package org.fws.main;

import java.io.IOException;
import java.util.Scanner;

/**
 * Cette classe ne sera jamais instanciée, l'ensemble des attributs et méthodes sont donc déclarés 'static'
 */
public class GameLogic {
    private static final int DEFAULT_SEPARATOR_LENGTH = 50;
    static Scanner scanner = new Scanner(System.in);
    static Player player;
    private static String[] enemies = {"Sorcier", "Bandit", "Bandit", "Sorcier", "Guerrier"};
    private static String[] actions = {"Combat", "Repos", "Combat", "Combat", "Repos"};
    private static boolean isGameRunning;
    private static int placeNumber = 0;
    private static String[] places = {"Place 1", "Place 2", "Place 3", "Place 4"};
    private static int level = 1;

    // Méthode destinée à récupérer la saisie utilisateur (input) dans la console
    public static int readChoiceInt(String prompt, int numberOfChoices) {
        int input = -1;
        do {
            if (input > numberOfChoices) {
                System.out.println("Veuillez saisie une valeur comprise entre 1 et " + numberOfChoices + " !");
            }
            System.out.print(prompt);
            try {
                input = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                input = -1;  // En cas d'erreur, on reste dans la boucle d'interaction
                System.out.println("Veuillez saisir quelque chose !");
            }
        } while (input < 1 || input > numberOfChoices);

        return input;
    }

    // Méthode destinée à effacer le contenu de la console
    public static void cleanOutput(boolean rough) {
        if (rough) {
            for (int i = 0; i < 100; i++) {
                System.out.println();
            }
        } else {
            try {
                if (System.getProperty("os.name").contains("Windows"))
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                else
                    Runtime.getRuntime().exec(new String[]{"clear"});
            } catch (IOException | InterruptedException e) {
                System.out.println("Une erreur inattendue est survenue : " + e);
            }
        }
    }

    // Méthode destinée à générer une ligne pour séparer les différents éléments affichés (amélioration de la lisibilité)
    public static void printLine(int length, String symbol) {
        symbol = (symbol == null) ? "-" : symbol;
        for (int i = 0; i < length; i++) {
            System.out.print(symbol);
        }
        System.out.println();
    }

    // Méthode destinée à générer un titre dans la console, précédé et suivi par une ligne séparatrice
    public static void mainMessage(String title, Integer lineLength, boolean withSeparator) {
        lineLength = (lineLength == null) ? GameLogic.DEFAULT_SEPARATOR_LENGTH : lineLength;
        if (withSeparator) {
            printLine(lineLength, null);
            System.out.println(title);
            printLine(lineLength, null);
        } else {
            System.out.println(title);
        }
    }

    // Méthode de mise en pause du jeu tant que l'utilisateur n'a pas effectué sa saisie
    public static void waitForInput() {
        System.out.println("Appuyez sur n'importe quel caractère puis « Entrée » pour continuer...");
        scanner.next();
    }

    // Méthode destinée à initialiser le jeu (état initial avec premier choix du joueur)
    public static void startGame() {
        boolean isNameDefined = false;
        String name;
        cleanOutput(true);
        mainMessage("Web Empire", null, true);
        waitForInput();

        do {
            cleanOutput(true);
            mainMessage("Veuillez choisir votre nom de joueur", null, true);
            System.out.print(">>> "); // TODO Implement a printPrompt() method ?
            name = scanner.next();
            cleanOutput(true);
            mainMessage("Le nom choisi est « " + name + " ».\nÊtes-vous sûr de votre choix ?", null, true);
            System.out.println("[1] Oui.");
            System.out.println("[2] Non, je souhaite modifier mon nom de joueur.");
            int choice = readChoiceInt(">>> ", 2);
            isNameDefined = choice == 1;
        } while (!isNameDefined);

        // Présentation de l'histoire
        Story.printIntro();

        // Instanciation d'un joueur
        player = new Player(name);

        // Début (Acte 1)
        Story.printFirstLevelIntro();

        // Exécution de la boucle principale d'interaction du jeu
        isGameRunning = true;
        startMainGameLoop();
    }

    // Méthode destinée à passer au niveau suivant en fonction des points d'expérience
    public static void goToNextLevel() {
        // TODO Implement the following with pattern matching ?
        if (player.experience >= 10 && level == 1) {
            level++;
            placeNumber++;
            // Affichage de l'épilogue du niveau actuel
            Story.printFirstLevelOutro();
            // Montée en compétence
            player.chooseSkills();
            // Création des ennemis pour le niveau suivant
            enemies = new String[]{"Bandit", "Mercenaire", "Sorcier", "Bandit", "Guerrier"};
            // Création des actions pour le niveau suivant
            actions = new String[]{"Combat", "Repos", "Combat", "Achat", "Repos"};
            // Affichage du prologue du niveau suivant
            Story.printSecondLevelIntro();
        } else if (player.experience >= 50 && level == 2) {
            level++;
            placeNumber++;
            // Affichage de l'épilogue
            Story.printSecondLevelOutro();
            // Montée en compétence
            player.chooseSkills();
            // Création des ennemis pour le niveau suivant
            enemies = new String[]{"Bandit", "Mercenaire", "Sorcier", "Bandit", "Guerrier"};
            // Création des actions pour le niveau suivant
            actions = new String[]{"Combat", "Repos", "Combat", "Achat", "Repos"};
            // Affichage du prologue du niveau suivant
            Story.printThirdLevelIntro();
            // Réinitialisation des points de vie du joueur
            player.health = player.maxHealth;
        } else if (player.experience >= 100 && level == 3) {
            level++;
            placeNumber++;
            // Affichage de l'épilogue
            Story.printThirdLevelOutro();
            // Montée en compétence
            player.chooseSkills();
            // Création des ennemis pour le niveau suivant
            enemies = new String[]{"Bandit", "Mercenaire", "Sorcier", "Bandit", "Guerrier"};
            // Création des actions pour le niveau suivant
            actions = new String[]{"Combat", "Repos", "Combat", "Achat", "Repos"};
            // Affichage du prologue du niveau suivant
            Story.printFourthLevelIntro();
            // Mise en place du combat final
            finalFight();
        }
    }

    // Méthode destinée au tirage aléatoire des éléments du jeu (ennemis et actions)
    public static void generateRandomAction() {
        int randomActionNumber = (int) (Math.random() * actions.length);
        switch (actions[randomActionNumber]) {
            case "Combat":
                startFight();
                break;
            case "Repos":
                rest();
                break;
            case "Achat":
                purchase();
                break;
        }
    }

    // Méthode destinée à poursuivre le jeu
    public static void continueGame() {
        // Passage au niveau suivant si nécessaire
        goToNextLevel();
        // Vérification du dernier niveau
        if (level != Story.LAST_LEVEL) {
            generateRandomAction();
        }
    }

    public static void showCharacterInfo() {
        cleanOutput(true);
        mainMessage("Vos informations - " + player.name, null, true);
        System.out.println("HP : " + player.health + " / " + player.maxHealth);
        printLine(50, null);
        System.out.println("XP : " + player.experience);
        printLine(50, null);
        System.out.println("Argent : " + player.coins);
        printLine(50, null);
        System.out.println("Nombre d'élixirs : " + player.elixirs);
        printLine(50, null);

        if (player.attackSkillsNumber > 0) {
            System.out.println("Attaque : " + player.attackSkills[player.attackSkillsNumber - 1]);
            printLine(50, null);
        }
        if (player.defenseSkillsNumber > 0) {
            System.out.println("Défense : " + player.defenseSkills[player.defenseSkillsNumber - 1]);
            printLine(50, null);
        }

        waitForInput();
    }

    public static void purchase() {
        cleanOutput(true);
        int randomPrice = (int) (Math.random() * (10 + player.elixirs * 3) + 10 + player.elixirs);
        mainMessage("Vous rencontrez un marchand qui cherche à vous vendre un élixir pour un total de " + randomPrice + " coins.", null, false);
        printLine(50, null);
        System.out.println("Acceptez-vous sa proposition ?");
        System.out.println("[1] Oui.");
        System.out.println("[2] Non, c'est bien trop cher.");
        int choice = readChoiceInt(">>> ", 2);
        if (choice == 1) {
            cleanOutput(true);
            if (player.coins >= randomPrice) {
                mainMessage("Vous venez d'acquérir l'élixir du marchand.", null, false);
                player.elixirs++;
                player.coins++;
            } else {
                mainMessage("Il vous manque " + (randomPrice - player.coins) + " coins pour acheter l'élixir.", null, false);
            }
            waitForInput();
        }
    }

    public static void rest() {
        cleanOutput(true);
        if (player.rests >= 1) {
            mainMessage("Vous pouvez encore reprendre des forces " + player.rests + " fois. Avez-vous besoin de reprendre des forces ?", null, false);
            System.out.println("[1] Oui.");
            System.out.println("[2] Non, je me sens en forme.");
            int choice = readChoiceInt(">>> ", 2);
            if (choice == 1) {
                cleanOutput(true);
                if (player.health < player.maxHealth) {
                    int restHealthEffect = (int) (Math.random() * ((double) player.experience / 4 + 1) + 10);
                    player.health = Math.min(player.health + restHealthEffect, player.maxHealth);
                    System.out.println("Vous avez pu reprendre des forces : vous disposez désormais de " + player.health + " points de vie.");
                    player.rests--;
                } else {
                    System.out.println("Inutile de reprendre des forces, vous êtes au maximum de vos capacités.");
                }
                waitForInput();
            }
        }

    }

    public static void startFight() {
        cleanOutput(true);
        mainMessage("Vous venez de rencontrer un ennemi...", null, false);
        waitForInput();
        String enemyName = enemies[(int) (Math.random() * enemies.length)];
        Enemy enemy = new Enemy(enemyName, player.experience);
        fight(enemy);
    }

    public static void fight(Enemy enemy) {
        boolean isFightOngoing = true;
        while (isFightOngoing) {
            cleanOutput(true);
            mainMessage("Ennemi [ " + enemy.name + " ] :\n- Points de vie : " + enemy.health + "\n- Points d'expérience : " + enemy.experience, null, false);
            mainMessage("Vous [ " + player.name + " ] :\n- Points de vie : " + player.health + "\n- Points d'expérience : " + player.experience, null, false);
            System.out.println("Veuillez choisir une action :");
            printLine(50, null);
            System.out.println("[1] Combattre.");
            System.out.println("[2] Utiliser un élixir.");
            System.out.println("[3] Prendre la fuite.");
            int choice = readChoiceInt(">>> ", 3);
            int dealtDamage;
            int takenDamage;
            switch (choice) {
                case 1: // Combat
                    dealtDamage = player.attack() - enemy.defend();
                    takenDamage = enemy.attack() - player.defend();
                    if (takenDamage < 0) {
                        dealtDamage -= takenDamage / 2;
                        takenDamage = 0;
                    }
                    if (dealtDamage < 0) {
                        dealtDamage = 0;
                    }
                    player.health -= takenDamage;
                    enemy.health -= dealtDamage;
                    cleanOutput(true);
                    mainMessage("Bilan du combat", null, false);
                    System.out.println("Vous avez infligé des dommages de " + dealtDamage + " points à " + enemy.name + ".");
                    printLine(50, null);
                    System.out.println(enemy.name + " vous a infligé des dommages de " + takenDamage + " points.");
                    waitForInput();
                    if (player.health <= 0) {
                        gameOver();
                        isFightOngoing = false;
                    } else if (enemy.health <= 0) {
                        cleanOutput(true);
                        mainMessage("Vous avez vaincu " + enemy.name + ".", null, false);
                        player.experience += enemy.experience;
                        mainMessage("Vous avez gagné " + enemy.experience + " points d'expérience.", null, false);
                        boolean increaseRests = Math.random() * 5 + 1 <= 2.25;
                        int increaseCoins = (int) (Math.random() * enemy.experience);
                        if (increaseRests) {
                            player.rests++;
                            System.out.println("Vous avez gagné la possibilité de reprendre des forces.");
                        }
                        if (increaseCoins > 0) {
                            player.coins += increaseCoins;
                            System.out.println("Vous avez dérobé " + increaseCoins + " coins sur la dépouille de " + enemy.name);
                        }
                        waitForInput();
                        isFightOngoing = false;
                    }
                    break;
                case 2: // Utilisation d'un élixir
                    cleanOutput(true);
                    if (player.elixirs > 0 && player.health < player.maxHealth) {
                        mainMessage("Êtes-vous certain de vouloir utiliser l'un de vos élixirs ? Il vous en reste " + player.elixirs + ".", null, false);
                        System.out.println("[1] Oui.");
                        System.out.println("[2] Non, pas pour le moment.");
                        choice = readChoiceInt(">>> ", 2);
                        switch (choice) {
                            case 1:
                                player.health = player.maxHealth;
                                mainMessage("Grâce à l'élixir, vous venez de récupérer la totalité de vos points de vie.", null, false);
                                waitForInput();
                                break;
                            case 2:
                                showCharacterInfo();
                                break;
                            case 3:
                                isGameRunning = false;
                            default:
                                // TODO To be implemented if necessary...
                                break;
                        }
                    } else {
                        mainMessage("Vous n'avez plus d'élixir ou vous n'en avez pas besoin.", null, false);

                    }
                    break;
                case 3: // Fuite
                    cleanOutput(true);
                    if (level != Story.LAST_LEVEL) {
                        // 35 % de chance de s'en sortir en prenant la fuite
                        if (Math.random() * 10 + 1 <= 3.5) {
                            mainMessage("Vous êtes parvenu à vous enfuir.", null, false);
                            waitForInput();
                            break;
                        } else {
                            mainMessage(enemy.name + " est parvenu à vous rattraper", null, false);
                            takenDamage = enemy.attack();
                            mainMessage("Vous avez perdu " + takenDamage + " points de vie.", null, false);
                            // FIXME Need to subtract taken damage ?
                            waitForInput();
                            if (player.health <= 0) {
                                gameOver();
                            }
                        }
                    } else {
                        mainMessage("Vous ne pouvez pas échapper au combat final.", null, false);
                        waitForInput();
                    }
                    break;
                default:
                    // TODO To be implemented if necessary...
                    break;
            }
        }
    }

    public static void finalFight() {
        Enemy finalEnemy = new Enemy("Grand Maître", 300);
        fight(finalEnemy);
        Story.printOutro();
        isGameRunning = false;
    }

    public static void printMainMenu() {
        cleanOutput(true);
        mainMessage(places[placeNumber], null, true);
        System.out.println("Veuillez choisir une action à effectuer :");
        printLine(50, null);
        System.out.println("[1] Poursuivre le jeu.");
        System.out.println("[2] Voir vos informations.");
        System.out.println("[3] Quitter le jeu.");
    }

    public static void gameOver() {
        cleanOutput(true);
        mainMessage("Vous venez de mourir...", null, false);
        mainMessage("Vous avez gagné " + player.experience + " points d'expérience au cours de cette partie.", null, false);
        System.out.println("Vous aurez peut-être plus de chance la prochaine fois.");
        isGameRunning = false;
    }

    // Méthode destinée à la gestion de la boucle principale d'interaction du jeu
    public static void startMainGameLoop() {
        while (isGameRunning) {
            printMainMenu();
            int choice = readChoiceInt(">>> ", 3);
            switch (choice) {
                case 1:
                    continueGame();
                    break;
                case 2:
                    showCharacterInfo();
                    break;
                case 3:
                    isGameRunning = false;
                default:
                    // TODO To be implemented if necessary...
                    break;
            }
        }
    }
}
