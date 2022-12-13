public class Product {
    private long id;
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(final long id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public long getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int  getQuantity() { return quantity; }

    public Object getField(String field) {
        if (field.equalsIgnoreCase("name")) return getName();
        else if (field.equalsIgnoreCase("price")) return getPrice();
        else if (field.equalsIgnoreCase("rating")) return getQuantity();
        else throw new IllegalArgumentException("No Such Field!");
    }

    public void setName(String name) { this.name = name; }
    public void setPrice(float price) { this.price = price;}
    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public String toString() {
        if (id != 0) {
            return String.format("Product{id=%d, name=%s, price=%f, quantity=%d}", id, name, price, quantity);
        } else
            return String.format("Product{name=%s, price=%f, quantity=%d}", name, price, quantity);
    }
}
