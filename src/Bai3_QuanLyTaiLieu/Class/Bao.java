package Bai3_QuanLyTaiLieu.Class;

public class Bao extends TaiLieu{
    private String ngayPhatHanh;

    public Bao() {

    }

    public Bao(String ngayPhatHanh) {
        this.ngayPhatHanh = ngayPhatHanh;
    }

    public Bao(String maTaiLieu, String tenNhaXuatBan, int soBanPhatHanh, String ngayPhatHanh) {
        super(maTaiLieu, tenNhaXuatBan, soBanPhatHanh);
        this.ngayPhatHanh = ngayPhatHanh;
    }

    public String getNgayPhatHanh() {
        return ngayPhatHanh;
    }

    public void setNgayPhatHanh(String ngayPhatHanh) {
        this.ngayPhatHanh = ngayPhatHanh;
    }

    @Override
    public String toString() {
        return "Bao{" +
                "ngayPhatHanh='" + ngayPhatHanh + '\'' +
                ", maTaiLieu='" + maTaiLieu + '\'' +
                ", tenNhaXuatBan='" + tenNhaXuatBan + '\'' +
                ", soBanPhatHanh=" + soBanPhatHanh +
                '}';
    }
}
