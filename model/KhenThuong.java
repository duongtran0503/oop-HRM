package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class KhenThuong implements ArraysInterface {
    String filePath = "Data\\TruongBan_data\\QuanLy.csv";
    ArrayList<String> list = new ArrayList<>();
    checkError check = new checkError();// check date

    @Override // them thong tin khen thuong // check + fix loi trùng thong tin nhan vien
    public void ThemThongTin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ho ten: ");
        String hoTen = scanner.nextLine();
        System.out.print("Nhap ma bo phan: ");
        String maBoPhan = scanner.nextLine();
        System.out.print("Nhap ma phong: ");
        String maPhong = scanner.nextLine();
        System.out.print("Nhap chuc vu: ");
        String chucVu = scanner.nextLine();
        String ngayDangKy;
        do {
            System.out.print("Nhap ngay dang ky (dd/mm/yyyy): ");
            ngayDangKy = scanner.nextLine();
        } while (!check.dateFormat(ngayDangKy));
        String ngayHetHan;
        do {
            System.out.print("Nhap ngay het han (dd/mm/yyyy): ");
            ngayHetHan = scanner.nextLine();
        } while (!check.dateFormat(ngayHetHan));
        System.out.print("Nhap luong khen thuong: ");
        String luongKhenThuong = scanner.nextLine();
        String luongKiLuat = "0";
        boolean nhanVienDaTonTai = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String currentHoTen = data[0].trim();
                String currentMaBoPhan = data[1].trim();
                String currentMaPhong = data[2].trim();
                // cap nhat thong tin nhan vien da ton tai
                if (currentHoTen.equals(hoTen) &&
                        currentMaBoPhan.equals(maBoPhan) &&
                        currentMaPhong.equals(maPhong)) {
                    nhanVienDaTonTai = true;
                    System.out.println("Nhan vien da ton tai trong file. Thong tin se duoc cap nhat.");
                    line = hoTen + "," + maBoPhan + "," + maPhong + "," + chucVu + ","
                            + ngayDangKy + "," + ngayHetHan + "," + luongKhenThuong + "," + luongKiLuat;
                }
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // neu chua co thong tin trung khop, them thong tin moi vao danh sach
        if (!nhanVienDaTonTai) {
            String newEntry = hoTen + "," + maBoPhan + "," + maPhong + "," + chucVu + ","
                    + ngayDangKy + "," + ngayHetHan + "," + luongKhenThuong + "," + luongKiLuat;
            list.add(newEntry);
        }
        // ghi lại thong tin vao file
        try (FileWriter fileWriter = new FileWriter(filePath);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                PrintWriter printWriter = new PrintWriter(bufferedWriter)) {
            for (String line : list) {
                printWriter.println(line);
            }
            System.out.println("Nhan vien da duoc them vao file.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override // xoa thong tin nhan vien khen thuong // check
    public void XoaThongTin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ten nhan vien can xoa: ");
        String hoTenToDelete = scanner.nextLine();
        System.out.print("Nhap ma bo phan: ");
        String maBoPhanToDelete = scanner.nextLine();
        System.out.print("Nhap ma phong: ");
        String maPhongToDelete = scanner.nextLine();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String currentHoTen = data[0].trim();
                String currentMaBoPhan = data[1].trim();
                String currentMaPhong = data[2].trim();
                // Kiem tra xem co phai nhan vien can xoa
                if (currentHoTen.equals(hoTenToDelete) &&
                        currentMaBoPhan.equals(maBoPhanToDelete) &&
                        currentMaPhong.equals(maPhongToDelete)) {
                    continue; // Bo qua dong du lieu can xoa
                }
                list.add(line);
            }
            if (list.size() > 0) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                    for (String data : list) {
                        writer.write(data);
                        writer.newLine();
                    }
                    System.out.println("Thong tin nhan vien da duoc xoa.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Khong tim thay nhan vien can xoa.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override // In danh sach nhan vien khen thuong // check
    public void InDanhSach() {// doc tu file goc
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.printf("%-30s%-15s%-15s%-15s\n", "Ho Ten", "Ma Bo Phan", "Ma Phong", "Luong Khen Thuong");
            // bo qua dong dau tien(ghi chu)
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                // kiem tra + bo dong trong
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] data = line.split(",");
                // Kiem tra nhan vien
                if (data.length >= 7 && !data[6].trim().isEmpty()) {
                    String hoTen = data[0].trim();
                    String maBoPhan = data[1].trim();
                    String maPhong = data[2].trim();
                    String luongKhenThuong = data[6].trim();
                    System.out.printf("%-30s%-15s%-15s%-15s\n", hoTen, maBoPhan, maPhong, luongKhenThuong);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override // chinh sua thong tin khen thuong // check
    public void ChinhSuaThongTin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ten nhan vien can chinh sua: ");
        String hoTenToEdit = scanner.nextLine();
        // doc tu file va xuat ra mang
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // nhap thong tin vao mang
        boolean found = false;
        for (int i = 0; i < list.size(); i++) {
            String[] data = list.get(i).split(",");
            String currentHoTen = data[0].trim();
            if (currentHoTen.equals(hoTenToEdit)) {
                System.out.print("Nhap thong tin moi:\nHo ten: ");
                String newHoTen = scanner.nextLine();
                System.out.print("Ma bo phan: ");
                String newMaBoPhan = scanner.nextLine();
                System.out.print("Ma phong: ");
                String newMaPhong = scanner.nextLine();
                System.out.print("Chuc vu: ");
                String newChucVu = scanner.nextLine();
                String newNgayDangKy;
                do {
                    System.out.print("Nhap ngay dang ky (dd/mm/yyyy): ");
                    newNgayDangKy = scanner.nextLine();
                } while (!check.dateFormat(newNgayDangKy));
                String newNgayHetHan;
                do {
                    System.out.print("Nhap ngay het han (dd/mm/yyyy): ");
                    newNgayHetHan = scanner.nextLine();
                } while (!check.dateFormat(newNgayHetHan));
                System.out.print("Luong khen thuong: ");
                String newLuongKhenThuong = scanner.nextLine();
                String newLuongKiLuat = data[7].trim();// luu lai thong tin ki luat khong chinh sua
                // cap nhat thong tin thay doi
                list.set(i, newHoTen + "," + newMaBoPhan + "," + newMaPhong + "," + newChucVu + ","
                        + newNgayDangKy + "," + newNgayHetHan + "," + newLuongKhenThuong + "," + newLuongKiLuat);
                found = true;
                break;
            }
        }
        // ghi vao file
        try (FileWriter fileWriter = new FileWriter(filePath);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                PrintWriter printWriter = new PrintWriter(bufferedWriter)) {
            for (String line : list) {
                printWriter.println(line);
            }
            if (found) {
                System.out.println("Thong tin nhan vien da duoc chinh sua.");
            } else {
                System.out.println("Khong tim thay nhan vien can chinh sua.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override // tiem kiem nhan vien khen thuong // check
    public void TimKiemThongTin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap thong tin can tim ( ho ten/ ma bo phan/ ma phong): ");
        String timkiem = scanner.nextLine();
        try {
            // doc du lieu tu file goc
            readDataFromFileAndSearch(timkiem);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void readDataFromFileAndSearch(String timkiem) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File(filePath))) {
            // Bo qua dong dau tien
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            System.out.println("Result:");
            boolean found = false;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                String hoten = data[0];
                String mabophan = data[1];
                String maphong = data[2];
                String chucvu = data[3];
                String luongkhenthuong = data[6];
                if (hoten.contains(timkiem)// tim kiem theo tieu chi
                        || mabophan.equals(timkiem)
                        || maphong.equals(timkiem)
                        || chucvu.equals(timkiem)) {
                    System.out.println("Ho ten: " + hoten);
                    System.out.println("Chuc vu: " + chucvu);
                    System.out.println("Luong khen thuong: " + luongkhenthuong);
                    System.out.println("------------------------");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("khong co thong tin can tim");
            }
        }
    }

}
