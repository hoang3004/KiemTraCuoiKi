package vn.edu.giadinh.vidutao;
import java.util.Scanner;
public class AppleLinkedList {
    Node head = null;
    Node tail = null;
    Scanner nhap = new Scanner(System.in);
    int ma;
    double khoiLuong;
    String mauSac;
    public AppleLinkedList(){}
    public void nhapThongtin(){
        System.out.print("+ Nhập mã của táo: ");
        ma = nhap.nextInt();
        System.out.print("+ Nhập khối lượng của táo: ");
        khoiLuong = nhap.nextDouble();
        System.out.print("+ Nhập màu sắc của táo: ");
        nhap.nextLine();
        mauSac = nhap.nextLine();
        System.out.println("___________________________");

    }
    public void in(){
        System.out.println("- Mã: "+ma);
        System.out.println("- Khối lượng: "+khoiLuong);
        System.out.println("- Màu sắc: "+mauSac);
        System.out.println("___________________________");
    }
    public void inThongTin(){
        Node current = head;

        if(head == null){
            System.out.println("- DANH SÁCH RỖNG.");
        }else{
            while(current != null){
                System.out.println("- Mã: "+current.ma);
                System.out.println("- Khối lượng: "+current.khoiLuong);
                System.out.println("- Màu sắc: "+current.mauSac);
                System.out.println("___________________________");
                current = current.next;
            }
        }
    }
    public void addHead(){
        nhapThongtin();
        Node newNode = new Node(ma, khoiLuong, mauSac);
        if(head == null){
            head = newNode;
            tail = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
    }
    public void addTail(){
        nhapThongtin();
        Node newNode = new Node(ma, khoiLuong, mauSac);
        if(head == null){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
    }
    Node find(){
        Node tam1 = head;
        System.out.print("- Nhập mã táo muốn tìm: ");
        int maTim = nhap.nextInt();
        if(head.ma == maTim){
            System.out.println("- Táo cần tìm: ");
            in();
        }
        while(tam1.next != null){
            if(tam1.next.ma == maTim){
                System.out.println("- Mã: "+tam1.next.ma);
                System.out.println("- Khối lượng: "+tam1.next.khoiLuong);
                System.out.println("- Màu sắc: "+tam1.next.mauSac);
                System.out.println("___________________________");
                return tam1;
            }
            tam1 = tam1.next;
        }
        return null;
        
    }
    void removeTail(){
        Node tam = head;
        if(head == null){
            System.out.println("- DANH SÁCH RỖNG");
            return;
        }
        while(tam != null){
            if(tam.next == tail){
                tail = tam;
                tail.next = null;
                return;
            }
            tam = tam.next;
        }
    }
    void add(){
        System.out.println("*Tìm thông tin của táo muốn thêm vào trước: ");
        Node tao = find();
        if(tao == null){
            System.out.println("- Không có táo cần tìm!");
            return;
        }
        System.out.println("- Nhập táo muốn thêm: ");
        nhapThongtin();
        Node them = new Node(ma, khoiLuong, mauSac);
        if(them == head){
            addHead();
            return;
        }
        them.next = tao.next;
        tao.next = them;
        System.out.println("- Thêm thành công.");
        

    }

}
