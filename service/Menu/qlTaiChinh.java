package service.Menu;

import java.util.Scanner;
import java.util.List;
import core.HeThong;
import model.Luong;
import model.NhanVien;

public class qlTaiChinh {
    public static void menu() {
        System.out.println("---------danh sach chuc nang--------");
        System.out.println("1.chuc nang tim kiem");
        System.out.println("2.chuc nang them ");
        System.out.println("3.chuc nang sua");
        System.out.println("4.chuc nang xoa");
        System.out.println("5.danh sach luong");
        System.out.println("6.tinh luong");
        System.out.println("9 danh xuat khoi he thong");
    }

    public static void ChucNang() {
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
            if (selector < 0 || selector > 7) {
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
        } while (selector < 0 || selector > 7);
        Luong method = new Luong();
        switch (selector) {
            case 1: {
                System.out.println("---------------------------");
                System.out.println("____________chuc nang tim kiem___________");
                int select = 0;
                do {
                    System.out.println("-------chon phong ban can thao tac--------");
                    System.out.println("1.phong nhan su");
                    System.out.println("2.phong tai chinh");
                    System.out.println("3.phong nhan luc");
                    System.out.println("4.truong ban");
                    System.out.println("5.phong quan tri");
                    System.out.println("6. tro lai danh sach chuc nang quan ly tai chinh");
                    System.out.print("nhap lua chon:");
                    select = inputs.nextInt();
                    if (select < 1 || select > 6) {
                        System.out.println("-----------------------------------");
                        System.out.println("loi lua chon vui long nhap lai");
                    }

                } while (select < 1 || select > 6);
                if (select == 6) {
                    ChucNang();
                    return;
                }
                System.out.println("-----------------------");
                System.out.println("chuc nang:tim kiem");
                method.TimKiemThongTin();
                do {
                    System.out.println("---------------------------------");
                    System.out.println("nhap 0 de thoat");
                    System.out.println("nhap 6 de tro lai chuc nang quan ly tai chinh");
                    System.out.print("nhan lua chon:");
                    select = inputs.nextInt();
                    if (select != 0 && select != 6) {
                        System.out.println("---------------------------------");
                        System.out.println("loi lua chon hay lua chon lai!");
                    }
                } while (select != 0 && select != 6);
                if (select == 6) {
                    ChucNang();
                    return;
                }
                if (select == 0) {
                    HeThong.state = 9;
                    return;
                }
                return;
            }
            case 2: {
                System.out.println("---------------------------");
                System.out.println("____________chuc nang them xoa muc luong___________");
                int select = 0;
                do {
                    System.out.println("-------chon phong ban can thao tac--------");
                    System.out.println("1.phong nhan su");
                    System.out.println("2.phong tai chinh");
                    System.out.println("3.phong nhan luc");
                    System.out.println("4.truong ban");
                    System.out.println("5.phong quan tri");
                    System.out.println("6. tro lai danh sach chuc nang quan ly tai chinh");
                    System.out.print("nhap lua chon:");
                    select = inputs.nextInt();
                    if (select < 1 || select > 6) {
                        System.out.println("-----------------------------------");
                        System.out.println("loi lua chon vui long nhap lai");
                    }

                } while (select < 1 || select > 6);
                if (select == 6) {
                    ChucNang();
                    return;
                }
                System.out.println("-----------------------");
                System.out.println("chuc nang:them muc luong");
                method.ThemThongTin();
                do {
                    System.out.println("---------------------------------");
                    System.out.println("nhap 0 de thoat");
                    System.out.println("nhap 6 de tro lai chuc nang quan ly tai chinh");
                    System.out.print("nhan lua chon:");
                    select = inputs.nextInt();
                    if (select != 0 && select != 6) {
                        System.out.println("---------------------------------");
                        System.out.println("loi lua chon hay lua chon lai!");
                    }
                } while (select != 0 && select != 6);
                if (select == 6) {
                    ChucNang();
                    return;
                }
                if (select == 0) {
                    HeThong.state = 9;
                    return;
                }
                return;
            }
            case 3: {
                System.out.println("---------------------------");
                System.out.println("____________chuc nang sua muc luong___________");
                int select = 0;
                do {
                    System.out.println("-------chon phong ban can thao tac--------");
                    System.out.println("1.phong nhan su");
                    System.out.println("2.phong tai chinh");
                    System.out.println("3.phong nhan luc");
                    System.out.println("4.truong ban");
                    System.out.println("5.phong quan tri");
                    System.out.println("6. tro lai danh sach chuc nang quan ly tai chinh");
                    System.out.print("nhap lua chon:");
                    select = inputs.nextInt();
                    if (select < 1 || select > 6) {
                        System.out.println("-----------------------------------");
                        System.out.println("loi lua chon vui long nhap lai");
                    }

                } while (select < 1 || select > 6);
                if (select == 6) {
                    ChucNang();
                    return;
                }
                System.out.println("-----------------------");
                System.out.println("chuc nang:sua muc luong");
                method.ChinhSuaThongTin();
                do {
                    System.out.println("---------------------------------");
                    System.out.println("nhap 0 de thoat");
                    System.out.println("nhap 6 de tro lai chuc nang quan ly tai chinh");
                    System.out.print("nhan lua chon:");
                    select = inputs.nextInt();
                    if (select != 0 && select != 6) {
                        System.out.println("---------------------------------");
                        System.out.println("loi lua chon hay lua chon lai!");
                    }
                } while (select != 0 && select != 6);
                if (select == 6) {
                    ChucNang();
                    return;
                }
                if (select == 0) {
                    HeThong.state = 9;
                    return;
                }
                return;
            }
            case 4: {
                System.out.println("---------------------------");
                System.out.println("____________chuc nang xoa muc luong___________");
                int select = 0;
                do {
                    System.out.println("-------chon phong ban can thao tac--------");
                    System.out.println("1.phong nhan su");
                    System.out.println("2.phong tai chinh");
                    System.out.println("3.phong nhan luc");
                    System.out.println("4.truong ban");
                    System.out.println("5.phong quan tri");
                    System.out.println("6. tro lai danh sach chuc nang quan ly tai chinh");
                    System.out.print("nhap lua chon:");
                    select = inputs.nextInt();
                    if (select < 1 || select > 6) {
                        System.out.println("-----------------------------------");
                        System.out.println("loi lua chon vui long nhap lai");
                    }

                } while (select < 1 || select > 6);
                if (select == 6) {
                    ChucNang();
                    return;
                }
                System.out.println("-----------------------");
                System.out.println("chuc nang:xoa muc luong");
                method.XoaThongTin();
                do {
                    System.out.println("---------------------------------");
                    System.out.println("nhap 0 de thoat");
                    System.out.println("nhap 6 de tro lai chuc nang quan ly tai chinh");
                    System.out.print("nhan lua chon:");
                    select = inputs.nextInt();
                    if (select != 0 && select != 6) {
                        System.out.println("---------------------------------");
                        System.out.println("loi lua chon hay lua chon lai!");
                    }
                } while (select != 0 && select != 6);
                if (select == 6) {
                    ChucNang();
                    return;
                }
                if (select == 0) {
                    HeThong.state = 9;
                    return;
                }
                return;
            }
            case 5: {
                System.out.println("---------------------------");
                System.out.println("____________chuc nang danh sach___________");
                int select = 0;
                do {
                    System.out.println("-------chon phong ban can thao tac--------");
                    System.out.println("1.phong nhan su");
                    System.out.println("2.phong tai chinh");
                    System.out.println("3.phong nhan luc");
                    System.out.println("4.truong ban");
                    System.out.println("5.phong quan tri");
                    System.out.println("6. tro lai danh sach chuc nang quan ly tai chinh");
                    System.out.print("nhap lua chon:");
                    select = inputs.nextInt();
                    if (select < 1 || select > 6) {
                        System.out.println("-----------------------------------");
                        System.out.println("loi lua chon vui long nhap lai");
                    }

                } while (select < 1 || select > 6);
                if (select == 6) {
                    ChucNang();
                    return;
                }
                System.out.println("-----------------------");
                System.out.println("chuc nang:in danh sach");
                method.InDanhSach();
                do {
                    System.out.println("---------------------------------");
                    System.out.println("nhap 0 de thoat");
                    System.out.println("nhap 6 de tro lai chuc nang quan ly tai chinh");
                    System.out.print("nhan lua chon:");
                    select = inputs.nextInt();
                    if (select != 0 && select != 6) {
                        System.out.println("---------------------------------");
                        System.out.println("loi lua chon hay lua chon lai!");
                    }
                } while (select != 0 && select != 6);
                if (select == 6) {
                    ChucNang();
                    return;
                }
                if (select == 0) {
                    HeThong.state = 9;
                    return;
                }
                return;
            }
            case 6: {
                System.out.println("---------------------------");
                System.out.println("____________chuc nang tinh luong___________");
                int select = 0;
                do {
                    System.out.println("-------chon phong ban can thao tac--------");
                    System.out.println("1.phong nhan su");
                    System.out.println("2.phong tai chinh");
                    System.out.println("3.phong nhan luc");
                    System.out.println("4.truong ban");
                    System.out.println("5.phong quan tri");
                    System.out.println("6. tro lai danh sach chuc nang quan ly tai chinh");
                    System.out.print("nhap lua chon:");
                    select = inputs.nextInt();
                    if (select < 1 || select > 6) {
                        System.out.println("-----------------------------------");
                        System.out.println("loi lua chon vui long nhap lai");
                    }

                } while (select < 1 || select > 6);
                if (select == 6) {
                    ChucNang();
                    return;
                }
                System.out.println("-----------------------");
                System.out.println("chuc nang:tinh luong");
                method.TinhLuong();
                do {
                    System.out.println("---------------------------------");
                    System.out.println("nhap 0 de thoat");
                    System.out.println("nhap 6 de tro lai chuc nang quan ly tai chinh");
                    System.out.print("nhan lua chon:");
                    select = inputs.nextInt();
                    if (select != 0 && select != 6) {
                        System.out.println("---------------------------------");
                        System.out.println("loi lua chon hay lua chon lai!");
                    }
                } while (select != 0 && select != 6);
                if (select == 6) {
                    ChucNang();
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
