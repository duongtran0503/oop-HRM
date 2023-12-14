package model;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ChucNangQLNL {

    public static List<CaLam> CALAM = new ArrayList<CaLam>();
    public static List<NhanVien> NHANVIEN = new ArrayList<NhanVien>();
    public static List<DeAn> DEAN = new ArrayList<DeAn>();
    Scanner inputs = new Scanner(System.in);

    public void docfile2() {
        String path = "Data\\NhanLuc_data\\CaLam.csv";
        if (CALAM.isEmpty()) {
            try (BufferedReader bir = new BufferedReader(new FileReader(path))) {
                bir.readLine();
                String line = bir.readLine();
                while (line != null) {
                    List<String> result = getCaLamInfo(line);
                    int soGioLam = Integer.parseInt(result.get(0));
                    String loaiCaLam = result.get(1);
                    double heSoChamCong = Double.parseDouble(result.get(2));
                    CALAM.add(new CaLam(soGioLam, loaiCaLam, heSoChamCong));
                    line = bir.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void TimCaLam() {
        docfile2();
        System.out.println("Nhap loai ca lam can tim:");
        String loaiCaLamCanTim = inputs.nextLine();

        boolean timThay = false;

        for (CaLam caLam : CALAM) {
            if (caLam.getLoaiCaLam().equalsIgnoreCase(loaiCaLamCanTim)) {
                System.out.println("Tim thay ca lam:");
                System.out.println("So gio lam: " + caLam.getSoGioLam());
                System.out.println("Loai ca lam: " + caLam.getLoaiCaLam());
                System.out.println("He so cham cong: " + caLam.getHeSoChamCong());
                timThay = true;
                break;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay ca lam co loai " + loaiCaLamCanTim);
        }
    }

    public void ThemCaLam() {
        System.out.println("Nhap thong tin ca lam");
        try {
            System.out.print("So gio lam: ");
            int soGioLam = inputs.nextInt();
            inputs.nextLine();

            System.out.print("Loai ca lam: ");
            String loaiCaLam = inputs.nextLine();

            if (kiemTraLoaiCaLamTonTai(loaiCaLam)) {
                System.out.println("Loai ca lam da ton tai. Khong the them moi.");
                return;
            }

            System.out.print("He So Cham Cong: ");
            double heSoChamCong = inputs.nextDouble();
            inputs.nextLine();

            CaLam caLamMoi = new CaLam(soGioLam, loaiCaLam, heSoChamCong);
            CALAM.add(caLamMoi);

            ghiVaoFile2(caLamMoi);

            System.out.println("Da them va ghi ca lam moi.");
        } catch (InputMismatchException ei) {
            System.out.println("Loi nhap lieu. Vui long nhap lai.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean kiemTraLoaiCaLamTonTai(String loaiCaLam) {
        for (CaLam caLam : CALAM) {
            if (caLam.getLoaiCaLam().equalsIgnoreCase(loaiCaLam)) {
                return true;
            }
        }
        return false;
    }

    private void ghiVaoFile2(CaLam caLam) {
        String path = "Data\\NhanLuc_data\\CaLam.csv";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            writer.write(String.format("%d,%s,%f",
                    caLam.getSoGioLam(), caLam.getLoaiCaLam(), caLam.getHeSoChamCong()));
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Loi khi ghi vao file CSV: " + e.getMessage());
        }
    }

    public static List<String> getCaLamInfo(String csvLine) {

        List<String> result = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < csvLine.length(); i++) {
            char ch = csvLine.charAt(i);
            if (ch == '\"') {
                if (str.length() > 0 && stack.size() % 2 == 0)
                    str.append(ch);
                stack.push(ch);
            } else if (ch == ',' && stack.size() % 2 == 0) {
                result.add(str.toString());
                stack.clear();
                str = new StringBuilder();
            } else if (ch == ',' && stack.size() % 2 != 0) {
                str.append(ch);
            } else {
                str.append(ch);
            }
        }
        result.add(str.toString());
        return result;
    }

    public void SuaThongTinCaLam() {
        docfile2();
        System.out.print("Nhap loai ca lam can sua:");
        String loaiCaLamCanSua = inputs.nextLine();

        Iterator<CaLam> iterator = CALAM.iterator();
        boolean daSua = false;
        while (iterator.hasNext()) {
            CaLam caLam = iterator.next();
            if (caLam.getLoaiCaLam().equalsIgnoreCase(loaiCaLamCanSua)) {
                System.out.println("Nhap thong tin moi cho ca lam:");

                try {

                    System.out.print("so gio lam: ");
                    int soGioLamMoi = inputs.nextInt();
                    caLam.setSoGioLam(soGioLamMoi);

                    System.out.print("he so cham cong: ");
                    double heSoChamCongMoi = inputs.nextDouble();
                    caLam.setHeSoChamCong(heSoChamCongMoi);

                    ghiLaiVaoFile2();

                    System.out.println("Da sua thong tin cho ca lam.");
                    daSua = true;
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Loi nhap lieu. Vui long nhap lai.");
                }
            }
        }

        if (!daSua) {
            System.out.println("Khong tim thay ca lam co loai " + loaiCaLamCanSua);
        }
    }

    private void ghiLaiVaoFile2() {
        String path = "Data\\NhanLuc_data\\CaLam.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {

            writer.write("sogiolam,loaicalam,hesochamcong");
            writer.newLine();

            for (CaLam caLam : CALAM) {
                String newData = String.format("%d,%s,%f",
                        caLam.getSoGioLam(), caLam.getLoaiCaLam(), caLam.getHeSoChamCong());
                writer.write(newData);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Loi khi ghi vao file CSV: " + e.getMessage());
        }
    }

    public void XoaCaLam() {
        docfile2();
        System.out.println("Nhap loai ca lam can xoa:");
        String loaiCaLamCanXoa = inputs.nextLine();

        Iterator<CaLam> iterator = CALAM.iterator();
        boolean daXoa = false;
        while (iterator.hasNext()) {
            CaLam caLam = iterator.next();
            if (caLam.getLoaiCaLam().equalsIgnoreCase(loaiCaLamCanXoa)) {
                iterator.remove();
                ghiLaiVaoFile2();

                System.out.println("Da xoa ca lam co loai " + loaiCaLamCanXoa);
                daXoa = true;
                break;
            }
        }

        if (!daXoa) {
            System.out.println("Khong tim thay ca lam co loai " + loaiCaLamCanXoa + " de xoa.");
        }
    }

    public void DanhSachCaLam() {

        docfile2();
        if (CALAM.isEmpty()) {
            System.out.println("Danh sach rong. Hay them ca lam truoc khi in.");
            return;
        }
        System.out.println("Danh Sach Ca Lam");
        System.out.println("----------------------------------------");
        CALAM.forEach(caLam -> {
            System.out.println("So gio lam: " + caLam.getSoGioLam());
            System.out.println("Loai ca lam: " + caLam.getLoaiCaLam());
            System.out.println("He so cham cong: " + caLam.getHeSoChamCong());
            System.out.println("----------------------------------------");
        });
    }

    public void themNhanVienvaocalam() {
        docfile2();

        System.out.print("Nhap loai ca lam can them nhan vien: ");
        String loaiCaLamcanthamnhanvien = inputs.nextLine();

        CaLam caLamcanthemnhanvien = null;

        for (CaLam calam : CALAM) {
            if (calam.getLoaiCaLam().equalsIgnoreCase(loaiCaLamcanthamnhanvien)) {
                caLamcanthemnhanvien = calam;
                break;
            }
        }

        if (caLamcanthemnhanvien != null) {
            docfile1();
            System.out.print("Nhap ma nhan vien can them: ");
            String maNhanVien = inputs.nextLine();

            NhanVien nhanVienCanThem = timNhanVienTheoMa(maNhanVien);

            if (nhanVienCanThem != null) {
                caLamcanthemnhanvien.themThanhVien(nhanVienCanThem);

                System.out.println("Da them nhan vien vao de an.");

            } else {
                System.out.println("Khong tim thay ma nhan vien co ma " + maNhanVien);
            }
        } else {
            System.out.println("Khong tim thay ma de an co loai " + loaiCaLamcanthamnhanvien);
        }
    }

    public void danhSachNhanVienThamGiaCaLam() {
        docfile2();

        System.out.print("Nhap loai ca lam can hien thi danh sach nhan vien: ");
        String loaicalamCanHienThi = inputs.nextLine();

        CaLam calamCanHienThi = null;

        for (CaLam calam : CALAM) {
            if (calam.getLoaiCaLam().equalsIgnoreCase(loaicalamCanHienThi)) {
                calamCanHienThi = calam;
                break;
            }
        }

        if (calamCanHienThi != null) {
            System.out.println("Danh sach nhan vien tham gia de an:");
            List<NhanVien> danhSachNhanVien = calamCanHienThi.getcacNhanVienThamGia();
            for (NhanVien nhanVien : danhSachNhanVien) {
                System.out.println(nhanVien.toString());
            }
        } else {
            System.out.println("Khong tim thay ma de an co loai " + loaicalamCanHienThi);
        }
    }

    public void docfile() {
        String path = "Data\\NhanLuc_data\\dean.csv";

        try (BufferedReader bir = new BufferedReader(new FileReader(path))) {
            String header = bir.readLine();
            if (header != null) {
                String line = bir.readLine();
                while (line != null) {
                    List<String> result = getDeAnInfo(line);

                    // Kiểm tra xem result có ít nhất 4 phần tử hay không
                    if (result.size() >= 4) {
                        String maDeAn = result.get(0);
                        String tenDeAn = result.get(1);
                        String ngaytao = result.get(2);
                        int soThanhVien = Integer.parseInt(result.get(3));

                        DEAN.add(new DeAn(maDeAn, tenDeAn, ngaytao, soThanhVien));
                    }

                    line = bir.readLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void TimDeAn() {
        docfile();
        System.out.println("Nhap ma de an can tim:");
        String MaDeAnCanTim = inputs.nextLine();

        boolean timThay = false;

        for (DeAn dean : DEAN) {
            if (dean.getMaDeAn().equalsIgnoreCase(MaDeAnCanTim)) {
                System.out.println("Tim thay ma de an:");
                System.out.println("ten de an " + dean.getTenDeAn());
                System.out.println("ngay tao " + dean.getNgayTao());
                System.out.println("so thanh vien " + dean.getSoThanhVien());
                timThay = true;
                break;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay ma de an  " + MaDeAnCanTim);
        }
    }

    public void ThemDeAn() {
        System.out.println("Nhap thong tin de an");
        try {

            System.out.print("nhap ma de an: ");
            String maDeAn = inputs.nextLine();

            if (kiemTraLoaiDeAnTonTai(maDeAn)) {
                System.out.println("ma de an da ton tai. Khong the them moi.");
                return;
            }

            System.out.print("nhap ten de an: ");
            String tenDeAn = inputs.nextLine();

            System.out.print("nhap ngay tao: ");
            String ngaytao = inputs.nextLine();

            int soThanhVien = 0;
            DeAn deanMoi = new DeAn(maDeAn, tenDeAn, ngaytao, soThanhVien);

            DEAN.add(deanMoi);

            ghiVaoFile(deanMoi);

            System.out.println("Da them de an moi.");
        } catch (InputMismatchException ei) {
            System.out.println("Loi nhap lieu. Vui long nhap lai.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean kiemTraLoaiDeAnTonTai(String maDeAn) {
        for (DeAn dean : DEAN) {
            if (dean.getMaDeAn().equalsIgnoreCase(maDeAn)) {
                return true;
            }
        }
        return false;
    }

    private void ghiVaoFile(DeAn dean) {
        String path = "Data\\NhanLuc_data\\dean.csv";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            writer.write(String.format("%s,%s,%s,%d",
                    dean.getMaDeAn(), dean.getTenDeAn(), dean.getNgayTao(), dean.getSoThanhVien()));
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Loi khi ghi vao file: " + e.getMessage());
        }
    }

    public static List<String> getDeAnInfo(String csvLine) {

        List<String> result = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < csvLine.length(); i++) {
            char ch = csvLine.charAt(i);
            if (ch == '\"') {
                if (str.length() > 0 && stack.size() % 2 == 0)
                    str.append(ch);
                stack.push(ch);
            } else if (ch == ',' && stack.size() % 2 == 0) {
                result.add(str.toString());
                stack.clear();
                str = new StringBuilder();
            } else if (ch == ',' && stack.size() % 2 != 0) {
                str.append(ch);
            } else {
                str.append(ch);
            }
        }
        result.add(str.toString());
        return result;
    }

    public void SuaThongTinDeAn() {
        docfile();
        System.out.print("Nhap ma de an can sua:");
        String maDeAnCanSua = inputs.nextLine();

        Iterator<DeAn> iterator = DEAN.iterator();
        boolean daSua = false;
        while (iterator.hasNext()) {
            DeAn dean = iterator.next();
            if (dean.getMaDeAn().equalsIgnoreCase(maDeAnCanSua)) {
                System.out.println("Nhap thong tin moi cho de an:");

                try {

                    System.out.print("nhap ten de an: ");
                    String tenDeAnmoi = inputs.nextLine();
                    dean.setTenDeAn(tenDeAnmoi);

                    System.out.print("nhap ngay tao:");
                    String ngaytaomoi = inputs.nextLine();
                    dean.setNgayTao(ngaytaomoi);

                    System.out.print("nhap so thanh vien: ");
                    int soThanhVienmoi = inputs.nextInt();
                    dean.setSoThanhVien(soThanhVienmoi);

                    ghiLaiVaoFile();

                    System.out.println("Da sua thong tin cho de an.");
                    daSua = true;
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Loi nhap lieu. Vui long nhap lai.");
                }
            }
        }

        if (!daSua) {
            System.out.println("Khong tim thay ma de an co loai " + maDeAnCanSua);
        }
    }

    private void ghiLaiVaoFile() {
        String path = "Data\\NhanLuc_data\\dean.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {

            writer.write("madean,tendean,ngaytao,sothanhvien");
            writer.newLine();

            for (DeAn dean : DEAN) {
                String newData = String.format("%s,%s,%s,%d",
                        dean.getMaDeAn(), dean.getTenDeAn(), dean.getNgayTao(), dean.getSoThanhVien());
                writer.write(newData);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Loi khi ghi vao file CSV: " + e.getMessage());
        }
    }

    public void XoaDeAn() {
        docfile();
        System.out.println("Nhap ma de an can xoa:");
        String maDeAnCanXoa = inputs.nextLine();

        Iterator<DeAn> iterator = DEAN.iterator();
        boolean daXoa = false;
        while (iterator.hasNext()) {
            DeAn dean = iterator.next();
            if (dean.getMaDeAn().equalsIgnoreCase(maDeAnCanXoa)) {
                iterator.remove();
                ghiLaiVaoFile();

                System.out.println("Da xoa ma de an " + maDeAnCanXoa);
                daXoa = true;
                break;
            }
        }

        if (!daXoa) {
            System.out.println("Khong tim thay ca lam co loai " + maDeAnCanXoa + " de xoa.");
        }
    }

    public void DanhSachDeAn() {

        docfile();
        if (DEAN.isEmpty()) {
            System.out.println("Danh sach rong. Hay them ca lam truoc khi in.");
            return;
        }
        System.out.println("Danh Sach Ca Lam");
        System.out.println("----------------------------------------");
        DEAN.forEach(dean -> {
            System.out.println("ma de an: " + dean.getMaDeAn());
            System.out.println("ten de an: " + dean.getTenDeAn());
            System.out.println("ngay tao: " + dean.getNgayTao());
            System.out.println("so thanh vien: " + dean.getSoThanhVien());
            System.out.println("----------------------------------------");
        });
    }

    public void themNhanVienVaoDeAn() {
        docfile();

        System.out.print("Nhap ma de an can them nhan vien: ");
        String loaiCaLamcanthamnhanvien = inputs.nextLine();

        DeAn deAnCanThemNhanVien = null;

        for (DeAn dean : DEAN) {
            if (dean.getMaDeAn().equalsIgnoreCase(loaiCaLamcanthamnhanvien)) {
                deAnCanThemNhanVien = dean;
                break;
            }
        }

        if (deAnCanThemNhanVien != null) {
            docfile1();
            System.out.print("Nhap ma nhan vien can them: ");
            String maNhanVien = inputs.nextLine();

            NhanVien nhanVienCanThem = timNhanVienTheoMa(maNhanVien);

            if (nhanVienCanThem != null) {
                deAnCanThemNhanVien.themThanhVien(nhanVienCanThem);
                deAnCanThemNhanVien.setSoThanhVien(deAnCanThemNhanVien.getSoThanhVien() + 1);
                System.out.println("Da them nhan vien vao de an.");

            } else {
                System.out.println("Khong tim thay ma nhan vien co ma " + maNhanVien);
            }
        } else {
            System.out.println("Khong tim thay ma de an co loai " + loaiCaLamcanthamnhanvien);
        }
    }

    private NhanVien timNhanVienTheoMa(String maNhanVien) {

        for (NhanVien nhanVien : NHANVIEN) {
            if (nhanVien.getMaNV().equalsIgnoreCase(maNhanVien)) {
                return nhanVien;
            }
        }
        return null;
    }

    public void danhSachNhanVienThamGiaDeAn() {
        docfile();

        System.out.print("Nhap ma de an can hien thi danh sach nhan vien: ");
        String maDeAnCanHienThi = inputs.nextLine();

        DeAn deAnCanHienThi = null;

        for (DeAn dean : DEAN) {
            if (dean.getMaDeAn().equalsIgnoreCase(maDeAnCanHienThi)) {
                deAnCanHienThi = dean;
                break;
            }
        }

        if (deAnCanHienThi != null) {
            System.out.println("Danh sach nhan vien tham gia de an:");
            List<NhanVien> danhSachNhanVien = deAnCanHienThi.getcacNhanVienThamGia();
            for (NhanVien nhanVien : danhSachNhanVien) {
                System.out.println(nhanVien.toString());
            }
        } else {
            System.out.println("Khong tim thay ma de an co loai " + maDeAnCanHienThi);
        }
    }

    public void docfile1() {
        String path = "Data/NhanVien_data/NhanVien.csv";
        if (NHANVIEN.isEmpty()) {
            try (BufferedReader bir = new BufferedReader(new FileReader(path))) {
                bir.readLine();
                String line = bir.readLine();
                while (line != null) {
                    List<String> result = getDeAnInfo(line);
                    String MANV = result.get(0);
                    String HoTen = result.get(1);
                    String MaPhong = result.get(2);
                    String ChucVu = result.get(3);
                    String LoaiHD = result.get(4);
                    String NgayKy = result.get(5);
                    String NgayHH = result.get(6);
                    String Gmail = result.get(7);

                    NHANVIEN.add(new NhanVien(MANV, HoTen, MaPhong, ChucVu, LoaiHD, NgayKy, NgayHH, Gmail));
                    line = bir.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
