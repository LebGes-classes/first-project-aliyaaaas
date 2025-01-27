public class Game {
    private int playerX = 1;
    private int playerY = 1;
    private Menu menu;
    private Map labirint;
    private ClearConsole c;
    private EndGame end;

    public Game(Menu menu, Map labirint, ClearConsole c, EndGame end) {
        this.menu = menu;
        this.labirint = labirint;
        this.c = c;
        this.end = end;
    }

    public boolean mainPart() {
        if (menu.showMenu(c)) {
            StartGame startGame = new StartGame();
            startGame.start(labirint,playerX, playerY, c);
            ProccesGame pr = new ProccesGame();
            while (!pr.proccess(playerX, playerY, labirint, c, end)) {
                User user = new User();
                int[] newCoordinate = user.movePlayer(playerX, playerY, labirint);
                if (newCoordinate.length == 2 ) {
                    playerX = newCoordinate[0];
                    playerY = newCoordinate[1];
                }
            }
        }
        else {
            end.exitGame();
        }
        return  false;
    }
}