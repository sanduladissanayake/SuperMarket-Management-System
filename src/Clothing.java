class Clothing extends Product {
    private String size;

    public Clothing() {
    }

    public Clothing(String name, double price, int quantity, String size) {
        super(name, price, quantity);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String toString() {
        return "Clothing - Name: " + getName() + ", Price: Rs." + getPrice() + ", Quantity: " + getQuantity() + ", Size: " + getSize();
    }
}