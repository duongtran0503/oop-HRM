package model;

import java.util.Scanner;

public class actionNhanVien implements ArraysInterface {
    Scanner input = new Scanner(System.in);
    private NhanVien[] danhSachNhanVien;
    private int kt = 0;
    checkError check = new checkError();

    public actionNhanVien() {
        danhSachNhanVien = new NhanVien[10];
        this.kt = 0;
    }

    public actionNhanVien(NhanVien[] danhSachNhanVien, int kt) {
        this.danhSachNhanVien = danhSachNhanVien;
        this.kt = kt;
    }

    public void setDanhSachNhanVien(NhanVien[] danhSachNhanVien) {
        this.danhSachNhanVien = danhSachNhanVien;
    }

    public NhanVien[] getDanhSachNhanVien() {
        return danhSachNhanVien;
    }

    public void setKt(int kt) {
        this.kt = kt;
    }

    public int getKt() {
        return kt;
    }

    private void incre_Array() {
        int newKT = danhSachNhanVien.length * 2;
        NhanVien[] newArray = new NhanVien[newKT];
        System.arraycopy(danhSachNhanVien, 0, newArray, 0, kt);
        danhSachNhanVien = newArray;
    }

    @Override
    public void ThemThongTin() {
        String choose;
        do {
            System.out.println("1. Thêm 1 Nhân Viên");
            System.out.println("2. Thêm Nhiều Nhân Viên");
            System.out.println("3. Thoát Menu Thêm Nhân Viên");
            choose = input.nextLine();
            switch (choose) {
                case "1":
                    push_1NV();
                    break;
                case "2":
                    push_nNV();
                    break;
                case "3":
                    break;
                default:
                    System.out.println("Vui Lòng Nhập Đúng Yêu Cầu Menu");
                    break;
            }
        } while (check.nullInput(choose) || !check.Int(choose));
    }

    public void push_1NV() {
        if (kt == danhSachNhanVien.length) {
            incre_Array();
        }
        NhanVien a = new NhanVien();
        a.input();
        danhSachNhanVien[kt++] = a;
    }

    public void push_nNV() {
        if (kt == danhSachNhanVien.length) {
            incre_Array();
        }
        String n;
        int i = 1;
        do {
            System.out.println("Nhập Số Lượng(số):");
            n = input.nextLine();
            if (check.Int(n)) {
                int t = Integer.parseInt(n);
                System.out.println("phong thu:" + i);
                i++;
                while (t > 0) {
                    NhanVien a = new NhanVien();
                    a.input();
                    t--;
                    danhSachNhanVien[kt++] = a;
                }
            } else {
                System.out.println("Vui lòng nhập số lượng đúng yêu cầu:");
            }
        } while (!check.Int(n));
    }

    @Override
    public void ChinhSuaThongTin() {
        System.out.println("Nhập Mã Nhân Viên Muốn Sửa:");
        String ma = input.nextLine();
        for (int i = 0; i < danhSachNhanVien.length; i++) {
            if (danhSachNhanVien[i].getMaNV().equals(ma) && danhSachNhanVien[i] != null) {
                String luaChon;
                do {
                    System.out.println("1. Sửa Mã Nhân Viên");
                    System.out.println("2. Sửa Tên Nhân Viên");
                    System.out.println("3. Sửa Mã Phòng");
                    System.out.println("4. Sửa Loại Hợp Đồng");
                    System.out.println("5. Sửa Gmail");
                    System.out.println("6. Thoát!");
                    System.out.print("Chọn thuộc tính muốn sửa (1-6): ");
                    luaChon = input.nextLine();

                    switch (luaChon) {
                        case "1":
                            danhSachNhanVien[i].check_setMaNV();
                            break;
                        case "2":
                            danhSachNhanVien[i].check_setHoten();
                            ;
                            break;
                        case "3":
                            danhSachNhanVien[i].setMaPhong();
                            break;
                        case "4":
                            danhSachNhanVien[i].check_setLoaiHD();
                            break;
                        case "5":
                            danhSachNhanVien[i].check_setGmail();
                            break;
                        case "6":
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ:");
                            break;
                    }
                } while (!luaChon.equals("6"));
            }
        }
    }

    @Override
    public void XoaThongTin() {
        String ma;
        do {
            System.out.println("Nhập manv muốn xóa");
            ma = input.nextLine();

            if (check.nullInput(ma)) {
                System.out.println("Bắt Buộc Phải Nhập mã nv");
            } else if (!check.checkMaNv(ma)) {
                System.out.println("mã nv không đúng định dạng");
            } else {
                for (int i = 0; i < kt; i++) {
                    if (danhSachNhanVien[i] != null && danhSachNhanVien[i].getMaNV().equals(ma)) {
                        System.arraycopy(danhSachNhanVien, i + 1, danhSachNhanVien, i, kt - i - 1);
                        danhSachNhanVien[kt - 1] = null;
                        kt--;
                        System.out.println("Đã xóa nhan vien có mã " + ma);
                        break;
                    }
                }
            }
        } while (check.nullInput(ma) || !check.checkMaNv(ma));
    }

    @Override
    public void TimKiemThongTin() {
        String luachon;
        do {
            System.out.println("1. Tìm Nhan Vien theo Ma Nhan vien");
            System.out.println("2. Tìm Nhan Vien Theo Ma Phong");
            System.out.println("3. Tìm Nhan Vien Theo Gmail");
            System.out.print("Chọn thuộc tính muốn Tìm (1-3): ");
            luachon = input.nextLine();
            switch (luachon) {
                case "1":
                    find_Manv();
                    break;
                case "2":
                    find_MaPhong();
                    break;
                case "3":
                    find_Gmail();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ:");
            }
        } while (check.nullInput(luachon));
    }

    public void find_Manv() {
        boolean find = false;
        String ma;
        do {
            System.out.println("Nhập Mã Nhân Viên");
            ma = input.nextLine();
            if (check.nullInput(ma)) {
                System.out.println("Bắt Buộc Phải Nhập Mã Nhân Viên");
            }
            if (!check.checkMaNv(ma)) {
                System.out.println("Mã Nhân Viên Không Đúng Định Dạng NVxxx(x là số)");
            } else {
                for (int i = 0; i < danhSachNhanVien.length; i++) {
                    if (danhSachNhanVien[i].getMaNV().equals(ma) && danhSachNhanVien[i] != null) {
                        System.out.println("Da Tim Thay Nhan Vien Co Ma:" + ma);
                        System.out.println(danhSachNhanVien[i].toString());
                        find = true;
                    }
                }
                if (!find) {
                    System.out.println("Khong tim thay nhan vien co ma" + ma);
                }
            }

        } while (check.nullInput(ma) || !check.checkMaNv(ma));
    }

    public void find_MaPhong() {
        boolean find = false;
        String MaPhong;
        do {
            System.out.println("Nhập Mã Phòng");
            MaPhong = input.nextLine();
            if (check.nullInput(MaPhong)) {
                System.out.println("Bắt Buộc Nhập Mã Phòng");
            } else {
                for (int i = 0; i < danhSachNhanVien.length; i++) {
                    if (danhSachNhanVien[i].getMaPhong().equals(MaPhong) && danhSachNhanVien[i] != null) {
                        System.out.println("Da Tim Thay Nhan Vien Co Ma Phong:" + MaPhong);
                        System.out.println(danhSachNhanVien[i].toString());
                        find = true;
                    }
                }
                if (!find) {
                    System.out.println("Khong tim thay nhan vien co ma phong:" + MaPhong);
                }
            }

        } while (check.nullInput(MaPhong));

    }

    public void find_Gmail() {
        boolean find = false;
        String Gmail;
        do {
            System.out.println("Nhập Gmail:");
            Gmail = input.nextLine();
            if (check.nullInput(Gmail)) {
                System.out.println("Bắt Buộc Nhập Gmail");
            }
            if (!check.checkEmail(Gmail)) {
                System.out.println("Nhập Sai Định Dạng Gmail");
            } else {
                for (int i = 0; i < danhSachNhanVien.length; i++) {
                    if (danhSachNhanVien[i].getGmail().equals(Gmail) && danhSachNhanVien[i] != null) {
                        System.out.println("Da Tim Thay Nhan Vien Co Gmail:" + Gmail);
                        System.out.println(danhSachNhanVien[i].toString());
                        find = true;
                    }

                }
                if (!find)
                    System.out.println("Khong tim thay nhan vien co GmaiL:" + Gmail);
            }

        } while (check.nullInput(Gmail) || !check.checkEmail(Gmail));

    }

    @Override
    public void InDanhSach() {
        for (int i = 0; i < danhSachNhanVien.length; i++)
            if (danhSachNhanVien[i] != null)
                System.out.println(danhSachNhanVien[i].toString());
    }

    public String toString() {
        for (int i = 0; i < danhSachNhanVien.length; i++)
            if (danhSachNhanVien[i] != null)
                return danhSachNhanVien[i].toString();
        return null;
    }

    public static void main(String[] args) {
        actionNhanVien a = new actionNhanVien();
        a.ThemThongTin();
        a.TimKiemThongTin();
        a.InDanhSach();

    }
}