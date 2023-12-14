package model;

import java.util.Scanner;

public class HopDong {
    Scanner sc = new Scanner(System.in);
    private String NgayKiHD;
    private String NgayHetHan;
    private String LuongCB;
    private String ViTri;
    private String ID;
    private String loaiHD;

    public HopDong() {
        this.NgayKiHD = "";
        this.NgayHetHan = "";
        this.LuongCB = "";
        this.ViTri = "";
        this.ID = "";
        this.loaiHD = "";
    }

    public HopDong(String NgayKiHD, String NgayHetHan, String LuongCB, String ViTri, String ID, String loaiHD) {
        this.NgayKiHD = NgayKiHD;
        this.NgayHetHan = NgayHetHan;
        this.LuongCB = LuongCB;
        this.ViTri = ViTri;
        this.ID = ID;
        this.loaiHD = loaiHD;

    }

    public HopDong(HopDong a) {
        this.NgayKiHD = a.NgayKiHD;
        this.NgayHetHan = a.NgayHetHan;
        this.LuongCB = a.LuongCB;
        this.ViTri = a.ViTri;
        this.ID = a.ID;
        this.loaiHD = a.loaiHD;
    }

    public void setLoaiHD(String loaiHD) {
        this.loaiHD = loaiHD;
    }

    public String getLoaiHD() {
        return loaiHD;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public String getID() {
        return ID;
    }

    public String getNgayKiHD() {
        return NgayKiHD;
    }

    public void setNgayKiHD(String ngayKiHD) {
        NgayKiHD = ngayKiHD;
    }

    public String getNgayHetHan() {
        return NgayHetHan;
    }

    public void setNgayHetHan(String ngayHetHan) {
        NgayHetHan = ngayHetHan;
    }

    public String getLuongCB() {
        return LuongCB;
    }

    public void setLuongCB(String luongCB) {
        LuongCB = luongCB;
    }

    public String getViTri() {
        return ViTri;
    }

    public void setViTri(String viTri) {
        ViTri = viTri;
    }

    checkError check = new checkError();

    public void input() {
        check_setID();
        check_setLoaiHD();
        check_setNgayKy();
        check_setNgayHetHan();
        check_setLuongCB();
        check_setViTri();
    }

    public void check_setLoaiHD() {
        String loaiHD = "";
        do {
            System.out.println("Nhap Loai Hop Dong");
            loaiHD = sc.nextLine();
            if (check.nullInput(loaiHD)) {
                System.out.println("Khong duoc de trong Loai Hop Dong");
            }
            if (!check.checkLoaiHD(loaiHD)) {
                System.out.println("Vui Long Nhap 'chinhthuc'hoac'thoivu'");
            }
            setLoaiHD(loaiHD);

        } while (check.nullInput(loaiHD) || !check.checkLoaiHD(loaiHD));

    }

    public void check_setID() {
        String ID = "";
        do {
            System.out.println("Nhap ID Hop Dong:");
            ID = sc.nextLine();
            if (check.nullInput(ID)) {
                System.out.println("Khong duoc de trong ID");
            }
            if (!check.checkIDHD(ID)) {
                System.out.println("Vui Long Nhap Theo Dinh Dang:HDxxxx( voi x la chu so)");
            }
            setID(ID);
        } while (check.nullInput(ID) || !check.checkIDHD(ID));
    }

    public void check_setNgayKy() {
        String ngayKy = "";
        do {
            System.out.println("Nhap Ngay Ki Hop Dong: ");
            ngayKy = sc.nextLine();
            if (check.nullInput(ngayKy)) {
                System.out.println("Khong duoc de trong Ngay Ki Hop Dong");
            }
            if (!check.dateFormat(ngayKy)) {
                System.out.println("Vui Long Nhap Dung Dinh Dang Ngay Thang Nam (dd/mm/yyyy)");
            }
            setNgayKiHD(ngayKy);
        } while (check.nullInput(ngayKy) || !check.dateFormat(ngayKy));
    }

    public void check_setNgayHetHan() {
        String ngayHet = "";
        do {
            System.out.print("Nhap Ngay Het Han: ");
            ngayHet = sc.nextLine();
            if (check.nullInput(ngayHet)) {
                System.out.println("Khong Duoc De Trong Ngay Het Han");
            }
            if (!check.dateFormat(ngayHet)) {
                System.out.println("Vui Long Nhap Dung Dinh Dang Ngay Thang Nam (dd/mm/yyyy)");
            }
            setNgayHetHan(ngayHet);
        } while (check.nullInput(ngayHet) || !check.dateFormat(ngayHet));
    }

    public void check_setLuongCB() {
        String Luong = "";
        do {
            System.out.print("Nhap Luong Co Ban: ");
            Luong = sc.nextLine();
            if (check.nullInput(Luong)) {
                System.out.println("Luong Khong Duoc De Trong");
            }
            if (!check.Luong(Luong)) {
                System.out.println("Luong Phai Tu:(0.1->+oo)");
            }
            setLuongCB(Luong);
        } while (check.nullInput(Luong) || !check.Luong(Luong));

    }

    public boolean isValidRole(String input) {
        return input.matches("NV|QL");
    }

    public void check_setViTri() {

        String ViTri;
        do {
            System.out.print("Nhap Vi Tri: ");
            ViTri = sc.nextLine();
            if (check.nullInput(ViTri)) {
                System.out.println("Vi Tri Khong Duoc De Trong");
            }
            if (!check.checkViTri(ViTri)) {
                System.out.println("Chi Duoc Chon 1 Trong Hai Vi Tri 'NV' hoac 'QL'");
            }
            setViTri(ViTri);
        } while (check.nullInput(ViTri) || !check.checkViTri(ViTri));

    }

    public String toString() {
        return getID() + "|" + getLoaiHD() + "|" + getNgayKiHD() + "|" + getNgayHetHan() + "|" + getLuongCB() + "|"
                + getViTri();
    }

    public static void main(String[] args) {
        HopDong a = new HopDong();
        a.input();
        System.out.println(a.toString());

    }
}