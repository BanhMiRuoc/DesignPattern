package models;

public class Student {
    private String mssv;
    private String hoTen;
    private String ngaySinh;
    private String lop;

    public Student(String mssv, String hoTen, String ngaySinh, String lop) {
        this.mssv = mssv;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.lop = lop;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }
}
