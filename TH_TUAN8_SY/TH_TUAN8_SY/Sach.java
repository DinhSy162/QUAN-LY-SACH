/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TH_TUAN8_SY.TH_TUAN8_SY;

/**
 *
 * @author DELL
 */

// Yêu cầu 1: Triển khai 2 interface IGiaBan và IKiemKe
public abstract class Sach implements IGiaBan, IKiemKe
{
    private String maSach;
    private String tieuDe;
    private String tacGia;
    private int namXuatBan;
    private int soLuong;
    private double giaCoBan; 

    public Sach() {}

    public Sach(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong, double giaCoBan) 
    {
        this.maSach = maSach;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.soLuong = soLuong;
        this.giaCoBan = giaCoBan;
    }

    // ===== Getter & Setter =====
    public String getMaSach() 
    { 
        return maSach; 
    }
    public void setMaSach(String maSach) 
    { 
        this.maSach = maSach; 
    }

    public String getTieuDe() 
    { 
        return tieuDe; 
    }
    public void setTieuDe(String tieuDe) 
    { 
        this.tieuDe = tieuDe; 
    }

    public String getTacGia() 
    { 
        return tacGia; 
    }
    public void setTacGia(String tacGia) 
    { 
        this.tacGia = tacGia; 
    }

    public int getNamXuatBan() 
    { 
        return namXuatBan; 
    }
    public void setNamXuatBan(int namXuatBan) 
    { 
        this.namXuatBan = namXuatBan; 
    }

    public int getSoLuong() 
    { 
        return soLuong; 
    }
    public void setSoLuong(int soLuong) 
    { 
        this.soLuong = soLuong; 
    }

    public double getGiaCoBan() 
    { 
        return giaCoBan; 
    }
    public void setGiaCoBan(double giaCoBan) 
    { 
        this.giaCoBan = giaCoBan; 
    }

    //Phương thức trừu tượng từ IGiaBan
    @Override
    public abstract double tinhGiaBan();

    // Yêu cầu 2: Thêm các phương thức trừu tượng từ IKiemKe
    @Override
    public abstract boolean kiemTraTonKho(int soLuongToiThieu);

    @Override
    public abstract void capNhatViTri(String viTriMoi);


    //Hiển thị thông tin 
    public void hienThiThongTin() 
    {
        System.out.println("Ma sach: " + maSach);
        System.out.println("Tieu de: " + tieuDe);
        System.out.println("Tac gia: " + tacGia);
        System.out.println("Nam xuat ban: " + namXuatBan);
        System.out.println("So luong: " + soLuong);
        System.out.println("Gia co ban: " + giaCoBan + " VND");
    }
}