public class EndGame {
    public void endGame() {
        System.out.println("Игра окончена. Возврат в главное меню...");
        try {
            Thread.sleep(2000); // Задержка перед возвратом в меню
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void exitGame() {
        System.out.println("Спасибо за игру! До свидания.");
    }

    public boolean checkVictory(int x, int y) {
        return x == 4 && y == 5;
    }
}