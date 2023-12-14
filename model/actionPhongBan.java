package model;

import java.util.Scanner;

public class actionPhongBan implements ArraysInterface {
    private PhongBan[] danhSachPhongBan;
    private int kt;
    Scanner input = new Scanner(System.in);
    checkError check = new checkError();

    public actionPhongBan() {
        this.danhSachPhongBan = new PhongBan[10];
        this.kt = 0;
    }

    public actionPhongBan(PhongBan[] danhSachPhongBan, int kt) {
        this.danhSachPhongBan = danhSachPhongBan;
        this.kt = kt;
    }

    public void setDanhSachPhongBan(PhongBan[] danhSachPhongBan) {
        this.danhSachPhongBan = danhSachPhongBan;
    }

    public PhongBan[] getDanhSachPhongBan() {
        return danhSachPhongBan;
    }

    public void setKt(int kt) {
        this.kt = kt;
    }

    public int getKt() {
        return kt;
    }

    private void incre_Array() {
        int newKT = danhSachPhongBan.length * 2;
        if (newKT == 0) {
            newKT = 1; // Xử lý trường hợp chiều dài ban đầu của mảng là 0
        }
        PhongBan[] newArray = new PhongBan[newKT];
        System.arraycopy(danhSachPhongBan, 0, newArray, 0, kt);
        danhSachPhongBan = newArray;
    }

    @Override
    public void ThemThongTin() {
        String choose;
        System.out.println("1. Thêm 1 Phong Ban");
        System.out.println("2. Thêm Nhiều Phong Ban");
        System.out.println("3. Thoát Menu Thêm Phong Ban");
        do {
            choose = input.nextLine();
            switch (choose) {
                case "1":
                    push_1PB();
                    break;
                case "2":
                    push_nPB();
                    break;
                case "3":
                    break;
                default:
                    System.out.println("Vui Lòng Nhập Đúng Yêu Cầu Menu");
                    break;
            }
        } while (check.nullInput(choose));
    }

    public void push_1PB() {
        if (kt == danhSachPhongBan.length) {
            incre_Array();
        }
        PhongBan a = new PhongBan();
        a.input();
        danhSachPhongBan[kt++] = a;
    }

    public void push_nPB() {
        if (kt == danhSachPhongBan.length) {
            incre_Array();
        }
        String n;
        int i = 1;
        do {
            System.out.println("Nhap so luong(so) ");
            n = input.nextLine();
            if (check.Int(n)) {
                int t = Integer.parseInt(n);
                while (t > 0) {
                    System.out.println("phong thu:" + i);
                    i++;
                    PhongBan a = new PhongBan();
                    a.input();
                    danhSachPhongBan[kt++] = a;
                    t--;

                }
            } else {
                System.out.println("Vui lòng nhập số lượng đúng yêu cầu:");
            }
        } while (check.nullInput(n) || !check.Int(n));
    }

    @Override
    public void ChinhSuaThongTin() {
        System.out.println("Nhập Mã Phong Ban Muốn Sửa:");
        input.nextLine();
        String ma = input.nextLine();
        for (int i = 0; i < danhSachPhongBan.length; i++) {
            if (danhSachPhongBan[i].getMaPhongBan().equals(ma) && danhSachPhongBan[i] != null) {
                String luaChon;
                do {
                    System.out.println("1. Sửa Mã Phong Ban");
                    System.out.println("2. Sửa Ten Phong Ban");
                    System.out.println("3. Sửa Ngay Thanh Lap");
                    System.out.println("4. Thoát!");
                    System.out.print("Chọn thuộc tính muốn sửa (1-4): ");
                    luaChon = input.nextLine();

                    switch (luaChon) {
                        case "1":
                            danhSachPhongBan[i].check_setMaPhong();
                            break;
                        case "2":
                            danhSachPhongBan[i].check_setTenPhong();
                            break;
                        case "3":
                            danhSachPhongBan[i].check_setNgayThanhLap();
                            break;
                        case "4":
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ:");
                            break;
                    }
                } while (check.nullInput(luaChon));
            }
        }
    }

    @Override
    public void XoaThongTin() {
        String ma;
        do {
            System.out.println("Nhập mã phòng muốn xóa");
            ma = input.nextLine(); // Đọc dòng nhập

            if (check.nullInput(ma)) {
                System.out.println("Bắt Buộc Phải Nhập mã phòng");
            } else if (!check.checkMaPhong(ma)) {
                System.out.println("mã phòng không đúng định dạng");
            } else {
                for (int i = 0; i < kt; i++) {
                    if (danhSachPhongBan[i] != null && danhSachPhongBan[i].getMaPhongBan().equals(ma)) {
                        System.arraycopy(danhSachPhongBan, i + 1, danhSachPhongBan, i, kt - i - 1);
                        danhSachPhongBan[kt - 1] = null;
                        kt--;
                        System.out.println("Đã xóa phòng ban có mã " + ma);
                        break;
                    }
                }
            }
        } while (check.nullInput(ma) || !check.checkMaPhong(ma));
    }

    @Override
    public void TimKiemThongTin() {
        String luaChon;
        do {
            System.out.println("1. Tìm Theo Ma Phong");
            System.out.println("2. Tìm Theo Ngày Ten Phong");
            System.out.println("3. Tìm Theo Ngay Thanh Lap");
            System.out.print("Chọn thuộc tính muốn Tìm (1-3): ");
            luaChon = input.nextLine();
            switch (luaChon) {
                case "1":
                    find_MaPhong();
                    break;
                case "2":
                    find_TenPhong();
                    break;
                case "3":
                    find_NgayThanhLap();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ:");
            }
        } while (check.nullInput(luaChon));
    }

    public void find_MaPhong() {
        String ma;
        boolean find = false;
        do {
            System.out.println("Nhap Ma Phong Ban");
            ma = input.nextLine();
            if (check.nullInput(ma)) {
                System.out.println("Khong duoc de trong ma phong");
            }
            if (!check.checkMaPhong(ma)) {
                System.out.println("Ma phong khong dung dinh dang");
            } else {
                for (int i = 0; i < danhSachPhongBan.length; i++) {
                    if (danhSachPhongBan[i].getMaPhongBan().equals(ma) && danhSachPhongBan[i] != null) {
                        System.out.println("Da Tim Thay Phong Ban Co Ma Phong:" + ma);
                        System.out.println(danhSachPhongBan[i].toString());
                        find = true;
                    }
                }
                if (!find) {
                    System.out.println("Khong Tim Thay Phong Ban Co Ma Phong:" + ma);
                }
            }

        } while (check.nullInput(ma) || !check.checkMaPhong(ma));
    }

    public void find_TenPhong() {
        String tenPhong;
        boolean find = false;
        do {
            System.out.println("Nhap Ten Phong Ban");
            tenPhong = input.nextLine();
            if (check.nullInput(tenPhong)) {
                System.out.println("Khong Duoc de trong ten phong");
            } else {
                for (int i = 0; i < danhSachPhongBan.length; i++) {
                    if (danhSachPhongBan[i].getTenPhongBan().equals(tenPhong) && danhSachPhongBan[i] != null) {
                        System.out.println("Da Tim Thay Phong Ban Co Ten Phong:" + tenPhong);
                        System.out.println(danhSachPhongBan[i].toString());
                        find = true;
                    }

                }
                if (!find) {
                    System.out.println("Khong Tim Thay Phong Ban Co Ten Phong:" + tenPhong);
                }
            }
        } while (check.nullInput(tenPhong));
    }

    public void find_NgayThanhLap() {
        String ngayThanhLap;
        boolean find = false;
        do {
            System.out.println("Nhap nhap ngay thanh lap");
            ngayThanhLap = input.nextLine();
            if (check.nullInput(ngayThanhLap)) {
                System.out.println("Khong Duoc de trong ngay thanh lap");
            }
            if (!check.dateFormat(ngayThanhLap)) {
                System.out.println("Ngay Thanh Lap khong dung dinh dang(mm/dd/yyyy)");
            } else {
                for (int i = 0; i < danhSachPhongBan.length; i++) {
                    if (danhSachPhongBan[i].getNgayThanhLap().equals(ngayThanhLap) && danhSachPhongBan[i] != null) {
                        System.out.println("Da Tim Thay Phong Ban Co Ngay Thanh Lap:" + ngayThanhLap);
                        System.out.println(danhSachPhongBan[i].toString());
                        find = true;
                    }

                }
                if (!find) {
                    System.out.println("Khong Tim Thay Phong Ban Co Ngay Thanh Lap:" + ngayThanhLap);
                }
            }
        } while (check.nullInput(ngayThanhLap) || !check.dateFormat(ngayThanhLap));
    }

    @Override
    public void InDanhSach() {
        for (int i = 0; i < danhSachPhongBan.length; i++) {
            if (danhSachPhongBan[i] != null)
                System.out.println(danhSachPhongBan[i].toString());
        }
    }
}