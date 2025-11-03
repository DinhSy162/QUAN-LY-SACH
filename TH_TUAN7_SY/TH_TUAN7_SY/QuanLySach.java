/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TH_TUAN7_SY.TH_TUAN7_SY;

/**
 *
 * @author DELL
 */


import java.util.ArrayList;

public class QuanLySach 
{
    private final ArrayList<Sach> danhSach;

    public QuanLySach() 
    {
        danhSach = new ArrayList<>();
    }

    public void themSach(Sach s) 
    {
        danhSach.add(s);
        System.out.println("Da them sach: " + s.getTieuDe());
    }

    public void xoaSach(String maSach) 
    {
        Sach s = timKiem(maSach);
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

    public void capNhatSoLuong(String maSach, int soLuongMoi) 
    {
        Sach s = timKiem(maSach);
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

    public Sach timKiem(String maSach) 
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

    public void hienThiDanhSach() 
    {
        System.out.println("\n=== DANH SACH SACH HIEN CO ===");
        for (Sach s : danhSach) 
        {
            System.out.println(s);
        }
    }

    Sach timKiemTheoMa(String maTim) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
     

}
