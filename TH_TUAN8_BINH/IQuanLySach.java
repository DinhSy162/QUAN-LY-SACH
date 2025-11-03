/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlisach1;

import java.util.ArrayList;

/**
 * Giao diện trừu tượng hóa các chức năng quản lý sách.
 */
public interface IQuanLySach {
    
    void themSach(sach s);
    sach timKiemSach(String maSach);
    void xoaSach(String maSach);
    void hienThiDanhSach();
    void capNhatSach(String maSach, sach sachMoi);
    ArrayList<sach> layTatCaSach(); // Thêm phương thức để test menu
}
