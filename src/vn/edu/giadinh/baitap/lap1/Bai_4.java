package vn.edu.giadinh.baitap.lap1;

import java.util.Scanner;

public class Bai_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập các hệ số thứ nhất của phương trình bậc 2: ");
        double a = scanner.nextDouble();
        System.out.println("nhập vào hệ số thứ hai của phương trình bậc 2: ");
        double b = scanner.nextDouble();
        System.out.println("nhập vào hệ số tự do của phương trình bậc 2: ");
        double c = scanner.nextDouble();
        double Delta = Math.pow(b, 2)-4*a*c;
        System.out.println("Delta của phương trình bậc 2 là: "+Delta);
        double canDelta = Math.sqrt(Delta);
        System.out.println("căn Delta của phương trình bậc 2 là: "+canDelta);

        
    }
}
