/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package TH_TUAN8_SY.TH_TUAN8_SY;

/**
 *
 * @author DELL
 */
/**
 * Yêu cầu 3: Interface trừu tượng hóa dịch vụ quản lý
 */
public interface IQuanLySach {
    void themSach(Sach s);
    void xoaSach(String maSach);
    Sach timKiemSach(String maSach); // Đổi tên từ timKiem/timKiemTheoMa
    void hienThiDanhSach();
}