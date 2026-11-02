package koneksi;
public class UTS_Inventori_25110045 {

public static void main(String[] args) {
    if (Koneksi.getKoneksi() != null) {
        System.out.println("Koneksi MySQL berhasil!");
    } else {
        System.out.println("Koneksi MySQL gagal!");
    }
}
        }