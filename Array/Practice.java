package Array;// Practice
// 기본 배열 자료형을 이용한 배열의 생성, 삽입, 삭제 기능 구현

import java.util.Arrays;

class MyArray {

    int[] arr;

//  배열의 초기 사이즈 설정
    MyArray(int size){
        this.arr = new int[size];
    }

//  배열에 데이터 삽입
    public void insertData(int index, int data){
        if(index < 0 || index > this.arr.length){
            System.out.println("인덱스 범위 초과");
            return;
        }
        int[] dupArr = this.arr.clone(); //현재 배열을 저장
        this.arr = new int[this.arr.length+1]; // 사이즈 하나 증가
        for (int i = 0; i < index; i++) { // 넣을 index 전까지 데이터 저장
            this.arr[i] = dupArr[i];
        }
        for (int i = index+1; i < arr.length; i++) {
            this.arr[i] = dupArr[i - 1]; // 넣은 index 제외하고, 나머지 값 저장
        }
        this.arr[index] = data; // 해당 인덱스에 데이터 저장
    }

//  배열에서 특정 데이터 삭제
    public void removeData(int data){
        int index = -1;
        for (int i = 0; i < this.arr.length; i++) {
            if(this.arr[i] == data){
                index = i;
                break;
            }
        }
        if(index == -1){
            System.out.println("데이터가 존재하지 않습니다.");
            return;
        }

        int[] dupArr = new int[this.arr.length-1]; //사이즈 하나 축소
        for (int i = 0; i < index; i++) {
            dupArr[i] = this.arr[i]; // 삭제하려는 값까지 저장
        }
        for (int i = index; i < dupArr.length; i++) {
            dupArr[i] = this.arr[i+1]; // 해당 인덱스 빼고 저장
        }
        this.arr = dupArr.clone();
    }
}

public class Practice {
    public static void main(String[] args) {

//      Test code
        int size = 5;
        MyArray myArray = new MyArray(size);

        for (int i = 0; i < size; i++) {
            myArray.arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(myArray.arr));   // [1, 2, 3, 4, 5]

        myArray.arr[0] = 10;
        System.out.println(Arrays.toString(myArray.arr));   // [10, 2, 3, 4, 5]

        myArray.insertData(2, 20);
        System.out.println(Arrays.toString(myArray.arr));   // [10, 2, 20, 3, 4, 5]

        myArray.insertData(6, 60);
        System.out.println(Arrays.toString(myArray.arr));   // [10, 2, 20, 3, 4, 5, 60]

        myArray.insertData(-1, 0);  // Index Error

        myArray.removeData(4);
        System.out.println(Arrays.toString(myArray.arr));   // [10, 2, 20, 3, 5, 60]

        myArray.removeData(5);
        System.out.println(Arrays.toString(myArray.arr));   // [10, 2, 20, 3, 60]

        myArray.removeData(99); // 해당 데이터가 없습니다.
    }
}
