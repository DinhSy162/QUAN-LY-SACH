/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlisach1;

import java.util.ArrayList;

// Yêu cầu 3: Đổi tên lớp và triển khai IQuanLySach
public class QuanLySachImpl implements IQuanLySach
{
    private final ArrayList<sach> danhSach;

    public QuanLySachImpl() 
    {
        danhSach = new ArrayList<>();
    }

    @Override
    public void themSach(sach s) 
    {
        danhSach.add(s);
        // System.out.println("Da them sach: " + s.getTieuDe()); // Bỏ bớt in 2 lần
    }

    @Override
    public void xoaSach(String maSach) 
    {
        sach s = timKiemSach(maSach);
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
        sach s = timKiemSach(maSach); // Sửa tên hàm
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
    public sach timKiemSach(String maSach) 
    {
        for (sach s : danhSach) 
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
        for (sach s : danhSach) 
        {
            System.out.println(s);
        }
    }

}