package CaseStude.view;

import CaseStude.services.DichVuSanPham;
import CaseStude.utils.TienIchUngDung;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Menu {

    static Scanner scanner = new Scanner(System.in);

    public static void showMenu() {


        while (true) {
            int choice;
            menu();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    while (true) {
                        quangLyTruyenTranh();
                        choice = Integer.parseInt(scanner.nextLine());
                        switch (choice) {
                            case 1:
                                Product.showProducts();
                                break;
                            case 2:
                                addProduct();
                                break;
                            case 3:
                                break;
                            case 10:
                                System.out.println("Thoát khỏi ứng dụng thành công!");
                                System.exit(0);
                            default:
                                System.out.println("Số không hợp lệ, vui lòng chọn lại!");
                        }

                    }

                case 2:
                    addProduct();

                    break;
                case 3:


                default:
                    System.out.println("không có sự lựa chọn");
            }
        }

    }
    private static void quangLyTruyenTranh(){
        System.out.println(
                "\n***********************************\n" +
                        "\n*       Quảng lý truyện tranh      *\n" +
                        "\n* 1 Danh sách truyện               *\n" +
                        "\n* 2 Thêm truyện                    *\n" +
                        "\n* 3 Sửa truyện                     *\n" +
                        "\n* 4 Xoá truyện                     *\n" +
                        "\n* 10 Exit                          *\n" +
                        "\n************************************\n" +
                        "\n Nhập sự lựa chọn của bạn"
        );
    }


    private static void menu() {
        System.out.println(
                        "\n***********************************\n" +
                        "\n*               Menu               *\n" +
                        "\n* 1 Quảng lý truyện tranh         *\n" +
                        "\n* 5 Danh sách truyện đang thuê     *\n" +
                        "\n* 6 thuê truyện                    *\n" +
                        "\n* 7 Trả truyện                     *\n" +
                        "\n* 10 Exit                          *\n" +
                        "\n************************************\n" +
                        "\n Nhập sự lựa chọn của bạn"
        );
    }
//Phương thức nhập tên
    public static String inputName() {
        System.out.println("Nhập tên sản phẩm : ");
//        return String.valueOf(scanner.nextInt());
     return    scanner.nextLine();
    }
    public static String inputNameTacGia() {
        System.out.println("Nhập tên Tác Giả : ");
//        return String.valueOf(scanner.nextInt());
        return    scanner.nextLine();
    }

    // nhập giá tiền
    private static double inputPrice() {
        do {
            try {
                System.out.println("Nhập giá sản phẩm : ");
                return Double.parseDouble(scanner.nextLine());
            }catch (Exception ex){
                System.out.println("Nhập sai vui lòng nhập lại");
            }
        }while (true);
    }

//    thêm sản phẩm
    private static void addProduct() {
        String name = inputName();
//        double price = TienIchUngDung.retryParseDouble();
        double price = inputPrice();
        String tacGia = inputNameTacGia();
        Date ngayXuatBan = new java.util.Date();
        int soLuong = TienIchUngDung.retryParseInt();
        Product newProduct = new Product();
            newProduct.setId( System.currentTimeMillis());
            newProduct.setName(name);
            newProduct.setTacGia(tacGia);
            newProduct.setPrice(price);
            newProduct.setNgayXuatBan(ngayXuatBan);
            newProduct.setSoLuong(soLuong);
            DichVuSanPham.add(newProduct);
    }

//    private static void showProduct() {
//        List<Product> products = DichVuSanPham.findAll();
//        for (Product product : products){
//            System.out.println(product.showProducts());
//        }
//    }
}

//    private static void menu() {
//        System.out.println(
//                "\n***********************************\n" +
//                        "\n*               Menu              *\n" +
//                        "\n*1 Quản lý danh sách truyện tranh *\n" +
//                        "\n*2 Quản lý danh sách khách hàng   *\n" +
//                        "\n*3 Exit                           *\n" +
//                        "\n***********************************\n" +
//                        "\n Nhập sự lựa chọn của bạn"
//        );
//    }
