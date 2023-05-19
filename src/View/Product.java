package CaseStude.view;

import CaseStude.services.DichVuSanPham;
import CaseStude.utils.TienIchUngDung;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Product {
    private long id;
    private String name;
    private String tacGia;

    private double price;
    private Date ngayXuatBan ;
    private int soLuong;

    public Product(long id, String name, String tacGia, double price, Date ngayXuatBan, int soLuong) {
        this.id = id;
        this.name = name;
        this.tacGia = tacGia;
        this.price = price;
        this.ngayXuatBan = ngayXuatBan;
        this.soLuong = soLuong;
    }

    public Product() {

    }


    public static Product parse(String raw)  {
        String[] fields = raw.split(",");
        long id = Long.parseLong(fields[0]);
        String name = fields[1];
        String tacGia = fields[2];
        double price = Double.parseDouble(fields[3]);
        Date ngayXuatBan = null;
        try {
            ngayXuatBan = new SimpleDateFormat("dd-MM-yyyy").parse(fields[4]);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        int soLuong = Integer.parseInt(fields[5]);
        Product product = new Product();
               product.setId(id);
               product.setName(name);
               product.setTacGia(tacGia);
               product.setPrice(price);
               product.setNgayXuatBan(ngayXuatBan);
               product.setSoLuong(soLuong);
               return product;
    }




    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public double getPrice(double price) {
        return this.price;
    }

    public Product setPrice(double price) {
        this.price = price;
        return this;
    }

    public String getNgayXuatBan() {
        return new SimpleDateFormat("dd-MM-yyyy").format(ngayXuatBan);
    }

    public Product setNgayXuatBan(Date ngayXuatBan) {
        this.ngayXuatBan = ngayXuatBan;
        return this;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public Product setSoLuong(int soLuong) {
        this.soLuong = soLuong;
        return this;
    }
    @Override
    public String toString() {
        return this.getId() + "," + this.getName() + "," + this.getTacGia() + "," + this.getPrice(price)+ ","+ this.getNgayXuatBan() + ","+ this.getSoLuong() ;
    }
    public static Object showProducts(){
//        return "$$  ID: " + this.getId() + "  ,  " +
//                "Truyện: " + this.getName() + "  ,  " +
//                "Tác giả: " + this.getTacGia() + "  ,  " +
//                "Giá thuê: " + this.getPrice(price)+ "  ,  "+
//                "Ngày nhập: " + this.getNgayXuatBan() + "  ,  " +
//                "Số lượng: " + this.getSoLuong() + "   $$";
        System.out.println("-----------------------------------------Thông Tin Truyện-------------------------------------------");
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s\n", "Id", "Tên Xe", "Tác Giả ", "Giá thuê", "Ngày nhập", "Số Lượng");
        for (Product product : DichVuSanPham.findAll()) {
            System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s\n",
                    product.getId(),
                    product.getName(),
                    product.getTacGia(),
                    TienIchUngDung.doubleToVND(product.getPrice())
                    , product.getNgayXuatBan(),
                    product.getSoLuong());


        }
        return null;
    }

    private double getPrice() {
        return price;
    }

//    public static void showTicket(List<String> showCars) {
//    System.out.println("-----------------------------------------Thông Tin Xe Trong Bãi-------------------------------------------");
//    System.out.printf("%-15s %-15s %-15s %-15s %-15s\n", "Id", "Tên Xe", "Biển Số ", "Giá", "Ngày Gửi");
//    for (Ticket ticket : parkingService.findAll()) {
//        System.out.printf("%-15s %-15s %-15s %-15s %-15s\n",
//                ticket.getId(),
//                ticket.getName(),
//                ticket.getBienSo(),
//                AppUtils.doubleToVND(ticket.getGia())
//                , ticket.getNgayGui());
//    }
//}

}
