package model;

public class StringArray {
    private String[] array = new String[0];

    public String[] getArray() {
        return this.array;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    public StringArray() {

    }

    public StringArray(int size) {
        this.array = new String[size];
    }

    public int sizeOf() {
        return this.array.length;
    }

    public boolean isEmty() {
        return this.array.length == 0;
    }

    public void push(String value) {
        String newArray[] = new String[this.sizeOf() + 1];
        for (int i = 0; i < newArray.length - 1; i++) {
            newArray[i] = this.array[i];
        }
        newArray[newArray.length - 1] = value;
        this.array = newArray;
    }

    public String shift() {
        if (this.isEmty()) {
            return "";
        }
        String newArray[] = new String[this.array.length - 1];
        for (int i = this.array.length - 1; i > 0; i--) {
            newArray[i] = this.array[i];
        }
        String result = this.array[0];
        this.array = newArray;
        return result;
    }

    public String toString() {
        String result = "[";
        for (String s : this.array) {
            result = result.concat(s);
            result = result.concat(";");
        }
        result = result.concat("]");
        return result;
    }
}
