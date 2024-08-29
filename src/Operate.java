import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


class Operate {
    private static ShoppingManager shoppingManager = new ShoppingManager();
    private static Map<String, String> staffCredentials = new HashMap<>();  //https://www.w3schools.com/java/java_hashmap.asp

    static {
        staffCredentials.put("staff1", "password1"); //https://www.geeksforgeeks.org/simplebindings-put-method-in-java-with-examples/
        staffCredentials.put("staff2", "password2");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter staff ID: ");
            String staffId = scanner.next();

            System.out.print("Enter password: ");
            String password = scanner.next();

            if (validateLogin(staffId, password)) {
                operate();
                break;
            } else {
                System.out.println("Invalid credentials. Try again.");
            }
        }
    }

    private static boolean validateLogin(String staffId, String password) {
        return staffCredentials.containsKey(staffId) && staffCredentials.get(staffId).equals(password);
    }

    private static void operate() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("**************************");
            System.out.println("    WELCOME TO SHOP 13");
            System.out.println("**************************");
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Clothing");
            System.out.println("2. Add Food");
            System.out.println("3. Add Electronic");
            System.out.println("4. View Products");
            System.out.println("5. Remove Product");
            System.out.println("6. Total Bill");
            System.out.println("7. Exit");

            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println("Sorry, invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    addProduct(new Clothing());
                    break;
                case 2:
                    addProduct(new Food());
                    break;
                case 3:
                    addProduct(new Electronic());
                    break;
                case 4:
                    viewProducts();
                    break;
                case 5:
                    removeProduct();
                    break;
                case 6:
                    printTotalValue();
                    break;
                case 7:
                    saveProductsToFile();
                    printTotalValue();
                    System.out.println("Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void removeProduct() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the product to remove: ");
        String productName = scanner.next();

        if (shoppingManager.getProducts().containsKey(productName)) {
            shoppingManager.removeProduct(productName);
            System.out.println("Product removed successfully!");
        } else {
            System.out.println("Product not found.");
        }
    }

    private static void addProduct(Product product) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter product name: ");
                String name = scanner.next();

                System.out.print("Enter product price: ");
                double price = Double.parseDouble(scanner.next());

                System.out.print("Enter product quantity: ");
                int quantity = Integer.parseInt(scanner.next());

                product.setName(name);
                product.setPrice(price);
                product.setQuantity(quantity);

                if (product instanceof Clothing) {
                    System.out.print("Enter clothing size: ");
                    String size = scanner.next();
                    ((Clothing) product).setSize(size);
                } else if (product instanceof Food) {
                    System.out.print("Enter food expiration date: ");
                    String expirationDate = scanner.next();
                    ((Food) product).setExpirationDate(expirationDate);
                } else if (product instanceof Electronic) {
                    System.out.print("Enter electronic brand: ");
                    String brand = scanner.next();
                    ((Electronic) product).setBrand(brand);
                }

                shoppingManager.addProduct(product);
                System.out.println(product.getClass().getSimpleName() + " added successfully!");
                break;
            } catch (NumberFormatException e) {
                System.out.println("Sorry, invalid input. Please enter valid numeric values for price and quantity.");
                scanner.nextLine();
            }
        }
    }

    private static void viewProducts() {
        System.out.println("\nProducts in the Shopping Manager:");
        for (Product product : shoppingManager.getProducts().values()) {
            System.out.println(product);
        }
    }

    private static void saveProductsToFile() {
        try (FileWriter fileWriter = new FileWriter("products.txt", true)) {
            for (Product product : shoppingManager.getProducts().values()) {
                fileWriter.write(product.toString() + "\n");
            }
            System.out.println("Products saved successfully!");
        } catch (IOException e) {
            System.err.println("Error saving products to file: " + e.getMessage());
        }
    }

    private static void printTotalValue() {
        double totalValue = shoppingManager.calculateTotalValue();
        System.out.println("Total value of products: Rs." + totalValue);
    }
}
