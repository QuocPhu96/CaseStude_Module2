package CaseStude.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {

//    Phương thức dùng để viết
    public static <T> void write(String path, List<T> iteam){
        try {
            PrintWriter printWriter = new PrintWriter(path);
            for (T item : iteam){
                printWriter.println(item);
            }
            printWriter.flush();
            printWriter.close();
        }catch (FileNotFoundException e){
            throw new IllegalArgumentException(path + "Không hợp lệ");
        }
    }

//   Phương thức dùng để đọc
    public static List<String> read(String path){
        List<String> Lines = new ArrayList<>();
        try {
            File file = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null && !line.trim().isEmpty())
                Lines.add(line);
        }catch (IOException e){
            throw new IllegalArgumentException(path + "Không hợp lệ");
        }
        return Lines;
    }
}
