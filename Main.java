public class Main {
    public static void main(String[] args) {
        boolean isRunning = true;
        ClearConsole c = new ClearConsole();
        while (isRunning) {
            Menu menu = new Menu();
            Map labirint = new Map();
            EndGame end = new EndGame();
            labirint.initializeLabyrinth();
            Game game = new Game(menu, labirint, c, end);
            game.mainPart();
        }
    }
}