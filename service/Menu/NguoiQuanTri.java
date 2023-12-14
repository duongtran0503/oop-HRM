package service.Menu;

import java.util.HashMap;
import java.util.Scanner;

import core.HeThong;
import model.QTFunction;
import model.TaiKhoan;

public class NguoiQuanTri {
    public static void menu() {
        System.out.println("-------------danh sach chuc nang---------------");
        System.out.println("1.tim kiem tai khoan");
        System.out.println("2.them tai khoan");
        System.out.println("3.xoa tai khoan");
        System.out.println("4.sua tai khoan");
        System.out.println("5.danh sach tai khoan");
        System.out.println("9.dang xuat khoi he thong");

    }

    public static void chucNang() {
        int selector = 10;
        Scanner inputs = new Scanner(System.in);
        if (selector == 9) {
            System.out.println("----------------------------------");
            System.out.println("thoat chuc nang !");
            System.out.println("---------------------------------");
            HeThong.state = 9;
            return;
        }
        do {
            menu();
            System.out.print("nhap lua chon:");
            selector = inputs.nextInt();
            if (selector < 0 || selector > 6) {
                System.out.println("lua chon  khong hop le");
                System.out.println("vui long nhap lai hoat nhan 9 de dang xuat");
            }
            if (selector == 9) {
                System.out.println("----------------------------------");
                System.out.println("da dang xuat !");
                System.out.println("---------------------------------");
                HeThong.state = 9;

                return;
            }
        } while (selector < 0 || selector > 6);
        switch (selector) {
            case 1: {
                int select = 0;
                do {
                    System.out.println("----chon loai tai khoan can tim-----");
                    System.out.println("1. tai khoan nhan vien");
                    System.out.println("2. tai khoan quan tri vien");
                    System.out.println("3. tai khoan QL nhan  su");
                    System.out.println("4. tai khoan QL Nhan luc");
                    System.out.println("5. tai khoan QL tai chinh");
                    System.out.println("6. tai khoan truong ban");
                    System.out.println("7.tro lai bang chuc nang quan tri vien");
                    System.out.print("nhan lua chon:");
                    select = inputs.nextInt();
                    if (select < 1 || select > 7) {
                        System.out.println("----------------------------------");
                        System.out.println("loi lua chon vui long nha lai !");
                    }
                } while (select < 1 || select > 7);
                if (select == 7) {
                    chucNang();
                    return;
                }
                HashMap<String, String> listAcount = HeThong.getDATA(select);
                System.out.println("----------------------------------");
                System.out.println("chuc nang:  tim kiem");
                QTFunction method = new QTFunction();
                method.findAcount(listAcount);
                do {
                    System.out.println("---------------------------------");
                    System.out.println("nhap 0 de thoat");
                    System.out.println("nhap 7 de tro lai chuc nang quang tri vien");
                    System.out.print("nhan lua chon:");
                    select = inputs.nextInt();
                    if (select != 0 && select != 7) {
                        System.out.println("---------------------------------");
                        System.out.println("loi lua chon hay lua chon lai!");
                    }
                } while (select != 0 && select != 7);
                if (select == 7) {
                    chucNang();
                    return;
                }
                if (select == 0) {
                    HeThong.state = 9;
                    return;
                }
                return;
            }
            case 2: {
                int select = 0;
                do {
                    System.out.println("----chon loai tai khoan can them-----");
                    System.out.println("1. tai khoan nhan vien");
                    System.out.println("2. tai khoan quan tri vien");
                    System.out.println("3. tai khoan QL nhan  su");
                    System.out.println("4. tai khoan QL Nhan luc");
                    System.out.println("5. tai khoan QL tai chinh");
                    System.out.println("6. tai khoan truong ban");
                    System.out.println("7.tro lai bang chuc nang quan tri vien");
                    System.out.print("nhan lua chon:");
                    select = inputs.nextInt();
                    if (select < 1 || select > 7) {
                        System.out.println("---------------------------------");
                        System.out.println("loi lua chon hay lua chon lai!");
                    }
                } while (select < 1 || select > 7);
                if (select == 7) {
                    chucNang();
                    return;
                }
                TaiKhoan user = new TaiKhoan();
                user.setQuyen(select);
                user.permission(select);
                HashMap<String, String> listAcount = HeThong.getDATA(select);
                System.out.println("----------------------------------");
                System.out.println("chuc nang: them tai khoan");
                QTFunction method = new QTFunction();
                method.addAcount(user, listAcount);
                HeThong.setDATA(select, listAcount);
                HeThong.UpdateAccount(2);
                do {
                    System.out.println("---------------------------------");
                    System.out.println("nhap 0 de thoat");
                    System.out.println("nhap 7 de tro lai chuc nang quang tri vien");
                    System.out.print("nhan lua chon:");
                    select = inputs.nextInt();
                    if (select != 0 && select != 7) {
                        System.out.println("---------------------------------");
                        System.out.println("loi lua chon hay lua chon lai!");
                    }
                } while (select != 0 && select != 7);
                if (select == 7) {
                    chucNang();
                    return;
                }
                if (select == 0) {

                    HeThong.state = 9;
                    return;
                }
                return;
            }
            case 3: {
                int select = 0;
                do {
                    System.out.println("----chon loai tai khoan can xoa-----");
                    System.out.println("1. tai khoan nhan vien");
                    System.out.println("2. tai khoan quan tri vien");
                    System.out.println("3. tai khoan QL nhan  su");
                    System.out.println("4. tai khoan QL Nhan luc");
                    System.out.println("5. tai khoan QL tai chinh");
                    System.out.println("6. tai khoan truong ban");
                    System.out.println("7.tro lai bang chuc nang quan tri vien");
                    System.out.print("nhan lua chon:");
                    select = inputs.nextInt();
                    if (select < 1 || select > 7) {
                        System.out.println("---------------------------------");
                        System.out.println("loi lua chon hay lua chon lai!");
                    }
                } while (select < 1 || select > 7);

                if (select == 7) {
                    chucNang();
                    return;
                }
                TaiKhoan user = new TaiKhoan();
                user.setQuyen(select);
                user.permission(select);
                HashMap<String, String> listAcount = HeThong.getDATA(select);
                System.out.println("----------------------------------");
                System.out.println("chuc nang: xoa tai khoan");
                QTFunction method = new QTFunction();
                method.deleteAcount(user, listAcount);
                HeThong.setDATA(select, listAcount);
                HeThong.UpdateAccount(2);
                do {
                    System.out.println("---------------------------------");
                    System.out.println("nhap 0 de thoat");
                    System.out.println("nhap 7 de tro lai chuc nang quang tri vien");
                    System.out.print("nhan lua chon:");
                    select = inputs.nextInt();
                    if (select != 0 && select != 7) {
                        System.out.println("---------------------------------");
                        System.out.println("loi lua chon hay lua chon lai!");
                    }
                } while (select != 0 && select != 7);
                if (select == 7) {
                    chucNang();
                    return;
                }
                if (select == 0) {
                    HeThong.state = 9;
                    return;
                }
                return;
            }
            case 4: {
                int select = 0;
                do {
                    System.out.println("----chon loai tai khoan can sua-----");
                    System.out.println("1. tai khoan nhan vien");
                    System.out.println("2. tai khoan quan tri vien");
                    System.out.println("3. tai khoan QL nhan  su");
                    System.out.println("4. tai khoan QL Nhan luc");
                    System.out.println("5. tai khoan QL tai chinh");
                    System.out.println("6. tai khoan truong ban");
                    System.out.println("7.tro lai bang chuc nang quan tri vien");
                    System.out.print("nhan lua chon:");
                    select = inputs.nextInt();
                    if (select < 1 || select > 7) {
                        System.out.println("---------------------------------");
                        System.out.println("loi lua chon hay lua chon lai!");
                    }
                } while (select < 1 || select > 7);
                if (select == 7) {
                    chucNang();
                    return;
                }
                TaiKhoan user = new TaiKhoan();
                user.setQuyen(select);
                user.permission(select);
                HashMap<String, String> listAcount = HeThong.getDATA(select);
                System.out.println("----------------------------------");
                System.out.println("chuc nang: sua tai khoan");
                QTFunction method = new QTFunction();
                method.setAcount(user, listAcount);
                HeThong.setDATA(select, listAcount);
                HeThong.UpdateAccount(2);
                do {
                    System.out.println("---------------------------------");
                    System.out.println("nhap 0 de thoat");
                    System.out.println("nhap 7 de tro lai chuc nang quang tri vien");
                    System.out.print("nhan lua chon:");
                    select = inputs.nextInt();
                    if (select != 0 && select != 7) {
                        System.out.println("---------------------------------");
                        System.out.println("loi lua chon hay lua chon lai!");
                    }
                } while (select != 0 && select != 7);
                if (select == 7) {
                    chucNang();
                    return;
                }
                if (select == 0) {
                    HeThong.state = 9;
                    return;
                }
                return;
            }
            case 5: {
                int select = 0;
                do {
                    System.out.println("----cac loai danh sach-----");
                    System.out.println("1.danh sach tai khoan nhan vien");
                    System.out.println("2.danh sach tai khoan quan tri vien");
                    System.out.println("3.danh sach tai khoan QL nhan  su");
                    System.out.println("4.danh sach tai khoan QL Nhan luc");
                    System.out.println("5.danh sach tai khoan QL tai chinh");
                    System.out.println("6.danh sach tai khoan truong ban");
                    System.out.println("7.tro lai bang chuc nang quan tri vien");
                    System.out.print("nhan lua chon:");
                    select = inputs.nextInt();
                    if (select < 1 || select > 7) {
                        System.out.println("---------------------------------");
                        System.out.println("loi lua chon hay lua chon lai!");
                    }
                } while (select < 1 || select > 7);
                if (select == 7) {
                    chucNang();
                    return;
                }
                HashMap<String, String> listAcount = HeThong.getDATA(select);
                System.out.println("----tai khoan------");
                String formatString = "%20s||%10s";
                System.out.format(formatString, "tai khoan", "mat khau");
                System.out.println();
                for (String key : listAcount.keySet()) {
                    System.out.format(formatString, key, listAcount.get(key));
                    System.out.println();
                }
                do {
                    System.out.println("---------------------------------");
                    System.out.println("nhap 0 de thoat");
                    System.out.println("nhap 7 de tro lai chuc nang quang tri vien");
                    System.out.print("nhan lua chon:");
                    select = inputs.nextInt();
                    if (select != 0 && select != 7) {
                        System.out.println("---------------------------------");
                        System.out.println("loi lua chon hay lua chon lai!");
                    }
                } while (select != 0 && select != 7);
                if (select == 7) {
                    chucNang();
                    return;
                }
                if (select == 0) {
                    HeThong.state = 9;
                    return;
                }
                return;
            }
            default:
                return;
        }
    }

}
