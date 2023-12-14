package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CaLam {
    Scanner sc = new Scanner(System.in);
    private int SoGioLam;
    private String LoaiCaLam;
    private double HeSoChamCong;
    private List<NhanVien> cacNhanVienThamGia;

    public CaLam() {
        this.SoGioLam = 0;
        this.LoaiCaLam = "";
        this.HeSoChamCong = 0;
    }

    public CaLam(int SoGioLam, String LoaiCaLam, double HeSoChamCong) {
        this.SoGioLam = SoGioLam;
        this.LoaiCaLam = LoaiCaLam;
        this.HeSoChamCong = HeSoChamCong;

        this.cacNhanVienThamGia = new ArrayList<>();
    }

    public void themThanhVien(NhanVien nhanVien) {
        cacNhanVienThamGia.add(nhanVien);
    }

    public int getSoGioLam() {
        return SoGioLam;
    }

    public void setSoGioLam(int SoGioLam) {
        this.SoGioLam = sc.nextInt();
    }

    public String getLoaiCaLam() {
        return LoaiCaLam;
    }

    public void setLoaiCaLam(String LoaiCaLam) {
        this.LoaiCaLam = sc.nextLine();
    }

    public double getHeSoChamCong() {
        return HeSoChamCong;
    }

    public void setHeSoChamCong(double HeSoChamCong) {
        this.HeSoChamCong = sc.nextDouble();
    }

    public List<NhanVien> getcacNhanVienThamGia() {
        return cacNhanVienThamGia;
    }

    public void input() {
        System.out.print("Nhap so gio lam: ");
        setSoGioLam(SoGioLam);
        sc.nextLine();
        System.out.print("Nhap loai ca lam: ");
        setLoaiCaLam(LoaiCaLam);
        System.out.print("Nhap he so cham cong: ");
        setHeSoChamCong(HeSoChamCong);
    }

    public String toString() {
        return "so gio lam " + getSoGioLam() + ", loai ca lam la " + getLoaiCaLam() + ", va he so cham cong la "
                + getHeSoChamCong();
    }

}