/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;


import Models.NhanVien;
import java.util.ArrayList;
import utils.DbConnection;
import java.sql.*;


/**
 *
 * @author HP
 */
public class NhanVienRepository {
    private Connection conn;
    public NhanVienRepository(){
        conn = DbConnection.getConnection();
    }
    
    public ArrayList<NhanVien> search(){
        String SQL = "SELECT * FROM SinhVien";
        
        ArrayList<NhanVien> ds = new ArrayList<>();
        
        try {
            PreparedStatement ps = this.conn.prepareStatement(SQL);
            ps.execute();
            
            ResultSet rs = ps.getResultSet();
            
            while(rs.next()){
                String maNhanVien = rs.getString("maNhanVien");
                String ten = rs.getString("ten");
                int tuoi = rs.getInt("tuoi");
                String diaChi = rs.getString("diaChi");
                ds.add(new NhanVien(maNhanVien, ten, tuoi, diaChi));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return ds;
        
    }
}
