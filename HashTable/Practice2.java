package HashTable;// Practice2
// 해시 충돌 해결 - 개방 주소법 (선형 탐사법)

class MyHashTable2 extends MyHashTable {

    MyHashTable2(int size) {
        super(size);
    }

    //빈 공간을 찾아서 데이터 삽입
    public void setValue(int key, int data) {
        int idx = this.getHash(key);

        if(this.elemCnt == this.table.length){
            System.out.println("테이블이 꽉 찼습니다");
            return;
        }else if(this.table[idx] == null){
            this.table[idx] = data;
        }else {
            int newIdx = idx;
            while(true){
                newIdx = (newIdx + 1) % this.table.length;
                if(table[newIdx] == null){
                    break;
                }
            }
            this.table[newIdx] = data;
        }
        elemCnt++;
    }
}

public class Practice2 {
    public static void main(String[] args) {
        // Test code
        MyHashTable2 ht = new MyHashTable2(5);
        ht.setValue(1, 1);
        ht.setValue(3, 3);
        ht.printHashTable();

        ht.setValue(1, 10); // 1 다음 자리에 들어감
        ht.printHashTable();

        ht.setValue(1, 20);
        ht.setValue(1, 30);
        ht.setValue(1, 40);
        ht.printHashTable();
    }
}
