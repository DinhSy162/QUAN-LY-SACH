
package bt_tuan5;

import java.util.ArrayList;

public class QuanLySachImpl implements IQuanLySach {
    
    private ArrayList<Sach> danhsach;

    public QuanLySachImpl() {
        danhsach = new ArrayList<>();
    }

    @Override
    public void themSach(Sach s) {
        danhsach.add(s);
        System.out.println("Da them sach '" + s.getTieuDe() + "' vao danh sach.");
    }

    @Override
    public void xoaSach(String ma) {
        Sach s = timKiem(ma);
        if (s != null) {
            danhsach.remove(s);
            System.out.println("Da xoa sach co ma: " + ma);
        } else {
            System.out.println("Khong tim thay sach voi ma: " + ma);
        }
    }

    @Override
    public void capNhatSach(String ma, Sach sachMoi) {
        for (int i = 0; i < danhsach.size(); i++) {
            if (danhsach.get(i).getMaSach().equalsIgnoreCase(ma)) {
                danhsach.set(i, sachMoi);
                System.out.println("Da cap nhat sach co ma: " + ma);
                return;
            }
        }
        System.out.println("Khong tim thay sach de cap nhat voi ma: " + ma);
    }

    @Override
    public Sach timKiem(String ma) {
        for (Sach s : danhsach) {
            if (s.getMaSach().equalsIgnoreCase(ma)) {
                return s;
            }
        }
        return null;
    }

    @Override
    public void hienThiDanhSach() {
        if (danhsach.isEmpty()) {
            System.out.println("Danh sach sach dang trong.");
        } else {
            System.out.println("--- DANH SACH SACH HIEN TAI ---");
            for (Sach s : danhsach) {
                System.out.println("===================================================");
                System.out.println(s.toString()); // Sử dụng toString() đã override
            }
            System.out.println("===================================================");
        }
    }
}
