
package bt_tuan5;

import java.io.Serializable;
import java.time.LocalDate;

class SachGiaoTrinh extends Sach implements Serializable {
    private String Monhoc;
    private String Capdo;
   
    
    public SachGiaoTrinh(String maSach,String tieuDe, String tacGia, int namXuatBan, int soluong, String Monhoc,String Capdo, double giacoban){
        
       super(maSach, tieuDe, tacGia, namXuatBan, soluong, giacoban); 
        this.Capdo = Capdo;
        this.Monhoc = Monhoc;   
        
    }
   @Override
    public double tinhGiaBan() {
        //  Tự động lấy năm hiện tại thay vì 2025
        int namHienTai = LocalDate.now().getYear();
        int soNam = namHienTai - getNamXuatBan(); 
        if (soNam < 0) soNam = 0; 
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