package Bai2_QuanLyCanBo;

public class CanBo extends Nguoi {
    private int luongCung;
    private int luongThuong;
    private int tienPhat;

    public CanBo() {
        super(); // gọi ra các phương thức mà mình override của lớp cha.
    }

    public CanBo(String hoTen, byte tuoi, String queQuan, String maGV, int luongCung, int luongThuong, int tienPhat) {
        super(hoTen, tuoi, queQuan, maGV);
        this.luongCung = luongCung;
        this.luongThuong = luongThuong;
        this.tienPhat = tienPhat;
    }

    public int getLuongCung() {
        return luongCung;
    }

    public void setLuongCung(int luongCung) {
        this.luongCung = luongCung;
    }

    public int getLuongThuong() {
        return luongThuong;
    }

    public void setLuongThuong(int luongThuong) {
        this.luongThuong = luongThuong;
    }

    public int getTienPhat() {
        return tienPhat;
    }

    public void setTienPhat(int tienPhat) {
        this.tienPhat = tienPhat;
    }
}
