package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Barang;

public class BarangDAO {
    private Connection conn;

    public BarangDAO() {
        this.conn = Koneksi.getKoneksi();
    }

    // Tugas 5: Simpan Data menggunakan PreparedStatement
    public boolean simpan(Barang b) throws SQLException {
        String sql = "INSERT INTO barang (kode_barang, nama_barang, kategori, stok) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, b.getKodeBarang());
            ps.setString(2, b.getNamaBarang());
            ps.setString(3, b.getKategori());
            ps.setInt(4, b.getStok());
            return ps.executeUpdate() > 0;
        }
    }

    // Tugas 6: Mengambil data untuk JTable
    public List<Barang> tampilkanSemua() throws SQLException {
        List<Barang> list = new ArrayList<>();
        String sql = "SELECT * FROM barang";
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Barang b = new Barang(
                    rs.getString("kode_barang"),
                    rs.getString("nama_barang"),
                    rs.getString("kategori"),
                    rs.getInt("stok")
                );
                list.add(b);
            }
        }
        return list;
    }

    // Tugas 7: Mengubah Data berdasarkan Kode Barang
    public boolean ubah(Barang b) throws SQLException {
        String sql = "UPDATE barang SET nama_barang=?, kategori=?, stok=? WHERE kode_barang=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, b.getNamaBarang());
            ps.setString(2, b.getKategori());
            ps.setInt(3, b.getStok());
            ps.setString(4, b.getKodeBarang());
            return ps.executeUpdate() > 0;
        }
    }

    // Tugas 7: Menghapus Data berdasarkan Kode Barang
    public boolean hapus(String kodeBarang) throws SQLException {
        String sql = "DELETE FROM barang WHERE kode_barang=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, kodeBarang);
            return ps.executeUpdate() > 0;
        }
    }
}
