public class Map {
    private String[][] choosedLab;
    public String[][] initializeLabyrinth() {
        choosedLab = GeneratorLab.mas();
        return choosedLab;
    }
    public void displayLabyrinth(int x, int y) {
        for (int i = 0; i < choosedLab.length; i++) {
            for (int j = 0; j < choosedLab[i].length; j++) {
                if (i == x && j == y) {
                    System.out.print("O "); // 'O' обозначает игрока
                } else {
                    System.out.print(choosedLab[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
    public boolean canMove(int x, int y) {
        return (choosedLab[x][y].equals(" ") || choosedLab[x][y].equals("E") );
    }
}