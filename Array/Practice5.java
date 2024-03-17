package Array;// Practice5
// 배열 arr 의 값을 오름차순으로 출력

// 입출력 예시)
// arr: 5, 3, 1, 4, 6, 1
// 결과: 1, 1, 3, 4, 5, 6

public class Practice5 {
    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 4, 6, 1};
        int[] visited = new int[arr.length];
        int visitCnt= 0;
        int minVal = Integer.MAX_VALUE;
        int minidx = -1;

        while(visitCnt < arr.length) {
            //최소값과 최소값인덱스찾기,
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < minVal && visited[i] == 0) {
                    minVal = arr[i];
                    minidx = i;
                }
            }
            //발견햇다면 출력하고 방문값으로 설정하고 cnt증가
            if(minidx != -1){
                System.out.print(minVal+" ");
                visited[minidx] = 1;
                visitCnt++;
            }
            minVal = Integer.MAX_VALUE;
            minidx = -1;
        }
    }
}

