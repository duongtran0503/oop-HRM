package model;

import java.util.HashMap;
import java.util.Scanner;

abstract class AbQTFunction {
    Scanner inputs = new Scanner(System.in);

    public void findAcount(HashMap<String, String> data) {
        String manv = "";
        checkError check = new checkError();
        do {
            System.out.print("nhan ma nhan vien:");
            manv = inputs.nextLine();
            if (check.nullInput(manv)) {
                System.out.println("thong tin khong duoc de trong");
            }
        } while (check.nullInput(manv));
        for (String key : data.keySet()) {
            if (key.equalsIgnoreCase(manv)) {
                System.out.println("ten tai khoan:" + key);
                System.out.println("mat khau:" + data.get(key));
                return;
            }
        }
        System.out.println("nhan vien  khong ton tai");
    }

    public void setAcount(TaiKhoan user, HashMap<String, String> data) {
    };
}
