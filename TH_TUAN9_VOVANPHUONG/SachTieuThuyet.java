
package bt_tuan5;

import java.io.Serializable;

class SachTieuThuyet extends Sach implements Serializable {
    private String theLoai;
    private boolean lasachSerise;
    
    public SachTieuThuyet(String maSach, String tieuDe, String tacGia, int namXuatBan,int soluong, String theLoai,boolean lasachSerise, double giacoban){
        
        super( maSach, tieuDe, tacGia, namXuatBan, soluong, giacoban);
        this.theLoai = theLoai;
        this.lasachSerise = lasachSerise;          
    }
    @Override
    public double tinhGiaBan() {
        return giacoban + (lasachSerise? 15000 : 0);
    }
    
    @Override
    public String toString() {
        return "[SACH TIEU THUYET]\n" + 
               super.toString() +
               "\n\tThe loai: " + theLoai + ", La sach series: " + (lasachSerise ? "Co" : "Khong") +
               "\n\t=> GIA BAN: " + String.format("%,.0f VND", tinhGiaBan());
    }
   
}
