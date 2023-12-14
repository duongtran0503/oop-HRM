package model;

import java.util.List;

import core.HeThong;

public class NVFunction {
    public NhanVien getNV(TaiKhoan user) {
        List<NhanVien> infor = HeThong.getList(1);
        for (NhanVien nv : infor) {
            if (nv.getMaNV().equalsIgnoreCase(user.getUserName())) {
                return nv;
            }
        }
        return new NhanVien();

    }

    public void setNV(NhanVien nvNew, TaiKhoan user) {
        List<NhanVien> infor = HeThong.getList(1);
        int index = 0;
        for (; index < infor.size(); index++) {
            if (infor.get(index).getMaNV().equalsIgnoreCase(user.getUserName())) {
                break;
            } else {
                continue;
            }
        }
        infor.set(index, nvNew);

    }
}