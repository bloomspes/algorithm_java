// 링크드 리스트, 큐, 스택, 트리 모두 노드와 포인터의 관계따라 자유롭게 구조 변경이 가능하다.
// 힙은 배열의 인덱스를 통해 단순히 노드를 더하는 것 보다도 쉽게 구현이 가능하다. (인덱스의 장점은 따로 정리해놓자)
// 힙 메모리에는 소스 코드에서 예약어 new를 사용해 생성된 인스턴스 변수가 놓인다.
// jvm의 gc에 의해서 지워질 때까지, 메소드 호출이 끝나지 않고 힙 메모리는 유지된다.


public class Heap {

    public int[] array;
    public int count;
    public int capacity;
    public int heap_type;
    public Heap(int capacity, int heap_type){

        this.heap_type = heap_type;
        this.count = 0;
        this.capacity = capacity;
        this.array = new int[capacity];

    }

    public int Parent(int i){

        if (i <= 0 || i >= this.count)
            return -1;

        return i - 1/2;
    }

    public int LeftChild(int i){
        int left = 2 * i + 1;
        if (left >= this.count)
            return -1;
        return left;
    }

    public int RightChild(int i){
        int right = 2 * i + 2;
        if (right >= this.count)
            return -1;
        return right;
    }

    public int getMax(int i){
        if (this.count == 0)
            return -1;
        return this.array[0];
    }

    public static void main(String[] args) {
        // 테스트 코드
    }

}
