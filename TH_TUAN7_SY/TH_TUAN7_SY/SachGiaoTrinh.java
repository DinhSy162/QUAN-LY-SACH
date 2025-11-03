/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TH_TUAN7_SY.TH_TUAN7_SY;

/**
 *
 * @author DELL
 */
public class SachGiaoTrinh extends Sach {
    private String monHoc; 
    private String capDo;

    public SachGiaoTrinh(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong, double giaCoBan, String monHoc, String capDo) {
        super(maSach, tieuDe, tacGia, namXuatBan, soLuong, giaCoBan); 
        this.monHoc = monHoc;
        this.capDo = capDo;
    }

    SachGiaoTrinh(String maGT, String tdGT, String tgGT, int namGT, int slGT, String mon, String capDo) {
        throw new UnsupportedOperationException("Not supported yet."); 
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

    @Override
    public double tinhGiaBan() {
        int soNamXuatBan = 2025 - getNamXuatBan();
        return getGiaCoBan() + (soNamXuatBan * 5000);
    }

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
