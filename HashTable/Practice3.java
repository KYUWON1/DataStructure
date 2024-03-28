package HashTable;// Practice3
// 해시 충돌 해결 - 개방 주소법 (제곱 탐사법)

class MyHashTable3 extends MyHashTable {

    MyHashTable3(int size) {
        super(size);
    }

    // 제곱 탐사법 구현
    public void setValue(int key, int data) {
        int idx = this.getHash(key);
        if(this.elemCnt == this.table.length){
            return;
        }else if(this.table[idx] == null){
            this.table[idx] = data;
        }else {
            int newIdx = idx;
            int cnt = 0;
            while(true){
                newIdx = (newIdx + (int)Math.pow(2,cnt)) % this.table.length;
                if(this.table[newIdx] == null){
                    break;
                }
                cnt++;
            }
            this.table[newIdx] = data;
        }
        this.elemCnt++;
    }
}

public class Practice3 {
    public static void main(String[] args) {
        // Test code
        MyHashTable3 ht = new MyHashTable3(11);
        ht.setValue(1, 10);
        ht.setValue(2, 20);
        ht.setValue(4, 40);
        ht.printHashTable();

        ht.setValue(1, 100); // 충돌지점 4칸만큼이동함 2의2승만큼
        ht.printHashTable();

        ht.setValue(1, 200);
        ht.setValue(1, 300);
        ht.setValue(1, 400);
        ht.printHashTable();
    }
}
