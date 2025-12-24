import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] carplates = new String[10];
        while (true) {
            System.out.println("*************QUẢN LÝ BIỂN SỐ XE*************");
            System.out.println("1. Thêm các biển số xe");
            System.out.println("2. Hiển thị danh sách biển số xe");
            System.out.println("3. Tìm kiếm biển số xe");
            System.out.println("4. Tìm kiếm biển số xe theo mã tỉnh");
            System.out.println("5. Sắp xếp biển số xe tăng dần");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scan.nextLine());
            switch (choice) {
                case 1:
                    boolean add = false;
                    while (add == false) {
                        System.out.print("Nhập biển số xe (hoặc -1 để thoát): ");
                        String newCarPlate = scan.nextLine();
                        if (newCarPlate.equals("-1") == true) {
                            add = true;
                        }
                        if (newCarPlate.length() != 10) System.out.println("Số lượng kí tự biển số xe không hợp lệ");
                        else if (Pattern.matches("[0-9]{2}[A-Z]-[0-9]{3}\\.[0-9]{2}",newCarPlate)==false) System.out.println("Các kí tự biển số xe không hợp lệ");
                        else {
                            for (int i = 0; i < carplates.length; i++) {
                                if (carplates[i] == null) {
                                    carplates[i] = newCarPlate;
                                    System.out.println("Đã thêm biển số xe!");
                                    add = true;
                                    break;
                                }
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.println("Danh sách biển số xe:");
                    for (String carplate : carplates) {
                        if (carplate == null) break;
                        System.out.println(carplate);
                    }
                    break;
                case 3:
                    System.out.print("Nhập biển số xe cần tìm: ");
                    String find =  scan.nextLine();
                    boolean found = false;
                    for (int i = 0; i < carplates.length; i++) {
                        if (carplates[i]==null) break;
                        if (carplates[i].equals(find)) {
                            System.out.println("Đã tìm thấy biển số xe, nằm ở vị trí: "+ i);
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("Không tìm thấy biển số xe");
                    break;
                case 4:
                    System.out.print("Tìm biển số xe dựa vào hai chữ số tỉnh: ");
                    int findNumber = Integer.parseInt(scan.nextLine());
                    StringBuilder founded = new StringBuilder();
                    for (String carplate : carplates) {
                        if (carplate==null) break;
                        if (Integer.parseInt(carplate.substring(0,2)) == findNumber) {
                            founded.append(carplate+"\n");
                        }
                    }
                    System.out.println("Danh sách các biển số xe tìm thấy: ");
                    System.out.println(founded.toString());
                    break;
                case 5:
                    int realengt=0;
                    for (int i = 0; i < carplates.length; i++) {
                        if (carplates[i]==null) {
                            realengt = i;
                            break;
                        }
                    }
                    for (int i = 0; i < realengt -1; i++) {
                        for (int j = i + 1; j < realengt; j++) {
                            if (carplates[i].compareTo(carplates[j]) > 0) { //tăng dần
                                String temp = carplates[i];
                                carplates[i] = carplates[j];
                                carplates[j] = temp;
                            }
                        }
                    }
                    break;
                case 6: System.exit(0);
                default:
                    System.out.println("Vui lòng nhập từ 1-6");
                    break;
            }
        }
    }
}