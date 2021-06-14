package QLTaiLieu;

public class Bao extends TaiLieu{
    private int ngayPhatHanh;
    private int thangPhatHanh;
    private int namPhatHanh;

    public Bao() {
    }

    public Bao(int ngayPhatHanh, int thangPhatHanh, int namPhatHanh) {
        this.ngayPhatHanh = ngayPhatHanh;
        this.thangPhatHanh = thangPhatHanh;
        this.namPhatHanh = namPhatHanh;
    }

    public Bao(String maTaiLieu, String tenNhaXuatBan, int soBanPhatHanh, int ngayPhatHanh, int thangPhatHanh, int namPhatHanh) {
        super(maTaiLieu, tenNhaXuatBan, soBanPhatHanh);
        this.ngayPhatHanh = ngayPhatHanh;
        this.thangPhatHanh = thangPhatHanh;
        this.namPhatHanh = namPhatHanh;
    }

    public int getNgayPhatHanh() {
        return ngayPhatHanh;
    }

    public void setNgayPhatHanh(int ngayPhatHanh) {
        this.ngayPhatHanh = ngayPhatHanh;
    }

    public int getThangPhatHanh() {
        return thangPhatHanh;
    }

    public void setThangPhatHanh(int thangPhatHanh) {
        this.thangPhatHanh = thangPhatHanh;
    }

    public int getNamPhatHanh() {
        return namPhatHanh;
    }

    public void setNamPhatHanh(int namPhatHanh) {
        this.namPhatHanh = namPhatHanh;
    }

    @Override
    public String toString() {
        return "Bao{" +
                "ngayPhatHanh=" + ngayPhatHanh +
                ", thangPhatHanh=" + thangPhatHanh +
                ", namPhatHanh=" + namPhatHanh +
                ", maTaiLieu='" + maTaiLieu + '\'' +
                ", tenNhaXuatBan='" + tenNhaXuatBan + '\'' +
                ", soBanPhatHanh=" + soBanPhatHanh +
                '}';
    }
}


