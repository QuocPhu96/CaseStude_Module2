package CaseStude.utils;

import java.text.DecimalFormat;
import java.util.Scanner;

public class TienIchUngDung {
    static Scanner scanner = new Scanner(System.in);

    //Phương thức chọn lại số khi sai
    public static void retryChoose(int min, int max) {
        int option;
        do {
            System.out.print(" ⭆ ");
            try {
                option = Integer.parseInt(scanner.nextLine());
                if (option > max || option < min) {
                    System.out.println("Chọn chức năng không đúng ! Vui lòng chọn lại ");
                    continue;
                }
                break;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } while (true);
        return;
    }
    //Phương thức thử lại Phân tích cú pháp Integer
    public static int retryParseInt(){
        int result;
        do {
            System.out.println("Nhập lại số lượng : ");
            System.out.print(" ⭆ ");
            try {
                result = Integer.parseInt(scanner.nextLine());
                return result;
            }catch (Exception ex){
                System.out.println("Nhập sai! vui lòng nhập lại");
            }
        }while (true);
    }
    //Phương thức Thử lại chuổi
    public static String retryString(String fielName){
        String result;
        System.out.print(" ⭆ ");
        while ((result = scanner.nextLine()).isEmpty()){
            System.out.printf("%s không được để Trống\n" , fielName);
            System.out.print(" ⭆ ");

        }
        return result;
    }

    //Phương thức thử lại phân tích cú pháp Double
    public static double retryParseDouble(){
        double result;
        do {
            System.out.println("Nhập giá tiền :");
            System.out.println(" ⭆ ");
            try {
                result = Double.parseDouble(scanner.nextLine());
                return result;
            }catch (Exception ex){
                System.out.println("Vui lòng nhập lại");
            }
        }while (true);
    }

//   Phương thức tiền VND
    public static String doubleToVND(double value){
        String patternVND = ",###₫";
        DecimalFormat decimalFormat = new DecimalFormat(patternVND);
        return decimalFormat.format(value);
    }

    public static void exit(){
        System.out.println("\tTạm biệt. Hẹn gặp lại!");
        System.exit(5);
    }
}
