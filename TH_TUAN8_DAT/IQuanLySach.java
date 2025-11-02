public interface IQuanLySach {
    void themSach(Sach s);
    void xoaSach(String maSach);
    Sach timKiemSach(String maSach);
    void capNhatSoLuong(String maSach, int soLuongMoi);
    void hienThiDanhSach();
    
    /**
     * Tinh tong gia tri ton kho cua tat ca sach trong danh sach.
     * Tong Gia Tri = SUM (Gia Ban * So Luong Ton Kho)
     * @return Tong gia tri ton kho.
     */
    double tinhTongGiaTriTonKho(); 
}