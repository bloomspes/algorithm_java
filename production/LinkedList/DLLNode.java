import static java.lang.reflect.Array.getLength;

public class DLLNode {

    /* 더블 연결 리스트의 장점은 한 노드를 중심으로 양 방향으로 탐색이 가능한 점이다.
    이전 노드의 포인터를 모르더라도 거꾸로 탐색이 가능하기 때문에 삭제하는데 지장이 없다.
     */

    private int data;
    private DLLNode next;
    private DLLNode pre; // pre : previous

    public void setData(int data){
        this.data = data;
    }

    public int getData(){
        return data;
    }

    public void setNext(DLLNode next){
        this.next = next;
    }

    public DLLNode getNext(){
        return this.next;
    }

    public void setPre(DLLNode pre){
        this.pre = pre;
    }

    public DLLNode getPre(){
        return this.pre;
    }

    // 중간에 노드 삽입하는 알고리즘

    DLLNode DLLInsert(DLLNode head, DLLNode insertNode, int position){

        if (head == null)
            return insertNode;

        int size = getLength(head);

        if (position > size + 1 || position < 1){
            System.out.println("Position of insertNode is invalid. "
            + "The valid inputs are 1 to " + (size + 1));
            return head;
        }

        if (position == 1){ // head에 노드 삽입하는 case
            insertNode.setNext(head);
            head.setPre(insertNode);
            return insertNode;
        }

        else { // 끝이 될 때까지 중간에 노드 삽입하는 case
            DLLNode preNode = head;
            int count = 1;
            while (count < position - 1){
                preNode = preNode.getNext();
                count++;
            }

            DLLNode currentNode = preNode.getNext();
            insertNode.setNext(currentNode);

            if (currentNode != null){
                currentNode.setPre(insertNode);
            }

            preNode.setNext(insertNode);
            insertNode.setPre(preNode);
        }

        return head;
    }

} 
