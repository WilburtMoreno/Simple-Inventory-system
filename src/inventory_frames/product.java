package inventory_frames;

public class product {
    private int productID;
    private String name;
    private int code;
    private int quantity;
    private float price; 
    private  byte[] image;
    public product(String idP, String nameP, int codeP, int quantityP, float priceP, byte[]img){
        this.name = nameP;
        this.code = codeP;
        this.quantity = quantityP;
        this.price = priceP;
        this.image = img;
    }
    public int getId() {return productID;}
    public String getName() {return name;}
    public int getCode() {return code;}
    public int getQuantity() {return quantity;}
    public float getPrice() {return price;}
    public byte[] getImage() {return image;}
}
