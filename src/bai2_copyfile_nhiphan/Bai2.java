package bai2_copyfile_nhiphan;

import bai1_ProductManager.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai2 {
    static Scanner scanner = new Scanner(System.in);
    static List<Products> pro;

    public static void main(String[] args) {
        pro = readPro();
        showProduct();
        System.out.println("nhập số sản phẩm muốn thêm:");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            Products products = createProductToFile();
            pro.add(products);
        }
        writeProduct();
        copy();
        showProduct();
    }

    private static List<Products> readPro() {
        File file = new File("D:\\MD3\\ss17_baitap_Serialization\\src\\bai2_copyfile_nhiphan\\source.txt");
        try {
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                List<Products> list = (List<Products>) ois.readObject();
                return list;
            }

        } catch (EOFException e) {
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return new ArrayList<>();
    }

    private static void showProduct() {
        System.out.println("\n****************** PRODUCT ******************");
        for (Products pro : pro
        ) {
            System.out.println(pro);
        }
        System.out.println("*********************************************\n");
    }

    private static Products createProductToFile() {
        Products products = new Products();
        if (pro.isEmpty()) {
            products.setId(1);
        } else {
            int newId = pro.get(pro.size() - 1).getId() + 1;
            products.setId(newId);
        }
        System.out.println("Nhập tên sản phẩm: ");
        products.setName(scanner.nextLine());
        System.out.println("Nhập hãng sản xuất sản phẩm: ");
        products.setProducer(scanner.nextLine());
        System.out.println("Nhập giá sản phẩm: ");
        products.setPrice(Double.parseDouble(scanner.nextLine()));
        System.out.println("Nhập mô tả sản phẩm: ");
        products.setTitle(scanner.nextLine());
        return products;
    }

    private static void writeProduct() {
        try {
            File file = new File("D:\\MD3\\ss17_baitap_Serialization\\src\\bai2_copyfile_nhiphan\\source.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(pro);
            fos.close();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void copy() {
        try {
            File file = new File("D:\\MD3\\ss17_baitap_Serialization\\src\\bai2_copyfile_nhiphan\\target.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(pro);
            fos.close();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
