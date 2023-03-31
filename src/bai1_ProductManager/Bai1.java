package bai1_ProductManager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai1 {
    static Scanner scanner = new Scanner(System.in);
    static List<Product> products;

    public static void main(String[] args) {
        products = readProduct();
        while (true) {
            System.out.println("******************************* MENU *******************************");
            System.out.print("1. Thêm          ");
            System.out.print("2. Hiển thị          ");
            System.out.print("3. Tìm kiếm          ");
            System.out.print("4. Thoát \n");
            System.out.println("********************************************************************");

            int chose = Integer.parseInt(scanner.nextLine());
            switch (chose) {
                case 1:

                    System.out.println("nhập số sản phẩm muốn thêm:");
                    int n = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < n; i++) {
                        Product product = createProductToFile();
                        products.add(product);
                    }
                    writeProduct();
                    break;
                case 2:
                    showProduct();
                    break;
                case 3:
                    System.out.println("bạn muốn tìm kiếm sản phẩm gì?");
                    String searchProduct = scanner.nextLine();
                    searchProduct(searchProduct);
                    break;
                case 4:
                    System.out.println("Tạm biệt!");
                    System.exit(0);
                    break;

            }
        }
    }

    private static void searchProduct(String searchProduct) {
        for (Product product:products) {
            if (product.getName().contains(searchProduct)){
                System.out.println(product);
            }
        }
    }

    private static void writeProduct() {
        try {
            File file = new File("product.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(products);
            fos.close();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Product> readProduct() {
        File file = new File("D:\\MD3\\ss17_baitap_Serialization\\product.txt");
        try {
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                List<Product> list = (List<Product>) ois.readObject();
                return list;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return new ArrayList<>();
    }

    private static void showProduct() {
        System.out.println("\n****************** PRODUCT ******************");
        for (Product pro : products
        ) {
            System.out.println(pro);
        }
        System.out.println("*********************************************\n");
    }

    private static Product createProductToFile() {
        Product product = new Product();
        if (products.isEmpty()) {
            product.setId(1);
        } else {
            int newId = products.get(products.size() - 1).getId() + 1;
            product.setId(newId);
        }
        System.out.println("Nhập tên sản phẩm: ");
        product.setName(scanner.nextLine());
        System.out.println("Nhập hãng sản xuất sản phẩm: ");
        product.setProducer(scanner.nextLine());
        System.out.println("Nhập giá sản phẩm: ");
        product.setPrice(Double.parseDouble(scanner.nextLine()));
        System.out.println("Nhập mô tả sản phẩm: ");
        product.setTitle(scanner.nextLine());
        return product;
    }
}
