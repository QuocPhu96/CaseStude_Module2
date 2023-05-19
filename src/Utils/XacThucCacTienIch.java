package CaseStude.utils;

import java.util.regex.Pattern;

public class XacThucCacTienIch {
    public static final String dangKyDienThoai = "^[0][1-9][0-9]{8,9}$";
    public static boolean dienThoaiCoHopLe(String number){
        return Pattern.compile(dangKyDienThoai).matcher(number).matches();
    }
}
