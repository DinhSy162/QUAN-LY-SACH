import java.util.ArrayList;

public class QuanLySach {
    private ArrayList<Sach> danhSachSach = new ArrayList<>();

    public void themSach(Sach s) {
        danhSachSach.add(s);
    }

    public void xoaSach(String maSach) {
        danhSachSach.removeIf(s -> s.getMaSach().equalsIgnoreCase(maSach));
    }

    public void capNhatSoLuong(String maSach, int soLuongMoi) {
        for (Sach s : danhSachSach) {
            if (s.getMaSach().equalsIgnoreCase(maSach)) {
                s.setSoLuong(soLuongMoi);
                break;
            }
        }
    }

    public Sach timKiemTheoMa(String maSach) {
        for (Sach s : danhSachSach) {
            if (s.getMaSach().equalsIgnoreCase(maSach)) {
                return s;
            }
        }
        return null;
    }

    public void hienThiTatCa() {
        if (danhSachSach.isEmpty()) {
            System.out.println("Danh sach sach trong!");
        } else {
            System.out.println("----- DANH SACH SACH -----");
            for (Sach s : danhSachSach) {
                System.out.println(s.toString());
            }
            System.out.println("--------------------------");
        }
    }
}
