package model;

public class TaiKhoan {
    private String userName;
    private String pass;
    private int quyen;
    private String permission;

    public String getPermission() {
        return this.permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public TaiKhoan() {
    }

    public TaiKhoan(String userName, String pass, int quyen) {
        this.userName = userName;
        this.pass = pass;
        this.quyen = quyen;
    }

    public TaiKhoan(String userName, String pass, String permission) {
        this.userName = userName;
        this.pass = pass;
        this.permission = permission;
    }

    public void permission(int select) {
        switch (select) {
            case 1:
                this.setPermission("nhan vien");
                break;
            case 2:
                this.setPermission("quan tri");
                break;
            case 3:
                this.setPermission("nhan su");
                break;
            case 4:
                this.setPermission("nhan luc");
                break;
            case 5:
                this.setPermission("tai chinh");
                break;
            case 6:
                this.setPermission("truong ban");
            default:
                break;
        }
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return this.pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getQuyen() {
        return this.quyen;
    }

    public void setQuyen(int quyen) {
        this.quyen = quyen;
    }

    public String toString() {
        return getUserName() + "," + getPass() + "," + getPermission();
    }
    // quyen,tai khoan,mat khau

    public String output() {
        return getPermission() + "," + getUserName() + "," + getPass();
    }
}
