package core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.NhanVien;
import model.StringArray;

interface Action {
    public void get();

    public void create();

    public void Update(StringArray arr, int selector);
}

public class Connection implements Action {
    public static class State {
        public static String path_data_QuanTri = "Data\\QuanTri_data\\QuanTri.csv";
        public static String path_data_Nhansu = "Data\\NhanSu_data\\Nhansu.csv";
        public static String path_data_NhanVien = "Data\\NhanVien_data\\NV_ThongTin.csv";
        public static String path_data_NhanLuc = "Data\\NhanLuc_data\\nhanluc.csv";
        public static String path_data_TaiChinh = "Data\\TaiChinh_data\\Luong.csv";
        public static String path_data_TruongBan = "Data\\TruongBan_data\\QuanLy.csv";

        public List<String[]> getData(String selector) {
            List<String[]> result = new ArrayList<>();
            try {
                FileReader fileread = new FileReader(selector);
                BufferedReader br = new BufferedReader(fileread);
                String line;
                line = br.readLine();
                while ((line = br.readLine()) != null) {
                    String arr[] = line.split(",");
                    result.add(arr);

                }
                br.close();
                fileread.close();

            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }

            catch (IOException e) {
                e.printStackTrace();
            }

            return result;

        }

        public void setData(String[] value, String selector) {
            try {
                FileWriter fileWriter = new FileWriter(selector);
                BufferedWriter bw = new BufferedWriter(fileWriter);
                for (String s : value) {
                    bw.write(s);
                    bw.newLine();
                }
                bw.close();
                fileWriter.close();
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    public void get() {

    }

    @Override
    public void create() {

    }

    @Override
    public void Update(StringArray arr, int selector) {

        String path = "";
        String title = "";
        switch (selector) {
            case 1:
                title = "HoTen,GioiTinh,DiaChi,QueQuan,NgaySinh,SoDT,DanToc,TonGiao,HocVan,MaNV,MaPhong,ChucVu,LoaiHD,NgayKiHD,NgayHetHan,Gmail,luongCb,capnhat";
                path = Connection.State.path_data_NhanVien;
                break;
            case 2:
                title = "quyen,tai khoan,mat khau";
                path = Connection.State.path_data_QuanTri;
                break;
            default:
                break;
        }
        String[] data = new String[arr.sizeOf() + 1];
        data[0] = title;
        String[] array = arr.getArray();
        for (int i = 1; i < data.length; i++) {
            data[i] = array[i - 1];
        }

        Connection.State reqest = new Connection.State();
        reqest.setData(data, path);
    }
}
