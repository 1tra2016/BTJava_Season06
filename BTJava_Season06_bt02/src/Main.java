import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String name = " ";
        String email= " ";
        String numbers= " ";
        String password= " ";
        while (true) {
            System.out.println("*************QUẢN LÝ NGƯỜI DÙNG*************");
            System.out.println("1. Nhập thông tin người dùng");
            System.out.println("2. Chuẩn hóa họ tên");
            System.out.println("3. Kiểm tra email");
            System.out.println("4. Kiểm tra số điện thoại");
            System.out.println("5. Kiểm tra mật khẩu");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scan.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Nhập họ và tên: ");
                    name = scan.nextLine();
                    System.out.print("Nhập email: ");
                    email = scan.nextLine();
                    System.out.print("Nhập số điện thoại: ");
                    numbers = scan.nextLine();
                    System.out.print("Nhập mật khẩu: ");
                    password = scan.nextLine();
                    break;
                case 2:
                    name = name.trim().replaceAll("\\s+"," ");
                    String[] words = name.split(" ");
                    StringBuilder newStr = new StringBuilder();

                    for(String word: words){
                        newStr.append(Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase() + " ");
                    }
                    System.out.printf("Kết quả sau chuẩn hóa: %s\n", newStr);
                    name  = newStr.toString().trim();
                    break;
                case 3:
                    if(email == " ") System.out.println("Chưa nhập email");
                    else if (Pattern.matches("\\w+@\\w+\\.[a-zA-Z]+",email) == false) System.out.println("Email chưa hợp lệ");
                    else System.out.println("Email đã hợp lệ");
                    break;
                case 4:
                    if(numbers == " ") System.out.println("Chưa nhập số điện thoại");
                    else if (Pattern.matches("0[0-9]{9}",numbers) == false) System.out.println("Số điện thoại chưa hợp lệ");
                    else System.out.println("Số điện thoại đã hợp lệ");
                    break;
                case 5:
                    if(password == " ") System.out.println("Chưa nhập mật khẩu");
                    else if (Pattern.matches(".{6,}",password) == false) System.out.println("Mật khẩu phải nhiều hơn 6 kí tự ");
                    else if (Pattern.matches(".*[a-z].*",password) == false) System.out.println("Mật khẩu phải chứa kí tự thường ");
                    else if (Pattern.matches(".*[A-Z].*",password) == false) System.out.println("Mật khẩu phải chứa kí tự in hoa ");
                    else if (Pattern.matches(".*[~!@#$%^&*(),.?\":{}|<>].*",password) == false) System.out.println("Mật khẩu phải chứa kí tự đặc biệt");
                    else System.out.println("Mật khẩu mạnh");
                    break;
                case 6: System.exit(0);
                default:
                    System.out.println("Vui lòng nhập từ 1-6");
                    break;
            }
        }
    }
}