public class ClearConsole {
    public void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}