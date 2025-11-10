package bt_tuan5;

import java.util.ArrayList;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class QuanLySachImpl implements IQuanLySach {
    
    private ArrayList<Sach> danhsach;

    private static final String FILENAME = "danhsach.dat";

    public QuanLySachImpl() {
 
        danhsach = docDuLieu();
        if (danhsach == null) {

            danhsach = new ArrayList<>();
        }
    }

    @Override
    public void themSach(Sach s) {
        if (timKiem(s.getMaSach()) != null) {
            System.out.println("LOI: Ma sach '" + s.getMaSach() + "' da ton tai. Khong them.");
            return;
        }
        
        danhsach.add(s);
        System.out.println("Da them sach '" + s.getTieuDe() + "' vao danh sach.");
        luuDuLieu();
    }

    @Override
    public void xoaSach(String ma) {
        Sach s = timKiem(ma);
        if (s != null) {
            danhsach.remove(s);
            System.out.println("Da xoa sach co ma: " + ma);
            luuDuLieu();
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
                luuDuLieu();
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
                System.out.println(s.toString()); 
            }
            System.out.println("===================================================");
        }
    }
    
    public void luuDuLieu() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            oos.writeObject(danhsach);
        } catch (IOException e) {
            System.out.println("Loi khi luu du lieu: " + e.getMessage());
        }
    }

    private ArrayList<Sach> docDuLieu() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
            System.out.println("Tai du lieu tu file " + FILENAME + " thanh cong!");
            return (ArrayList<Sach>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("File du lieu cu khong ton tai. Khoi tao moi...");
            return null;
        }
    }
}