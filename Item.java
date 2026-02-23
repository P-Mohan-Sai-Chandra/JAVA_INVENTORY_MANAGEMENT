public class Item implements Comparable<Item>{
    private String name; 
    private double price; 
    private int quantity;  
    private  String id;

    public Item(String id,String name,double price,int quantity){ 
        this.id = id;
        this.name = name; 
        this.price = price; 
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getId(){
        return this.id;
    }   

    public void setId(String id){
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    } 

    
    @Override
    public int compareTo(Item o) {
        return (int)(this.price - o.price);
    }


}
    