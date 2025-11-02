import java.util.Scanner;

public class Test {
    
    public static Sach taoSach(Scanner sc) {
        System.out.println("\n--- TAO SACH MOI ---");
        System.out.print("Nhap Ma Sach: ");
        String maSach = sc.nextLine();
        System.out.print("Nhap Tieu De: ");
        String tieuDe = sc.nextLine();
        System.out.print("Nhap Tac Gia: ");
        String tacGia = sc.nextLine();
        System.out.print("Nhap Nam Xuat Ban: ");
        int namXuatBan = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap So Luong: ");
        int soLuong = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap Gia Co Ban: ");
        double giaCoBan = Double.parseDouble(sc.nextLine());
        
        System.out.print("Chon loai sach (1: Sach Giao Trinh, 2: Sach Tieu Thuyet): ");
        String loai = sc.nextLine();

        if (loai.equals("1")) {
            System.out.print("Nhap Mon Hoc: ");
            String monHoc = sc.nextLine();
            System.out.print("Nhap Cap Do: ");
            String capDo = sc.nextLine();
            return new SachGiaoTrinh(maSach, tieuDe, tacGia, namXuatBan, soLuong, giaCoBan, monHoc, capDo);
        } else if (loai.equals("2")) {
            System.out.print("Nhap The Loai: ");
            String theLoai = sc.nextLine();
            System.out.print("La Sach Series (true/false): ");
            boolean laSeries = Boolean.parseBoolean(sc.nextLine());
            return new SachTieuThuyet(maSach, tieuDe, tacGia, namXuatBan, soLuong, giaCoBan, theLoai, laSeries);
        } else {
            System.out.println("Loai sach khong hop le.");
            return null;
        }
    }

    public static void main(String[] args) {
        IQuanLySach quanLy = new QuanLySachImpl();
        Scanner sc = new Scanner(System.in);
        int luaChon;
        
        quanLy.themSach(new SachGiaoTrinh("GT001", "Giai tich 1", "Nguyen Van A", 2021, 15, 50000.0, "Toan hoc", "Dai hoc"));
        quanLy.themSach(new SachTieuThuyet("TT001", "Harry Potter", "J.K. Rowling", 2000, 5, 120000.0, "Gia tuong", true));
        
        do {
            System.out.println("\n=============== MENU QUAN LY SACH ===============");
            System.out.println("1. Them sach moi");
            System.out.println("2. Hien thi danh sach sach");
            System.out.println("3. Tim kiem sach theo ma");
            System.out.println("4. Cap nhat so luong sach");
            System.out.println("5. Kiem tra ton kho (Demo)");
            System.out.println("6. Cap nhat vi tri (Demo)");
            System.out.println("7. Tinh Tong Gia Tri Ton Kho (NOI DUNG THEM)");
            System.out.println("0. Thoat chuong trinh");
            System.out.println("=================================================");
            System.out.print("Nhap lua chon cua ban: ");
            
            try {
                luaChon = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                luaChon = -1; 
            }

            switch (luaChon) {
                case 1:
                    Sach sachMoi = taoSach(sc);
                    if (sachMoi != null) {
                        quanLy.themSach(sachMoi);
                    }
                    break;
                case 2:
                    quanLy.hienThiDanhSach();
                    break;
                case 3:
                    System.out.print("Nhap Ma Sach can tim: ");
                    String maTim = sc.nextLine();
                    Sach tim = quanLy.timKiemSach(maTim);
                    if (tim != null) {
                        System.out.println("Ket qua tim kiem: " + tim.toString());
                    } else {
                        System.out.println("Khong tim thay sach co ma " + maTim);
                    }
                    break;
                case 4:
                    System.out.print("Nhap Ma Sach can cap nhat so luong: ");
                    String maCapNhat = sc.nextLine();
                    System.out.print("Nhap So Luong moi: ");
                    try {
                        int soLuongMoi = Integer.parseInt(sc.nextLine());
                        quanLy.capNhatSoLuong(maCapNhat, soLuongMoi);
                    } catch (NumberFormatException e) {
                        System.out.println("So luong khong hop le.");
                    }
                    break;
                case 5:
                    System.out.print("Nhap Ma Sach de kiem tra ton kho: ");
                    String maKiemKho = sc.nextLine();
                    Sach sachKiemKho = quanLy.timKiemSach(maKiemKho);
                    if (sachKiemKho != null) {
                         System.out.print("Nhap so luong toi thieu: ");
                         try {
                            int toiThieu = Integer.parseInt(sc.nextLine());
                            if (sachKiemKho.kiemTraTonKho(toiThieu)) {
                                System.out.println("[" + sachKiemKho.getTieuDe() + "] - DU HANG: So luong hien tai (" + sachKiemKho.getSoLuong() + ") >= " + toiThieu);
                            } else {
                                System.out.println("[" + sachKiemKho.getTieuDe() + "] - HET HANG: So luong hien tai (" + sachKiemKho.getSoLuong() + ") < " + toiThieu);
                            }
                         } catch (NumberFormatException e) {
                             System.out.println("So luong toi thieu khong hop le.");
                         }
                    } else {
                        System.out.println("Khong tim thay sach co ma " + maKiemKho);
                    }
                    break;
                case 6:
                    System.out.print("Nhap Ma Sach de cap nhat vi tri: ");
                    String maViTri = sc.nextLine();
                    Sach sachViTri = quanLy.timKiemSach(maViTri);
                    if (sachViTri != null) {
                        System.out.print("Nhap vi tri moi: ");
                        String viTriMoi = sc.nextLine();
                        sachViTri.capNhatViTri(viTriMoi);
                    } else {
                        System.out.println("Khong tim thay sach co ma " + maViTri);
                    }
                    break;
                case 7:
                    double tongGiaTri = quanLy.tinhTongGiaTriTonKho();
                    System.out.println("=================================================");
                    System.out.println("TONG GIA TRI TON KHO HIEN TAI: " + String.format("%.2f", tongGiaTri) + " VND");
                    System.out.println("=================================================");
                    break;
                case 0:
                    System.out.println("Tam biet!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long nhap lai.");
            }
        } while (luaChon != 0);
        
        sc.close();
    }
}
