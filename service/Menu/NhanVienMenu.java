package service.Menu;

import java.util.Scanner;

import core.HeThong;
import model.NVFunction;
import model.NhanVien;
import model.checkError;
import service.User;

public class NhanVienMenu {
  public static void Chucnang() {
    Scanner inputs = new Scanner(System.in);

    int select = 0;
    do {
      System.out.println("------------danh sach chuc nang-----");
      System.out.println("1.xem thong tin ca nhan");
      System.out.println("2.chinh sua thong tin ca nhan");

      System.out.println("3.dang xuat ");
      System.out.print("nhap lua chon:");
      select = inputs.nextInt();
      if (select < 1 || select > 3) {
        System.out.println("loi lua chon vui long nhap lai");
      }

    } while (select < 1 || select > 3);
    if (select == 3) {
      System.out.println("----------------------------------");
      System.out.println("da dang xuat !");
      System.out.println("---------------------------------");
      HeThong.state = 9;

      return;
    }
    NVFunction method = new NVFunction();
    NhanVien nhanVien = method.getNV(User.userAcount);
    switch (select) {
      case 1: {
        // String HoTen, String GioiTinh, String DiaChi, String QueQuan, String
        // NgaySinh, String SoDT,
        // String DanToc, String TonGiao, String HocVan, String MaNV, String MaPhong,
        // String ChucVu, String LoaiHD, String NgayKiHD, String NgayHetHan, String
        // Gmail
        System.out.println("----thong tin ca nhan----------");
        System.out.println("ho ten:" + nhanVien.getHoTen());
        System.out.println("Gioi tinh:" + nhanVien.getGioiTinh());
        System.out.println("dia chi:" + nhanVien.getDiaChi());
        System.out.println("que quan:" + nhanVien.getQueQuan());
        System.out.println("ngay sinh:" + nhanVien.getNgaySinh());
        System.out.println("so dien thoai" + nhanVien.getSoDT());
        System.out.println("dan toc:" + nhanVien.getDanToc());
        System.out.println("ton giao:" + nhanVien.getTonGiao());
        System.out.println("hoc van:" + nhanVien.getHocVan());
        System.out.println("ma nhan vien:" + nhanVien.getMaNV());
        System.out.println("ma phong:" + nhanVien.getMaPhong());
        System.out.println("chuc vu:" + nhanVien.getChucVu());
        System.out.println("loai hop dong:" + nhanVien.getLoaiHD());
        System.out.println("ngay ki hop dong:" + nhanVien.getNgayKy());
        System.out.println("ngay het han:" + nhanVien.getNgayHetHan());
        System.out.println("gmail:" + nhanVien.getGmail());
        do {
          System.out.println("---------------------------------");
          System.out.println("nhap 0 de thoat");
          System.out.println("nhap 9 de tro lai chuc nang nhan vien");
          System.out.print("nhan lua chon:");
          select = inputs.nextInt();
          if (select != 0 && select != 9) {
            System.out.println("---------------------------------");
            System.out.println("loi lua chon hay lua chon lai!");
          }
        } while (select != 0 && select != 9);
        if (select == 9) {
          Chucnang();
          return;
        }
        if (select == 0) {
          HeThong.state = 9;
          return;
        }
        return;
      }
      case 2: {
        System.out.println("-------chinh sua thong tin ca nhan------");
        int option = 0;
        do {
          System.out.println("chon thong tin can chinh sua");
          System.out.println("1 ho ten");
          System.out.println("2 gioi tinh");
          System.out.println("3 dia chi");
          System.out.println("4 que quan");
          System.out.println("5 ngay sinh");
          System.out.println("6 so dien thoai");
          System.out.println("7 dan toc");
          System.out.println("8 ton gia");
          System.out.println("9 hoc van");
          System.out.println("10 gmail");
          System.out.println("11 thoat chuc nang");
          System.out.print("nhap tuy chon:");
          option = inputs.nextInt();
          if (option < 1 || option > 11) {
            System.out.println("---------------------------------");
            System.out.println("loi lua chon hay lua chon lai!");
          }

        } while (option < 1 || option > 11);
        if (option == 11) {
          System.out.println("----------------------------------");
          System.out.println("da dang xuat !");
          System.out.println("---------------------------------");
          HeThong.state = 9;

          return;
        }
        checkError check = new checkError();
        inputs.nextLine();
        switch (option) {
          case 1: {
            System.out.println("ho ten cu:" + nhanVien.getHoTen());
            String hoTen = "";
            do {
              System.out.print("nhap ho ten moi:");
              hoTen = inputs.nextLine();
              if (check.nullInput(hoTen)) {
                System.out.println("thong tin khong duoc bo trong");
              }
            } while (check.nullInput(hoTen));
            nhanVien.setHoTen(hoTen);
            System.out.println("-----da  cap nhat ho ten------");
          }
            break;
          case 2: {
            System.out.print("nhap gioi  tinh(Nam/Nu):");
            String GioiTinh = "";
            do {
              System.out.print("nhap gioi tinh");
              GioiTinh = inputs.nextLine();
              if (check.nullInput(GioiTinh)) {
                System.out.println("thong tin khong duoc bo trong");
              }
            } while (check.nullInput(GioiTinh));
            nhanVien.setGioiTinh(GioiTinh);
            System.out.println("------da cap nhat gioi tinh---------");
          }
            break;
          case 3: {
            System.out.println("dia chi cu:" + nhanVien.getDiaChi());
            String DiaChi = "";
            do {
              System.out.print("nhap dia chi moi");
              DiaChi = inputs.nextLine();
              if (check.nullInput(DiaChi)) {
                System.out.println("thong tin khong duoc bo trong");
              }
            } while (check.nullInput(DiaChi));
            nhanVien.setDiaChi(DiaChi);
            System.out.println("--------da cap nhat dia chi");
          }
            break;
          case 4: {
            System.out.println("que quan cu:" + nhanVien.getQueQuan());
            String QueQuan = "";
            do {
              System.out.print("nhap ho que quan moi:");
              QueQuan = inputs.nextLine();
              if (check.nullInput(QueQuan)) {
                System.out.println("thong tin khong duoc bo trong");
              }
            } while (check.nullInput(QueQuan));
            nhanVien.setQueQuan(QueQuan);
            System.out.println("--------da cap nhat que quan------");

          }
            break;
          case 5: {
            System.out.println("ngay sinh cu:" + nhanVien.getNgaySinh());
            String NgaySinh = "";
            do {
              System.out.print("nhap ngay sinh moi:");
              NgaySinh = inputs.nextLine();
              if (check.nullInput(NgaySinh)) {
                System.out.println("thong tin khong duoc bo trong");
              }
              if (!check.dateFormat(NgaySinh)) {
                System.out.println("dinh dang ngay sinh khong chinh sac dd-mm-yyyy");
              }

            } while (check.nullInput(NgaySinh) && !check.dateFormat(NgaySinh));
            nhanVien.setNgaySinh(NgaySinh);
            System.out.println("----------da cap nhat ngay sinh---------");

          }
            break;
          case 6: {
            System.out.println("so dien thoai cu:" + nhanVien.getSoDT());
            String SoDT = "";
            do {
              System.out.print("nhap so dien thoai");
              SoDT = inputs.nextLine();
              if (check.nullInput(SoDT)) {
                System.out.println("thong tin khong duoc bo trong");
              }
              if (!check.isNumber(SoDT)) {
                System.out.println("thong tin khong phai la so!");
              }
            } while (check.nullInput(SoDT) && !check.isNumber(SoDT));
            nhanVien.setSoDT(SoDT);
            System.out.println("---------da cap nhat so dien thoai--------");
          }
            break;
          case 7: {
            System.out.print("nhap dan toc:");
            String danToc = "";
            do {
              System.out.print("nhap dan toc:");
              danToc = inputs.nextLine();
              if (check.nullInput(danToc)) {
                System.out.println("thong tin khong duoc bo trong");
              }
            } while (check.nullInput(danToc));
            nhanVien.setDanToc(danToc);
            System.out.println("-----------da cap nhat dan toc----------");
          }
            break;
          case 8: {
            System.out.print("nhap ton giao :");
            String TonGiao = "";
            do {
              System.out.print("nhap ton giao:");
              TonGiao = inputs.nextLine();
              if (check.nullInput(TonGiao)) {
                System.out.println("thong tin khong duoc bo trong");
              }
            } while (check.nullInput(TonGiao));
            nhanVien.setTonGiao(TonGiao);
            System.out.println("----------da cap nhat ton giao--------");
          }
            break;
          case 9: {
            System.out.print("nhap hoc van(12/12):");
            String HocVan = "";
            do {
              System.out.print("nhap hoc van:");
              HocVan = inputs.nextLine();
              if (check.nullInput(HocVan)) {
                System.out.println("thong tin khong duoc bo trong");
              }
              if (!check.isNumber(HocVan)) {
                System.out.println("thong tin khong phai la so");
              }
            } while (check.nullInput(HocVan) && !check.isNumber(HocVan));
            nhanVien.setHocVan(HocVan);
            System.out.println("-----------da cap nhat hoc van ------------");
          }
            break;
          case 10: {
            System.out.println("gmail cu:" + nhanVien.getGmail());
            String Gmail = "";
            do {
              System.out.print("nhap gmail moii:");
              Gmail = inputs.nextLine();
              if (check.nullInput(Gmail)) {
                System.out.println("thong tin khong duoc bo trong");
              }
              if (!check.checkEmail(Gmail)) {
                System.out.println("dinh dang gmail khong dung");
              }
            } while (check.nullInput(Gmail) && !check.checkEmail(Gmail));
            nhanVien.setGmail(Gmail);
            System.out.println("----------da cap nhat gmail--------------");
          }
            break;
          default:
            break;
        }
        method.setNV(nhanVien, User.userAcount);
        do {
          System.out.println("---------------------------------");
          System.out.println("nhap 0 de thoat");
          System.out.println("nhap 12 de tro lai chuc nang nhan vien");
          System.out.print("nhan lua chon:");
          select = inputs.nextInt();
          if (select != 0 && select != 12) {
            System.out.println("---------------------------------");
            System.out.println("loi lua chon hay lua chon lai!");
          }
        } while (select != 0 && select != 12);
        if (select == 12) {
          Chucnang();
          return;
        }
        if (select == 0) {
          HeThong.UpdateList(1);
          System.out.println("out");
          HeThong.state = 9;
          return;
        }
        return;

      }
      default:
        break;
    }
  }
}
