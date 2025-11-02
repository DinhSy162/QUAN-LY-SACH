
package bt_tuan5;

class SachGiaoTrinh extends Sach {
    private String Monhoc;
    private String Capdo;
   
    
    public SachGiaoTrinh(String maSach,String tieuDe, String tacGia, int namXuatBan, int soluong, String Monhoc,String Capdo, double giacoban){
        
       super(maSach, tieuDe, tacGia, namXuatBan, soluong, giacoban); 
        this.Capdo = Capdo;
        this.Monhoc = Monhoc;   
        
    }
   @Override
    public double tinhGiaBan() {
        int soNam = 2025 - getNamXuatBan(); 
        return giacoban + soNam * 5000;
    }
    @Override
    public String toString() {
        return "[SACH GIAO TRINH]\n" + 
               super.toString() +
               "\n\tMon hoc: " + Monhoc + ", Cap do: " + Capdo +
               "\n\t=> GIA BAN: " + String.format("%,.0f VND", tinhGiaBan());
    }
    
    
    
   
}