package model;

import java.util.Scanner;

public class PhongBan {
    Scanner input = new Scanner(System.in);
    checkError check = new checkError();
    private String maPhongBan;
    private String tenPhongBan;
    private String ngayThanhLap;

    public PhongBan() {
        this.maPhongBan = "";
        this.tenPhongBan = "";
        this.ngayThanhLap = "";
    }

    public PhongBan(String maPhongBan, String tenPhongBan, String ngayThanhLap) {
        this.maPhongBan = maPhongBan;
        this.tenPhongBan = tenPhongBan;
        this.ngayThanhLap = ngayThanhLap;
    }

    public PhongBan(PhongBan a) {
        this.maPhongBan = a.maPhongBan;
        this.tenPhongBan = a.tenPhongBan;
        this.ngayThanhLap = a.ngayThanhLap;
    }

    public String getMaPhongBan() {
        return maPhongBan;
    }

    public void setMaPhongBan(String maPhongBan) {
        this.maPhongBan = maPhongBan;
    }

    public String getTenPhongBan() {
        return tenPhongBan;
    }

    public void setTenPhongBan(String tenPhongBan) {
        this.tenPhongBan = tenPhongBan;
    }

    public String getNgayThanhLap() {
        return ngayThanhLap;
    }

    public void setNgayThanhLap(String ngayThanhLap) {
        this.ngayThanhLap = ngayThanhLap;
    }

    private String getInput(String message) {
        System.out.println(message);
        return input.nextLine();
    }

    public void check_setMaPhong() {
        String maPhong;
        do {
            maPhong = getInput("Nhap Ma Phong Ban");
            if (check.nullInput(maPhong)) {
                System.out.println("Khong duoc de trong ma phong");
            } else if (!check.checkMaPhong(maPhong)) {
                System.out.println("Ma Phong khong dung dinh dang (pxxxx) voi x la so");
            } else {
                setMaPhongBan(maPhong);
            }
        } while (check.nullInput(maPhong) || !check.checkMaPhong(maPhong));
    }

    public void check_setTenPhong() {
        String tenPhong;
        do {
            tenPhong = getInput("Nhap Ten Phong");
            if (check.nullInput(tenPhong)) {
                System.out.println("Khong duoc de trong ten phong");
            } else {
                setTenPhongBan(tenPhong);
            }
        } while (check.nullInput(tenPhong));
    }

    public void check_setNgayThanhLap() {
        String ngayThanhLap;
        do {
            ngayThanhLap = getInput("Nhap Ngay Thanh Lap");
            if (check.nullInput(ngayThanhLap)) {
                System.out.println("Khong duoc de trong ngay thanh lap");
            } else if (!check.dateFormat(ngayThanhLap)) {
                System.out.println("Ngay Thanh Lap khong dung dinh dang (dd/mm/yyyy)");
            } else {
                setNgayThanhLap(ngayThanhLap);
            }
        } while (check.nullInput(ngayThanhLap) || !check.dateFormat(ngayThanhLap));
    }

    public void input() {
        check_setMaPhong();
        check_setTenPhong();
        check_setNgayThanhLap();
    }

    public String toString() {
        return getMaPhongBan() + "|" + getTenPhongBan() + "|" + getNgayThanhLap();
    }
}