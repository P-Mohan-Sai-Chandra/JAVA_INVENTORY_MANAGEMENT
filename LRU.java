import java.util.*;
public class LRU { 

    private HashMap<String,Node> maps; 
    private Node LRU; 
    private Node MRU; 
    private int cap; 
    private int size; 

    public LRU(int capacity){
        this.cap = capacity; 
        this.size = 0;
    }


    public Item get(String key){
        if(maps.containsKey(key)){
            Node node = maps.get(key); 
            node = unlink(node);
            placeFirst(node);
            return node.item;
        }
        return null;
    }

    public void addRecentlyViewedItem(Item item){
        if(maps.containsKey(item.getId())){
            Node node = maps.get(item.getId()); 
            node.item = item; 
            node = unlink(node); 
            placeFirst(node);
        }
        else if(size + 1 <= cap){
            Node node = new Node(item); 
            maps.put(item.getId(),node);   
            placeFirst(node);
            size++;
        }
        else{
            maps.remove(LRU.item.getId()); 
            unlink(LRU); 
            Node node = new Node(item);
            maps.put(item.getId(),node); 
            placeFirst(node);
        }
    }


    private Node unlink(Node node){
        if(node == MRU && node == LRU){
            MRU = LRU = null;
        }
        else if(node == LRU){
            Node nxt = node.next; 
            nxt.prev = null; 
            node.next = null; 
            LRU = nxt;
        }
        else if(node == MRU){
            Node prv = node.prev; 
            prv.next = null; 
            node.prev = null; 
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
    private void placeFirst(Node node){
        if(node == MRU && node == LRU) return; 
        if(node == MRU) return; 
        
        MRU.next = node; 
        node.prev = MRU; 
        MRU = node; 
    }
    private class Node{
        Item item;
        Node prev; 
        Node next; 

        Node(Item item){
            this.item = item;
        }

        @Override
        public String toString() {
            return "Node [item=" + item + ", prev=" + prev + ", next=" + next + "]";
        }

        


    }


    
}
