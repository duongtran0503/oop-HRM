package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class rwNhanSu {
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
            System.out.println("-----Da Ghi Du Lieu Vao File Nhan Vien-----");
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
            System.out.println("-----Da Ghi Du Lieu Vao File Hop Dong----");
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
            System.out.println("-----Da Ghi Du Lieu Vao File Phong Ban-----");
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
            System.out.println("-----Da Doc Du Lieu Tu File NhanVien-----");
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
            System.out.println("----Da Doc Du Lieu Tu File Hop Dong----");

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
            System.out.println("----Da Doc Du Lieu Tu File Phong Ban----");
            reader.close();
            fr.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return phongban;
    }
}