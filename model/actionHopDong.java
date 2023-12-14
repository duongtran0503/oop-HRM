package model;

import java.util.Scanner;

public class actionHopDong implements ArraysInterface {
    Scanner input = new Scanner(System.in);
    private HopDong[] danhSachHopDong;
    private int kt;
    checkError check = new checkError();

    public actionHopDong() {
        kt = 0;
        danhSachHopDong = new HopDong[10];
    }

    public actionHopDong(HopDong[] danhSachHopDong, int kt) {
        this.danhSachHopDong = danhSachHopDong;
        this.kt = kt;
    }

    public void setDanhSachHopDong(HopDong[] danhSachHopDong) {
        this.danhSachHopDong = danhSachHopDong;
    }

    public HopDong[] getDanhSachHopDong() {
        return danhSachHopDong;
    }

    public void setKt(int kt) {
        this.kt = kt;
    }

    public int getKt() {
        return kt;
    }

    private void incre_Array() {
        int newKT = danhSachHopDong.length * 2;
        HopDong[] newArray = new HopDong[newKT];
        System.arraycopy(danhSachHopDong, 0, newArray, 0, kt);
        danhSachHopDong = newArray;
    }

    public void push_1HD() {
        if (kt == danhSachHopDong.length) {
            incre_Array();
        }
        HopDong a = new HopDong();
        a.input();
        danhSachHopDong[kt++] = a;
    }

    public void push_nHD() {
        if (kt == danhSachHopDong.length) {
            incre_Array();
        }
        String n;
        int i = 1;
        do {
            System.out.println("Nhập Số Lượng:");
            n = input.nextLine();
            if (check.Int(n)) {
                int t = Integer.parseInt(n);
                while (t > 0) {
                    System.out.println("Hop Dong Thu :" + i);
                    HopDong a = new HopDong();
                    a.input();
                    danhSachHopDong[kt++] = a;
                    i++;
                    t--;
                }
            } else {
                System.out.println("Vui lòng nhập đúng yêu cầu:");
            }
        } while (!check.Int(n));
    }

    @Override
    public void ThemThongTin() {
        String luaChon;
        do {
            System.out.println("1.  Thêm 1 Hợp Đồng");
            System.out.println("2.  Thêm Nhiều Hợp Đồng");
            System.out.println("0.  Quay Lại");
            luaChon = input.nextLine();
            switch (luaChon) {
                case "1":
                    push_1HD();
                    break;
                case "2":
                    push_nHD();
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Vui lòng nhập đúng yêu cầu:");
                    break;
            }
        } while (check.nullInput(luaChon) || !check.Int(luaChon));
    }

    @Override
    public void ChinhSuaThongTin() {
        System.out.println("Nhập ID Hợp Đồng Muốn Sửa");
        input.nextLine(); // tiêu thụ ký tự mới xuống
        String id = input.nextLine();
        for (int i = 0; i < danhSachHopDong.length; i++) {
            if (id.equals(danhSachHopDong[i].getID()) && danhSachHopDong[i] != null) {
                String luaChon;
                do {
                    System.out.println("1. Sửa Ngày Kí Hợp Đồng");
                    System.out.println("2. Sửa Ngày Hết Hạn");
                    System.out.println("3. Sửa Lương Cơ Bản");
                    System.out.println("4. Sửa Vị Trí");
                    System.out.println("5. Sửa ID");
                    System.out.println("6. Thoát!");
                    System.out.print("Chọn thuộc tính muốn sửa (1-6): ");
                    luaChon = input.nextLine();

                    switch (luaChon) {
                        case "1":
                            danhSachHopDong[i].check_setNgayKy();
                            break;
                        case "2":
                            danhSachHopDong[i].check_setNgayHetHan();
                            break;
                        case "3":

                            danhSachHopDong[i].check_setLuongCB();
                            break;
                        case "4":

                            danhSachHopDong[i].check_setViTri();
                            break;
                        case "5":

                            danhSachHopDong[i].check_setID();
                            break;
                        case "6":
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ:");
                            break;
                    }
                } while (check.nullInput(luaChon) || !check.Int(luaChon));
                return; // thoát khỏi vòng lặp nếu ID được tìm thấy và chỉnh sửa
            }
        }
        System.out.println("ID không hợp lệ hoặc hợp đồng không tồn tại.");
    }

    @Override
    public void XoaThongTin() {
        String ID;
        boolean find = false;
        do {
            System.out.println("Nhập ID Hợp Đồng:");
            ID = input.nextLine();
            if (check.nullInput(ID)) {
                System.out.println("Bat Buoc Phai Nhap ID");
            }
            if (!check.checkIDHD(ID)) {
                System.out.println("ID khong dung dinh dang");
            } else {
                for (int i = 0; i < danhSachHopDong.length; i++) {
                    if (danhSachHopDong[i].getID().equals(ID) && danhSachHopDong[i] != null) {
                        System.arraycopy(danhSachHopDong, i + 1, danhSachHopDong, i, kt - i - 1);
                        kt--;
                        danhSachHopDong[kt - 1] = null;
                        System.out.println("Đã xóa hợp đồng có ID " + ID);
                        find = true;
                        break;
                    }
                }
                if (!find) {
                    System.out.println("Không tìm thấy hợp đồng có ID " + ID);
                }
            }
        } while (check.nullInput(ID) || !check.checkIDHD(ID));
    }

    @Override
    public void InDanhSach() {
        for (int i = 0; i < kt; i++) {
            if (danhSachHopDong[i] != null)
                System.out.println(danhSachHopDong[i].toString());
        }
    }

    public void find_ID() {
        String ID;
        boolean find = false;
        do {
            System.out.println("Nhập ID Hợp Đồng Muốn Tìm");

            ID = input.nextLine();
            if (check.nullInput(ID)) {
                System.out.println("Bat Buoc Phai Co ID");
            }
            if (check.checkIDHD(ID) == false) {
                System.out.println("ID khong dung dinh dang HDxxxx(x la so)");
            } else {
                for (int i = 0; i < danhSachHopDong.length; i++) {
                    if (danhSachHopDong[i].getID().equals(ID) && danhSachHopDong[i] != null) {
                        System.out.println("Da Tim Thay Hop Dong Co ID:" + ID);
                        System.out.println(danhSachHopDong[i].toString());
                        find = true;
                    }
                }
                if (!find) {
                    System.out.println("Khong Tim Thay Hop Dong Co ID:" + ID);
                }
            }
        } while (check.nullInput(ID) || check.checkIDHD(ID) == false);
    }

    public void find_NgayKi() {
        String ngayky;
        boolean find = false;
        do {
            System.out.println("Nhập Ngày Ký Hợp Đồng Muốn Tìm");

            ngayky = input.nextLine();
            if (check.nullInput(ngayky)) {
                System.out.println("Bat Buoc Nhap Ngay Ki");
            }
            if (!check.dateFormat(ngayky)) {
                System.out.println("Ngay Ki Khong Dung Dinh Dang (dd/mm/yyy)");
            } else {
                for (int i = 0; i < danhSachHopDong.length; i++) {
                    if (danhSachHopDong[i].getNgayKiHD().equals(ngayky) && danhSachHopDong[i] != null) {
                        System.out.println("Da Tim Thay Hop Dong Co Ngay Ky:" + ngayky);
                        System.out.println(danhSachHopDong[i].toString());
                        find = true;
                    }
                }
                if (!find) {
                    System.out.println("Khong Tim Thay Hop Dong Co Ngay Ky:" + ngayky);
                }
            }
        } while (check.nullInput(ngayky) || !check.dateFormat(ngayky));
    }

    public void find_LuongCB() {
        String luongCB;
        boolean find = false;
        do {
            System.out.println("Nhập Lương Cơ Bản Hợp Đồng Muốn Tìm");
            luongCB = input.nextLine();
            if (check.nullInput(luongCB)) {
                System.out.println("Bat Buoc Nhap Luong Co Ban");
            }
            if (!check.Luong(luongCB)) {
                System.out.println("Nhap Luong Khong Dung Dinh Dang (so thap phan)");
            } else {
                for (int i = 0; i < danhSachHopDong.length; i++) {
                    if (danhSachHopDong[i].getLuongCB().equals(luongCB) && danhSachHopDong[i] != null) {
                        System.out.println("Da Tim Thay Hop Dong Co Luong CB:" + luongCB);
                        System.out.println(danhSachHopDong[i].toString());
                        find = true;
                    }
                }
                if (!find) {
                    System.out.println("Khong Tim Thay Hop Dong Co Luong CB:" + luongCB);
                }
            }
        } while (check.nullInput(luongCB) || !check.Luong(luongCB));
    }

    @Override
    public void TimKiemThongTin() {
        System.out.println("1. Tìm Theo ID");
        System.out.println("2. Tìm Theo Ngày Ký Hợp Đồng");
        System.out.println("3. Tìm Theo Lương Cơ Bản");
        System.out.print("Chọn thuộc tính muốn Tìm (1-3): ");
        String luaChon = input.nextLine();
        switch (luaChon) {
            case "1":
                find_ID();
                break;
            case "2":
                find_NgayKi();
                break;
            case "3":
                find_LuongCB();
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ:");
        }
    }
}