class Electronic extends Product {
    private String brand;

    public Electronic() {
    }

    public Electronic(String name, double price, int quantity, String brand) {
        super(name, price, quantity);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String toString() {
        return "Electronic - Name: " + getName() + ", Price: Rs." + getPrice() + ", Quantity: " + getQuantity() + ", Brand: " + getBrand();
    }
}
