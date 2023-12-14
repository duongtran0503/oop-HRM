package model;

interface check {
    public boolean checkEmail(String email);

    public boolean nullInput(String input);

    public boolean dateFormat(String input);

    public boolean isNumber(String input);

    public boolean Month(String input);

    public boolean Luong(String input);

    public boolean Int(String input);

    public boolean checkIDHD(String input);

    public boolean checkViTri(String input);

    public boolean checkMaNv(String input);

    public boolean checkMaPhong(String input);

    public boolean checkLoaiHD(String input);
}

public class checkError implements check {
    @Override
    public boolean checkEmail(String email) {
        String ePattern = "^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    @Override
    public boolean nullInput(String input) {
        return input.length() == 0;
    }

    @Override
    public boolean dateFormat(String input) {
        // dinh dang ngay thang dd/mm/yy vd:02-12-2023
        return input.matches("([0-9]{2})-([0-9]{2})-([0-9]{4})");
    }

    @Override
    public boolean isNumber(String input) {
        String regex = "[0-9]+";
        return input.matches(regex);
    }

    @Override
    public boolean Month(String input) {
        // so thang tu 1 den 12
        return input.matches("[1-9]|1[0-2]");
    }

    @Override
    public boolean Luong(String input) {
        // luong kieu float
        try {
            Float.parseFloat(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public boolean Int(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public boolean checkIDHD(String input) {
        // hai ky tu dau la HD :theo sau la 4 so
        return input.matches("HD\\d{4}");
    }

    @Override
    public boolean checkViTri(String input) {
        return input.matches("NV|QL");
    }

    @Override
    public boolean checkMaNv(String input) {
        return input.matches("NV\\d{4}");
    }

    @Override
    public boolean checkMaPhong(String input) {
        return input.matches("p\\d{4}");
    }

    @Override
    public boolean checkLoaiHD(String input) {
        return input.matches("chinhthuc|thoivu");
    }
}
