public class Listing {

    private Integer id;
    private String make;
    private Integer price;
    private Integer mileage;
    private String seller_type;

    public Listing(int id, String make, int price, int mileage, String seller_type) {

        this.id = id;
        this.make = make;
        this.price = price;
        this.mileage = mileage;
        this.seller_type = seller_type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getSeller_type() {
        return seller_type;
    }

    public void setSeller_type(String seller_type) {
        this.seller_type = seller_type;
    }

}