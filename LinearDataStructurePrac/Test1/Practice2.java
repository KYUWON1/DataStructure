package LinearDataStructurePrac.Test1;

import java.util.HashMap;
import java.util.Map;

public class Practice2 {

    public static void solution(int[][] matrix) {
        //key는 행, value는 열, 0의 위치를 미리 맵에 저장
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0){
                    map.put(i,j);
                }
            }
        }

        for(Map.Entry<Integer,Integer> item: map.entrySet()){
            int row = item.getKey();
            int col = item.getValue();
            for (int i = 0; i < matrix.length; i++) {
                matrix[row][i] = 0;
            }
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

    }


    public static void main(String[] args) {
        // Test code
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        solution(matrix);

        System.out.println();
        matrix = new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        solution(matrix);
    }
}
