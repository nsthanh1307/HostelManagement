package com.hqt.happyhostel.dao;

import com.hqt.happyhostel.dto.HostelService;
import com.hqt.happyhostel.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HostelServiceDAO {

    private static final String GET_CURRENT_LIST_SERVICES_OF_A_HOSTEL =
            "SELECT hostel_service_id, hostel_id, service_id, service_price, valid_date, status \n" +
            "FROM HostelService WHERE status = 1 AND hostel_id = ?";

    private static final String INSERT_LIST_SERVICES_INTO_HOSTEL =
            "INSERT INTO HostelService (hostel_id, service_id, service_price, valid_date, status)\n" +
                    "VALUES (?, ?, ?, GETDATE(), 1)";

    private static final String UPDATE_STATUS_HOSTEL_SERVICES =
            "UPDATE HostelService SET status = ?\n" +
            "WHERE hostel_service_id = ?";

    public boolean updateStatusOfListHostelServices(int status, List<HostelService> hostelServiceList) throws SQLException {
        Connection conn = null;
        PreparedStatement psm = null;

        boolean check = false;
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                conn.setAutoCommit(false);

                boolean checkUpdate;
                for (HostelService item : hostelServiceList) {
                    psm = conn.prepareStatement(UPDATE_STATUS_HOSTEL_SERVICES);
                    psm.setInt(1, status);
                    psm.setInt(2, item.getHostelServiceId());
                    checkUpdate = psm.executeUpdate() > 0;

                    if (!checkUpdate) {
                        conn.rollback();
                        conn.setAutoCommit(true);
                        return false;
                    }
                }
                conn.commit();
                conn.setAutoCommit(true);
                check = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (psm != null) psm.close();
            if (conn != null) conn.close();
        }
        return check;
    }

    public boolean insertListServicesIntoHostel(List<HostelService> hostelServiceList, int hostelId) throws SQLException {
        Connection conn = null;
        PreparedStatement psm = null;

        boolean check = false;
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                conn.setAutoCommit(false);

                boolean checkInsert;
                for (HostelService item : hostelServiceList) {
                    psm = conn.prepareStatement(INSERT_LIST_SERVICES_INTO_HOSTEL);
                    psm.setInt(1, hostelId);
                    psm.setInt(2, item.getServiceID());
                    psm.setDouble(3, item.getServicePrice());
                    checkInsert = psm.executeUpdate() > 0;

                    if (checkInsert) {
                        check =  true;
                    } else {
                        conn.rollback();
                        conn.setAutoCommit(true);
                        return false;
                    }
                }
                conn.commit();
                conn.setAutoCommit(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (psm != null) psm.close();
            if (conn != null) conn.close();
        }
        return check;
    }

    public List<HostelService> getCurrentListServicesOfAHostel (int hostelId) throws SQLException {
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        List<HostelService> list = new ArrayList<>();
        try {
            conn = DBUtils.makeConnection();
            if (conn != null) {
                psm = conn.prepareStatement(GET_CURRENT_LIST_SERVICES_OF_A_HOSTEL);
                psm.setInt(1, hostelId);
                rs = psm.executeQuery();
                while (rs != null && rs.next()) {
                    list.add(HostelService.builder()
                            .hostelServiceId(rs.getInt("hostel_service_id"))
                            .hostelID(rs.getInt("hostel_id"))
                            .serviceID(rs.getInt("service_id"))
                            .servicePrice(rs.getInt("service_price"))
                            .validDate(rs.getString("valid_date"))
                            .status(rs.getInt("status")).build());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (psm != null) {
                psm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

}
