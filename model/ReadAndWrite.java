package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReadAndWrite {
    String pathNV = "Data/NhanVien_data/NV.csv";
    String pathHD = "Data/NhanVien_data/HD.csv";
    String pathPB = "Data/NhanVien_data/PB.csv";
    Scanner input = new Scanner(System.in);
    checkError check = new checkError();

    public int demSoDong(String path) throws IOException {
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        int soDong = 0;
        while (bufferedReader.readLine() != null) {
            soDong++;
        }

        bufferedReader.close();
        fileReader.close();

        return soDong;
    }

    public void WriteNhanVien(NhanVien[] nhanvien, int kt) {
        try {
            FileWriter fw = new FileWriter(pathNV);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < kt; i++) {
                if (nhanvien[i] != null) {
                    bw.write(nhanvien[i].toString());
                    bw.newLine();
                }
            }
            System.out.println("-----Da Ghi Du Lieu Vao File-----");
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void WriteHopDong(HopDong[] hopdong, int kt) {
        try {
            FileWriter fw = new FileWriter(pathHD);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < kt; i++) {
                if (hopdong[i] != null) {
                    bw.write(hopdong[i].toString());
                    bw.newLine();
                }
            }
            System.out.println("-----Da Ghi Du Lieu Vao File-----");
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void WritePhongBan(PhongBan[] phongban, int kt) {
        try {
            FileWriter fw = new FileWriter(pathPB);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < kt; i++) {
                if (phongban[i] != null) {
                    bw.write(phongban[i].toString());
                    bw.newLine();
                }
            }
            System.out.println("-----Da Ghi Du Lieu Vao File-----");
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public NhanVien[] ReadNhanVien() {
        NhanVien[] nhanvien = null;

        try {
            int soDong = demSoDong(pathNV);
            nhanvien = new NhanVien[soDong];

            FileReader fr = new FileReader(pathNV);
            BufferedReader reader = new BufferedReader(fr);

            PhongBan phong;
            HopDong hopdong;
            NhanVien nv;

            String line;
            int i = 0;

            while ((line = reader.readLine()) != null) {
                String txt[] = line.split("\\|");
                nv = new NhanVien();
                nv.setMaNV(txt[0]);
                nv.setHoTen(txt[1]);
                phong = new PhongBan();
                phong.setMaPhongBan(txt[2]);
                hopdong = new HopDong();
                hopdong.setViTri(txt[3]);
                hopdong.setLoaiHD(txt[4]);
                hopdong.setNgayKiHD(txt[5]);
                hopdong.setNgayHetHan(txt[6]);
                nv.setGmail(txt[7]);
                nhanvien[i] = new NhanVien(nv, hopdong, phong);
                i++;
            }
            System.out.println("-----Da Doc Du Lieu Tu File-----");
            reader.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nhanvien;

    }

    public HopDong[] ReadHopDong() {
        HopDong[] hopdong = null;
        HopDong hd;
        try {
            int soDong = demSoDong(pathHD);
            hopdong = new HopDong[soDong];

            FileReader fr = new FileReader(pathHD);
            BufferedReader reader = new BufferedReader(fr);
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                String txt[] = line.split("\\|");
                hd = new HopDong();
                hd.setID(txt[0]);
                hd.setLoaiHD(txt[1]);
                hd.setLuongCB(txt[2]);
                hd.setViTri(txt[3]);
                hd.setNgayKiHD(txt[4]);
                hd.setNgayHetHan(txt[5]);
                hopdong[i] = new HopDong(hd);
                i++;

            }
            reader.close();
            fr.close();
            System.out.println("----Da Doc Du Lieu Tu File----");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return hopdong;
    }

    public PhongBan[] ReadPhongBan() {
        PhongBan[] phongban = null;
        PhongBan pb;
        try {
            int soDong = demSoDong(pathPB);
            phongban = new PhongBan[soDong];
            FileReader fr = new FileReader(pathPB);
            BufferedReader reader = new BufferedReader(fr);
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                String txt[] = line.split("\\|");
                pb = new PhongBan();
                pb.setMaPhongBan(txt[0]);
                pb.setTenPhongBan(txt[1]);
                pb.setNgayThanhLap(txt[2]);
                phongban[i] = new PhongBan(pb);
                i++;
            }
            System.out.println("----Da Doc Du Lieu Tu File----");
            reader.close();
            fr.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return phongban;
    }

    public void menu1() {
        String choose;
        ReadAndWrite a = new ReadAndWrite();
        actionNhanVien b = new actionNhanVien();
        do {
            System.out.println("======Nhap Lua Chon Cua Ban====");
            System.out.println("      1.Tao File Nhan Vien");
            System.out.println("      2.Thuc Hien Chuc Nang");
            System.out.println("      3.Ghi File Nhan Vien");
            System.out.println("      4.Doc File Nhan Vien");
            System.out.println("      5.Quay Lai !!!");
            choose = input.nextLine();
            switch (choose) {
                case "1":
                    b.ThemThongTin();
                    break;
                case "2":
                    String chon;
                    do {
                        System.out.println("=====Nhap Lua Chon Cua Ban=====");
                        System.out.println("     1.Them Nhan Vien ");
                        System.out.println("     2.Chinh Sua Thong Tin Nhan Vien");
                        System.out.println("     3.Xoa Nhan Vien");
                        System.out.println("     4.Tim Kiem Nhan Vien");
                        System.out.println("     5.In Danh Sach Nhan Vien");
                        System.out.println("     6.Quay Lai !!!");
                        chon = input.nextLine();
                        switch (chon) {
                            case "1":
                                b.ThemThongTin();
                                break;
                            case "2":
                                b.ChinhSuaThongTin();
                                break;
                            case "3":
                                b.XoaThongTin();
                                break;
                            case "4":
                                b.TimKiemThongTin();
                                break;
                            case "5":
                                b.InDanhSach();
                                break;
                            case "6":
                                break;
                            default:
                                System.out.println("Lua Chon Cua Ban Khong Hop Le !");
                                break;
                        }

                    } while (!chon.equals("6"));

                    break;
                case "3":
                    a.WriteNhanVien(b.getDanhSachNhanVien(), b.getKt());
                    break;
                case "4":
                    NhanVien[] nhanvien = a.ReadNhanVien();
                    b = new actionNhanVien(nhanvien, nhanvien.length);
                    break;
                case "5":
                    break;
                default:
                    System.out.println("Lua Chon Cua Ban Khong Hop Le !");
                    break;

            }

        } while (!choose.equals("5"));
    }

    public void menu2() {
        String choose;
        ReadAndWrite a = new ReadAndWrite();
        actionHopDong b = new actionHopDong();
        do {
            System.out.println("=====Nhap Lua Chon Cua Ban=====");
            System.out.println("     1.Tao File Hop Dong");
            System.out.println("     2.Thuc Hien Chuc Nang");
            System.out.println("     3.Ghi File HopDong");
            System.out.println("     4.Doc File HopDong");
            System.out.println("     5.Quay Lai !!!");
            choose = input.nextLine();
            switch (choose) {
                case "1":
                    b.ThemThongTin();
                    break;
                case "2":
                    String chon;
                    do {
                        System.out.println("=====Nhap Lua Chon Cua Ban");
                        System.out.println("     1.Them Hop Dong ");
                        System.out.println("     2.Chinh Sua Thong Tin Hop Dong");
                        System.out.println("     3.Xoa Hop Dong");
                        System.out.println("     4.Tim Kiem Hop Dong");
                        System.out.println("     5.In Danh Sach Hop Dong");
                        System.out.println("     6.Quay Lai !!!");
                        chon = input.nextLine();
                        switch (chon) {
                            case "1":
                                b.ThemThongTin();
                                break;
                            case "2":
                                b.ChinhSuaThongTin();
                                break;
                            case "3":
                                b.XoaThongTin();
                                break;
                            case "4":
                                b.TimKiemThongTin();
                                break;
                            case "5":
                                b.InDanhSach();
                                break;
                            case "6":
                                break;
                            default:
                                System.out.println("Lua Chon Cua Ban Khong Hop Le !");
                                break;
                        }

                    } while (!chon.equals("6"));

                    break;
                case "3":
                    a.WriteHopDong(b.getDanhSachHopDong(), b.getKt());
                    break;
                case "4":
                    HopDong[] hopdong = ReadHopDong();
                    b = new actionHopDong(hopdong, hopdong.length);
                    break;
                case "5":
                    break;
                default:
                    System.out.println("Lua Chon Cua Ban Khong Hop Le !");
                    break;

            }

        } while (!choose.equals("5"));
    }

    public void menu3() {
        String choose;
        ReadAndWrite a = new ReadAndWrite();
        actionPhongBan b = new actionPhongBan();
        do {
            System.out.println("=====Nhap Lua Chon Cua Ban=====");
            System.out.println("     1.Tao File PhongBan");
            System.out.println("     2.Thuc Hien Chuc Nang");
            System.out.println("     3.Ghi File Phong Ban");
            System.out.println("     4.Doc File Phong Ban");
            System.out.println("     5.Quay Lai !!!");
            choose = input.nextLine();
            switch (choose) {
                case "1":
                    b.ThemThongTin();
                    break;
                case "2":
                    String chon;
                    do {
                        System.out.println("=====Nhap Lua Chon Cua Ban=====");
                        System.out.println("     1.Them Phong Ban ");
                        System.out.println("     2.Chinh Sua Thong Tin Phong Ban");
                        System.out.println("     3.Xoa Phong Ban");
                        System.out.println("     4.Tim Kiem Phong Ban");
                        System.out.println("     5.In Danh Sach Phong Ban");
                        System.out.println("     6.Quay Lai !!!");
                        chon = input.nextLine();
                        switch (chon) {
                            case "1":
                                b.ThemThongTin();
                                break;
                            case "2":
                                b.ChinhSuaThongTin();
                                break;
                            case "3":
                                b.XoaThongTin();
                                break;
                            case "4":
                                b.TimKiemThongTin();
                                break;
                            case "5":
                                b.InDanhSach();
                                break;
                            case "6":
                                break;
                            default:
                                System.out.println("Lua Chon Cua Ban Khong Hop Le !");
                                break;
                        }

                    } while (!chon.equals("6"));

                    break;
                case "3":
                    a.WritePhongBan(b.getDanhSachPhongBan(), b.getKt());
                    break;
                case "4":
                    PhongBan[] phongban = ReadPhongBan();
                    b = new actionPhongBan(phongban, phongban.length);
                    break;
                case "5":
                    break;
                default:
                    System.out.println("Lua Chon Cua Ban Khong Hop Le !");
                    break;

            }

        } while (!choose.equals("5"));
    }

    public void menu() {
        String chon;
        do {
            System.out.println("=====Nhap Lua Chon Cua Ban=====");
            System.out.println("    1.Doc-Ghi File Nhan Vien");
            System.out.println("    2.Doc-Ghi File Hop Dong");
            System.out.println("    3.Doc-Ghi File Phong Ban");
            System.out.println("    4.Thoat");
            chon = input.nextLine();
            switch (chon) {
                case "1":
                    menu1();

                    break;
                case "2":
                    menu2();
                    break;
                case "3":
                    menu3();
                    break;
                case "4":
                    break;
                default:
                    System.out.println("Lua Chon Khong Hop Le");
                    break;
            }
        } while (!chon.equals("4"));
    }

    public static void main(String[] args) {
        ReadAndWrite a = new ReadAndWrite();
        a.menu();
    }
}