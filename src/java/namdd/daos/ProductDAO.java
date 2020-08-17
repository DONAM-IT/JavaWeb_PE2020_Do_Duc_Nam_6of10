/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package namdd.daos;

import namdd.dtos.ProductDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author namdo
 */
public class ProductDAO {

    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    private void closeConnection() throws SQLException, SQLException {

        if (rs != null) {
            rs.close();
        }
        if (pst != null) {
            pst.close();
        }
        if (conn != null) {
            conn.close();
        }

    }


    public Vector<ProductDTO> loadProduct2() throws SQLException {
        Vector<ProductDTO> vec = new Vector<>();
        try {
            conn = namdd.DBUtils.MyConnection.getMyConnection();
            String sql = "select productID,productName,price,quantity from tblProducts where status='true' and quantity>0";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String productID = rs.getString("productID");
                String productName = rs.getString("productName");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                vec.add(new ProductDTO(productID, productName, price, quantity));
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return vec;
    }

    public ProductDTO loadProduct1(String productID) throws SQLException {
        ProductDTO dto = null;
        try {
            conn = namdd.DBUtils.MyConnection.getMyConnection();
            String sql = "select productName,price from tblProducts where status='true' and quantity>0 and productID=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, productID);
            rs = pst.executeQuery();
            while (rs.next()) {
                String productName = rs.getString("productName");
                double price = rs.getDouble("price");
                dto = new ProductDTO(productID, productName, price);
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return dto;
    }
}
