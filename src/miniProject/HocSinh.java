package miniProject;

public class HocSinh extends Nguoi {
    private String lop;
    private String khoaHoc;
    private String kyHoc;
    private double diemTB;
    private String maHS;

    public HocSinh() {

    }

    public HocSinh(String lop, String khoaHoc, String kyHoc, double diemTB, String maHS) {
        this.lop = lop;
        this.khoaHoc = khoaHoc;
        this.kyHoc = kyHoc;
        this.diemTB = diemTB;
        this.maHS = maHS;
    }

    public HocSinh(String hoTen, String gioiTinh, String queQuan, String lop, String khoaHoc, String kyHoc, double diemTB, String maHS) {
        super(hoTen, gioiTinh, queQuan);
        this.lop = lop;
        this.khoaHoc = khoaHoc;
        this.kyHoc = kyHoc;
        this.diemTB = diemTB;
        this.maHS = maHS;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(String khoaHoc) {
        this.khoaHoc = khoaHoc;
    }

    public String getKyHoc() {
        return kyHoc;
    }

    public void setKyHoc(String kyHoc) {
        this.kyHoc = kyHoc;
    }

    public double getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(double diemTB) {
        this.diemTB = diemTB;
    }

    public String getMaHS() {
        return maHS;
    }

    public void setMaHS(String maHS) {
        this.maHS = maHS;
    }

    @Override
    public String toString() {
        return "HocSinh{" +
                "lop='" + lop + '\'' +
                ", khoaHoc='" + khoaHoc + '\'' +
                ", kyHoc='" + kyHoc + '\'' +
                ", diemTB=" + diemTB +
                ", maHS='" + maHS + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", queQuan='" + queQuan + '\'' +
                '}';
    }
}