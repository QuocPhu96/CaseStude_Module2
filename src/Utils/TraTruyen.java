package utils;

public class ThueTruyen {
    private String name;
    private  double price;
    private int soNgayThue;

    public ThueTruyen(String name, double price, int ngayThue) {
        this.name = name;
        this.price = price;
        this.soNgayThue = soNgayThue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSoNgayThue() {
        return soNgayThue;
    }

    public void setSoNgayThue(int soNgayThue) {
        this.soNgayThue = soNgayThue;
    }
    public double tinhTienThue(){
        double total = 0;
        if (soNgayThue <= 5){
            total = price * soNgayThue;
        }else {
            total = soNgayThue * 5 +(soNgayThue - 5) * price * 1.5;
        }
        return total;
    }
}
