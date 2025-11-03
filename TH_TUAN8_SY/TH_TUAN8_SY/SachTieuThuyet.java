/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TH_TUAN8_SY.TH_TUAN8_SY;

/**
 *
 * @author DELL
 */
public class SachTieuThuyet extends Sach {
    private String theLoai;
    private boolean laSachSeries;
    
    public SachTieuThuyet(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong, double giaCoBan, String theLoai, boolean laSachSeries) {
        super(maSach, tieuDe, tacGia, namXuatBan, soLuong, giaCoBan); 
        this.theLoai = theLoai;
        this.laSachSeries = laSachSeries; 
    }


    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public boolean isLaSachSeries() {
        return laSachSeries;
    }

    public void setLaSachSeries(boolean laSachSeries) {
        this.laSachSeries = laSachSeries;
    }

    // Yêu cầu 2: Hoàn thành hợp đồng (Ghi đè tinhGiaBan)
    @Override
    public double tinhGiaBan() {
        if (laSachSeries) {
            return getGiaCoBan() + 15000;
        } 
        else 
        {
            return getGiaCoBan();
        }
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
        return "SachTieuThuyet {" +
                "maSach='" + getMaSach() + '\'' +
                ", tieuDe='" + getTieuDe() + '\'' +
                ", tacGia='" + getTacGia() + '\'' +
                ", namXuatBan=" + getNamXuatBan() +
                ", soLuong=" + getSoLuong() +
                ", giaCoBan=" + getGiaCoBan() +
                ", theLoai='" + theLoai + '\'' +
                ", laSachSeries=" + (laSachSeries ? "Có" : "Không") +
                ", giaBan=" + tinhGiaBan() +
                '}';
    }
}