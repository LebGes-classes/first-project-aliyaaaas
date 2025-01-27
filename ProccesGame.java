public class ProccesGame {
    public boolean proccess(int x, int y, Map labir, ClearConsole c, EndGame e) {
            c.clearConsole();
            labir.displayLabyrinth(x,y);
            if (e.checkVictory(x,y)) {
                System.out.println("Поздравляем! Вы прошли лабиринт!");
                e.endGame();
                return true;
            }
    return false;
    }
}