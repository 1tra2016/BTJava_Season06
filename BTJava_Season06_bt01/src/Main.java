import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhập số lượng sinh viên: ");
        int n = Integer.parseInt(scan.nextLine());
        int[] arr = new int[n];
        while(true){
            System.out.println("*********Quản lý điểm sinh viên*********");
            System.out.println("1. Nhập danh sách điểm sinh viên");
            System.out.println("2. In danh sách điểm");
            System.out.println("3. Tính điểm trung bình các sinh viên");
            System.out.println("4. Tìm điểm cao nhất và thấp nhất");
            System.out.println("5. Đếm số lượng sinh viên đạt và trượt");
            System.out.println("6. Sắp xếp điểm tăng dần");
            System.out.println("7. Thống kê số lượng giỏi và xuất sắc");
            System.out.println("8. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scan.nextLine());
            switch (choice) {
                case 1:
                    for (int i = 0; i < n; i++) {
                        System.out.printf("Nhập điểm cho sinh viên thứ %d: ",i+1);
                        arr[i] = Integer.parseInt(scan.nextLine());
                    }
                    break;
                case 2:
                    for (int i = 0; i < n; i++) {
                        System.out.printf("Điểm của sinh viên thứ %d: %d\n",i+1,arr[i]);
                    }
                    break;
                case 3:
                    int sum =0;
                    for (int i = 0; i < n; i++) {
                        sum+=arr[i];
                    }
                    System.out.printf("Điểm trung bình: %d\n",sum/n);
                    break;
                case 4:
                    int min = arr[0];
                    int max = arr[0];
                    for (int i = 1; i < n; i++) {
                        if(arr[i]<min) min = arr[i];
                        if(arr[i]>max) max = arr[i];
                    }
                    System.out.printf("Max: %d\nMin: %d\n",max,min);
                    break;
                case 5:
                    int pass = 0;
                    int fail = 0;
                    for (int i = 0; i < n; i++) {
                        if(arr[i]>=5) pass++;
                        else  fail++;
                    }
                    System.out.printf("Pass: %d\nFail: %d\n",pass,fail);
                    break;
                case 6:
                    for(int i=0;i<n-1;i++){
                        for(int j=i+1;j<n;j++){
                            if(arr[i]>arr[j]){
                                int temp = arr[j];
                                arr[j] = arr[i];
                                arr[i] = temp;
                            }
                        }
                    }
                    System.out.println("Đã sắp xếp lại danh sách sinh viên");
                    for (int i = 0; i < n; i++) {
                        System.out.printf("Điểm của sinh viên thứ %d: %d\n",i+1,arr[i]);
                    }
                    break;
                case 7:
                    int good = 0;
                    for (int i = 0; i < n; i++) {
                        if(arr[i]>=8) good++;
                    }
                    System.out.printf("Số lượng học sinh giỏi hoặc xuất sắc: %d\n",good);
                    break;
                case 8: System.exit(0);
                default:
                    System.out.println("Vui lòng nhập số hợp lệ từ 1 đến 8");
                    break;
            }
        }
    }
}