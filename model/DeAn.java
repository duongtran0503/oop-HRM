package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeAn {
    private String maDeAn;
    private String tenDeAn;
    private String ngayTao;
    private int soThanhVien;
    private List<NhanVien> cacNhanVienThamGia;

    public DeAn(String maDeAn, String tenDeAn, String ngayTao, int soThanhVien) {
        this.maDeAn = maDeAn;
        this.tenDeAn = tenDeAn;
        this.ngayTao = ngayTao;
        this.soThanhVien = soThanhVien;
        this.cacNhanVienThamGia = new ArrayList<>();

    }

    public void themThanhVien(NhanVien nhanVien) {
        cacNhanVienThamGia.add(nhanVien);

    }

    public String getMaDeAn() {
        return maDeAn;
    }

    public void setMaDeAn(String maDeAn) {
        this.maDeAn = maDeAn;
    }

    public String getTenDeAn() {
        return tenDeAn;
    }

    public void setTenDeAn(String tenDeAn) {
        this.tenDeAn = tenDeAn;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public int getSoThanhVien() {
        return soThanhVien;
    }

    public void setSoThanhVien(int soThanhVien) {
        this.soThanhVien = soThanhVien;
    }

    public List<NhanVien> getcacNhanVienThamGia() {
        return cacNhanVienThamGia;
    }

    @Override
    public String toString() {
        return "DeAn{" +
                "maDeAn='" + maDeAn + '\'' +
                ", tenDeAn='" + tenDeAn + '\'' +
                ", ngayTao='" + ngayTao + '\'' +
                ", soThanhVien=" + soThanhVien +

                '}';
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập Mã Dự Án: ");
        setMaDeAn(scanner.nextLine());

        System.out.print("Nhập Tên Dự Án: ");
        setTenDeAn(scanner.nextLine());

        System.out.print("Nhập Ngày Tạo: ");
        setNgayTao(scanner.nextLine());

        System.out.print("Nhập Số Thành Viên: ");
        setSoThanhVien(scanner.nextInt());
        scanner.nextLine();

        scanner.close();

    }

}