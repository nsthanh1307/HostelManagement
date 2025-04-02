package com.hqt.happyhostel.servlets;

import com.hqt.happyhostel.dao.HostelDAO;
import com.hqt.happyhostel.dto.HandlerStatus;
import com.hqt.happyhostel.dto.Hostel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateHostelServlet", value = "/UpdateHostelServlet")
public class UpdateHostelServlet extends HttpServlet {
    public static final String ERROR = "list-hostels";
    public static final String SUCCESS = "ShowListHostelsServlet";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int hostelID = Integer.parseInt(req.getParameter("hostelID"));
            Hostel hostel = new HostelDAO().getHostelById(hostelID);
            req.setAttribute("HOSTEL", hostel);
            req.getRequestDispatcher("update-hostel-page").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = ERROR;
        req.setCharacterEncoding("UTF-8");
        try {
            int hostelID = Integer.parseInt(req.getParameter("hostelID"));
            String hostelName = req.getParameter("hostel-name");
            String hostelAddress = req.getParameter("hostel-address");
            String hostelWard = req.getParameter("hostel-ward");
            String hostelDistrict = req.getParameter("hostel-district");
            String hostelProvince = req.getParameter("hostel-province");

            HostelDAO dao = new HostelDAO();
            Hostel newHostel = Hostel.builder()
                    .hostelName(hostelName)
                    .address(hostelAddress)
                    .ward(hostelWard)
                    .district(hostelDistrict)
                    .city(hostelProvince).build();
            boolean checkUpdate = dao.updateHostel(newHostel, hostelID);
            if (checkUpdate) {
                url = SUCCESS;
                req.setAttribute("RESPONSE_MSG", HandlerStatus.builder()
                        .status(true)
                        .content("Cập nhật thông tin khu trọ thành công!").build());
            } else {
                req.setAttribute("RESPONSE_MSG", HandlerStatus.builder()
                        .status(false)
                        .content("Đã có lỗi xảy ra! Cập nhật thông tin khu trọ thất bại!").build());
            }
        } catch (Exception e) {
            log("Error at UpdateHostel: " + e.toString());
        } finally {
            req.getRequestDispatcher(url).forward(req, resp);
        }
    }
}
