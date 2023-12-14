package model;

interface methodArray {
    public void add(NhanVien value);

    public int sizeOfArray();
}

public class ArrayClass implements methodArray {
    private NhanVien[] array = new NhanVien[0];

    public ArrayClass() {
    }

    public ArrayClass(int size) {
        this.array = new NhanVien[size];
    }

    public static NhanVien[] concat(NhanVien[] arr1, NhanVien[] arr2) {
        int length = arr1.length + arr2.length;
        NhanVien[] result = new NhanVien[length];
        int pos = 0;
        for (NhanVien nv : arr1) {
            result[pos++] = nv;
        }
        for (NhanVien nv : arr2) {
            result[pos++] = nv;
        }
        return result;
    }

    @Override
    public void add(NhanVien value) {
        NhanVien[] nv = { value };
        concat(this.array, nv);
    }

    @Override
    public int sizeOfArray() {
        return this.array.length;
    }

    public String toString() {
        String element = "";
        for (NhanVien nv : this.array) {
            element += nv;
            element += ",";
        }
        return "[" + element + "]";
    }
}
