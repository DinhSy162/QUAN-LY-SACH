
package bt_tuan5;


public abstract class Sach implements IGiaBan, IkiemKe {
    private String maSach;
    private String tieuDe;
    private String tacGia;
    private int namXuatBan;
    private int soluong;
    protected double giacoban;
    public Sach(){
        
    }

    public Sach(String maSach, String tieuDe, String tacGia, int namXuatBan, int soluong, double giacoban) {
        this.maSach = maSach;
        this.tieuDe = tieuDe;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.soluong = soluong;
        this.giacoban= giacoban;
    }

    public String getMaSach() {
        return maSach;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public String getTacGia() {
        return tacGia;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }
    public void setTacGia(String tacGia){
        this.tacGia = tacGia;
    }

    public void setNamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
    public void hienthithongtin(){
   
        System.out.println(this.toString());

    }
    @Override
    public String toString() {
        return "Ma sach: " + maSach +", Tieu de: " + tieuDe +", Tac giai: " + tacGia +", Nam xuat ban: " + namXuatBan +", so luong: " + soluong;
    }
    // 15-10
    @Override
    public abstract double tinhGiaBan();
    @Override
    public boolean kiemTraTonKho(int soLuongToiThieu) {
        return this.soluong >= soLuongToiThieu;
    }
    @Override
    public void capNhatViTri(String viTriMoi) {
        System.out.println("DA CHUYEN SACH [" + this.getTieuDe() + "] DEN KHU VUC: [" + viTriMoi + "].");
    }
  
    public double getGiacoban(){
        return giacoban;
    }
    public void setGiacoban(double giacoban){
        this.giacoban = giacoban; 
    }
}
