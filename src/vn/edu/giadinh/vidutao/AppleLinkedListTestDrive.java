package vn.edu.giadinh.vidutao;
import java.util.Scanner;
public class AppleLinkedListTestDrive {
    public static void main(String[] args) {
        AppleLinkedList appleLinkedList = new AppleLinkedList();
        Scanner nhap = new Scanner(System.in);
        int chon;
        do{
            System.out.println("========MENU========");
            System.out.println(">>1: Thêm táo vào đầu danh sách.");
            System.out.println(">>2: Thêm táo vào cuối danh sách.");
            System.out.println(">>3: Xoá táo ở cuối danh sách.");
            System.out.println(">>4: Tìm táo trong danh sách.");
            System.out.println(">>5: Thêm táo vào trước 1 táo.");
            System.out.println(">>6: In danh sách táo.");
            System.out.println(">>7: Kết thúc.");
            System.out.print("- Nhập vào sự lựa chọn(1->7): ");
            chon = nhap.nextInt();
            switch(chon){
                case 1:
                    appleLinkedList.addHead();
                    break;
                case 2: 
                    appleLinkedList.addTail();
                    break;
                case 3:
                    appleLinkedList.removeTail();
                    break;
                case 4:
                    appleLinkedList.find();
                    break;
                case 5:
                    appleLinkedList.add();
                    break;
                case 6:
                    appleLinkedList.inThongTin();
                    break;
                case 7:
                    System.out.println("- KẾT THÚC");
                    return;
            }
            System.out.print("- Quay lại MENU(1:yes/0:no): ");
            chon = nhap.nextInt();
        } while(chon == 1);
        nhap.close();
    }
}
