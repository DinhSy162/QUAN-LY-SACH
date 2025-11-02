public class SachGiaoTrinh extends Sach {
    private String monHoc;
    private String capDo;

    public SachGiaoTrinh(String maSach, String tieuDe, String tacGia, int namXuatBan, int soLuong, double giaCoBan, String monHoc, String capDo) {
        super(maSach, tieuDe, tacGia, namXuatBan, soLuong, giaCoBan);
        this.monHoc = monHoc;
        this.capDo = capDo;
    }

    @Override
    public double tinhGiaBan() {
        final int NAM_HIEN_TAI = 2025;
        int soNamDaXuatBan = NAM_HIEN_TAI - getNamXuatBan();
        soNamDaXuatBan = Math.max(0, soNamDaXuatBan);
        return getGiaCoBan() + (soNamDaXuatBan * 5000.0);
    }
    

    @Override
    public String toString(){
        return super.toString() + ", Mon hoc: " + monHoc + ", Cap do: " + capDo;
    }
}
