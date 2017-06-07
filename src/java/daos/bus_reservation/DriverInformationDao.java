package daos.bus_reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.bus_reservation.DriverInformation;

/**
 *
 * @author Kamal Jabari
 *
 */
public class DriverInformationDao extends BusConnectionDao {

    public ArrayList<DriverInformation> buildDriver() throws Exception {

        ArrayList<DriverInformation> list = new ArrayList<>();
        try {
            Connection conn = getConnection();

            String sql = "SELECT * FROM DRIVERS";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(populateDrivers(rs));
            }

            rs.close();
            ps.close();

            return list;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    private DriverInformation populateDrivers(ResultSet rs) throws SQLException {
        DriverInformation driver = new DriverInformation();

        driver.setDriverID(rs.getInt("DRIVER_ID"));
        driver.setDriverNameEn(rs.getString("DRIVER_NAME_EN"));
        driver.setDriverNameAr(rs.getString("DRIVER_NAME_AR"));
        driver.setPhone(rs.getInt("PHONE_NUMBER"));
        driver.setDriverAddressEn(rs.getString("DRIVER_ADDRESS_EN"));
        driver.setDriverAddressAr(rs.getString("DRIVER_ADDRESS_AR"));
        driver.setDriverLicenseNo(rs.getInt("DRIVER_LICENSE_NO"));

        return driver;
    }

    public void insertDriver(DriverInformation driver) throws Exception {
        try {
            Connection conn = getConnection();

            String sql = "INSERT INTO DRIVERS "
                    + "( DRIVER_ID,"
                    + " DRIVER_NAME_EN,"
                    + " DRIVER_NAME_AR,"
                    + " PHONE_NUMBER, "
                    + " DRIVER_ADDRESS_EN,"
                    + " DRIVER_ADDRESS_AR,"
                    + " DRIVER_LICENSE_NO)"
                    + " VALUES ((select max(Driver_ID) from DRIVERS)+1,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, driver.getDriverNameEn());
            ps.setString(2, driver.getDriverNameAr());
            ps.setInt(3, driver.getPhone());
            ps.setString(4, driver.getDriverAddressEn());
            ps.setString(5, driver.getDriverAddressAr());
            ps.setInt(6, driver.getDriverLicenseNo());

            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public void updateDriver(DriverInformation driver) throws Exception {
        try {
            Connection conn = getConnection();

            String sql = "UPDATE DRIVERS SET "
                    + " DRIVER_NAME_EN,"
                    + " DRIVER_NAME_AR,"
                    + " PHONE_NUMBER, "
                    + " DRIVER_ADDRESS_EN,"
                    + " DRIVER_ADDRESS_AR,"
                    + " DRIVER_LICENSE_NO,"
                    + " WHERE DRIVER_ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, driver.getDriverNameEn());
            ps.setString(2, driver.getDriverNameAr());
            ps.setInt(3, driver.getPhone());
            ps.setString(4, driver.getDriverAddressEn());
            ps.setString(5, driver.getDriverAddressAr());
            ps.setInt(6, driver.getDriverLicenseNo());
            ps.setInt(7, driver.getDriverID());

            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public void deleteDriver(int driver_id) throws Exception {
        Connection conn = getConnection();

        try {
            String sql = "DELETE FROM DRIVERS WHERE DRIVER_ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, driver_id);

            ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            DriverInformationDao dao = new DriverInformationDao();
        } catch (Exception ex) {
            Logger.getLogger(DriverInformationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
