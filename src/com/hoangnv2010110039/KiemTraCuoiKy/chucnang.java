package com.hoangnv2010110039.KiemTraCuoiKy;


import java.util.Collections;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.Comparator;

public class chucnang {
    static hanghoa HangHoa;

    static Scanner nhap = new Scanner(System.in);

    static LocalDate date =  LocalDate.now();

    public static void luaChon() {
        System.out.println("==============Menu=============");
        System.out.println("|       1). Them hang hoa      |                             ");
        System.out.println("|       2). Sua hang hoa       |                            ");
        System.out.println("|       3). Xoa hang hoa       |                             ");
        System.out.println("|       4). Tim kiem hang hoa  |                             ");
        System.out.println("|       5). Sap xep hang hoa   |                             ");
        System.out.println("|       6). Thong ke hang hoa  |                             ");
        System.out.println("==============Menu=============");
        System.out.print("    hay nhap su lua chon: ");
        int luachon = nhap.nextInt();
        nhap.nextLine();

        switch (luachon) { 
            case 1:
                chucnang.themHangHoa();
            case 2:
                chucnang.chinhSuaHangHoa();
            case 3:
                chucnang.xoaHangHoa();
            case 4:
                chucnang.timKiemHangHoa();
            case 5:
                chucnang.sapXepHangHoa();
            case 6:
                chucnang.thongKeHangHoa();
        }
    }

    public static int timHangHoaBangmaHangHoa(String timMaHangHoa) {
        for (int chon = 0; chon < testDrive.list.size(); chon++) {
            if (testDrive.list.get(chon).maHangHoa.equals(timMaHangHoa))
                return chon;
        }
        return -1;
    }

    public static void themHangHoa() { // co gi tu chinh sua lai nha
        HangHoa = new hanghoa();

        System.out.print("Hay nhap ma hang hoa: ");
        HangHoa.maHangHoa = nhap.nextLine();

        System.out.print("Hay nhap loai hang hoa: ");
        HangHoa.loaiHangHoa = nhap.nextLine();

        System.out.print("Hay nhap ten hang hoa: ");
        HangHoa.tenHangHoa = nhap.nextLine();

        System.out.print("Hay nhap gia hang hoa: ");
        HangHoa.giaNhapHang = nhap.nextInt();
        nhap.nextLine();

        System.out.print("Hay nhap so luong ton kho hang hoa: ");
        HangHoa.soLuongTonKho = nhap.nextInt();
        nhap.nextLine();

        HangHoa.ngayNhap = date;

        for (int chon = 0; chon < testDrive.list.size(); chon++) {
            if (testDrive.list.get(chon).maHangHoa.equals(HangHoa.maHangHoa)) {
                System.out.println("MA NAY DA TON TAI !!!, VUI LONG NHAP LAI");
                themHangHoa();
            }
        }

        testDrive.list.add(HangHoa);

        luaChon();


    }

    public static void chinhSuaHangHoa() {
        System.out.println("Hay nhap ma hang hoa muon chinh sua: ");
        String ma = nhap.nextLine();

        int hang = -1;
        for (int chon = 0; chon < testDrive.list.size(); chon++) {
            if (testDrive.list.get(chon).maHangHoa.equals(ma)) {
                hang = chon;
                break;
            }
        }

        System.out.println("|         1). Ten                |");
        System.out.println("|         2). Gia                |");
        System.out.println("|         3). So luong ton kho   |");
        System.out.println("Ban muon chinh sua thong tin nao cua hang hoa ?");
        System.out.print("  hay nhap su lua chon: ");
        int luachon = nhap.nextInt();
        nhap.nextLine();

        switch (luachon) {
            case 1: {
                System.out.print("Hay nhap ten muon thay doi: ");
                String tenThayDoi = nhap.nextLine();

                HangHoa.tenHangHoa = tenThayDoi;
                HangHoa.maHangHoa = testDrive.list.get(hang).maHangHoa;
                HangHoa.giaNhapHang = testDrive.list.get(hang).giaNhapHang;
                HangHoa.loaiHangHoa = testDrive.list.get(hang).loaiHangHoa;
                HangHoa.soLuongTonKho = testDrive.list.get(hang).soLuongTonKho;
                HangHoa.ngayNhap = testDrive.list.get(hang).ngayNhap;

                testDrive.list.set(hang, HangHoa);
                break;
            }
            case 2: {
                System.out.print("Hay nhap gia muon thay doi: ");
                int giaThayDoi = nhap.nextInt();

                HangHoa.giaNhapHang = giaThayDoi;
                HangHoa.maHangHoa = testDrive.list.get(hang).maHangHoa;
                HangHoa.tenHangHoa = testDrive.list.get(hang).tenHangHoa;
                HangHoa.loaiHangHoa = testDrive.list.get(hang).loaiHangHoa;
                HangHoa.soLuongTonKho = testDrive.list.get(hang).soLuongTonKho;
                HangHoa.ngayNhap = testDrive.list.get(hang).ngayNhap;

                testDrive.list.set(hang, HangHoa);
                break;
            }
            case 3: {
                System.out.print("Hay nhap so luong muon thay doi: ");
                int soLuongThayDoi = nhap.nextInt();

                HangHoa.soLuongTonKho = soLuongThayDoi;
                HangHoa.maHangHoa = testDrive.list.get(hang).maHangHoa;
                HangHoa.giaNhapHang = testDrive.list.get(hang).giaNhapHang;
                HangHoa.loaiHangHoa = testDrive.list.get(hang).loaiHangHoa;
                HangHoa.tenHangHoa = testDrive.list.get(hang).tenHangHoa;
                HangHoa.ngayNhap = testDrive.list.get(hang).ngayNhap;

                testDrive.list.set(hang, HangHoa);
                break;
            }
        }

        luaChon();
    }

    public static void xoaHangHoa() {
        System.out.print("Hay nhap ma hang hoa can xoa: ");
        String maHangHoa = nhap.nextLine();

        testDrive.list.remove(timHangHoaBangmaHangHoa(maHangHoa));
        System.out.println("Da xoa hang hoa ra khoi he thong.\n");
        testDrive.list.add(HangHoa);

        luaChon();
    }
    
    

    public static void  timKiemHangHoa() {

        int luaChonLoaiHangHoa;

        do {
            System.out.println("Hay lua chon loai hang hoa can tim");
            System.out.println("|         1. Thuc pham       |");
            System.out.println("|         2. Sanh su         |");
            System.out.println("|         3. Dien tu         |");
            System.out.print("\nHay nhap lua chon cua ban: ");

            luaChonLoaiHangHoa = nhap.nextInt();
            nhap.nextLine();
        } while (luaChonLoaiHangHoa > 3 && luaChonLoaiHangHoa < 1);

        System.out.println("\n\n|============KET QUA TIM KIEM============|");

        switch (luaChonLoaiHangHoa) {
            case 1: {
                for (hanghoa chon : testDrive.list) {
                    if (chon.loaiHangHoa.equals("Thuc pham") || chon.loaiHangHoa.equals("thuc pham")) {
                        System.out.println("Ma hang hoa: " + chon.maHangHoa);
                        System.out.println("Ten hang hoa: " + chon.tenHangHoa);
                        System.out.println("Gia hang hoa: " + chon.giaNhapHang);
                        System.out.println("So luong trong kho: " + chon.soLuongTonKho);
                        System.out.println("Ngay nhap hang: " + chon.ngayNhap);
                        System.out.println("------\n");
                    }
                }
            }
            case 2: {
                for (hanghoa chon : testDrive.list) {
                    if (chon.loaiHangHoa.equals("Sanh su") || chon.loaiHangHoa.equals("sanh su")) {
                        System.out.println("Ma hang hoa: " + chon.maHangHoa);
                        System.out.println("Ten hang hoa: " + chon.tenHangHoa);
                        System.out.println("Gia hang hoa: " + chon.giaNhapHang);
                        System.out.println("So luong trong kho: " + chon.soLuongTonKho);
                        System.out.println("Ngay nhap hang: " + chon.ngayNhap);
                        System.out.println("------\n");
                    }
                }
            }
            case 3: {
                for (hanghoa chon : testDrive.list) {
                    if (chon.loaiHangHoa.equals("Dien tu") || chon.loaiHangHoa.equals("dien tu")) {
                        System.out.println("Ma hang hoa: " + chon.maHangHoa);
                        System.out.println("Ten hang hoa: " + chon.tenHangHoa);
                        System.out.println("Gia hang hoa: " + chon.giaNhapHang);
                        System.out.println("So luong trong kho: " + chon.soLuongTonKho);
                        System.out.println("Ngay nhap hang: " + chon.ngayNhap);
                        System.out.println("------\n");
                    }
                }
            }
        }
        testDrive.list.add(HangHoa);

        luaChon();
    }

    public static void sapXepHangHoa() {
        System.out.println("\nHay lua chon loai sap xep hang hoa");
        System.out.println("(1) Gia tang dan");
        System.out.println("(2) Gia giam dan");
        System.out.print("\nNhap lua chon cua ban: ");

        int select = nhap.nextInt();

        if (select == 1)
            sapXepHangHoaTangDan();
        else
            sapXepHangHoaGiamDan();
    }

    public static void sapXepHangHoaTangDan() {
        Collections.sort(testDrive.list, new Comparator<hanghoa>() {

            @Override
            public int compare(hanghoa o1, hanghoa o2) {
                if (o1.giaHangHoa() < o2.giaHangHoa()) {
                    return -1;
                } else {
                    if (o1.giaHangHoa() == o2.giaHangHoa()) {
                        return 0;
                    } else
                        return -1;
                }
            }
        });
    }   
    public static void sapXepHangHoaGiamDan() {
        Collections.sort(testDrive.list, new Comparator<hanghoa>() {

            @Override
            public int compare(hanghoa o1, hanghoa o2) {
                if (o1.giaHangHoa() < o2.giaHangHoa()) {
                    return 1;
                } else {
                    if (o1.giaHangHoa() == o2.giaHangHoa()) {
                        return 0;
                    } else
                        return -1;
                }
            }
        });
        testDrive.list.add(HangHoa);

        luaChon();
    }

    public static void thongKeHangHoa() {
        System.out.println("\n\nHay lua chon loai thong ke hang hoa");
        System.out.println("(1) Tong so luong hang hoa");
        System.out.println("(2) Tong gia tri nhap kho");
        System.out.println("(3) So luong loai hang");
        System.out.print("\nNhap lua chon cua ban: ");

        int select = nhap.nextInt();
        nhap.nextLine();

        switch (select) {
            case 1:
                tongSoLuongHangHoatonKho();
            case 2:
                tongGiaTriHanghoa();
            case 3:
                soLuongHangHoa();
        }
    }

    public static void tongSoLuongHangHoatonKho() {
        int total = 0;
        for (hanghoa chon : testDrive.list) {
            total += chon.soLuongTonKho;
        }
        System.out.println("Tong so luong hang hoa ton kho la " + total);
    }

    public static void tongGiaTriHanghoa() {
        int total= 0;
        for (hanghoa chon : testDrive.list) {
            total += chon.giaNhapHang;
        }
        System.out.println("Tong so luong gia tri hang hoa la " + total);
    }

    public static void soLuongHangHoa() {
        System.out.println("\n\nHay lua chon loai hang hoa muon thong ke so luong");
        System.out.println("(1) Thuc pham");
        System.out.println("(2) Sanh su");
        System.out.println("(3) Dien tu");
        System.out.print("\nNhap lua chon cua ban: ");

        int select = nhap.nextInt();
        nhap.nextLine();

        int total = 0;

        switch (select) {
            case 1: {
                for (hanghoa chon : testDrive.list) {
                    if (chon.loaiHangHoa.equals("Thuc pham") || chon.loaiHangHoa.equals("thuc pham")) {
                        total += chon.soLuongTonKho;
                    }
                }

                System.out.println("Tong so luong ton kho cua hang hoa \"Thuc pham\" la " + total);
            }
            case 2: {
                for (hanghoa chon : testDrive.list) {
                    if (chon.loaiHangHoa.equals("Sanh su") || chon.loaiHangHoa.equals("sanh su")) {
                        total += chon.soLuongTonKho;
                    }
                }

                System.out.println("Tong so luong ton kho cua hang hoa \"Sanh su\" la " + total);
            }
            case 3: {
                for (hanghoa chon : testDrive.list) {
                    if (chon.loaiHangHoa.equals("Dien tu") || chon.loaiHangHoa.equals("dien tu")) {
                        total += chon.soLuongTonKho;
                    }
                }

                System.out.println("Tong so luong ton kho cua hang hoa \"Dien tu\" la " + total);
            }
        }
        testDrive.list.add(HangHoa);

        luaChon();
    }
    
}
