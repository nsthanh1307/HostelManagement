package com.hqt.happyhostel.servlets.RenterServlets;

import com.hqt.happyhostel.dao.*;
import com.hqt.happyhostel.dto.Account;
import com.hqt.happyhostel.dto.Information;
import com.hqt.happyhostel.dto.RoommateInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UpdateRenterRoommateServlet", value = "/UpdateRenterRoommateServlet")
public class UpdateRenterRoommateServlet extends HttpServlet {
    public static final String ERROR = "RoommateUpdateDetail";
    public static final String SUCCESS = "RoommateUpdateDetail";
//    public static final String SUCCESS = "Renter-update-roommate";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = ERROR;
        req.setCharacterEncoding("UTF-8");
        try {
            int roommateID = Integer.parseInt(req.getParameter("roommateID"));
            RoommateInfo roommateInfo = new RoommateInfoDAO().getRoommateByID(roommateID);
            String roommateName = req.getParameter("new-name").equals("") ? roommateInfo.getInformation().getFullname() : req.getParameter("new-name");
            String roommateEmail = req.getParameter("new-email").equals("") ? roommateInfo.getInformation().getEmail() : req.getParameter("new-email");
            String roommateBirthday = req.getParameter("new-birthday").equals("") ? roommateInfo.getInformation().getBirthday() : req.getParameter("new-birthday");
            int roommateGender = Integer.parseInt(req.getParameter("new-gender"));
            String roommatePhone = req.getParameter("new-phone").equals("") ? roommateInfo.getInformation().getPhone() : req.getParameter("new-phone");
            String roommateAddress = req.getParameter("new-address").equals("") ? roommateInfo.getInformation().getAddress() : req.getParameter("new-address");
            String roommateCCCD = req.getParameter("new-cccd").equals("") ? roommateInfo.getInformation().getCccd() : req.getParameter("new-cccd");

            Information information = Information.builder()
                    .fullname(roommateName)
                    .email(roommateEmail)
                    .birthday(roommateBirthday)
                    .sex(roommateGender)
                    .phone(roommatePhone)
                    .address(roommateAddress).cccd(roommateCCCD).build();
            roommateInfo = roommateInfo.builder()
                    .information(information)
                    .build();
            HostelDAO dao = new HostelDAO();
            boolean checkUpdateProfile = new InformationDAO().updateRoommateInfoByID(roommateInfo, roommateID);
            if (checkUpdateProfile) {
                req.setAttribute("SUCCESS", "Đã cập nhật thông tin thành công");
                req.setAttribute("roommateID", roommateID);
                HttpSession session = req.getSession();
                Account account = (Account)session.getAttribute("USER");

                List<RoommateInfo> list = new RoommateInfoDAO().getListRoommatesOfAnAccount(account.getAccId());
                session.setAttribute("listroommateinfor", list);
                url = SUCCESS;
            } else {
                req.setAttribute("ERROR", "Đã xảy ra lỗi! Vui lòng kiểm tra lại");
            }
        } catch (Exception e) {
            log("Error at UpdateHostel: " + e.toString());
        } finally {
            req.getRequestDispatcher(url).forward(req, resp);
        }
    }
}
