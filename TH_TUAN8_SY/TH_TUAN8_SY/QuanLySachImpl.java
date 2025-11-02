/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TH_TUAN8_SY.TH_TUAN8_SY;
/**
 *
 * @author DELL
 */

import java.util.ArrayList;

// Yêu cầu 3: Đổi tên lớp và triển khai IQuanLySach
public class QuanLySachImpl implements IQuanLySach
{
    private final ArrayList<Sach> danhSach;

    public QuanLySachImpl() 
    {
        danhSach = new ArrayList<>();
    }

    @Override
    public void themSach(Sach s) 
    {
        danhSach.add(s);
        // System.out.println("Da them sach: " + s.getTieuDe()); // Bỏ bớt in 2 lần
    }

    @Override
    public void xoaSach(String maSach) 
    {
        Sach s = timKiemSach(maSach);
        if (s != null) 
        {
            danhSach.remove(s);
            System.out.println("Da xoa sach co ma: " + maSach);
        } 
        else 
        {
            System.out.println("Khong tim thay sach co ma: " + maSach);
        }
    }

    // Phương thức này không có trong interface, nhưng được gọi từ Test.java
    public void capNhatSoLuong(String maSach, int soLuongMoi) 
    {
        Sach s = timKiemSach(maSach); // Sửa tên hàm
        if (s != null) 
        {
            s.setSoLuong(soLuongMoi);
            System.out.println("Da cap nhat so luong sach " + maSach + " thanh: " + soLuongMoi);
        } 
        else 
        {
            System.out.println("Khong tim thay sach de cap nhat!");
        }
    }

    // Yêu cầu 3: Đổi tên phương thức để khớp interface
    @Override
    public Sach timKiemSach(String maSach) 
    {
        for (Sach s : danhSach) 
        {
            if (s.getMaSach().equalsIgnoreCase(maSach)) 
            {
                return s;
            }
        }
        return null;
    }

    @Override
    public void hienThiDanhSach() 
    {
        System.out.println("\n=== DANH SACH SACH HIEN CO ===");
        if (danhSach.isEmpty()) {
            System.out.println("Danh sach trong.");
            return;
        }
        for (Sach s : danhSach) 
        {
            System.out.println(s);
        }
    }

}