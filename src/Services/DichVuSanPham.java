package CaseStude.services;

import CaseStude.utils.CSVUtils;
import CaseStude.view.Product;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class DichVuSanPham {
    private final static String path = "Data/Data.csv";

    public DichVuSanPham (){}

//   Đọc dữ liệu từ file
    public static List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        List<String> lines = CSVUtils.read(path);
        for (String line : lines){
            Product product = Product.parse(line);
            products.add(product);
        }
        return products;
    }
//    Thêm sản phẩm mới vô CSV
    public static void add(Product newProduct){
        List<Product> products = findAll();
        products.add(newProduct);
        CSVUtils.write(path, products);
    }

//    Tồn tại theo ID
    public boolean existsById(long id){
        List<Product> products = findAll();
        for (Product product : products){
            if (product.getId() == id)
                return true;
        }
        return false;
    }

//    Tìm ID
    public Product findById(long id){
        List<Product> products = findAll();
        for (Product product : products){
            if (product.getId() == id)
                return product;
        }
        return null;
    }
//    Cập nhật
    public void update(Product newProdict){
        findAll().add(newProdict);
    }
}
