
package bt_tuan5;

import java.util.Scanner;


public class Test {
    
    private static IQuanLySach quanLy = new QuanLySachImpl();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Thêm dữ liệu mẫu
        quanLy.themSach(new SachGiaoTrinh("GT01", "Lap trinh Java", "Nguyen Van A", 2020, 100, "CNTT", "Dai hoc", 120000));
        quanLy.themSach(new SachTieuThuyet("TT01", "Harry Potter", "J.K. Rowling", 2005, 200, "Ky ao", true, 180000));
        quanLy.themSach(new SachTieuThuyet("TT02", "Nha Gia Kim", "Paulo Coelho", 1988, 150, "Tieu thuyet", false, 90000));

        // Chạy menu
        menuChinh();
        scanner.close();
    }

    public static void menuChinh() {
        boolean thoat = false;
        while (!thoat) {
            System.out.println("\n--- CHUONG TRINH QUAN LY SACH ---");
            System.out.println("1. Them mot sach moi");
            System.out.println("2. Xoa sach theo ma");
            System.out.println("3. Tim kiem sach theo ma");
            System.out.println("4. Hien thi toan bo danh sach sach");
            System.out.println("5. Kiem tra ton kho (Chuc nang IKiemKe)");
            System.out.println("6. Cap nhat vi tri (Chuc nang IKiemKe)");
            System.out.println("0. Thoat chuong trinh");
            System.out.print("Vui long chon chuc nang: ");

            try {
                int luaChon = Integer.parseInt(scanner.nextLine());
                switch (luaChon) {
                    case 1:
                        themMoiSach();
                        break;
                    case 2:
                        xoaSach();
                        break;
                    case 3:
                        timKiemSach();
                        break;
                    case 4:
                        quanLy.hienThiDanhSach();
                        break;
                    case 5:
                        kiemTraTonKho();
                        break;
                    case 6:
                        capNhatViTri();
                        break;
                    case 0:
                        thoat = true;
                        System.out.println("Cam on da su dung chuong trinh!");
                        break;
                    default:
                        System.out.println("Lua chon khong hop le. Vui long chon lai.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Loi: Vui long nhap mot so.");
            }
        }
    }

    private static void themMoiSach() {
        System.out.println("Chon loai sach (1: Sach Giao Trinh, 2: Sach Tieu Thuyet): ");
        int loai = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhap ma sach: ");
        String ma = scanner.nextLine();
        System.out.print("Nhap tieu de: ");
        String tieuDe = scanner.nextLine();
        System.out.print("Nhap tac gia: ");
        String tacGia = scanner.nextLine();
        System.out.print("Nhap nam xuat ban: ");
        int nam = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhap so luong: ");
        int sl = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhap gia co ban: ");
        double gia = Double.parseDouble(scanner.nextLine());

        if (loai == 1) {
            System.out.print("Nhap mon hoc: ");
            String mon = scanner.nextLine();
            System.out.print("Nhap cap do: ");
            String cap = scanner.nextLine();
            Sach s = new SachGiaoTrinh(ma, tieuDe, tacGia, nam, sl, mon, cap, gia);
            quanLy.themSach(s);
        } else if (loai == 2) {
            System.out.print("Nhap the loai: ");
            String theLoai = scanner.nextLine();
            System.out.print("Co phai sach series (true/false): ");
            boolean series = Boolean.parseBoolean(scanner.nextLine());
            Sach s = new SachTieuThuyet(ma, tieuDe, tacGia, nam, sl, theLoai, series, gia);
            quanLy.themSach(s);
        } else {
            System.out.println("Loai sach khong hop le.");
        }
    }

    private static void xoaSach() {
        System.out.print("Nhap ma sach can xoa: ");
        String ma = scanner.nextLine();
        quanLy.xoaSach(ma);
    }

    private static void timKiemSach() {
        System.out.print("Nhap ma sach can tim: ");
        String ma = scanner.nextLine();
        Sach s = quanLy.timKiem(ma);
        if (s != null) {
            System.out.println("--- KET QUA TIM KIEM ---");
            System.out.println(s.toString());
        } else {
            System.out.println("Khong tim thay sach voi ma: " + ma);
        }
    }

    private static void kiemTraTonKho() {
        System.out.print("Nhap ma sach can kiem tra: ");
        String ma = scanner.nextLine();
        Sach s = quanLy.timKiem(ma);
        if (s != null) {
            System.out.print("Nhap so luong toi thieu can kiem tra: ");
            int min = Integer.parseInt(scanner.nextLine());
            
            // Su dung tinh da hinh de goi phuong thuc
            boolean duHang = s.kiemTraTonKho(min); 
            
            if (duHang) {
                System.out.println("=> KET QUA: DU TON KHO (So luong: " + s.getSoluong() + " >= " + min + ")");
            } else {
                System.out.println("=> KET QUA: KHONG DU TON KHO (So luong: " + s.getSoluong() + " < " + min + ")");
            }
        } else {
            System.out.println("Khong tim thay sach voi ma: " + ma);
        }
    }

    private static void capNhatViTri() {
        System.out.print("Nhap ma sach can cap nhat vi tri: ");
        String ma = scanner.nextLine();
        Sach s = quanLy.timKiem(ma);
        if (s != null) {
            System.out.print("Nhap vi tri moi (Vi du: Ke A1-Tang 3): ");
            String viTri = scanner.nextLine();
            
            // Su dung tinh da hinh de goi phuong thuc
            s.capNhatViTri(viTri);
            
        } else {
            System.out.println("Khong tim thay sach voi ma: " + ma);
        }
    }
}
