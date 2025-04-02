package com.hqt.happyhostel.dao;

import com.hqt.happyhostel.dto.HostelService;
import com.hqt.happyhostel.dto.Hostel;
import com.hqt.happyhostel.utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HostelDAO {

    private static final String INSERT_HOSTEl =
            "INSERT INTO [dbo].[Hostels](owner_account_id, name, address, ward, district, city) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String INSERT_HOSTEL_SERVICE =
            "INSERT INTO HostelService (hostel_id, service_id, service_price, valid_date, status)\n" +
            "VALUES (?, ?, ?, GETDATE(), 1)";
    private static final String UPDATE_HOSTEL =
            "UPDATE Hostels SET name = ?, address = ?, ward = ?, district = ?, city = ? WHERE hostel_id = ?";
    private static final String GET_HOSTEL_BY_ID =
            "SELECT hostel_id, owner_account_id, name, address, ward, district, city FROM [dbo].[Hostels] WHERE hostel_id = ?";
    private static final String GET_HOSTEL_BY_ID_WITH_CONSTRAINT =
            "SELECT hostel_id, owner_account_id, name, address, ward, district, city FROM Hostels WHERE hostel_id = ? AND owner_account_id = ?";
    private static final String GET_HOSTEL_BY_OWNER_ID =
            "SELECT hostel_id, owner_account_id, name, address, ward, district, city FROM [dbo].[Hostels] WHERE owner_account_id = ?";
    private static final String GET_HOSTEL_BY_RENTER_ID =
            "SELECT Hostels.hostel_id, Hostels.owner_account_id, Hostels.name, Hostels.address, Hostels.ward, Hostels.district, Hostels.city\n" +
                    "FROM Hostels INNER JOIN Rooms ON Hostels.hostel_id=Rooms.hostel_id \n" +
                    "INNER JOIN Contracts ON Rooms.room_id = Contracts.room_id\n" +
                    "INNER JOIN Accounts ON Contracts.renter_id = Accounts.account_id\n" +
                    "Where account_id = ?";
    private static final String GET_LIST_HOSTEL = "SELECT hostel_id, owner_account_id, [name], [address], ward, district, city \n" +
            "FROM [dbo].[Hostels] ";
    private static final String GET_HOSTEL_BY_ROOM_ID =
            "SELECT H.hostel_id, owner_account_id, name, address, ward, district, city\n" +
            "FROM Hostels H JOIN Rooms R ON H.hostel_id = R.hostel_id WHERE R.room_id = ?";

    public Hostel getHostelById(int hostelId) throws SQLException {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Hostel hostel = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                pst = cn.prepareStatement(GET_HOSTEL_BY_ID);
                pst.setInt(1, hostelId);
                rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    int hostelOwnerAccountID = rs.getInt("owner_account_id");
                    String name =  rs.getString("name");
                    String address =  rs.getString("address");
                    String ward = rs.getString("ward");
                    String district = rs.getString("district");
                    String city = rs.getString("city");
                    hostel = Hostel.builder()
                            .hostelID(hostelId)
                            .hostelOwnerAccountID(hostelOwnerAccountID)
                            .hostelName(name)
                            .address(address)
                            .ward(ward)
                            .district(district)
                            .city(city)
                            .build();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return hostel;
    }

    public Hostel getHostelByRoomId(int roomId) throws SQLException {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Hostel hostel = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                pst = cn.prepareStatement(GET_HOSTEL_BY_ROOM_ID);
                pst.setInt(1, roomId);
                rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    int hostelOwnerAccountID = rs.getInt("owner_account_id");
                    int hostelId = rs.getInt("hostel_id");
                    String name =  rs.getString("name");
                    String address =  rs.getString("address");
                    String ward = rs.getString("ward");
                    String district = rs.getString("district");
                    String city = rs.getString("city");
                    hostel = Hostel.builder()
                            .hostelID(hostelId)
                            .hostelOwnerAccountID(hostelOwnerAccountID)
                            .hostelName(name)
                            .address(address)
                            .ward(ward)
                            .district(district)
                            .city(city)
                            .build();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return hostel;
    }

    public Hostel getHostelByIdWithConstraint(int hostelId, int ownerAccountID) throws SQLException {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Hostel hostel = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                pst = cn.prepareStatement(GET_HOSTEL_BY_ID_WITH_CONSTRAINT);
                pst.setInt(1, hostelId);
                pst.setInt(2, ownerAccountID);
                rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    int hostelOwnerAccountID = rs.getInt("owner_account_id");
                    String name = rs.getString("name");
                    String address = rs.getString("address");
                    String ward = rs.getString("ward");
                    String district = rs.getString("district");
                    String city = rs.getString("city");
                    hostel = Hostel.builder()
                            .hostelID(hostelId)
                            .hostelOwnerAccountID(hostelOwnerAccountID)
                            .hostelName(name)
                            .address(address)
                            .ward(ward)
                            .district(district)
                            .city(city).build();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return hostel;
    }

    public List<Hostel> getHostelByOwnerId(int hostelOwnerAccountID) throws SQLException {
        List<Hostel> listHostels = new ArrayList<>();
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Hostel hostel = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                pst = cn.prepareStatement(GET_HOSTEL_BY_OWNER_ID);
                pst.setInt(1, hostelOwnerAccountID);
                rs = pst.executeQuery();
                while (rs != null && rs.next()) {
                    int hostelID = rs.getInt("hostel_id");
                    String name = rs.getString("name");
                    String address = rs.getString("address");
                    String ward = rs.getString("ward");
                    String district = rs.getString("district");
                    String city = rs.getString("city");
                    hostel = Hostel.builder()
                            .hostelID(hostelID)
                            .hostelOwnerAccountID(hostelOwnerAccountID)
                            .hostelName(name)
                            .address(address)
                            .ward(ward)
                            .district(district)
                            .city(city).build();
                    listHostels.add(hostel);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return listHostels;
    }

    public int addHostel(Hostel hostel, List<HostelService> hostelServices) throws SQLException {
        int id = -1;
        boolean check;
        Connection cn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            cn = DBUtils.makeConnection();
            //Insert table Hostel
            if (cn != null) {
                cn.setAutoCommit(false);

                ptm = cn.prepareStatement(INSERT_HOSTEl, Statement.RETURN_GENERATED_KEYS);
                ptm.setInt(1, hostel.getHostelOwnerAccountID());
                ptm.setString(2, hostel.getHostelName());
                ptm.setString(3, hostel.getAddress());
                ptm.setString(4, hostel.getWard());
                ptm.setString(5, hostel.getDistrict());
                ptm.setString(6, hostel.getCity());
                check = ptm.executeUpdate() > 0;
                if (!check) {
                    cn.rollback();
                    cn.setAutoCommit(true);
                    return -1;
                }

                rs = ptm.getGeneratedKeys();

                if (rs.next()) {
                    id = rs.getInt(1);
                }

                for (HostelService ser : hostelServices) {
                    ptm = cn.prepareStatement(INSERT_HOSTEL_SERVICE);
                    ptm.setInt(1, id);
                    ptm.setInt(2, ser.getServiceID());
                    ptm.setInt(3, ser.getServicePrice());
                    check = ptm.executeUpdate() > 0;
                    if (!check) {
                        cn.rollback();
                        cn.setAutoCommit(true);
                        return -1;
                    }
                }
                cn.commit();
                cn.setAutoCommit(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return id;
    }

    public boolean updateHostel(Hostel hostel, int hostelID) throws SQLException {
        boolean checkUpdate = false;
        Connection cn = null;
        PreparedStatement ptm = null;
        try {
            cn = DBUtils.makeConnection();

            if (cn != null) {
                cn.setAutoCommit(false);
                ptm = cn.prepareStatement(UPDATE_HOSTEL);
                ptm.setString(1, hostel.getHostelName());
                ptm.setString(2, hostel.getAddress());
                ptm.setString(3, hostel.getWard());
                ptm.setString(4, hostel.getDistrict());
                ptm.setString(5, hostel.getCity());
                ptm.setInt(6, hostelID);
                checkUpdate = ptm.executeUpdate() > 0;

                if (!checkUpdate) {
                    cn.rollback();
                } else {
                    cn.commit();
                }
                cn.setAutoCommit(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return checkUpdate;
    }

    public Hostel getHostelByRenterId(int renterId) throws SQLException {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Hostel hostel = null;
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                pst = cn.prepareStatement(GET_HOSTEL_BY_RENTER_ID);
                pst.setInt(1, renterId);
                rs = pst.executeQuery();
                if (rs != null && rs.next()) {
                    int hostelId = rs.getInt("hostel_id");
                    int hostelOwnerAccountID = rs.getInt("owner_account_id");
                    String name = rs.getString("name");
                    String address = rs.getString("address");
                    String ward = rs.getString("ward");
                    String district = rs.getString("district");
                    String city = rs.getString("city");
                    hostel = new Hostel(hostelId, hostelOwnerAccountID, name, address, ward, district, city);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return hostel;
    }


    public ArrayList<Hostel> getListHostel() throws SQLException {
        Connection cn = null;
        Statement pst = null;
        ResultSet rs = null;
        Hostel hostel = null;
        ArrayList<Hostel> listHostel = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                pst = cn.createStatement();
                rs = pst.executeQuery(GET_LIST_HOSTEL);
                while (rs != null && rs.next()) {
                    int hostelId = rs.getInt("hostel_id");
                    int hostelOwnerAccountID = rs.getInt("owner_account_id");
                    String name = rs.getString("name");
                    String address = rs.getString("address");
                    String ward = rs.getString("ward");
                    String district = rs.getString("district");
                    String city = rs.getString("city");
                    hostel = new Hostel(hostelId, hostelOwnerAccountID, name, address, ward, district, city);
                    listHostel.add(hostel);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return listHostel;
    }
    public ArrayList<Integer> getListRenterIdByHostelId(int hostelId){
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<Integer> accIdList = new ArrayList<>();
        try {
            cn = DBUtils.makeConnection();
            if (cn != null) {
                pst = cn.prepareStatement("SELECT A.[account_id] AS account_id\n" +
                        "FROM [dbo].[Accounts] AS A JOIN [dbo].[Rooms] AS R ON A.[room_id] = R.[room_id]\n" +
                        "WHERE R.[hostel_id] = ? AND A.[status] = 1");
                pst.setInt(1, hostelId);
                rs = pst.executeQuery();
                while (rs != null && rs.next()) {
                    int accId = rs.getInt("account_id");
                    accIdList.add(accId);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (cn != null) {
                    cn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        return accIdList;
    }


}
