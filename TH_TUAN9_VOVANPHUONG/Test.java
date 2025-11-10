package bt_tuan5;

import java.util.Scanner;


public class Test {
    
    private static IQuanLySach quanLy = new QuanLySachImpl();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
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
            System.out.println("7. Cap nhat thong tin sach"); // 2. THÊM CHỨC NĂNG MỚI
            System.out.println("0. Thoat chuong trinh");
            int luaChon = nhapSoNguyen("Vui long chon chuc nang: ");

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
                case 7:
                    capNhatThongTinSach();
                    break;
                case 0:
                    thoat = true;
                    System.out.println("Cam on da su dung chuong trinh!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }
        }
    }
    private static int nhapSoNguyen(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Loi: Vui long nhap mot SO NGUYEN hop le.");
            }
        }
    }
    
    private static int nhapSoNguyenDuong(String prompt) {
        while (true) {
            int so = nhapSoNguyen(prompt);
            if (so > 0) {
                return so;
            } else {
                System.out.println("Loi: Vui long nhap mot so lon hon 0.");
            }
        }
    }
    
    private static double nhapSoThucDuong(String prompt) {
         while (true) {
            try {
                System.out.print(prompt);
                double so = Double.parseDouble(scanner.nextLine());
                if (so > 0) {
                    return so;
                } else {
                     System.out.println("Loi: Vui long nhap mot so lon hon 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Loi: Vui long nhap mot SO THUC hop le.");
            }
        }
    }

    private static String nhapChuoi(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = scanner.nextLine();
            if (s != null && !s.trim().isEmpty()) {
                return s;
            } else {
                System.out.println("Loi: Khong duoc de trong.");
            }
        }
    }
    
    private static boolean nhapBoolean(String prompt) {
        while (true) {
            String s = nhapChuoi(prompt).toLowerCase();
            if (s.equals("true") || s.equals("t") || s.equals("y") || s.equals("co")) {
                return true;
            }
            if (s.equals("false") || s.equals("f") || s.equals("n") || s.equals("khong")) {
                return false;
            }
            System.out.println("Loi: Vui long nhap true/false (hoac t/f, y/n, co/khong).");
        }
    }
    
    private static void themMoiSach() {
        int loai = nhapSoNguyen("Chon loai sach (1: Sach Giao Trinh, 2: Sach Tieu Thuyet): ");
        String ma = nhapChuoi("Nhap ma sach: ");
        String tieuDe = nhapChuoi("Nhap tieu de: ");
        String tacGia = nhapChuoi("Nhap tac gia: ");
        int nam = nhapSoNguyen("Nhap nam xuat ban: ");
        int sl = nhapSoNguyenDuong("Nhap so luong: ");
        double gia = nhapSoThucDuong("Nhap gia co ban: ");

        if (loai == 1) {
            String mon = nhapChuoi("Nhap mon hoc: ");
            String cap = nhapChuoi("Nhap cap do: ");
            Sach s = new SachGiaoTrinh(ma, tieuDe, tacGia, nam, sl, mon, cap, gia);
            quanLy.themSach(s);
        } else if (loai == 2) {
            String theLoai = nhapChuoi("Nhap the loai: ");
            boolean series = nhapBoolean("Co phai sach series (true/false): ");
            Sach s = new SachTieuThuyet(ma, tieuDe, tacGia, nam, sl, theLoai, series, gia);
            quanLy.themSach(s);
        } else {
            System.out.println("Loai sach khong hop le.");
        }
    }

    private static void xoaSach() {
        String ma = nhapChuoi("Nhap ma sach can xoa: ");
        quanLy.xoaSach(ma);
    }

    private static void timKiemSach() {
        String ma = nhapChuoi("Nhap ma sach can tim: ");
        Sach s = quanLy.timKiem(ma);
        if (s != null) {
            System.out.println("--- KET QUA TIM KIEM ---");
            System.out.println(s.toString());
        } else {
            System.out.println("Khong tim thay sach voi ma: " + ma);
        }
    }

    private static void kiemTraTonKho() {
        String ma = nhapChuoi("Nhap ma sach can kiem tra: ");
        Sach s = quanLy.timKiem(ma);
        if (s != null) {
            int min = nhapSoNguyenDuong("Nhap so luong toi thieu can kiem tra: ");
            
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
        String ma = nhapChuoi("Nhap ma sach can cap nhat vi tri: ");
        Sach s = quanLy.timKiem(ma);
        if (s != null) {
            String viTri = nhapChuoi("Nhap vi tri moi (Vi du: Ke A1-Tang 3): ");
            
            s.capNhatViTri(viTri);
            ((QuanLySachImpl) quanLy).luuDuLieu();
            
        } else {
            System.out.println("Khong tim thay sach voi ma: " + ma);
        }
    }
    
    private static void capNhatThongTinSach() {
        String ma = nhapChuoi("Nhap ma sach can cap nhat: ");
        Sach s = quanLy.timKiem(ma);

        if (s == null) {
            System.out.println("Khong tim thay sach voi ma: " + ma);
            return;
        }

        System.out.println("Tim thay sach. Thong tin hien tai:");
        System.out.println(s.toString());
        System.out.println("--- MOI BAN CHON THONG TIN CAN SUA ---");
        System.out.println("1. Cap nhat Tieu de");
        System.out.println("2. Cap nhat Tac gia");
        System.out.println("3. Cap nhat So luong");
        System.out.println("4. Cap nhat Gia co ban");
        System.out.println("0. Quay lai");

        int luaChon = nhapSoNguyen("Chon thong tin (0-4): ");
        boolean daThayDoi = false;

        switch (luaChon) {
            case 1:
                String tieuDeMoi = nhapChuoi("Nhap tieu de moi: ");
                s.setTieuDe(tieuDeMoi);
                daThayDoi = true;
                break;
            case 2:
                String tacGiaMoi = nhapChuoi("Nhap tac gia moi: ");
                s.setTacGia(tacGiaMoi);
                daThayDoi = true;
                break;
            case 3:
                int slMoi = nhapSoNguyenDuong("Nhap so luong moi: ");
                s.setSoluong(slMoi);
                daThayDoi = true;
                break;
            case 4:
                double giaMoi = nhapSoThucDuong("Nhap gia co ban moi: ");
                s.setGiacoban(giaMoi);
                daThayDoi = true;
                break;
            case 0:
                System.out.println("Huy cap nhat.");
                return;
            default:
                System.out.println("Lua chon khong hop le.");
                return;
        }

        // Nếu có thay đổi, gọi hàm lưu file
        if (daThayDoi) {
            // Ép kiểu 'quanLy' về 'QuanLySachImpl' để gọi hàm luuDuLieu()
            ((QuanLySachImpl) quanLy).luuDuLieu();
            System.out.println("Da cap nhat thanh cong!");
        }
    }
}