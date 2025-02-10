package org.fws.main;

/**
 * Cette classe ne sera jamais instanciée, l'ensemble des attributs et méthodes sont donc déclarés 'static'
 */
public class Story {
    public static final int LAST_LEVEL = 4;

    public static void printIntro() {
        GameLogic.cleanOutput(true);
        GameLogic.printLine(50, null);
        System.out.println("Histoire");
        GameLogic.printLine(50, null);
        System.out.println("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        System.out.println("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.");
        System.out.println("Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur ?");
        GameLogic.waitForInput();
    }

    public static void printOutro() {
        GameLogic.cleanOutput(true);
        GameLogic.printLine(50, null);
        System.out.println("Victoire");
        GameLogic.printLine(50, null);
        System.out.println("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
    }

    public static void printFirstLevelIntro() {
        GameLogic.cleanOutput(true);
        GameLogic.printLine(50, null);
        System.out.println("Niveau 1 - Prologue");
        GameLogic.printLine(50, null);
        System.out.println("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        System.out.println("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.");
        System.out.println("Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur ?");
        GameLogic.waitForInput();
    }

    public static void printFirstLevelOutro() {
        GameLogic.cleanOutput(true);
        GameLogic.printLine(50, null);
        System.out.println("Niveau 1 - Épilogue");
        GameLogic.printLine(50, null);
        System.out.println("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        System.out.println("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.");
        System.out.println("Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur ?");
        GameLogic.waitForInput();
    }

    public static void printSecondLevelIntro() {
        GameLogic.cleanOutput(true);
        GameLogic.printLine(50, null);
        System.out.println("Niveau 2 - Prologue");
        GameLogic.printLine(50, null);
        System.out.println("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        System.out.println("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.");
        System.out.println("Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur ?");
        GameLogic.waitForInput();
    }

    public static void printSecondLevelOutro() {
        GameLogic.cleanOutput(true);
        GameLogic.printLine(50, null);
        System.out.println("Niveau 2 - Épilogue");
        GameLogic.printLine(50, null);
        System.out.println("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        System.out.println("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.");
        System.out.println("Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur ?");
        GameLogic.waitForInput();
    }

    public static void printThirdLevelIntro() {
        GameLogic.cleanOutput(true);
        GameLogic.printLine(50, null);
        System.out.println("Niveau 3 - Prologue");
        GameLogic.printLine(50, null);
        System.out.println("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        System.out.println("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.");
        System.out.println("Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur ?");
        GameLogic.waitForInput();
    }

    public static void printThirdLevelOutro() {
        GameLogic.cleanOutput(true);
        GameLogic.printLine(50, null);
        System.out.println("Niveau 3 - Épilogue");
        GameLogic.printLine(50, null);
        System.out.println("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        System.out.println("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.");
        System.out.println("Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur ?");
        GameLogic.waitForInput();
    }

    public static void printFourthLevelIntro() {
        GameLogic.cleanOutput(true);
        GameLogic.printLine(50, null);
        System.out.println("Niveau 4 - Prologue");
        GameLogic.printLine(50, null);
        System.out.println("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        System.out.println("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.");
        System.out.println("Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur ?");
        GameLogic.waitForInput();
    }

    public static void printFourthLevelOutro() {
        GameLogic.cleanOutput(true);
        GameLogic.printLine(50, null);
        System.out.println("Niveau 4 - Épilogue");
        GameLogic.printLine(50, null);
        System.out.println("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        System.out.println("Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.");
        System.out.println("Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur ?");
        GameLogic.waitForInput();
    }
}
