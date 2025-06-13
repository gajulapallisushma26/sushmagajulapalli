import java.util.*;

class Product {
    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

class CartItem {
    Product product;
    int quantity;

    CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}

public class ECommerceApp {
    static List<Product> products = new ArrayList<>();
    static List<CartItem> cart = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        initProducts();

        while (true) {
            System.out.println("\n===== E-Commerce Menu =====");
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    viewProducts();
                    break;
                case 2:
                    addToCart(sc);
                    break;
                case 3:
                    viewCart();
                    break;
                case 4:
                    checkout();
                    break;
                case 5:
                    System.out.println("Thank you for shopping!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    static void initProducts() {
        products.add(new Product(101, "Laptop", 50000));
        products.add(new Product(102, "Mobile", 20000));
        products.add(new Product(103, "Headphones", 1500));
        products.add(new Product(104, "Smartwatch", 3000));
    }

    static void viewProducts() {
        System.out.println("\nAvailable Products:");
        for (Product p : products) {
            System.out.println(p.id + " - " + p.name + " - ₹" + p.price);
        }
    }

    static void addToCart(Scanner sc) {
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();
        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();

        Product selected = null;
        for (Product p : products) {
            if (p.id == id) {
                selected = p;
                break;
            }
        }

        if (selected != null) {
            cart.add(new CartItem(selected, qty));
            System.out.println(qty + " x " + selected.name + " added to cart.");
        } else {
            System.out.println("Product not found.");
        }
    }

    static void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        System.out.println("\nYour Cart:");
        double total = 0;
        for (CartItem item : cart) {
            double price = item.product.price * item.quantity;
            System.out.println(item.quantity + " x " + item.product.name + " = ₹" + price);
            total += price;
        }
        System.out.println("Total: ₹" + total);
    }

    static void checkout() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty. Add products first.");
        } else {
            viewCart();
            System.out.println("Checkout complete! Thank you for your purchase.");
            cart.clear();
        }
    }
}