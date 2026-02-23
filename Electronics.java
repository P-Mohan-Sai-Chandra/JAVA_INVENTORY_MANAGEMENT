public class Electronics extends Item{

    private int warrenty; 

    public Electronics(String id,String name,double price,int quantity,int warrenty){
        super(id,name,price,quantity);
        this.warrenty = warrenty;   
    }

}