package vn.edu.giadinh.baitap.lap2;

import java.util.Scanner;

public class Bai_1 {
public static void main(String[] args) {
    int a, b;
        double nghiem;
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số a: ");
        a = scanner.nextInt();
        System.out.println("Nhập vào số b: ");
        b = scanner.nextInt();
        System.out.println("Phương trình bạn vừa nhập vào là: " + a + "x + " + b + " = 0.");
        if (a == 0) {
            if (b == 0) {
                System.out.println("Phương trình này có vô số nghiệm.");
            } else {
                System.out.println("Phương trình vô nghiệm.");
            }
        } else {
            nghiem = (double) -b / a;   
            System.out.println("Phương trình có nghiệm x = " + nghiem + ".");
        }
    }   
          
    
}
