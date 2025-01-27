import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class node
{
    static int  x, y, distance;

    node(int x, int y, int dist)
    {
        this.x = x;
        this.y = y;
        this.distance = dist;
    }
}

public class GeneratorLab {
    static int M = 5;
    static int N = 6;
    static boolean flag = true;

    static boolean isValid(int mat[][], boolean visited[][], int row, int col) {
        return ((row >= 0) && (row < M) ) && ((col >= 0) && (col < N)) && (mat[row][col] == 1 || mat[row][col] == 3) && (!visited[row][col]);
    }

    private static void bfs(int matrix[][], int i, int j, int x, int y) {
        int row[] =
                {-1, 0, 0, 1};
        int col[] =
                {0, -1, 1, 0};

        boolean[][] visited = new boolean[M][N];
        Queue<node> q = new LinkedList<node>();
        visited[i][j] = true;
        q.add(new node(i, j, 0));
        int minimum_distance = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            node node = q.poll();
            i = node.x;
            j = node.y;
            int dist = node.distance;
            if (i == x && j == y) {
                minimum_distance = dist;
                break;

            }

            for (int k = 0; k < 4; k++) {
                if (row[k] + col[k] == 1 || row[k] + col[k] == -1) {
                    if (isValid(matrix, visited, i + row[k], j + col[k])) {
                        visited[i + row[k]][j + col[k]] = true;
                        node n = new node(i + row[k], j + col[k], dist + 1);
                        q.add(n);
                    }
                }
            }
        }

        if (minimum_distance == Integer.MAX_VALUE) {
            System.out.print("");
        } else {
            flag = false;
        }
    }

    public static void main(String[] args) {
        mas();
    }

    public static String[][] mas() {
        String[][] matrix1 = new String[6][7];
        int val = 0;
        while (flag) {
            int countZero = 0;
            int k = 0;
            int[][] matrix = new int[6][7];
            int[] arr = new int[30];

            arr[0] = 4;
            arr[29] = 3;
            for (int i = 0; i < arr.length; i++) {
                Random r = new Random();
                arr[i] = r.nextInt(2);
                if (arr[i] == 0) {
                    countZero++;
                }
            }
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if ( i != 0 && j != 0 && i != 5 && j != 6  ) {
                        matrix[i][j] = arr[k];
                        k++;
                    }
                }

            }
            bfs(matrix, 1, 1, 4, 5);
            if (countZero > 3) {
                if (!flag ) {

                    for (int i = 0; i < matrix.length; i++) {
                        for (int j  = 0; j < matrix[0].length; j++) {
                            if (matrix[i][j] == 0) {
                                matrix1[i][j] = "#";
                            }
                            if (matrix[i][j] == 1) {
                                matrix1[i][j] = " ";
                            }
                            if (i + j == 9 && i != 5 && j != 6) {
                                matrix1[i][j] = "E";
                            }
                        }
                    }
                }
            }
        }
        flag = true;
        return matrix1;
    }    }