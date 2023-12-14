package model;

import java.util.Scanner;

public class ConNguoi {
    Scanner sc = new Scanner(System.in);
    protected String HoTen;
    protected String GioiTinh;
    protected String DiaChi;
    protected String QueQuan;
    protected String NgaySinh;
    protected String SoDT;
    protected String DanToc;
    protected String TonGiao;
    protected String HocVan;

    public String getHoTen() {
        return this.HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getGioiTinh() {
        return this.GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getDiaChi() {
        return this.DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getQueQuan() {
        return this.QueQuan;
    }

    public void setQueQuan(String QueQuan) {
        this.QueQuan = QueQuan;
    }

    public String getNgaySinh() {
        return this.NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getSoDT() {
        return this.SoDT;
    }

    public void setSoDT(String SoDT) {
        this.SoDT = SoDT;
    }

    public String getDanToc() {
        return this.DanToc;
    }

    public void setDanToc(String DanToc) {
        this.DanToc = DanToc;
    }

    public String getTonGiao() {
        return this.TonGiao;
    }

    public void setTonGiao(String TonGiao) {
        this.TonGiao = TonGiao;
    }

    public String getHocVan() {
        return this.HocVan;
    }

    public void setHocVan(String HocVan) {
        this.HocVan = HocVan;
    }

    public ConNguoi() {

    }

    public ConNguoi(String HoTen, String GioiTinh, String DiaChi, String QueQuan, String NgaySinh, String SoDT,
            String DanToc, String TonGiao, String HocVan) {
        this.HoTen = HoTen;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.QueQuan = QueQuan;
        this.NgaySinh = NgaySinh;
        this.SoDT = SoDT;
        this.DanToc = DanToc;
        this.TonGiao = TonGiao;
        this.HocVan = HocVan;
    }

    public void input() {
        System.out.print("Nhap Ho Ten: ");
        String hoTen = sc.nextLine();
        setHoTen(hoTen);
        System.out.print("Nhap Gioi Tinh: ");
        String goiTinh = sc.nextLine();
        setGioiTinh(goiTinh);
        System.out.print("Nhap Dia Chi: ");
        String diaChi = sc.nextLine();
        setDiaChi(diaChi);
        System.out.print("Nhap Que Quan: ");
        String queQuan = sc.nextLine();
        setQueQuan(queQuan);
        System.out.print("Nhap Ngay Sinh: ");
        String ngaySinh = sc.nextLine();
        setNgaySinh(ngaySinh);
        System.out.print("Nhap So DT: ");
        String DT = sc.nextLine();
        setSoDT(DT);
        System.out.print("Nhap Dan Toc: ");
        String DanToc = sc.nextLine();
        setDanToc(DanToc);
        System.out.print("Nhap Ton Giao: ");
        String TonGiao = sc.nextLine();
        setTonGiao(TonGiao);
        System.out.print("Nhap Hoc Van: ");
        String HocVan = sc.nextLine();
        setHocVan(HocVan);
    }
    // HoTen,GioiTinh,DiaChi,QueQuan,NgaySinh,SoDT,DanToc,TonGiao,HocVan,MaNV,MaPhong,ChucVu,LoaiHD,NgayKiHD,NgayHetHan,Gmail,capnhat

    public String toString() {
        return getHoTen() + "," + getGioiTinh() + "," + getDiaChi() + "," + getQueQuan() + "," + getNgaySinh() + ","
                + getSoDT() + "," + getDanToc() + "," + getTonGiao() + "," + getHocVan();
    }

    public String output() {
        return getHoTen() + "," + getGioiTinh() + "," + getDiaChi() + "," + getQueQuan() + "," + getNgaySinh() + ","
                + getSoDT() + "," + getDanToc() + "," + getTonGiao() + "," + getHocVan();
    }
}