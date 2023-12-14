package model;

import java.util.HashMap;
import java.util.Scanner;
import java.util.List;
import core.Store;

public class QTFunction extends AbQTFunction {
   public QTFunction() {
   }

   Scanner inputs = new Scanner(System.in);

   public void findAcount(HashMap<String, String> data, TaiKhoan user) {
      checkError check = new checkError();
      String manv = "";
      do {
         System.out.print("nhap ma nhan vien:");
         manv = inputs.nextLine();
         if (check.nullInput(manv)) {
            System.out.println("thong tin khong duoc de trong");
         }
      } while (check.nullInput(manv));
      for (String key : data.keySet()) {
         if (key.equalsIgnoreCase(manv)) {
            System.out.println("ten tai khoan:" + key);
            System.out.println("mat khau:" + data.get(key));
            user.setUserName(key);
            user.setPass(manv);
            return;
         }
      }
      System.out.println("nhan vien khong ton tai");
   }

   @Override
   public void setAcount(TaiKhoan user, HashMap<String, String> data) {
      this.findAcount(data, user);
      if (user.getUserName().length() == 0) {
         return;
      }
      data.remove(user.getUserName());
      String passWorld = "";
      checkError check = new checkError();
      do {
         System.out.print("nhap mat khau moi:");
         passWorld = inputs.nextLine();
         if (check.nullInput(passWorld)) {
            System.out.println("thong tin khong duoc de trong!");
         }
      } while (check.nullInput(passWorld));
      user.setPass(passWorld);
      data.put(user.getUserName(), user.getPass());
      System.out.println("-------cap nhap hoan tat-------");
   }

   public void deleteAcount(TaiKhoan user, HashMap<String, String> data) {
      this.findAcount(data, user);
      if (user.getUserName().length() == 0) {
         return;
      }

      data.remove(user.getUserName());
      System.out.println("-------xoa tai khoan  hoan tat-------");
   }

   public void addAcount(TaiKhoan user, HashMap<String, String> data) {
      checkError check = new checkError();
      String userName = "";
      String passWorld = "";

      do {
         System.out.print("nhap ma nhan vien:");
         userName = inputs.nextLine();
         if (check.nullInput(userName)) {
            System.out.print("thong tin khong duoc de trong");

         }
      } while (check.nullInput(userName));
      do {
         System.out.print("nhap mat khau:");
         passWorld = inputs.nextLine();
         if (check.nullInput(passWorld)) {
            System.out.println("thong tin khong duoc de trong");

         }
      } while (check.nullInput(passWorld));
      user.setUserName(userName);
      user.setPass(passWorld);
      List<TaiKhoan> listAccounts = Store.listAccount;
      for (TaiKhoan u : listAccounts) {
         if (u.getUserName().equalsIgnoreCase(userName)) {
            System.out.println("khong the them tai khoan");
            System.out.println("ma nhan vien da ton tai!");
            return;
         }
      }
      listAccounts.add(user);
      data.put(userName, passWorld);

      System.out.println("----them tai khoan nhan vien hoan tat-------");
   }
}
