package QLTaiLieu;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLySach {

    private ArrayList<TaiLieu> taiLieus;

    public QuanLySach() {
        taiLieus = new ArrayList<>();
        run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int chosse = -1;
        while (chosse != 0) {
            System.out.println("Danh muc chuc nang: ");
            System.out.println("1. Nhap tai lieu");
            System.out.println("2. Xuat tai lieu");
            System.out.println("3. Xoa tai tieu");
            System.out.println("4. Tim kiem tai lieu bang maID");
            System.out.println("5. Tim kiem tai lieu bang keyword cua ID va Ten nha xuat ban");
            System.out.println("6. Cap Nhat tai lieu");
            System.out.println("0. Thoat khoi chuong trinh");

            boolean flag = true;

            do {
                System.out.println("Nhap chuc nang: ");
                chosse = scanner.nextInt();

                flag = true;

                switch (chosse) {
                    case 0:
                        System.out.println("Đã thoát chương trình!!!");
                        break;
                    case 1:
                        add();
                        break;
                    case 2:
                        view();
                        break;
                    case 3:
                        delete();
                        break;
                    case 4:
                        TaiLieu taiLieu= find();
                        if(taiLieu != null) {
                            System.out.println("Tai lieu can tim la: " + taiLieu.toString());
                        }
                        else {
                            System.out.println("Khong tim thay tai lieu can tim");
                        }
                        break;
                    case 5:
                        TaiLieu taiLieu1= findByKeyWord();
                        if(taiLieu1 != null) {
                            System.out.println("Tai lieu can tim la: " + taiLieu1.toString());
                        }
                        else {
                            System.out.println("Khong tim thay tai lieu can tim");
                        }
                        break;
                    case 6:
                        edit();
                        break;
                    default:
                        System.out.println("Chuc nang vua nhap khong ton tai. Vui long nhap lai!");
                        flag = false;
                        break;
                }
            } while (!flag);
        }

    }

//  Nhập tài liệu

    public void add() {
        int chosse = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Danh Sách Mục Tài Liệu: ");
        System.out.println("1. Sách");
        System.out.println("2. Tạp Chí");
        System.out.println("3. Báo");

        boolean flag = true;

        do {
            flag = true;

            System.out.println("Lua chon tai lieu");
            chosse = scanner.nextInt();

            TaiLieu taiLieu = new TaiLieu();
            switch (chosse) {
                case 1:
                    taiLieu = createTaiLieu();

                    scanner.nextLine();
                    System.out.println("Nhap ten tac gia: ");
                    String tenTacGia = scanner.nextLine();

                    System.out.println("Nhap so trang: ");
                    int soTrang = scanner.nextInt();

                    taiLieu = new Sach(taiLieu.getMaTaiLieu(), taiLieu.getTenNhaXuatBan(),
                            taiLieu.getSoBanPhatHanh(), tenTacGia, soTrang);

                    taiLieus.add(taiLieu);
                    break;
                case 2:

                    taiLieu = createTaiLieu();

                    System.out.println("Nhap so phat hanh: ");
                    int soPhatHanh = scanner.nextInt();

                    System.out.println("Nhap thang phat hanh: ");
                    int thangPhatHanh = scanner.nextInt();

                    taiLieu = new TapChi(taiLieu.getMaTaiLieu(), taiLieu.getTenNhaXuatBan(),
                            taiLieu.getSoBanPhatHanh(), soPhatHanh, thangPhatHanh);

                    taiLieus.add(taiLieu);

                    break;
                case 3:
                    taiLieu = createTaiLieu();

                    System.out.println("Nhap ngay thang nam phat hanh: ");
                    int ngayPhatHanh = scanner.nextInt();
                    int thangPhatHanh0 = scanner.nextInt();
                    int namPhatHanh = scanner.nextInt();

                    taiLieu = new Bao(taiLieu.getMaTaiLieu(), taiLieu.getTenNhaXuatBan(),
                            taiLieu.getSoBanPhatHanh(), ngayPhatHanh, thangPhatHanh0, namPhatHanh);

                    taiLieus.add(taiLieu);
                    break;
                default:
                    System.out.println("Khong co muc vua nhap, vui long nhap lai! ");
                    flag = false;
                    break;

            }

        } while (!flag);

    }
//  Xóa tài liệu
    public void delete() {

        TaiLieu taiLieu= find();

        if (taiLieu != null) {
            taiLieus.remove(taiLieu);
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Không tim thấy tài liệu!");
        }
    }

//  Xuất tài liệu
    public void view() {
        for (TaiLieu taiLieu : taiLieus) {
            System.out.println(taiLieu.toString());
        }
    }

//  Chỉnh sửa tài liệu
    public void edit() {
        TaiLieu taiLieu = find();
        Scanner scanner= new Scanner(System.in);

        boolean flag= true;
        int chosse= 0;

        if(taiLieu != null){
            System.out.println("Lua chon thuoc tinh can chinh sua: ");
            System.out.println("1. Ten nha xuat ban");
            System.out.println("2. So ban phat hanh");

            if(taiLieu instanceof Sach){
                System.out.println("3. Ten tac gia");
                System.out.println("4. So trang");

                do{
                    flag= true;

                    System.out.println("Nhap thuoc tinh can chinh sua: ");
                    chosse = scanner.nextInt();

                    switch (chosse){
                        case 1:
                            scanner.nextLine();
                            System.out.println("Nhap nha ten nha xuat ban");
                            taiLieu.setTenNhaXuatBan(scanner.nextLine());
                            break;
                        case 2:
                            System.out.println("Nhap so ban phat hanh");
                            taiLieu.setSoBanPhatHanh(scanner.nextInt());
                            break;
                        case 3:
                            scanner.nextLine();
                            System.out.println("Nhap ten tac gia: ");
                            ((Sach) taiLieu).setTenTacGia(scanner.nextLine());
                            break;
                        case 4:
                            System.out.println("Nhap so trang: ");
                            ((Sach) taiLieu).setSoTrang(scanner.nextInt());
                            break;
                        default:
                            System.out.println("Thuoc tinh vua nhap khong dung! Vui long nhap lai.");
                            flag= false;
                            break;
                    }

                    if(flag){
                        System.out.println("Cap nhat thanh cong!");
                    }

                }while (!flag);


            }

            else if(taiLieu instanceof TapChi){
                System.out.println("3. So phat hanh");
                System.out.println("4. Thang phat hanh");

                do{
                    flag= true;

                    System.out.println("Nhap thuoc tinh can chinh sua: ");
                    chosse = scanner.nextInt();

                    switch (chosse){
                        case 1:
                            scanner.nextLine();
                            System.out.println("Nhap nha ten nha xuat ban");
                            taiLieu.setTenNhaXuatBan(scanner.nextLine());
                            break;
                        case 2:
                            System.out.println("Nhap so ban phat hanh");
                            taiLieu.setSoBanPhatHanh(scanner.nextInt());
                            break;
                        case 3:
                            System.out.println("Nhap so phat hanh: ");
                            ((TapChi) taiLieu).setSoPhatHanh(scanner.nextInt());
                            break;
                        case 4:
                            System.out.println("Nhap so trang: ");
                            ((TapChi) taiLieu).setThangPhatHanh(scanner.nextInt());
                            break;
                        default:
                            System.out.println("Thuoc tinh vua nhap khong dung! Vui long nhap lai.");
                            flag= false;
                            break;
                    }

                    if(flag){
                        System.out.println("Cap nhat thanh cong!");
                    }

                }while (!flag);


            }

            else if(taiLieu instanceof Bao){
                System.out.println("3. Ngay phat hanh");
                System.out.println("4. Thang phat hanh");
                System.out.println("5. Nam phat hanh");

                do{
                    flag= true;

                    System.out.println("Nhap thuoc tinh can chinh sua: ");
                    chosse = scanner.nextInt();

                    switch (chosse){
                        case 1:
                            scanner.nextLine();
                            System.out.println("Nhap nha ten nha xuat ban");
                            taiLieu.setTenNhaXuatBan(scanner.nextLine());
                            break;
                        case 2:
                            System.out.println("Nhap so ban phat hanh");
                            taiLieu.setSoBanPhatHanh(scanner.nextInt());
                            break;
                        case 3:
                            System.out.println("Nhap ngay phat hanh: ");
                            ((Bao) taiLieu).setNgayPhatHanh(scanner.nextInt());
                            break;
                        case 4:
                            System.out.println("Nhap thang phat hanh: ");
                            ((Bao) taiLieu).setThangPhatHanh(scanner.nextInt());
                            break;
                        case 5:
                            System.out.println("Nhap nam phat hanh: ");
                            ((Bao) taiLieu).setNamPhatHanh(scanner.nextInt());
                            break;
                        default:
                            System.out.println("Thuoc tinh vua nhap khong dung! Vui long nhap lai.");
                            flag= false;
                            break;
                    }

                    if(flag){
                        System.out.println("Cap nhat thanh cong!");
                    }

                }while (!flag);


            }
        }
        else{
            System.out.println("Khong tim thay tai lieu co ma vua nhap!");
        }

    }

//  Tạo tài liệu ban đầu
    private TaiLieu createTaiLieu() {
        Scanner scanner = new Scanner(System.in);

        TaiLieu taiLieu = new TaiLieu();

//        System.out.println("Nhap ma Tai Lieu");
        taiLieu.setMaTaiLieu(getNewID());

        System.out.println("Nhap nha ten nha xuat ban");
        taiLieu.setTenNhaXuatBan(scanner.nextLine());

        System.out.println("Nhap so ban phat hanh");
        taiLieu.setSoBanPhatHanh(scanner.nextInt());

        return taiLieu;
    }

//  Tự động khởi tạo ID
    private String getNewID() {
        String maxID = "TL0";

//        kiểm tra và gán maxID = mã tài liệu lớn nhất
        for (TaiLieu taiLieu : taiLieus) {
            if (taiLieu.getMaTaiLieu().compareTo(maxID) > 0) {
                maxID = taiLieu.getMaTaiLieu();
            }
        }
//       Tạo newID = maxID - 2 kí tự đầu = "0"
        int newID = Integer.parseInt(maxID.substring(2));
//        tăng 1 giá trị cho ID mới
        newID += 1;

//      lengh = 8 - số chữ số của newID -> để lấp đầy các số 0
        int lenght = 8 - Integer.toString(newID).length();
        maxID = "TL";

//      Lấp đầu các số 0 vào maxID
        while (lenght > 0) {
            maxID += "0";
            lenght--;
        }

//      Sau khi lấp đầy số 0 thì mã id có dạng TL0000000
//      Cộng maxID = maxID + new ID = "TL0000000" + "1" = "TL00000001"
        maxID += Integer.toString(newID);

        return maxID;
    }

//  Tìm kiếm bằng MãTL
    public TaiLieu find(){
        TaiLieu info= null;

        Scanner scanner = new Scanner(System.in);
        String maTL= "";

        System.out.println("Nhap ma Tl can tim: ");
        maTL = scanner.nextLine();

        for (TaiLieu taiLieu: taiLieus){
            if(maTL.trim().equals(taiLieu.getMaTaiLieu().trim())){
                info = taiLieu;
                break;
            }
        }

        return info;
    }

    // Tìm kiếm bằng keyword
    public TaiLieu findByKeyWord(){
        TaiLieu info= null;

        Scanner scanner = new Scanner(System.in);
        String keyWord= "";

        System.out.println("Nhap ma Tl can tim: ");
        keyWord = scanner.nextLine();

        for (TaiLieu taiLieu: taiLieus){
            if(taiLieu.getMaTaiLieu().trim().contains(keyWord.trim())
                    || taiLieu.getTenNhaXuatBan().trim().contains(keyWord.trim())) {

                info = taiLieu;
                break;
            }
        }

        return info;
    }


}

