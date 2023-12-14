package service.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import core.HeThong;
import model.KhenThuong;
import model.KiLuat;
public class TruongBan { 
    public static void menuKhenThuong(){    // + class KhenThuong + class ArraysInterface
        System.out.println(" -------- Danh sach chuc nang khen thuong --------");
        System.out.println("1.tim kiem nhan vien khen thuong");
        System.out.println("2.them nhan vien khen thuong");
        System.out.println("3.chinh sua thong tin khen thuong");
        System.out.println("4.xoa nhan vien khen thuong");
        System.out.println("5.danh sach khen thuong");
        System.out.println("6.tro lai chuc nang Truong ban ");
        System.out.println("9.Dang xuat");
    }

    public static void menuKiLuat(){    // + class KiLuat
        System.out.println(" -------- Danh sach chuc nang ki luat --------");
        System.out.println("1.tim kiem nhan vien ki luat");
        System.out.println("2.them nhan vien ki luat");
        System.out.println("3.chin sua thong tin ki luat");
        System.out.println("4.xoa nhan vien ki luat");
        System.out.println("5.danh sach ki luat");
        System.out.println("6.tro lai chuc nang Truong ban ");
        System.out.println("9.Dang xuat");
    }

    public static void menuBaoCao(){    // + class BaoCao
        System.out.println(" -------- Danh sach chuc nang bao cao --------");
        System.out.println("1.in danh sach theo nhan vien nghi viec");
        System.out.println("2.in danh sach theo nhan vien con lam");
        System.out.println("3.in danh sach theo chuc vu");
        System.out.println("6.tro lai chuc nang Truong ban ");
        System.out.println("9.Dang xuat");
    }

    // public static KhenThuong khenthuong;
    // public static KiLuat kiluat;
    // public static BaoCao baocao;

    // public TruongBan() {
    //     khenthuong = new KhenThuong();
    //     kiluat = new KiLuat();
    //     baocao = new BaoCao();
    // }

 
    // Chức năng
    public static void ChucNang() {
        Scanner input = new Scanner(System.in);
        int option = 0;
        do {
            try{
                System.out.println("----- danh sach chuc nang -----");
                System.out.println("1.chuc nang khen thuong");
                System.out.println("2.chuc nang ki luat");
                System.out.println("3.chuc nang bao cao");
                System.out.println("9.Dang xuat");
                System.out.print("Nhap lua chon: ");
                option = input.nextInt();
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
            if (option < 0 && option > 4) {
                System.out.println("loi lua chon vui long nhap lai");
            }
        }while(option < 0 && option > 4);

            switch (option) {
                case 1:{ // lua chon menu khen thuong
                    menuKhenThuong();
                    int select = 0;
                    System.out.println("Nhap lua chon: ");
                    select = input.nextInt();
                    if(select == 6){
                        ChucNang();
                        return;
                    }
                    if(select == 9){
                        System.out.println("----------------------------------"); 
                        System.out.println("da dang xuat !");
                        System.out.println("---------------------------------");
                        HeThong.state = 9;
                        return;
                    } 
                // tuy chon trong menu khen thuong
                KhenThuong khenthuong = new KhenThuong();
                    switch(select){
                        case 1:{
                            System.out.println("----------------------------------");
                            System.out.println("chuc nang: tim kiem nhan vien khen thuong");
                            khenthuong.TimKiemThongTin();
                        }
                            break;
                        case 2: {
                            System.out.println("----------------------------------");
                            System.out.println("chuc nang: them thong tin khen thuong");
                            khenthuong.ThemThongTin();
                        }
                            break;
                        case 3: {
                            System.out.println("----------------------------------");
                            System.out.println("chuc nang: chinh sua thong tin khen thuong");
                            khenthuong.ChinhSuaThongTin();
                        }
                            break;
                        case 4: {
                            System.out.println("----------------------------------");
                            System.out.println("chuc nang: xoa thong tin khen thuong ");
                            khenthuong.XoaThongTin();
                        }
                            break;
                        case 5: {
                            System.out.println("----------------------------------");
                            System.out.println("chuc nang: danh sach khen thuong");
                            khenthuong.InDanhSach();
                        }
                            break;
                        default:
                        break;

                    } 
                    do {
                        System.out.println("---------------------------------");
                        System.out.println("nhap 0 de thoat");
                        System.out.println("nhap 6 de tro lai chuc nang Truong ban");
                        System.out.print("nhan lua chon: ");
                        select = input.nextInt();
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
                }
                // end tuy chon trong menu khen thuong

                case 2:{ // lua chon menu ki luat 
                    int select = 0;
                    menuKiLuat();
                    System.out.println("Nhap lua chon: ");
                    select = input.nextInt();
                    if(select == 6){
                        ChucNang();
                        return;
                    }
                    if(select == 9){
                        System.out.println("----------------------------------");
                        System.out.println("da dang xuat !");
                        System.out.println("---------------------------------");
                        HeThong.state = 9;
                        return;
                    }
                // tuy chon trong menu Ki Luat
                KiLuat kiluat = new KiLuat();
                    switch(select){ 
                        case 1:{
                            System.out.println("----------------------------------");
                            System.out.println("chuc nang: tim kiem nhan vien ki luat");
                            kiluat.TimKiemThongTin();
                        }
                            break;
                        case 2: {
                            System.out.println("----------------------------------");
                            System.out.println("chuc nang: them thong tin ki luat");
                            kiluat.ThemThongTin();
                        }
                            break;
                        case 3: {
                            System.out.println("----------------------------------");
                            System.out.println("chuc nang: chinh sua thong tin ki luat");
                            kiluat.ChinhSuaThongTin();
                        }
                            break;
                        case 4: {
                            System.out.println("----------------------------------");
                            System.out.println("chuc nang: xoa thong tin ki luat");
                            kiluat.XoaThongTin();
                        }
                            break;
                        case 5: {
                            System.out.println("----------------------------------");
                            System.out.println("chuc nang: danh sach ki luat");
                            kiluat.InDanhSach();
                        }
                            break;
                        default:
                        break;
                    } 
                    
                    do {
                        System.out.println("---------------------------------");
                        System.out.println("nhap 0 de thoat");
                        System.out.println("nhap 6 de tro lai chuc nang Truong ban");
                        System.out.print("nhan lua chon: ");
                        select = input.nextInt();
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
                }   
                // end tuy chon trong menu ki luat

                case 3: { //chon chuc nang in bao cao
                    int select = 0;
                    menuBaoCao();
                    System.out.println("Nhap lua chon: ");
                    select = input.nextInt();
                    if(select == 6){
                        ChucNang();
                        return;
                    }
                    if(select == 9){
                        System.out.println("----------------------------------");
                        System.out.println("da dang xuat !");
                        System.out.println("---------------------------------");
                        HeThong.state = 9;
                        return;
                    }
                BaoCao baocao = new BaoCao();
                // tuy chon trong menu bao cao
                    switch(select){ 
                        case 1:{
                            System.out.println("----------------------------------");
                            System.out.println("chuc nang: bao cao theo nhan vien nghi viec");
                            baocao.InNhanVienDaNghi();
                        }
                            break;
                        case 2:{
                            System.out.println("----------------------------------");
                            System.out.println("chuc nang: bao cao theo nhan vien con lam");
                            baocao.InNhanVienConLam();
                        }
                            break;
                        case 3:{
                            System.out.println("----------------------------------");
                            System.out.println("chuc nang: bao cao theo chuc vu");   
                            baocao.InTheoChucVu();
                        }
                            break;
                        default:
                        break;
                    }
                    do {
                        System.out.println("---------------------------------");
                        System.out.println("nhap 0 de thoat");
                        System.out.println("nhap 6 de tro lai chuc nang quan ly nhan su");
                        System.out.print("nhan lua chon: ");
                        select = input.nextInt();
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
                }
                // end chuc nang bao cao 

                default:
                    break;
            }
    }
}
       