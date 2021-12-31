package vn.edu.giadinh.testbaitap;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.text.SimpleDateFormat;  
import java.util.Scanner;

public class app_function {
    static goods Goods;

    static Scanner input = new Scanner(System.in);

    static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
    static Date date = new Date();  

    public static void Menu() {
        int selection;

        do {
            System.out.println("-----------------------------------");
            System.out.println("Chuong trinh quan ly hang hoa\n");
            System.out.println("(1) Them hang hoa");
            System.out.println("(2) Sua hang hoa");
            System.out.println("(3) Xoa hang hoa");
            System.out.println("(4) Tim kiem hang hoa");
            System.out.println("(5) Sap xep hang hoa");
            System.out.println("(6) Thong ke hang hoa");

            System.out.print("\nHay nhap lua chon cua ban: ");

            selection = input.nextInt();
            input.nextLine();
            UserSelection(selection);
        } while (selection > 6 && selection < 1);
    }

    public static void UserSelection(int sel) {
        switch(sel) {
            case 1: insertGoods();
            case 2: editGoods();
            case 3: deleteGoods();
            case 4: findGoodsWithType();
            case 5: sortGoods();
            case 6: statisticGoods();
        }
    }

    
    public static void returnToSelect(String toWhere, String message) {
        if (message.length() > 0)
            System.out.println(message);

        if (input.nextLine().equals("1")) {
            switch(toWhere) {
                case "Menu": Menu();
                case "Insert": insertGoods();
                case "Edit": editGoods();
                case "Delete": deleteGoods();
                case "Find Type": findGoodsWithType();
            }
        } else Menu();
    }
// vao dis 
    public static boolean checkExistId(String id_check) {
        for(goods index : goods_application.goods_list) {
            if (index.id.equals(id_check))
                return true;
        }
        return false;
    }

    public static int findGoodsWithId(String id_check) {
        for(int index = 0; index < goods_application.goods_list.size(); index++) {
            if (goods_application.goods_list.get(index).id.equals(id_check))
                return index;
        }
        return -1;
    }

    public static boolean checkInsertGoods(String _id, String _type, String _name, int _price, int _left_in_stock) {

        if (_id.isBlank()) {
            System.out.println("\n(?) Ma hang hoa chua nhap.");
            return false;
        }

        if (checkExistId(_id)) {
            System.out.println("\n(?) Ma hang hoa da ton tai.");
            return false;
        }

        if (_type.isBlank()) {
            System.out.println("\n(?) Loai san pham chua nhap.");
            return false;
        }

        if (_name.isBlank()) {
            System.out.println("\n(?) Ten san pham chua nhap.");
            return false;
        }

        if (_price < 0) {
            System.out.println("(?) Gia san pham khong the nho hon 0.");
            return false;
        }

        if (_left_in_stock < 0) {
            System.out.println("(?) So luong ton kho khong the nho hon 0.");
            return false;
        }

        return true;
    }

    public static void insertGoods() {
        
        Goods = new goods();

        System.out.println("\n\n-----------------------------------");
        System.out.print("Nhap ma hang: ");
        Goods.id = input.nextLine();

        System.out.print("Nhap loai hang hoa (Thuc pham, Sanh su, Dien tu): ");
        Goods.type = input.nextLine();

        System.out.print("Nhap ten hang hoa: ");
        Goods.name = input.nextLine();

        System.out.print("Nhap gia hang hoa (VND): ");
        Goods.price = input.nextInt();
        input.nextLine();

        System.out.print("Nhap so luong ton kho: ");
        Goods.left_in_stock = input.nextInt();
        input.nextLine();

        Goods.import_date = formatter.format(date);

        if (checkInsertGoods(Goods.id, Goods.type, Goods.name, Goods.price, Goods.left_in_stock)) {
            goods_application.goods_list.add(Goods);

            System.out.println("\n\nDa them hang hoa voi thong tin sau vao he thong!");
            System.out.println("-----------------------------------");
            System.out.println("Ma hang hoa: " + Goods.id);
            System.out.println("Ten hang hoa: " + Goods.name);
            System.out.println("Loai hang hoa: " + Goods.type);
            System.out.println("Gia hang hoa: " + Goods.price);
            System.out.println("So luong ton kho: " + Goods.left_in_stock);
            System.out.println("Ngay nhap hang: " + Goods.import_date);
            System.out.println("-----------------------------------\n");

            returnToSelect("Insert", "De tiep tuc them hang hoa vui long nhap 1, de quay tro lai ve chuong trinh chinh vui long nhap bat ky.");
        } else {
            System.out.println("Da xay ra loi, vui long nhap lai.\n");
            insertGoods();
        }
    }

    public static void editGoods() {
        System.out.println("\n\n-----------------------------------");
        System.out.print("Hay nhap ma hang hoa muon chinh sua thong tin: ");
        String id_to_find = input.nextLine();

        if (!checkExistId(id_to_find)) {
            System.out.println("(?) Khong tim thay hang hoa tuong ung voi ma nay.\n");
            
            returnToSelect("Edit", "De tiep tuc chinh sua hang hoa vui long nhap 1, de quay tro lai ve chuong trinh vui long nhap bat ky.");
        }

        int index = findGoodsWithId(id_to_find);
        if (index < 0) {
            System.out.println("(?) Loi khong xac dinh, vui long thu lai.\n");

            returnToSelect("Edit", "De tiep tuc chinh sua hang hoa vui long nhap 1, de quay tro lai ve chuong trinh vui long nhap bat ky.");
        }  

        int select;

        do {
            System.out.println("\n\nBan muon chinh sua thong tin nao cua hang hoa \"" + id_to_find + "\" ?\n");
            System.out.println("(1) Ten hang hoa");
            System.out.println("(2) Loai hang hoa");
            System.out.println("(3) Gia hang hoa");
            System.out.println("(4) So luong ton kho");
            System.out.print("\nHay nhap lua chon cua ban: ");

            select = input.nextInt();
            input.nextLine();
        } while (select > 3 && select < 1);

        Goods = new goods();

        switch(select) {
            case 1: {
                System.out.println("\n\n> Ten hang hoa hien tai la \"" + goods_application.goods_list.get(index).name + "\"");
                System.out.print("Hay ten hang hoa ma ban muon thay doi: ");

                Goods.name = input.nextLine();
                Goods.type = goods_application.goods_list.get(index).type;
                Goods.id = goods_application.goods_list.get(index).id;
                Goods.price = goods_application.goods_list.get(index).price;
                Goods.left_in_stock = goods_application.goods_list.get(index).left_in_stock;
                Goods.import_date = goods_application.goods_list.get(index).import_date;
                break;
            }
            case 2: {
                System.out.println("\n\n> Loai hang hoa hien tai la \"" + goods_application.goods_list.get(index).type + "\"");
                System.out.print("Hay nhap loai hang hoa ban muon thay doi: ");

                Goods.type = input.nextLine();
                Goods.name = goods_application.goods_list.get(index).name;
                Goods.id = goods_application.goods_list.get(index).id;
                Goods.price = goods_application.goods_list.get(index).price;
                Goods.left_in_stock = goods_application.goods_list.get(index).left_in_stock;
                Goods.import_date = goods_application.goods_list.get(index).import_date;
                break;
            }
            case 3: {
                System.out.println("\n\n> Gia hang hoa hien tai la \"" + goods_application.goods_list.get(index).price + "\"");
                System.out.print("Hay nhap gia hang hoa ban muon thay doi: ");

                Goods.price = input.nextInt();
                input.nextLine();
                Goods.type = goods_application.goods_list.get(index).type;
                Goods.id = goods_application.goods_list.get(index).id;
                Goods.name = goods_application.goods_list.get(index).name;
                Goods.left_in_stock = goods_application.goods_list.get(index).left_in_stock;
                Goods.import_date = goods_application.goods_list.get(index).import_date;
                break;
            }

            case 4: {
                System.out.println("\n\n> So luong ton kho hien tai la \"" + goods_application.goods_list.get(index).left_in_stock + "\"");
                System.out.print("Hay nhap so luong ton kho hang hoa ban muon thay doi: ");

                Goods.left_in_stock = input.nextInt();
                input.nextLine();
                Goods.price =goods_application.goods_list.get(index).price; 
                Goods.type = goods_application.goods_list.get(index).type;
                Goods.id = goods_application.goods_list.get(index).id;
                Goods.name = goods_application.goods_list.get(index).name;
                Goods.import_date = goods_application.goods_list.get(index).import_date;
                break;
            }
        }

        goods_application.goods_list.set(index, Goods);
        System.out.println("\n\nDa dieu chinh thong tin hang hoa thanh cong!");

        System.out.println("-----------------------------------");
        System.out.println("Ma hang hoa: " + Goods.id);
        System.out.println("Ten hang hoa: " + Goods.name);
        System.out.println("Loai hang hoa: " + Goods.type);
        System.out.println("Gia hang hoa: " + Goods.price);
        System.out.println("So luong ton kho: " + Goods.left_in_stock);
        System.out.println("Ngay nhap hang: " + Goods.import_date);
        System.out.println("-----------------------------------");

        returnToSelect("Edit", "De tiep tuc chinh sua hang hoa vui long nhap 1, de quay tro lai ve chuong trinh vui long nhap bat ky.");
    }

    public static void deleteGoods() {
        System.out.println("\n\n-----------------------------------");
        System.out.print("Hay nhap ma hang hoa can xoa: ");
        String id = input.nextLine();

        goods_application.goods_list.remove(findGoodsWithId(id));
        System.out.println("Da xoa hang hoa ra khoi he thong.\n");

        returnToSelect("Delete", "De tiep tuc xoa hang hoa vui long nhap 1, de quay tro lai ve chuong trinh vui long nhap bat ky.");
    }

    public static void findGoodsWithType() {

        int select_type;

        do {
            System.out.println("Hay lua chon loai hang hoa can tim");
            System.out.println("1. Thuc pham");
            System.out.println("2. Sanh su");
            System.out.println("3. Dien tu");
            System.out.print("\nHay nhap lua chon cua ban: ");

            select_type = input.nextInt();
            input.nextLine();
        } while (select_type > 3 && select_type < 1);

        System.out.println("\n\n|------------KET QUA TIM KIEM------------|");
        
        switch(select_type) {
            case 1: {
                for(goods index : goods_application.goods_list) {
                    if (index.type.equals("Thuc pham") || index.type.equals("thuc pham")) {
                        System.out.println("Ma hang hoa: " + index.id);
                        System.out.println("Ten hang hoa: " + index.name);
                        System.out.println("Gia hang hoa: " + index.price);
                        System.out.println("So luong trong kho: " + index.left_in_stock);
                        System.out.println("Ngay nhap hang: " + index.import_date);
                        System.out.println("------\n");
                    }
                }
            }
            case 2: {
                for(goods index : goods_application.goods_list) {
                    if (index.type.equals("Sanh su") || index.type.equals("sanh su")) {
                        System.out.println("Ma hang hoa: " + index.id);
                        System.out.println("Ten hang hoa: " + index.name);
                        System.out.println("Gia hang hoa: " + index.price);
                        System.out.println("So luong trong kho: " + index.left_in_stock);
                        System.out.println("Ngay nhap hang: " + index.import_date);
                        System.out.println("------\n");
                    }
                }
            }
            case 3: {
                for(goods index : goods_application.goods_list) {
                    if (index.type.equals("Dien tu") || index.type.equals("dien tu")) {
                        System.out.println("Ma hang hoa: " + index.id);
                        System.out.println("Ten hang hoa: " + index.name);
                        System.out.println("Gia hang hoa: " + index.price);
                        System.out.println("So luong trong kho: " + index.left_in_stock);
                        System.out.println("Ngay nhap hang: " + index.import_date);
                        System.out.println("------\n");
                    }
                }
            }
        }

        returnToSelect("Find Type", "De tiep tuc tim kiem san pham theo loai vui long nhap 1, de quay tro lai chuong trinh chinh vui long nhap bat ky.");
    }

    public static void sortGoods() {
        System.out.println("\n\nHay lua chon loai sap xep hang hoa");
        System.out.println("(1) Gia tang dan");
        System.out.println("(2) Gia giam dan");
        System.out.print("\nNhap lua chon cua ban: ");

        int select = input.nextInt();

        if (select == 1)
            sortGoodsAscending();
        else
            sortGoodsDescending();
    }

    public static void sortGoodsAscending() {
        Collections.sort(goods_application.goods_list, new Comparator<goods>() {

            @Override
            public int compare(goods o1, goods o2) {
                if (o1.getGoodsPrice() < o2.getGoodsPrice()) {
                    return -1;
                } else {
                    if (o1.getGoodsPrice() == o2.getGoodsPrice()) {
                        return 0;
                    } else
                        return 1;
                }
            }
        });

        System.out.println("\n\nDa sap xep san pham theo thu tu gia tang dan!\n");
        Menu();
    }

    public static void sortGoodsDescending() {
        Collections.sort(goods_application.goods_list, new Comparator<goods>() {

            @Override
            public int compare(goods o1, goods o2) {
                if (o1.getGoodsPrice() < o2.getGoodsPrice()) {
                    return 1;
                } else {
                    if (o1.getGoodsPrice() == o2.getGoodsPrice()) {
                        return 0;
                    } else
                        return -1;
                }
            }
        });

        System.out.println("\n\nDa sap xep san pham theo thu tu gia giam dan!\n");
        Menu();
    }

    public static void statisticGoods() {
        System.out.println("\n\nHay lua chon loai thong ke hang hoa");
        System.out.println("(1) Tong so luong hang hoa");
        System.out.println("(2) Tong gia tri nhap kho");
        System.out.println("(3) So luong loai hang");
        System.out.print("\nNhap lua chon cua ban: ");

        int select = input.nextInt();
        input.nextLine();

        switch(select) {
            case 1: totalAmountGoods();
            case 2: totalPriceGoods();
            case 3: quantityEachGoods();
        }
    }

    public static void totalAmountGoods() {
        int total = 0;
        for(goods index : goods_application.goods_list) {
            total += index.left_in_stock;
        }
        System.out.println("Tong so luong hang hoa ton kho la " + total);
    }

    public static void totalPriceGoods() {
        int total = 0;
        for(goods index : goods_application.goods_list) {
            total += index.price;
        }
        System.out.println("Tong so luong gia tri hang hoa la " + total);
    }
    
    public static void quantityEachGoods() {
        System.out.println("\n\nHay lua chon loai hang hoa muon thong ke so luong");
        System.out.println("(1) Thuc pham");
        System.out.println("(2) Sanh su");
        System.out.println("(3) Dien tu");
        System.out.print("\nNhap lua chon cua ban: ");

        int select = input.nextInt();
        input.nextLine();

        int total = 0;

        switch(select) {
            case 1: {
                for(goods index : goods_application.goods_list) {
                    if (index.type.equals("Thuc pham") || index.type.equals("thuc pham")) {
                        total += index.left_in_stock;
                    }
                }

                System.out.println("Tong so luong ton kho cua hang hoa \"Thuc pham\" la " + total);
            }
            case 2: {
                for(goods index : goods_application.goods_list) {
                    if (index.type.equals("Sanh su") || index.type.equals("sanh su")) {
                        total += index.left_in_stock;
                    }
                }

                System.out.println("Tong so luong ton kho cua hang hoa \"Sanh su\" la " + total);
            }
            case 3: {
                for(goods index : goods_application.goods_list) {
                    if (index.type.equals("Dien tu") || index.type.equals("dien tu")) {
                        total += index.left_in_stock;
                    }
                }

                System.out.println("Tong so luong ton kho cua hang hoa \"Dien tu\" la " + total);
            }
        }
    }
}
