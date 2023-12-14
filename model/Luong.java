
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
import java.util.List;
import java.util.Scanner;

interface ArraysInterface1 {
    void ThemThongTin();

    void XoaThongTin();

    void InDanhSach();

    void ChinhSuaThongTin();

    void TimKiemThongTin();

}

public class Luong implements ArraysInterface1 {

    String LuongfilePath = "Data\\TaiChinh_data\\Luong.csv";
    String NhanVienfilePath = "Data\\NhanVien_data\\NhanVien.csv";
    String QuanLyfilePath = "Data\\TruongBan_data\\QuanLy.csv";
    ArrayList<String> list = new ArrayList<>();

    @Override // them thong tin luong
    public void ThemThongTin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ma luong: ");
        String MaLuong = scanner.nextLine();
        System.out.print("Nhap ma phong: ");
        String MaPhong = scanner.nextLine();
        System.out.print("Nhap luong co ban: ");
        String LuongCoBan = scanner.nextLine();
        System.out.print("Nhap luong khen thuong: ");
        String LuongKhenThuong = scanner.nextLine();
        System.out.print("Nhap luong ki luat: ");
        String LuongKiLuat = scanner.nextLine();

        boolean LuongDaTonTai = false;
        ArrayList<String> updatedList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(LuongfilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String currentMaLuong = data[0].trim(); // Mã lương trong file
                String currentMaPhong = data[1].trim(); // Mã phòng trong file
                // Kiểm tra mã phòng
                if (currentMaLuong.equals(MaLuong) &&
                        currentMaPhong.equals(MaPhong)) {
                    LuongDaTonTai = true;
                    System.out.println("Luong da ton tai trong file. Thong tin se duoc cap nhat.");
                    // Cập nhật thông tin lương nếu đã tồn tại mã phòng
                    line = MaLuong + "," + MaPhong + "," + LuongCoBan + "," + LuongKhenThuong + "," + LuongKiLuat;
                }
                updatedList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Nếu mã phòng không tồn tại trong danh sách, thêm thông tin mới
        if (!LuongDaTonTai) {
            String newEntry = MaLuong + "," + MaPhong + "," + LuongCoBan + "," + LuongKhenThuong + "," + LuongKiLuat;
            updatedList.add(newEntry);
        }

        // Ghi lại thông tin vào file
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(LuongfilePath))) {
            for (String line : updatedList) {
                printWriter.println(line);
            }
            System.out.println("Luong da duoc them vao file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override // xoa thong tin Luong
    public void XoaThongTin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ma phong can xoa: ");
        String MaPhongToDelete = scanner.nextLine();
        System.out.print("Nhap ma luong: ");
        String MaLuongToDelete = scanner.nextLine();
        try (BufferedReader reader = new BufferedReader(new FileReader(LuongfilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String currentMaLuong = data[0].trim();
                String currentMaPhong = data[1].trim();
                // Kiem tra xem co phai luong can xoa
                if (currentMaLuong.equals(MaLuongToDelete) && currentMaPhong.equals(MaPhongToDelete)) {
                    continue; // Bo qua dong du lieu can xoa
                }
                list.add(line);
            }
            if (list.size() > 0) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(LuongfilePath))) {
                    for (String data : list) {
                        writer.write(data);
                        writer.newLine();
                    }
                    System.out.println("Thong tin Luong da duoc xoa.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Khong tim thay Luong can xoa.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override // chinh sua thong tin luong
    public void ChinhSuaThongTin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ma luong can chinh sua: ");
        String MaLuongToEdit = scanner.nextLine();
        System.out.print("Nhap ma phong can chinh sua: ");
        String MaPhongToEdit = scanner.nextLine();

        // Đọc dữ liệu từ file và lưu vào mảng
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(LuongfilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Nhập thông tin mới vào mảng
        boolean found = false;
        for (int i = 0; i < list.size(); i++) {
            String[] data = list.get(i).split(",");
            String currentMaLuong = data[0].trim();
            String currentMaPhong = data[1].trim();
            if (currentMaLuong.equals(MaLuongToEdit) && currentMaPhong.equals(MaPhongToEdit)) {
                System.out.print("Nhap thong tin moi:\nMa Luong: ");
                String newMaLuong = scanner.nextLine();
                System.out.print("Ma phong: ");
                String newMaPhong = scanner.nextLine();
                System.out.print("Luong co ban: ");
                String newLuongCB = scanner.nextLine();
                System.out.print("Luong khen thuong: ");
                String newLuongKT = scanner.nextLine();
                System.out.print("Luong ki luat: ");
                String newLuongKL = scanner.nextLine();
                list.set(i, newMaLuong + "," + newMaPhong + "," + newLuongCB + ","
                        + newLuongKT + "," + newLuongKL);
                found = true;
                break;
            }
        }

        // Ghi vào file từ mảng đã chỉnh sửa
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(LuongfilePath))) {
            for (String line : list) {
                printWriter.println(line);
            }
            if (found) {
                System.out.println("Thong tin luong da duoc chinh sua.");
            } else {
                System.out.println("Khong tim thay ma luong va ma phong can chinh sua.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override // tiem kiem luong
    public void TimKiemThongTin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ma luong can tim: ");
        String maLuongCanTim = scanner.nextLine();
        System.out.println("Nhap ma phong can tim: ");
        String maPhongCanTim = scanner.nextLine();

        try {
            // Đọc dữ liệu từ file và thực hiện tìm kiếm
            readDataFromFileAndSearch(maLuongCanTim, maPhongCanTim);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void readDataFromFileAndSearch(String maLuongCanTim, String maPhongCanTim) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File(LuongfilePath))) {
            // Bỏ qua dòng đầu tiên (tiêu đề)
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            System.out.println("Result:");
            boolean found = false;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                String maLuong = data[0];
                String maPhong = data[1];
                String luongCB = data[2];
                String luongKT = data[3];
                String luongKL = data[4];

                // So sánh cả mã lương và mã phòng
                if (maLuong.equals(maLuongCanTim) && maPhong.contains(maPhongCanTim)) {
                    System.out.println("Ma Luong: " + maLuong);
                    System.out.println("Ma Phong: " + maPhong);
                    System.out.println("Luong co ban: " + luongCB);
                    System.out.println("Luong khen thuong: " + luongKT);
                    System.out.println("Luong ki luat: " + luongKL);
                    System.out.println("------------------------");
                    found = true;
                    // Bỏ break nếu muốn tìm kiếm toàn bộ thông tin có thể khớp
                }
            }

            if (!found) {
                System.out.println("Khong co thong tin can tim");
            }
        }
    }

    private static double hienthithongtinLuong(String manvCanTinhLuong) {
        try (BufferedReader nhanvienReader = new BufferedReader(new FileReader("Data\\NhanVien_data\\NhanVien.csv"));
                BufferedReader quanlyReader = new BufferedReader(new FileReader("Data\\TruongBan_data\\QuanLy.csv"));
                BufferedReader luongReader = new BufferedReader(new FileReader("Data\\TaiChinh_data\\Luong.csv"))) {
            System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-25s%-25s%-15s\n", "MANV", "Ho ten", "Ma Phong",
                    "Chuc Vu", "Ma Luong",
                    "Luong Co Ban", "Luong Khen Thuong", "Luong Ki Luat", "Tong Luong");
            String nhanvienLine;
            String quanlyLine;
            String luongLine;

            while ((nhanvienLine = nhanvienReader.readLine()) != null) {
                String[] nhanvienData = nhanvienLine.split(",");
                String manvFromFile = nhanvienData[0].trim(); // Mã nhân viên từ file

                if (manvCanTinhLuong.equals(manvFromFile)) {
                    String hoten = nhanvienData[1].trim();
                    String maPhong = nhanvienData[2].trim();
                    String chucvu = nhanvienData[3].trim();
                    String maluong = null;
                    String luongCoBan = null;
                    String luongKhenThuong = null;
                    String luongKiLuat = null;
                    while ((luongLine = luongReader.readLine()) != null) {
                        String[] luongData = luongLine.split(",");
                        if (nhanvienData[0].trim().equals(luongData[5].trim())) {
                            maluong = luongData[0].trim();
                            luongCoBan = nhanvienData[8].trim();
                            break;
                        }
                    }

                    while ((quanlyLine = quanlyReader.readLine()) != null) {
                        String[] quanlyData = quanlyLine.split(",");
                        if (nhanvienData[0].trim().equals(quanlyData[8].trim())) {
                            luongKhenThuong = quanlyData[6].trim();
                            luongKiLuat = quanlyData[7].trim();
                            break;
                        }
                    }

                    if (maluong != null && luongCoBan != null && luongKhenThuong != null && luongKiLuat != null) {
                        double tongLuong = Double.parseDouble(luongCoBan) + Double.parseDouble(luongKhenThuong)
                                - Double.parseDouble(luongKiLuat);
                        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-25s%-25s%-15s\n", manvFromFile, hoten,
                                maPhong, chucvu,
                                maluong, luongCoBan, luongKhenThuong, luongKiLuat, tongLuong);

                    } else {
                        System.out.println("Khong tim thay thong tin luong cho nhan vien co ma " + manvFromFile);

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1; // Trả về giá trị âm để chỉ không tìm thấy thông tin luong
    }

    public void TinhLuong() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ma nhan vien can tinh luong: ");
        String MaNVCanTinhLuong = scanner.nextLine();

        hienthithongtinLuong(MaNVCanTinhLuong);
    }

    @Override // In danh sach luong
    public void InDanhSach() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ma phong de in ra danh sach luong (pqt, pnl, pns, ptc, ptb): ");
        String maPhongCanTim = scanner.nextLine();
        try (BufferedReader nhanvienReader = new BufferedReader(new FileReader("Data\\NhanVien_data\\NhanVien.csv"));
                BufferedReader quanlyReader = new BufferedReader(new FileReader("Data\\TruongBan_data\\QuanLy.csv"));
                BufferedReader luongReader = new BufferedReader(new FileReader("Data\\TaiChinh_data\\Luong.csv"))) {
            System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-25s%-25s%-15s\n", "MANV", "Ho ten", "Ma Phong",
                    "Chuc Vu", "Ma Luong",
                    "Luong Co Ban", "Luong Khen Thuong", "Luong Ki Luat", "Tong Luong");
            String nhanvienLine;
            String quanlyLine;
            String luongLine;

            while ((nhanvienLine = nhanvienReader.readLine()) != null) {
                String[] nhanvienData = nhanvienLine.split(",");
                String maPhongFromFile = nhanvienData[2].trim(); // Mã nhân viên từ file

                if (maPhongCanTim.equals(maPhongFromFile)) {
                    String MANV = nhanvienData[0].trim();
                    String hoten = nhanvienData[1].trim();
                    String chucvu = nhanvienData[3].trim();
                    String maluong = null;
                    String luongCoBan = null;
                    String luongKhenThuong = null;
                    String luongKiLuat = null;
                    while ((luongLine = luongReader.readLine()) != null) {
                        String[] luongData = luongLine.split(",");
                        if (nhanvienData[0].trim().equals(luongData[5].trim())) {
                            maluong = luongData[0].trim();
                            luongCoBan = nhanvienData[8].trim();
                            break;
                        }
                    }

                    while ((quanlyLine = quanlyReader.readLine()) != null) {
                        String[] quanlyData = quanlyLine.split(",");
                        if (nhanvienData[0].trim().equals(quanlyData[8].trim())) {
                            luongKhenThuong = quanlyData[6].trim();
                            luongKiLuat = quanlyData[7].trim();
                            break;
                        }
                    }

                    if (maluong != null && luongCoBan != null && luongKhenThuong != null && luongKiLuat != null) {
                        double tongLuong = Double.parseDouble(luongCoBan) + Double.parseDouble(luongKhenThuong)
                                - Double.parseDouble(luongKiLuat);
                        switch (maPhongCanTim) {
                            case "pqt": // phong quan tri
                                if (maPhongCanTim.equalsIgnoreCase(nhanvienData[2].trim())) {
                                    System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-25s%-25s%-15s\n", MANV, hoten,
                                            maPhongFromFile, chucvu,
                                            maluong, luongCoBan, luongKhenThuong, luongKiLuat, tongLuong);
                                }
                                break;
                            case "pnl": // phong nhan luc
                                if (maPhongCanTim.equalsIgnoreCase(nhanvienData[2].trim())) {
                                    System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-25s%-25s%-15s\n", MANV, hoten,
                                            maPhongFromFile, chucvu,
                                            maluong, luongCoBan, luongKhenThuong, luongKiLuat, tongLuong);
                                }
                                break;
                            case "pns": // phong nhan su
                                if (maPhongCanTim.equalsIgnoreCase(nhanvienData[2].trim())) {
                                    System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-25s%-25s%-15s\n", MANV, hoten,
                                            maPhongFromFile, chucvu,
                                            maluong, luongCoBan, luongKhenThuong, luongKiLuat, tongLuong);
                                }
                                break;
                            case "ptc": // phong tai chinh
                                if (maPhongCanTim.equalsIgnoreCase(nhanvienData[2].trim())) {
                                    System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-25s%-25s%-15s\n", MANV, hoten,
                                            maPhongFromFile, chucvu,
                                            maluong, luongCoBan, luongKhenThuong, luongKiLuat, tongLuong);
                                }
                                break;
                            case "ptb": // phong truong ban
                                if (maPhongCanTim.equalsIgnoreCase(nhanvienData[2].trim())) {
                                    System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-25s%-25s%-15s\n", MANV, hoten,
                                            maPhongFromFile, chucvu,
                                            maluong, luongCoBan, luongKhenThuong, luongKiLuat, tongLuong);
                                }
                                break;

                        }

                    } else {
                        System.out.println("Khong tim thay thong tin luong cua phong ban co ma " + maPhongFromFile);

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
