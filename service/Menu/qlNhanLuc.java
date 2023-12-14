package service.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;
import model.ChucNangQLNL;
import core.HeThong;

public class qlNhanLuc {
    public static void menuCaLam() {
        System.out.println("------------danh sach chuc nang--------");
        System.out.println("1.tim kiem ca lam");
        System.out.println("2.them ca lam");
        System.out.println("3.sua ca lam");
        System.out.println("4.xoa ca lam");
        System.out.println("5.danh sach nhan vien tham gia ca lam");
        System.out.println("6.chinh sua nhan vien tham gia ca lam");
        System.out.println("7.tro lai chuc nang quan ly nhan luc");
        System.out.println("9.dang xuat");
    }

    public static void menuDeAn() {
        System.out.println("--------danh sach chuc nang---------");
        System.out.println("1.tim kiem de an");
        System.out.println("2.them de an");
        System.out.println("3.sua de an");
        System.out.println("4.xoa de an");
        System.out.println("5.danh sach nhan vien tham gia de an");
        System.out.println("6.chinh sua nhan vien tham gia de an");
        System.out.println("7.tro lai chuc nang quan ly nhan luc");
        System.out.println("9.dang xuat");
    }

    public static void ChucNang() {
        ChucNangQLNL chucnangqlnl = new ChucNangQLNL();
        int option = 0;
        Scanner inputs = new Scanner(System.in);

        do {
            try {
                System.out.println("----danh sach chuc nang-----");
                System.out.println("1.chuc nang quan ly ca lam");
                System.out.println("2.chuc nang quan ly de an");
                System.out.println("9.dang xuat");
                System.out.print("nhap lua chon");
                option = inputs.nextInt();
            } catch (InputMismatchException ei) {
                System.out.println("loi lu chon vui long nhan lai");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            if (option == 9) {
                System.out.println("----------------------------------");
                System.out.println("da dang xuat !");
                System.out.println("---------------------------------");
                HeThong.state = 9;
                return;
            }
            if (option < 0 && option > 2) {
                System.out.println("loi  lua chon vui long nhap lai");
            }
        } while (option < 0 && option > 2);
        switch (option) {
            case 1: {
                int select = 0;
                do {
                    menuCaLam();
                    System.out.print("nhan  lua chon:");
                    select = inputs.nextInt();
                    if ((select < 0 || select > 7) && select != 9) {
                        System.out.println("-----------------------");
                        System.out.println("loi lua chon vui long nhap lai");
                    }
                } while ((select < 0 || select > 7) && select != 9);
                if (select == 7) {
                    ChucNang();
                    return;
                }
                if (select == 9) {
                    System.out.println("----------------------------------");
                    System.out.println("da dang xuat !");
                    System.out.println("---------------------------------");
                    HeThong.state = 9;
                    return;
                }
                switch (select) {
                    case 1: {
                        System.out.println("----------------------------------");
                        System.out.println("chuc nang: tim kiem ca lam");
                        chucnangqlnl.TimCaLam();
                    }
                        break;
                    case 2: {
                        System.out.println("----------------------------------");
                        System.out.println("chuc nang:  them ca lam");
                        chucnangqlnl.ThemCaLam();
                    }
                        break;
                    case 3: {
                        System.out.println("----------------------------------");
                        System.out.println("chuc nang:  sua ca lam");
                        chucnangqlnl.SuaThongTinCaLam();
                    }
                        break;
                    case 4: {
                        System.out.println("----------------------------------");
                        System.out.println("chuc nang:  xoa ca lam");
                        chucnangqlnl.XoaCaLam();
                    }
                        break;
                    case 5: {
                        System.out.println("----------------------------------");
                        System.out.println("chuc nang:   danh sach nhan vien tham gia ca lam");
                        chucnangqlnl.danhSachNhanVienThamGiaCaLam();
                    }
                        break;
                    case 6: {
                        System.out.println("----------------------------------");
                        System.out.println("chuc nang:  chinh sua nhan vien tham gia ca lam");
                        chucnangqlnl.themNhanVienvaocalam();
                    }
                        break;
                    default:
                        break;
                }
                do {
                    System.out.println("---------------------------------");
                    System.out.println("nhap 0 de thoat");
                    System.out.println("nhap 7 de tro lai chuc nang quan ly nhan su");
                    System.out.print("nhan lua chon:");
                    select = inputs.nextInt();
                    if (select != 0 && select != 7) {
                        System.out.println("---------------------------------");
                        System.out.println("loi lua chon hay lua chon lai!");
                    }

                } while (select != 0 && select != 7);
                if (select == 7) {
                    ChucNang();
                    return;
                }
                if (select == 0) {
                    HeThong.state = 9;
                    return;
                }
            }
                break;
            case 2: {
                int select = 0;
                do {
                    menuDeAn();
                    ;
                    System.out.print("nhan  lua chon:");
                    select = inputs.nextInt();
                    if ((select < 0 || select > 7) && select != 9) {
                        System.out.println("-----------------------");
                        System.out.println("loi lua chon vui long nhap lai");
                    }
                } while ((select < 0 || select > 7) && select != 9);
                if (select == 7) {
                    ChucNang();
                    return;
                }
                if (select == 9) {
                    System.out.println("----------------------------------");
                    System.out.println("da dang xuat !");
                    System.out.println("---------------------------------");
                    HeThong.state = 9;
                    return;
                }
                switch (select) {
                    case 1: {
                        System.out.println("----------------------------------");
                        System.out.println("chuc nang: tim kiem de an");
                        chucnangqlnl.TimDeAn();
                    }
                        break;
                    case 2: {
                        System.out.println("----------------------------------");
                        System.out.println("chuc nang:  them de an");
                        chucnangqlnl.ThemDeAn();
                    }
                        break;
                    case 3: {
                        System.out.println("----------------------------------");
                        System.out.println("chuc nang:  sua de an");
                        chucnangqlnl.SuaThongTinDeAn();
                    }
                        break;
                    case 4: {
                        System.out.println("----------------------------------");
                        System.out.println("chuc nang:  xoa de an");
                        chucnangqlnl.XoaDeAn();
                    }
                        break;
                    case 5: {
                        System.out.println("----------------------------------");
                        System.out.println("chuc nang:   danh sach nhan vien tham gia de an");
                        chucnangqlnl.danhSachNhanVienThamGiaDeAn();
                    }
                        break;
                    case 6: {
                        System.out.println("----------------------------------");
                        System.out.println("chuc nang:   chinh sua nhan vien tham gia de an");
                        chucnangqlnl.themNhanVienVaoDeAn();
                    }
                        break;
                    default:
                        break;
                }
                do {
                    System.out.println("---------------------------------");
                    System.out.println("nhap 0 de thoat");
                    System.out.println("nhap 7 de tro lai chuc nang quan ly nhan su");
                    System.out.print("nhan lua chon:");
                    select = inputs.nextInt();
                    if (select != 0 && select != 7) {
                        System.out.println("---------------------------------");
                        System.out.println("loi lua chon hay lua chon lai!");
                    }

                } while (select != 0 && select != 7);
                if (select == 7) {
                    ChucNang();
                    return;
                }
                if (select == 0) {
                    HeThong.state = 9;
                    return;
                }
            }
            default:
                break;
        }
    }
}
