package com.hqt.happyhostel.servlets.NotificationServlets;

import com.google.gson.Gson;
import com.hqt.happyhostel.dao.HostelDAO;
import com.hqt.happyhostel.dao.NotificationDAO;
import com.hqt.happyhostel.dto.Account;
import com.hqt.happyhostel.dto.Hostel;
import com.hqt.happyhostel.dto.Notification;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "GetNotificationListServlet", value = "/GetNotificationListServlet")
public class GetNotificationListServlet extends HttpServlet {
    private final String SUCCESS = "notification-page";
    private final String FAIL = "notification-page";
    private final String ERROR = "error-page";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = ERROR;
        try {
            HttpSession session = request.getSession(false);
            if(session != null){
                Account owner = (Account) session.getAttribute("USER");
                if (owner != null){
                    url = FAIL;
                    int ownerId = owner.getAccId();
                    List<Notification> notificationList = new NotificationDAO().getNotificationByOwnerId(ownerId);
                    List<Hostel> hostelList = new HostelDAO().getHostelByOwnerId(ownerId);
                    request.setAttribute("NOTIFICATION_LIST", notificationList);
                    session.setAttribute("HOSTEL_LIST", hostelList);
                    url = SUCCESS;
                    session.setAttribute("CURRENT_PAGE", "notification");
                }
            }
        }catch (Exception e){
            log("Error at GetNotificationListServlet: " + e);
        }finally {
            if (ERROR.equalsIgnoreCase(url)) response.sendRedirect(url);
            else request.getRequestDispatcher(url).forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        try {
            HttpSession session = request.getSession();
            String hostelIdStr = request.getParameter("hostelID");
            Account owner = (Account) session.getAttribute("USER");
            Map<Integer, Hostel> hostelOfNotification = new HashMap<>();
            HostelDAO hostelDAO = new HostelDAO();
            int ownerId = owner.getAccId();
            List<Notification> notificationList;

            if (hostelIdStr.equals("")) {
                notificationList = new NotificationDAO().getNotificationByOwnerId(ownerId);
            } else {
                int hostelId = Integer.parseInt(hostelIdStr);
                notificationList = new NotificationDAO().getNotificationByOwnerIdAndHostelId(ownerId, hostelId);
            }

            for (Notification item : notificationList) {
                hostelOfNotification.put(item.getNotification_id(), hostelDAO.getHostelById(item.getHostel_id()));
            }

            List<Object> list = new ArrayList<>();
            list.add(notificationList);
            list.add(hostelOfNotification);
            Gson gson = new Gson();
            String json = gson.toJson(list);
            response.getWriter().println(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
