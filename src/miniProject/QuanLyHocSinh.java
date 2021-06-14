package miniProject;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyHocSinh {
    private ArrayList<HocSinh> hocSinhs;

    public QuanLyHocSinh() {
        Scanner scanner = new Scanner(System.in);
        khoiTao();

        while (true) {
            int num = 0;


            boolean flag = true;

            System.out.println("Chuc nang cua he thong");
            System.out.println("1.Khoi tao");
            System.out.println("2.Nhap");
            System.out.println("3.Xuat");
            System.out.println("4.Xoa");
            System.out.println("5.Tim kiem theo ten");
            System.out.println("6.sua thong tin");
            System.out.println("7.tu dong khoi tao maHS");
            System.out.println("8.hien thi danh sach lop can tim");
            System.out.println("9.tim kiem hoc sinh bang maHS");
            System.out.println("10.sap xep danh sach HS theo diem TB giam dan");

            do {
                flag = true;

                System.out.print("Nhap chuc nang: ");
                num = scanner.nextInt();

                switch (num) {
                    case 1:
                        khoiTao();
                        break;
                    case 2:
                        nhap();
                        break;
                    case 3:
                        xuat();
                        break;
                    case 4:
                        xoa();
                        break;
                    case 5:
                        timKiem();
                        break;
                    case 6:
                        sua();
                        break;
                    case 8:
                        hienThiDanhSachLop();
                        break;
                    case 9:
                        HocSinh hocSinh = find();
                        if (hocSinh != null) {
                            System.out.println("hoc sinh can tim la: " + hocSinh.toString());
                        }
                        break;
                    case 10:
                        sapXepDiemGiamDan();
                        break;
                    default:
                        flag = false;
                        System.out.println("chức năng này k tồn tại, vui lòng chon dung chuc nang!");
                        break;
                }
            }
            while (!flag);
        }
    }

    public void khoiTao() {

        hocSinhs = new ArrayList<>();
    }

    public void nhap() {

        Scanner scanner = new Scanner(System.in);
        HocSinh hocSinh = new HocSinh();

        System.out.print("họ và tên: ");
        hocSinh.setHoTen(scanner.nextLine());
        System.out.print("giới tính: ");
        hocSinh.setGioiTinh(scanner.nextLine());
        System.out.print("quê quán: ");
        hocSinh.setQueQuan(scanner.nextLine());
        System.out.print("lớp: ");
        hocSinh.setLop(scanner.nextLine());
        System.out.print("khóa học: ");
        hocSinh.setKhoaHoc(scanner.nextLine());
        System.out.print("kỳ học: ");
        hocSinh.setKyHoc(scanner.nextLine());
        System.out.print("điểm TB: ");
        hocSinh.setDiemTB(scanner.nextDouble());
        System.out.print("ma HS: ");
        hocSinh.setMaHS(auToID());
//        taiLieu.setMaTaiLieu(getNewID());


        hocSinhs.add(hocSinh);
    }

    public void xoa() {
        if (hocSinhs.size() == 0) {
            System.out.println("Danh sach rong!");

            return;
        }

        Scanner scanner = new Scanner(System.in);
        String tenHS = "";

        System.out.print("Nhap vao ten can xoa: ");
        tenHS = scanner.nextLine();

        int index = -1;
        for (int i = 0; i < hocSinhs.size(); i++) {
            if (tenHS.trim().equals(hocSinhs.get(i).getHoTen().trim())) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            hocSinhs.remove(index);

            System.out.println("Xoa thanh cong!");
        } else {
            System.out.println("tên học sinh vừa nhập không đúng!");
        }
    }

    public void xuat() {
        for (int i = 0; i < hocSinhs.size(); i++) {
            System.out.println(hocSinhs.get(i).toString());
        }
    }

    private void timKiem() {
        Scanner scanner = new Scanner(System.in);

        String keyword = "";

        System.out.print("nhạp vao tên học sinh cần tìm: ");
        keyword = scanner.nextLine();

        for (HocSinh hocSinh : hocSinhs) {
            if (hocSinh.getHoTen().contains(keyword.trim())) {
                System.out.println(hocSinh.toString());
            }
        }
    }

    public void sua() {
        HocSinh hocSinh = find();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        int chosse = 0;

        if (hocSinh != null) {
            System.out.println("Lua chon thuoc tinh can chinh sua: ");
            System.out.println("1. ho ten");
            System.out.println("2. gioi tinh");
            System.out.println("3. que quan");
            System.out.println("4. lop");
            System.out.println("5. khoa hoc");
            System.out.println("6. ky hoc");
            System.out.println("7. diem TB");
            System.out.println("8. ma HS");

            do {
                flag = true;

                System.out.print("Nhap thuoc tinh can chinh sua: ");
                chosse = scanner.nextInt();

                switch (chosse) {
                    case 1:
                        scanner.nextLine();
                        System.out.println("Nhap ho ten");
                        hocSinh.setHoTen(scanner.nextLine());
                        break;
                    case 2:
                        scanner.nextLine();
                        System.out.println("Nhap gioi tinh");
                        hocSinh.setGioiTinh(scanner.nextLine());
                        break;
                    case 3:
                        scanner.nextLine();
                        System.out.println("Nhap que quan: ");
                        hocSinh.setQueQuan(scanner.nextLine());
                        break;
                    case 4:
                        scanner.nextLine();
                        System.out.println("Nhap lop: ");
                        hocSinh.setLop(scanner.nextLine());
                        break;
                    case 5:
                        scanner.nextLine();
                        System.out.println("Nhap khoa hoc: ");
                        hocSinh.setKhoaHoc(scanner.nextLine());
                        break;
                    case 6:
                        scanner.nextLine();
                        System.out.println("Nhap ky hoc: ");
                        hocSinh.setKyHoc(scanner.nextLine());
                        break;
                    case 7:
                        System.out.println("Nhap diem TB: ");
                        hocSinh.setDiemTB(scanner.nextDouble());
                        break;
                    case 8:
                        scanner.nextLine();
                        System.out.println("Nhap ma HS: ");
                        hocSinh.setMaHS(scanner.nextLine());
                        break;
                    default:
                        System.out.println("Thuoc tinh vua nhap khong dung! Vui long nhap lai.");
                        flag = false;
                        break;
                }

                if (flag) {
                    System.out.println("Cap nhat thanh cong!");
                }

            } while (!flag);
        }
    }

    private String auToID() {
        String maxID = "HS0";

        for (HocSinh hocSinh : hocSinhs) {
            if (hocSinh.getMaHS().compareTo(maxID) > 0) {
                maxID = hocSinh.getMaHS();
            }
        }

        int newID = Integer.parseInt(maxID.substring(2));

        newID += 1;

        int lenght = 5 - Integer.toString(newID).length();
        maxID = "HS";

        while (lenght > 0) {
            maxID += "0";
            lenght--;
        }

        maxID += Integer.toString(newID);

        return maxID;
    }

    public HocSinh find() {
        HocSinh info = null;

        Scanner scanner = new Scanner(System.in);
        String maHS = "";

        System.out.print("Nhap ma HS can tim: ");
        maHS = scanner.nextLine();

        for (HocSinh hocSinh : hocSinhs) {
            if (maHS.trim().equals(hocSinh.getMaHS().trim())) {
                info = hocSinh;
                break;
            }
        }

        return info;
    }


    private void hienThiDanhSachLop() {
        Scanner scanner = new Scanner(System.in);

        String keyword = "";

        System.out.print("nhap vao ten lop can hien thi DS: ");
        keyword = scanner.nextLine();

        for (HocSinh hocSinh : hocSinhs) {
            if (hocSinh.getLop().contains(keyword.trim())) {
                System.out.println(hocSinh.toString());
            }
        }
    }

    private void sapXepDiemGiamDan() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < hocSinhs.size(); i++) {
            for (int j = 0; j < hocSinhs.size(); j++) {
                if (hocSinhs.get(i).getDiemTB() > hocSinhs.get(j).getDiemTB()) {
                    double temp = hocSinhs.get(i).getDiemTB();
                    hocSinhs.get(i).setDiemTB(hocSinhs.get(j).getDiemTB());
                    hocSinhs.get(j).setDiemTB(temp);
                }
            }
        }
        xuat();
    }
}