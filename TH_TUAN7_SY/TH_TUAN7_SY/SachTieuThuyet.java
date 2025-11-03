/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TH_TUAN7_SY.TH_TUAN7_SY;

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

    SachTieuThuyet(String maTT, String tdTT, String tgTT, int namTT, int slTT, String tl, boolean series) {
        throw new UnsupportedOperationException("Not supported yet."); 
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

    // Ghi đè phương thức trừu tượng
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

