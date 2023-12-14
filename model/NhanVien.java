package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NhanVien extends ConNguoi {
    Scanner sc = new Scanner(System.in);
    private String MaNV;
    private String MaPhong;
    private String ChucVu;
    private String LoaiHD;
    private String NgayKy;
    private String NgayHetHan;
    private String Gmail;
    private double luongCb;
    private String timeUpdate;
    private List<DeAn> cacDeAnThamGia;

    public List<DeAn> getCacDeAnThamGia() {
        return this.cacDeAnThamGia;
    }

    public void setCacDeAnThamGia(List<DeAn> cacDeAnThamGia) {
        this.cacDeAnThamGia = cacDeAnThamGia;
    }

    private HopDong hopdong;
    private PhongBan phongban;

    public HopDong getHopdong() {
        return this.hopdong;
    }

    public void setHopdong(HopDong hopdong) {
        this.hopdong = hopdong;
    }

    public PhongBan getPhongban() {
        return this.phongban;
    }

    public void setPhongban(PhongBan phongban) {
        this.phongban = phongban;
    }

    public String getTimeUpdate() {
        return this.timeUpdate;
    }

    public void setTimeUpdate(String timeUpdate) {
        this.timeUpdate = timeUpdate;
    }

    public double getLuongCb() {
        return this.luongCb;
    }

    public void setLuongCb(double luongCb) {
        this.luongCb = luongCb;
    }

    public String getMaNV() {
        return this.MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMaPhong() {
        return this.MaPhong;
    }

    public void setMaPhong(String MaPhong) {
        this.MaPhong = MaPhong;
    }

    public String getChucVu() {
        return this.ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }

    public String getLoaiHD() {
        return this.LoaiHD;
    }

    public void setLoaiHD(String LoaiHD) {
        this.LoaiHD = LoaiHD;
    }

    public String getNgayKy() {
        return this.NgayKy;
    }

    public void setNgayKy(String NgayKy) {
        this.NgayKy = NgayKy;
    }

    public String getNgayHetHan() {
        return this.NgayHetHan;
    }

    public void setNgayHetHan(String NgayHetHan) {
        this.NgayHetHan = NgayHetHan;
    }

    public String getGmail() {
        return this.Gmail;
    }

    public void setGmail(String Gmail) {
        this.Gmail = Gmail;
    }

    public NhanVien() {
        super();
        hopdong = new HopDong();
        phongban = new PhongBan();
    }

    public NhanVien(String manv, String Hoten, String MaPhong, String ChucVu, String LoaiHD, String NgayKi,
            String Ngayhh, String Gmail) {
        this.MaNV = manv;
        this.HoTen = Hoten;
        this.MaPhong = MaPhong;
        this.ChucVu = ChucVu;
        this.LoaiHD = LoaiHD;
        this.NgayKy = NgayKi;
        this.NgayHetHan = Ngayhh;
        this.Gmail = Gmail;
    }

    public NhanVien(String MaNV, String LoaiHD, String MaPhong) {
        this.HoTen = MaNV;
        this.LoaiHD = LoaiHD;
        this.MaPhong = MaPhong;
    }

    public NhanVien(String HoTen, String GioiTinh, String DiaChi, String QueQuan, String NgaySinh, String SoDT,
            String DanToc, String TonGiao, String HocVan, String MaNV, String MaPhong,
            String ChucVu, String LoaiHD, String NgayKiHD, String NgayHetHan, String Gmail, double luongCb,
            String timeUpdate) {
        super(HoTen, GioiTinh, DiaChi, QueQuan, NgaySinh, SoDT, DanToc, TonGiao, HocVan);
        this.MaNV = MaNV;
        this.MaPhong = MaPhong;
        this.ChucVu = ChucVu;
        this.LoaiHD = LoaiHD;
        this.NgayKy = NgayKiHD;
        this.NgayHetHan = NgayHetHan;
        this.Gmail = Gmail;
        this.luongCb = luongCb;
        this.timeUpdate = timeUpdate;

    }

    public NhanVien(NhanVien nhanvien, HopDong hopdong, PhongBan phongban) {
        this.MaNV = nhanvien.MaNV;
        this.HoTen = nhanvien.HoTen;
        this.hopdong = hopdong;
        this.phongban = phongban;
        this.Gmail = nhanvien.Gmail;
    }

    public void input() {
        check_setHoten();
        check_setMaNV();
        setMaPhong();
        hopdong.check_setViTri();
        hopdong.check_setLoaiHD();
        hopdong.check_setNgayKy();
        hopdong.check_setNgayHetHan();
        check_setGmail();
    }

    public void check_setHoten() {
        String ten;
        do {
            System.out.println("Nhap Ho Ten:");
            ten = input.nextLine();
            if (check.nullInput(ten)) {
                System.out.println("Khong duoc de trong ho ten");
            }
            setHoTen(ten);

        } while (check.nullInput(ten));
    }

    public void check_setMaNV() {
        String MaNV;
        do {

            System.out.println("Nhap Ma Nhan Vien");
            MaNV = input.nextLine();
            if (check.nullInput(MaNV)) {
                System.out.println("Khong duoc de trong Ma Nhan Vien");

            }
            if (!check.checkMaNv(MaNV)) {
                System.out.println("Ma Nhan Vien Phai Theo Dinh Dang NVxxxx voi xxxx la cac chu so");
            }
            setMaNV(MaNV);

        } while (check.nullInput(MaNV) || !check.checkMaNv(MaNV));

    }

    public void check_setLoaiHD() {
        hopdong.input();
    }

    public void check_setGmail() {
        String Gmail;
        do {
            System.out.println("Nhap Gmail");
            Gmail = input.nextLine();
            if (check.nullInput(Gmail)) {
                System.out.println("Khong duoc de trong Gmail");
            }
            if (!check.checkEmail(Gmail)) {
                System.out.println("Gmail Khong Dung Dinh Dang");
            }
            setGmail(Gmail);

        } while (check.nullInput(Gmail) || !check.checkEmail(Gmail));
    }

    // MANV,ho ten,ma phong,chuc vu,loai hd,ngay ky,ngay het
    // han,gmail,luongCb,capnhap
    public String toString() {
        return getMaNV() + "," + getHoTen() + "," + getMaPhong() + "," + getChucVu() + "," +
                getLoaiHD() + "," + getNgayKy() + "," + getNgayHetHan() + "," + getGmail() + "," + getTimeUpdate();
    }

    // thong tin ca nhan
    // HoTen,GioiTinh,DiaChi,QueQuan,NgaySinh,SoDT,DanToc,TonGiao,HocVan,MaNV,MaPhong,ChucVu,LoaiHD,NgayKiHD,NgayHetHan,Gmail,capnhat
    public String output() {
        return super.output() + "," + getMaNV() + "," + getMaPhong() + "," + getChucVu() + "," +
                getLoaiHD() + "," + getNgayKy() + "," + getNgayHetHan() + "," + getGmail() + "," + getLuongCb() + ","
                + getTimeUpdate();
    }

}