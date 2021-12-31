package vn.edu.giadinh.tuan02;

import java.util.Scanner;

public class CTMinhHoaNhap {
  private static Scanner Scanner;

  public static void main(String[] args) {
      
    Scanner bienNhap;
     double diemMonCTDLGT;
       diemMonCTDLGT = 5.0;
       Scanner = bienNhap = new Scanner(System.in);
       System.out.print("Nhập vào điểm môn CTDL & GT:");
       diemMonCTDLGT = bienNhap.nextDouble();
       System.out.println("Điểm vừa nhập vào là: " + diemMonCTDLGT);
       String chuoi = new String("Hello mấy bạn");

    }
    
}

