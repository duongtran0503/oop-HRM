package core;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

import model.NhanVien;
import model.StringArray;
import model.TaiKhoan;
import service.PhanQuyen;
import service.User;
import service.Menu.NguoiQuanTri;
import service.Menu.NhanVienMenu;
import service.Menu.TruongBan;
import service.Menu.qlNhanLuc;
import service.Menu.qlNhanSu;
import service.Menu.qlTaiChinh;

public class HeThong {
    public static Integer state = 10;

    public static void heThong() {
        if (state == 10) {
            Store init = new Store();
        }
        if (state == 0) {
            return;
        }
        User newUser = new User();
        PhanQuyen newPhanQuyen = new PhanQuyen();
        newUser.login();
        newPhanQuyen.PhanQuyenTK(User.userAcount);
        return;
    }

    public static HashMap<String, String> getDATA(int selector) {

        if (selector == 1) {
            return Store.DATA_AC_NV;
        }
        if (selector == 2) {
            return Store.DATA_AC_QT;
        }
        if (selector == 3) {
            return Store.DATA_AC_NS;
        }
        if (selector == 4) {
            return Store.DATA_AC_NL;
        }
        if (selector == 5) {
            return Store.DATA_AC_TC;
        }
        if (selector == 6) {
            return Store.DATA_AC_TB;
        }
        return Store.UNDEFINE_H;
    }

    public static void setDATA(int selector, HashMap<String, String> newDATA) {
        if (selector == 1) {
            Store.DATA_AC_NV = newDATA;
        }
        if (selector == 2) {
            Store.DATA_AC_QT = newDATA;
        }
        if (selector == 3) {
            Store.DATA_AC_NS = newDATA;
        }
        if (selector == 4) {
            Store.DATA_AC_NL = newDATA;
        }
        if (selector == 5) {
            Store.DATA_AC_TC = newDATA;
        }
        if (selector == 6) {
            Store.DATA_AC_TB = newDATA;
        }

    }

    public static List<NhanVien> getList(int selector) {

        if (selector == 1) {
            return Store.listinfor;
        }
        return Store.UNDEFINE_L;
    }

    public static void UpdateList(int selector) {
        List<NhanVien> list = getList(selector);
        StringArray array = new StringArray();
        for (NhanVien ep : list) {
            // thong tin nhan vien
            // MANV,ho ten,ma phong,chuc vu,loai hd,ngay ky,ngay het
            // han,gmail,luongCb,capnhap
            // thong tin ca nhan
            // HoTen,GioiTinh,DiaChi,QueQuan,NgaySinh,SoDT,DanToc,TonGiao,HocVan,MaNV,MaPhong,ChucVu,LoaiHD,NgayKiHD,NgayHetHan,Gmail,capnhat

            LocalDate localDate = LocalDate.now();
            if (!ep.getTimeUpdate().equals(localDate)) {
                ep.setTimeUpdate(localDate + "");
            }
            String value = ep.output();
            array.push(value);
        }
        Connection newUpdate = new Connection();
        newUpdate.Update(array, selector);
    }

    public static void UpdateAccount(int selector) {
        List<TaiKhoan> list = Store.listAccount;
        StringArray array = new StringArray();
        for (TaiKhoan ep : list) {
            String value = ep.output();
            array.push(value);
        }
        Connection newUpdate = new Connection();
        newUpdate.Update(array, selector);
    }

    public static void connect(int selector) {
        switch (selector) {
            case 1: {
                NhanVienMenu.Chucnang();
                if (state == 9) {
                    heThong();
                    return;
                }
                return;
            }
            case 2: {

                NguoiQuanTri.chucNang();
                if (state == 9) {
                    heThong();
                    return;
                }
                return;
            }
            case 3: {
                qlNhanSu.ChucNang();
                if (state == 9) {
                    heThong();
                    return;
                }
                return;
            }
            case 4: {
                qlNhanLuc.ChucNang();
                if (state == 9) {
                    heThong();
                    return;
                }
                return;
            }
            case 5: {
                qlTaiChinh.ChucNang();
                if (state == 9) {
                    heThong();
                    return;
                }
                return;
            }
            case 6: { // phu dang lam
                TruongBan.ChucNang();
                if (state == 9) {
                    heThong();
                    return;
                }
                return;
            }

            default:
                return;
        }

    }

}