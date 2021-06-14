package Bai3_QuanLyTaiLieu.Class;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLySach {
    private ArrayList<TaiLieu> taiLieus;

    public void run() {
        while (true) {
            System.out.println("danh sách tài liệu: ");
            System.out.println("1.thêm tài liệu");
            System.out.println("2.xóa tài liệu");
            System.out.println("3.hiển thị danh sách");

            boolean flag = true;

            do {
                flag = true;

                int chose = 0;

                Scanner scanner = new Scanner(System.in);

                System.out.println("lựa chọn loại tài liệu: ");
                chose = scanner.nextInt();

                switch (chose){
                    case 1:
                        add();
                        break;
                    case 2:
                        delete();
                        break;
                    case 3:
                        view();
                        break;
                    default:
                        System.out.println("không có danh mục vừa nhập, vui lòng nhập lại!");
                        flag = false;
                }
            } while (!flag);
        }
    }

    public void add() {
        int chose = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("danh sách mục tài liệu: ");
        System.out.println("1.sách");
        System.out.println("2.tạp chí");
        System.out.println("3.báo");

        boolean flag = true;

        do {
            flag = true;
            System.out.println("lựa chọn loại tài liệu:");
            chose = scanner.nextInt();

            TaiLieu taiLieu = new TaiLieu();
            scanner.nextLine();

            switch (chose) {
                case 1:
                    taiLieu = createTaiLieu();
                    System.out.println("ten tác giả: ");
                    String tenTacGia = scanner.nextLine();
                    System.out.println("so trang: ");
                    int soTrang = scanner.nextInt();

                    taiLieus.add(new Sach(taiLieu.getMaTaiLieu(), taiLieu.getTenNhaXuatBan(),
                            taiLieu.getSoBanPhatHanh(), tenTacGia, soTrang));

                    break;
                case 2:
                    taiLieu = createTaiLieu();

                    System.out.println("so phat hành: ");
                    int soPhatHanh = scanner.nextInt();
                    System.out.println("tháng phat hành: ");
                    String thangPhatHanh = scanner.nextLine();

                    taiLieus.add(new TapChi(taiLieu.getMaTaiLieu(), taiLieu.getTenNhaXuatBan(),
                            taiLieu.getSoBanPhatHanh(), soPhatHanh, thangPhatHanh));
                    break;
                case 3:
                    taiLieu = createTaiLieu();

                    System.out.println("ngày phát hành: ");
                    String ngayPhatHanh = scanner.nextLine();

                    taiLieus.add(new Bao(taiLieu.getMaTaiLieu(), taiLieu.getTenNhaXuatBan(),
                            taiLieu.getSoBanPhatHanh(), ngayPhatHanh));
                    break;
                default:
                    System.out.println("không có danh mục vừa nhập, vui lòng nhập lại!");
                    flag = false;
                    break;
            }
        } while (!flag);

    }

    public void delete() {
        Scanner scanner = new Scanner(System.in);

        boolean flag = false;

        String maTaiLieu = "";

        System.out.println("nhập vào mã tài liệu cần xóa: ");
        for (TaiLieu taiLieu : taiLieus) {
            if (taiLieu.getMaTaiLieu().equals(maTaiLieu.trim())) {
                taiLieus.remove(taiLieu);
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.print("xóa thành công!");
        } else {
            System.out.print("không tìm thấy tài liệu có mã vừa nhập!");
        }
    }

    public void view() {
        for (TaiLieu taiLieu : taiLieus) {
            System.out.println(taiLieu.toString());
        }
    }

    private TaiLieu createTaiLieu() {
        Scanner scanner = new Scanner(System.in);

        TaiLieu taiLieu = new TaiLieu();

        System.out.println("ma tài liệu: ");
        taiLieu.setMaTaiLieu(scanner.nextLine());
        System.out.println("tên nhà xuất bản: ");
        taiLieu.setTenNhaXuatBan(scanner.nextLine());
        System.out.println("số bản phát hành: ");
        taiLieu.setSoBanPhatHanh(scanner.nextInt());

        return taiLieu;

    }
}
