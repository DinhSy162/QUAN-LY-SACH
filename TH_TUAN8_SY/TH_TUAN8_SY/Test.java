/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package TH_TUAN8_SY.TH_TUAN8_SY;

/**
 *
 * @author DELL
 */
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        // Yêu cầu 4: Khởi tạo đối tượng quản lý qua Interface
        IQuanLySach ql = new QuanLySachImpl();
        
        // Phải ép kiểu để dùng hàm capNhatSoLuong (không có trong Interface)
        // Hoặc thêm hàm capNhatSoLuong vào IQuanLySach
        QuanLySachImpl qlImpl = (QuanLySachImpl) ql; 
        
        try (Scanner sc = new Scanner(System.in)) {
            int chon = 0;
            
            do {
                System.out.println("\n===== MENU QUAN LY SACH =====");
                System.out.println("1. Them sach giao trinh");
                System.out.println("2. Them sach tieu thuyet");
                System.out.println("3. Hien thi danh sach");
                System.out.println("4. Tim kiem theo ma sach");
                System.out.println("5. Cap nhat so luong sach");
                System.out.println("6. Xoa sach theo ma");
                System.out.println("0. Thoat");
                System.out.print("Chon chuc nang: ");
                
                try {
                    chon = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Lua chon khong hop le! Phai nhap so.");
                    continue;
                }
                
                switch (chon) {
                    case 1 -> {
                        try {
                            System.out.println("\n Them sach giao trinh ==");
                            System.out.print("Ma sach: ");
                            String maGT = sc.nextLine();
                            System.out.print("Tieu de: ");
                            String tdGT = sc.nextLine();
                            System.out.print("Tac gia: ");
                            String tgGT = sc.nextLine();
                            System.out.print("Nam xuat ban: ");
                            int namGT = Integer.parseInt(sc.nextLine());
                            System.out.print("So luong: ");
                            int slGT = Integer.parseInt(sc.nextLine());
                            System.out.print("Gia co ban: ");
                            double giaGT = Double.parseDouble(sc.nextLine());
                            System.out.print("Mon hoc: ");
                            String mon = sc.nextLine();
                            System.out.print("Cap do: ");
                            String capDo = sc.nextLine();
                            
                            SachGiaoTrinh sg = new SachGiaoTrinh(maGT, tdGT, tgGT, namGT, slGT, giaGT, mon, capDo);
                            ql.themSach(sg); // Yêu cầu 4: Thực thi
                            System.out.println("Da them sach giao trinh!");
                        } catch (NumberFormatException e) {
                            System.out.println("Loi nhap lieu: Nam xuat ban, So luong, Gia phai la so!");
                        }
                    }
                    
                    case 2 -> {
                        try {
                            System.out.println("\nThem sach tieu thuyet ==");
                            System.out.print("Ma sach: ");
                            String maTT = sc.nextLine();
                            System.out.print("Tieu de: ");
                            String tdTT = sc.nextLine();
                            System.out.print("Tac gia: ");
                            String tgTT = sc.nextLine();
                            System.out.print("Nam xuat ban: ");
                            int namTT = Integer.parseInt(sc.nextLine());
                            System.out.print("So luong: ");
                            int slTT = Integer.parseInt(sc.nextLine());
                            System.out.print("Gia co ban: ");
                            double giaTT = Double.parseDouble(sc.nextLine());
                            System.out.print("The loai: ");
                            String tl = sc.nextLine();
                            System.out.print("Co phai sach series khong (true/false): ");
                            boolean series = Boolean.parseBoolean(sc.nextLine());
                            
                            SachTieuThuyet st = new SachTieuThuyet(maTT, tdTT, tgTT, namTT, slTT, giaTT, tl, series);
                            ql.themSach(st); // Yêu cầu 4: Thực thi
                            System.out.println("Da them sach tieu thuyet!");
                        } catch (NumberFormatException e) {
                            System.out.println("Loi nhap lieu: Nam xuat ban, So luong, Gia phai la so!");
                        }
                    }
                    
                    case 3 -> {
                        System.out.println("\n Danh sach cac sach:");
                        ql.hienThiDanhSach();
                    }
                    
                    case 4 -> {
                        System.out.print("\nNhap ma sach can tim: ");
                        String maTim = sc.nextLine();
                        Sach kq = ql.timKiemSach(maTim); 
                        if (kq != null) {
                            System.out.println("Tim thay sach:");
                            System.out.println(kq);
                        } else {
                            System.out.println("Khong tim thay sach co ma: " + maTim);
                        }
                    }
                    
                    case 5 -> {
                        try {
                            System.out.print("\n Nhap ma sach can cap nhat: ");
                            String maCN = sc.nextLine();
                            System.out.print("Nhap so luong moi: ");
                            int slMoi = Integer.parseInt(sc.nextLine());
                            qlImpl.capNhatSoLuong(maCN, slMoi); 
                        } catch (NumberFormatException e) {
                            System.out.println("So luong moi phai la so!");
                        }
                    }
                    
                    case 6 -> {
                        System.out.print("\nNhap ma sach can xoa: ");
                        String maXoa = sc.nextLine();
                        ql.xoaSach(maXoa);
                    }
                    
                    case 0 -> System.out.println("Thoat chuong trinh...");
                    
                    default -> System.out.println("Lua chon khong hop le!");
                }
            } while (chon != 0);
        }
    }
}