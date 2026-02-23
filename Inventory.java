import java.util.*;

public class Inventory<T extends Item>{ 

    private HashMap<String,T> items; 
    
    public Inventory(){
        this.items = new HashMap<>();
    }
    
    public void addItem(T item){
        items.put(item.getId(),item);
    }
    
    public void removeItem(T item){
        items.remove(item.getId());
    }

    public T getItem(String id){
        return items.get(id);
    }

    public Collection<T> getAllItems(){
        return items.values();
    }
}
