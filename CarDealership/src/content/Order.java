/*
author @ Harman Bath
*/
package content;

public class Order {
    
    private String orderID; 
    private String name; 
    private String address;
    private String city; 
    private String product; 
    private double price; 
    private int quantity; 
    
    public Order(String OrderID){
        this.orderID = OrderID;
    }
    
    public String getOrderID(){
        return this.orderID; 
    }
    
    public void setName(String name){
        this.name = name; 
    }
    
    public String getName(){
        return this.name; 
    }
    
    public void setAddress(String address){
        this.address = address; 
    }
    
    public String getAddress(){
        return this.address; 
    }
    
     public void setCity(String city){
        this.city = city; 
    }
    
    public String getCity(){
        return this.city; 
    }
    
    public void setProduct(String product){
        this.product = product; 
    }
    
    public String getProduct(){
        return this.product; 
    }
    
    public void setPrice(double price){
        this.price = price; 
    }
    
    public double getPrice(){
        return this.price; 
    }
    
    public void setQuantity(int quantity){
        this.quantity = quantity; 
    }
    
    public int getQuantity(){
        return this.quantity; 
    }
       
}
