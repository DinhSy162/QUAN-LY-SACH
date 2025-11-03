/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlisach1;

public class SachGiaoTrinh extends sach {
    private String monHoc; 
    private String capDo;

    public SachGiaoTrinh(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong, double giaCoBan, String monHoc, String capDo) {
        super(maSach, tieuDe, tacGia, namXuatBan, soLuong, giaCoBan); 
        this.monHoc = monHoc;
        this.capDo = capDo;
    }


    public String getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(String monHoc) {
        this.monHoc = monHoc;
    }

    public String getCapDo() {
        return capDo;
    }

    public void setCapDo(String capDo) {
        this.capDo = capDo;
    }

    // Yêu cầu 2: Hoàn thành hợp đồng (Ghi đè tinhGiaBan)
    @Override
    public double tinhGiaBan() {
        int soNamXuatBan = 2025 - getNamXuatBan(); // Giả sử năm hiện tại là 2025
        return getGiaCoBan() + (soNamXuatBan * 5000);
    }
    
    // Yêu cầu 2: Hoàn thành hợp đồng (Triển khai IKiemKe)
    @Override
    public boolean kiemTraTonKho(int soLuongToiThieu) {
        return this.getSoLuong() >= soLuongToiThieu;
    }

    @Override
    public void capNhatViTri(String viTriMoi) {
        System.out.println("Đã chuyển sách [" + getTieuDe() + "] đến khu vực [" + viTriMoi + "].");
    }

    // Yêu cầu 2: Cập nhật toString
    @Override
    public String toString() {
        return "SachGiaoTrinh {" +
                "maSach='" + getMaSach() + '\'' +
                ", tieuDe='" + getTieuDe() + '\'' +
                ", tacGia='" + getTacGia() + '\'' +
                ", namXuatBan=" + getNamXuatBan() +
                ", soLuong=" + getSoLuong() +
                ", giaCoBan=" + getGiaCoBan() +
                ", monHoc='" + monHoc + '\'' +
                ", capDo='" + capDo + '\'' +
                ", giaBan=" + tinhGiaBan() +
                '}';
    }
}