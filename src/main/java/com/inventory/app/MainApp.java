package com.inventory.app;

import com.inventory.dao.ProductDAO;
import com.inventory.model.Product;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductDAO dao = new ProductDAO();

        while (true) {
            System.out.println("\n==== Inventory Menu ====");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    // Add Product
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter category: ");
                    String category = sc.nextLine();
                    System.out.print("Enter quantity: ");
                    int qty = sc.nextInt();
                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();

                    Product p = new Product(0, name, category, qty, price);
                    dao.addProduct(p);
                    break;

                case 2:
                    // View Products
                    dao.getAllProducts().forEach(System.out::println);
                    break;

                case 3:
                    // Update Product
                    System.out.print("Enter product ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    Product existing = dao.getProductById(updateId);
                    if (existing == null) {
                        System.out.println("❌ Product not found!");
                        break;
                    }

                    System.out.print("Enter new name (" + existing.getName() + "): ");
                    String newName = sc.nextLine();
                    if (!newName.isEmpty()) existing.setName(newName);

                    System.out.print("Enter new category (" + existing.getCategory() + "): ");
                    String newCategory = sc.nextLine();
                    if (!newCategory.isEmpty()) existing.setCategory(newCategory);

                    System.out.print("Enter new quantity (" + existing.getQuantity() + "): ");
                    String qtyStr = sc.nextLine();
                    if (!qtyStr.isEmpty()) existing.setQuantity(Integer.parseInt(qtyStr));

                    System.out.print("Enter new price (" + existing.getPrice() + "): ");
                    String priceStr = sc.nextLine();
                    if (!priceStr.isEmpty()) existing.setPrice(Double.parseDouble(priceStr));

                    if (dao.updateProduct(existing)) {
                        System.out.println("✅ Product updated successfully!");
                    } else {
                        System.out.println("❌ Update failed!");
                    }
                    break;

                case 4:
                    // Delete Product
                    System.out.print("Enter product ID to delete: ");
                    int deleteId = sc.nextInt();
                    sc.nextLine();
                    if (dao.deleteProduct(deleteId)) {
                        System.out.println("✅ Product deleted!");
                    } else {
                        System.out.println("❌ Product not found or delete failed.");
                    }
                    break;

                case 5:
                    System.out.println("👋 Exiting...");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
