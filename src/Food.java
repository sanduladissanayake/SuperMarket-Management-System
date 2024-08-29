class Food extends Product {
    private String expirationDate;

    public Food() {
    }

    public Food(String name, double price, int quantity, String expirationDate) {
        super(name, price, quantity);
        this.expirationDate = expirationDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
    public String toString() {
        return "Food - Name: " + getName() + ", Price: Rs." + getPrice() + ", Quantity: " + getQuantity() + ", Expiration Date: " + getExpirationDate();
    }
}