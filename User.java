import java.util.Scanner;

public class User {

    public int[] movePlayer(int x, int y, Map map) {
        System.out.print("Введите направление (W - вверх, S - вниз, A - влево, D - вправо): ");
        Scanner scanner = new Scanner(System.in);
        char direction = scanner.next().toUpperCase().charAt(0);
        int newX = x;
        int newY = y;

        switch (direction) {
            case 'W':
                newX--;
                break;
            case 'S':
                newX++;
                break;
            case 'A':
                newY--;
                break;
            case 'D':
                newY++;
                break;
            default:
                System.out.println("Некорректное направление. Попробуйте снова.");
                return new int[]{};
        }
        if (map.canMove(newX, newY)) {
             x = newX ;
             y = newY ;
             int[] arr = {x,y};
            return arr;
        } else {
            System.out.println("Вы не можете пройти через стену!");
            return new int[]{};
        }
    }}