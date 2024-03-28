package HashTable;// Practice4
// 해시 충돌 해결 - 개방 주소법 (이중 해싱)

class MyHashTable4 extends MyHashTable {
    int c;

    MyHashTable4(int size) {
        super(size);
        this.c = this.getHashC(size);
    }
    public int getHashC(int size){
        int c = 0;

        if(size <= 2){
            return size;
        }

        for (int i = size-1; i > 2; i--) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                //1또는 자기자신으로 나누어지는게 소수, 1과 자기자신을제외했으니, 걸리면 break;
                if(i % j == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                c = i;
                break;
            }
        }
        return c;
    }

    public int getHash2(int key){
        int hash = 1 + key % this.c; // c값은 보통 테이블보다 작은 소수
        return hash;
    }

    public void setValue(int key, int data) {
        int idx = this.getHash(key);

        if(this.elemCnt == this.table.length){
            return;
        }else if(this.table[idx] == null){
            this.table[idx] = data;
        }else {
            int newIdx = idx;
            int cnt = 1;
            while(true){
                newIdx = (newIdx + this.getHash2(newIdx) * cnt) % this.table.length;
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
public class Practice4 {
    public static void main(String[] args) {
        // Test code
        MyHashTable4 ht = new MyHashTable4(11);
        ht.setValue(1, 10);
        ht.setValue(2, 20);
        ht.setValue(3, 30);
        ht.printHashTable();

        // 데이터가 골고루 잘 퍼져서 들어감
        ht.setValue(1, 100);
        ht.setValue(1, 200);
        ht.setValue(1, 300);
        ht.printHashTable();
    }
}
