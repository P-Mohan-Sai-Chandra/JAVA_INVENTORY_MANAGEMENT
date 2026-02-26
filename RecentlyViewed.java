import java.util.HashMap;
import java.util.Map;

public class RecentlyViewed{

    private Map<String,Node> map; 
    private Node LRU; 
    private Node MRU; 
    private final int cap = 10; 
    private int size = 0; 

    public RecentlyViewed(){
        map = new HashMap<>();
    }


    public Item get(String key){
        if(map.containsKey(key)){ 
            Node node = map.get(key); 
            node = delete(node); 
            placeFront(node);
            return node.item;
        }
        return null; 
    }

    public void put(Item item){

        if(map.containsKey(item.getId())){
            Node node = map.get(item.getId()); 
            node.item = item; 
            node = delete(node); 
            placeFront(node);
        }
        else if(size + 1 <= cap){
            Node nnode = new Node(item); 
            map.put(item.getId(),nnode); 
            placeFront(nnode);
            size++;
        }
        else{
            Node nnode = new Node(item);
            delete(LRU); 
            placeFront(nnode);
        }

    }

    private Node delete(Node node){

        if(node == LRU){
            Node nxt = LRU.next; 
            LRU.next = null; 
            nxt.prev = null; 
            LRU = nxt;
        }
        else if(node == MRU){
            Node prv = MRU.prev; 
            prv.next = null; 
            MRU.prev = null; 
            MRU = prv;
        }
        else{
            Node nxt = node.next; 
            Node prv = node.prev;
            nxt.prev = prv; 
            prv.next = nxt; 
        }
        return node; 
    }

    private void placeFront(Node node){
        if(MRU == null){
            MRU = node;
        }
        else{
            MRU.next = node; 
            node.prev = MRU; 
            MRU = node;
        }
    }


    private class Node{
        private Node prev; 
        private Node next; 
        private Item item;

        public Node(Item item){
            this.item = item;
        }
    }

}