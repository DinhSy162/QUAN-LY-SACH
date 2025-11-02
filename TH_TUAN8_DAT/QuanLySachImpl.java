import java.util.ArrayList;

public class QuanLySachImpl implements IQuanLySach {
    private ArrayList<Sach> danhSachSach = new ArrayList<>();

    @Override
    public void themSach(Sach s) {
        danhSachSach.add(s);
        System.out.println("Da them sach: " + s.getTieuDe());
    }

    @Override
    public void xoaSach(String maSach) {
        boolean removed = danhSachSach.removeIf(s -> s.getMaSach().equalsIgnoreCase(maSach));
        if (removed) {
            System.out.println("Da xoa sach co ma: " + maSach);
        } else {
            System.out.println("Khong tim thay sach co ma: " + maSach + " de xoa.");
        }
    }

    @Override
    public Sach timKiemSach(String maSach) {
        for (Sach s : danhSachSach) {
            if (s.getMaSach().equalsIgnoreCase(maSach)) {
                return s;
            }
        }
        return null;
    }
    
    @Override
    public void capNhatSoLuong(String maSach, int soLuongMoi) {
        Sach s = timKiemSach(maSach);
        if (s != null) {
            s.setSoLuong(soLuongMoi);
            System.out.println("Da cap nhat so luong cho sach [" + s.getTieuDe() + "] thanh " + soLuongMoi);
        } else {
            System.out.println("Khong tim thay sach co ma: " + maSach + " de cap nhat.");
        }
    }

    @Override
    public void hienThiDanhSach() {
        if (danhSachSach.isEmpty()) {
            System.out.println("Danh sach sach trong!");
        } else {
            System.out.println("----- DANH SACH SACH Hien Co -----");
            for (Sach s : danhSachSach) {
                System.out.println(s.toString());
            }
            System.out.println("----------------------------------");
        }
    }
    
    /**
     * Tinh tong gia tri ton kho cua tat ca sach trong danh sach.
     * Tong Gia Tri = SUM (Gia Ban * So Luong Ton Kho)
     * @return Tong gia tri ton kho.
     */
    @Override
    public double tinhTongGiaTriTonKho() {
        double tongGiaTri = 0;
        for (Sach s : danhSachSach) {
            // Gia tri cua mot cuon sach = Gia ban * So luong hien co
            tongGiaTri += s.tinhGiaBan() * s.getSoLuong(); 
        }
        return tongGiaTri;
    }
}