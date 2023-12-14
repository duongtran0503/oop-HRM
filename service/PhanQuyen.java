package service;

import core.HeThong;
import model.TaiKhoan;

interface PhanQuyenNV {
    public void PhanQuyenTK(TaiKhoan user);

}

public class PhanQuyen implements PhanQuyenNV {

    @Override
    public void PhanQuyenTK(TaiKhoan user) {
        if (HeThong.state == 0) {
            return;
        }
        switch (user.getQuyen()) {
            case 1: {
                System.out.println("nhan vien" + user.getUserName());
                System.out.println("chuc nhan danh cho nhan vien !");
                HeThong.connect(1);
            }
                break;
            case 2: {
                System.out.println("quan tri vien:" + user.getUserName());
                HeThong.connect(2);

            }
                break;

            case 3: {
                System.out.println("quan ly nhan su:" + user.getUserName());
                System.out.println("chuc nang quan ly nhan su");
                HeThong.connect(3);
            }
                break;
            case 4: {
                System.out.println("quan ly nhan luc" + user.getUserName());
                System.out.println("chuc nang quan ly nhan luc");
                HeThong.connect(4);
            }
                break;
            case 5: {
                System.out.println("quan ly tai chinh:" + user.getUserName());
                System.out.println("chuc nang quan ly tai chinh");
                HeThong.connect(5);
            }
                break;
            case 6: {
                System.out.println("truong ban:" + user.getUserName());
                System.out.println("chuc nang cua truong ban");
                HeThong.connect(6);
            }
                break;
            default: {
                return;
            }
        }

    }
}
