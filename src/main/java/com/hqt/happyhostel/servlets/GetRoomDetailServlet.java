package com.hqt.happyhostel.servlets;

import com.hqt.happyhostel.dao.*;
import com.hqt.happyhostel.dao.AccountDAO;
import com.hqt.happyhostel.dao.ConsumeDAO;
import com.hqt.happyhostel.dao.InfrastructureDAO;
import com.hqt.happyhostel.dao.RoomDAO;
import com.hqt.happyhostel.dto.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GetRoomDetailServlet", value = "/GetRoomDetailServlet")
public class GetRoomDetailServlet extends HttpServlet {
    private final String ERROR = "error-page";

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "RoomDetailPage";

        try {
            HttpSession session = request.getSession();

            int accID = ((Account) session.getAttribute("USER")).getAccId();

            int hostelID = (request.getParameter("hostelID") != null ) ? Integer.parseInt(request.getParameter("hostelID")) : ((Hostel) session.getAttribute("hostel")).getHostelID();

            int roomId = (request.getParameter("roomID") != null ) ? Integer.parseInt(request.getParameter("roomID")) : (int) session.getAttribute("current_room_id");

            List<Infrastructures> infrastructures = new ArrayList<>();
            // Check xem roomID có thuộc ownerID không
            if (new HostelOwnerDAO().checkOwnerRoom(accID, roomId)) {
                RoomDAO roomDAO = new RoomDAO();
                ConsumeDAO consumeDAO = new ConsumeDAO();
                AccountDAO accountDAO = new AccountDAO();
                InfrastructureDAO infrastructureDAO = new InfrastructureDAO();

                Room room = roomDAO.getRoomInformationByRoomId(roomId, hostelID, accID);
                if(room != null){
                    session.setAttribute("room", room);
                    session.setAttribute("current_room_id", room.getRoomId());

                    Hostel hostel = new HostelDAO().getHostelById(hostelID);
                    session.setAttribute("hostel", hostel);

                    Contract contract = new ContractDAO().getContract(roomId);
                    request.setAttribute("contractRoom", contract);

                    List<Consume> consumeList = consumeDAO.getConsumeHistory(roomId);
                    request.setAttribute("consumeList", consumeList);

                    Consume consumeNumber = consumeDAO.getNearestConsume(roomId);
                    request.setAttribute("consumeNumber", consumeNumber);

                    List<InfrastructureItem> infrastructureItemList = infrastructureDAO.getAllInfrastructure();
                    request.setAttribute("infrastructureList", infrastructureItemList);

                    Bill bill = new BillDAO().getLastBill(roomId);
                    request.setAttribute("billRoom", bill);

                    List<Consume> consumeThisMonth = new ConsumeDAO().getConsumeThisMonth(roomId);
                    request.setAttribute("consumeListThisMonth", consumeThisMonth);

                    if (contract != null) {
                        Account renterAccount = accountDAO.getAccountById(contract.getRenterId());
                        request.setAttribute("renterAccount", renterAccount);

                        List<RoommateInfo> listRoommatesInfo = new RoommateInfoDAO().getListRoommatesOfAnAccount(contract.getRenterId());
                        request.setAttribute("listRoommatesInfo", listRoommatesInfo);
                    }

                    List<Payment> payments = new PaymentDAO().getPaymentList();
                    request.setAttribute("paymentList", payments);

                    if (bill != null) {
                        int billID = bill.getBillID();
                        BillDetail billDetail = new BillDAO().getBillDetail(billID);
                        int consumeIDStart = billDetail.getConsumeIDStart();
                        int consumeIDEnd = billDetail.getConsumeIDEnd();

                        if (bill.getStatus() == 0 || bill.getPayment() != null) {
                            String paymentName = new BillDAO().getPaymentName(bill.getPayment().getPaymentID());
                            request.setAttribute("paymentName", paymentName);
                        }

                        Consume consumeStart = new ConsumeDAO().getConsumeByID(consumeIDStart);
                        Consume consumeEnd = new ConsumeDAO().getConsumeByID(consumeIDEnd);

                        int numberConsumeElectric = consumeEnd.getNumberElectric() - consumeStart.getNumberElectric();
                        int numberConsumeWater = consumeEnd.getNumberWater() - consumeStart.getNumberWater();

                        request.setAttribute("consumeStart", consumeStart);
                        request.setAttribute("consumeEnd", consumeEnd);

                        int billDetailID = billDetail.getBillDetailID();
                        List<ServiceInfo> serviceInfos = new ServiceInfoDAO().getServiceOfBill(billDetailID, hostelID);
                        request.setAttribute("serviceInfo", serviceInfos);

                        int accountHOID = billDetail.getAccountHostelOwnerID();
                        int accountRenterID = billDetail.getAccountRenterID();
                        AccountInfo accountHOInfo = accountDAO.getAccountInformationById(accountHOID);
                        AccountInfo accountRenterInfo = accountDAO.getAccountInformationById(accountRenterID);

                        request.setAttribute("billMakerFullName", accountHOInfo.getInformation().getFullname());
                        request.setAttribute("billPaymenterFullName", accountRenterInfo.getInformation().getFullname());
                    }
                    infrastructures = infrastructureDAO.getRoomInfrastructures(roomId);
                    request.setAttribute("infrastructures", infrastructures);
                }else {
                    url = ERROR;
                }
            }else {
                url = ERROR;
            }

            session.setAttribute("CURRENT_PAGE", "room");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ERROR.equalsIgnoreCase(url))
                response.sendRedirect(url);
            else
                request.getRequestDispatcher(url).forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "RoomDetailPage";

        try {
            HttpSession session = request.getSession();
            int hostelID = (request.getParameter("hostelID") != null ) ? Integer.parseInt(request.getParameter("hostelID")) : ((Hostel) session.getAttribute("hostel")).getHostelID();

            int accID = ((Account) session.getAttribute("USER")).getAccId();

            int roomId = ((Room) session.getAttribute("room")).getRoomId();

            RoomDAO roomDAO = new RoomDAO();
            ConsumeDAO consumeDAO = new ConsumeDAO();
            AccountDAO accountDAO = new AccountDAO();
            InfrastructureDAO infrastructureDAO = new InfrastructureDAO();

            Room room = roomDAO.getRoomInformationByRoomId(roomId, hostelID, accID);
            session.setAttribute("room", room);

            Hostel hostel = new HostelDAO().getHostelById(hostelID);
            session.setAttribute("hostel", hostel);

            Contract contract = new ContractDAO().getContract(roomId);
            request.setAttribute("contractRoom", contract);

            List<Consume> consumeList = consumeDAO.getConsumeHistory(roomId);
            request.setAttribute("consumeList", consumeList);

            Consume consumeNumber = consumeDAO.getNearestConsume(roomId);
            request.setAttribute("consumeNumber", consumeNumber);

            List<InfrastructureItem> infrastructureItemList = infrastructureDAO.getAllInfrastructure();
            request.setAttribute("infrastructureList", infrastructureItemList);

            Bill bill = new BillDAO().getLastBill(roomId);
            request.setAttribute("billRoom", bill);

            List<Payment> payments = new PaymentDAO().getPaymentList();
            request.setAttribute("paymentList", payments);

            List<Consume> consumeThisMonth = new ConsumeDAO().getConsumeThisMonth(roomId);
            request.setAttribute("consumeListThisMonth", consumeThisMonth);

            if (contract != null) {
                Account renterAccount = accountDAO.getAccountById(contract.getRenterId());

                request.setAttribute("renterAccount", renterAccount);

                List<RoommateInfo> listRoommatesInfo = new RoommateInfoDAO().getListRoommatesOfAnAccount(contract.getRenterId());
                request.setAttribute("listRoommatesInfo", listRoommatesInfo);
            }

            if (bill != null) {
                int billID = bill.getBillID();
                BillDetail billDetail = new BillDAO().getBillDetail(billID);
                int consumeIDStart = billDetail.getConsumeIDStart();
                int consumeIDEnd = billDetail.getConsumeIDEnd();

                if (bill.getStatus() == 0 || bill.getPayment() != null) {
                    String paymentName = new BillDAO().getPaymentName(bill.getPayment().getPaymentID());
                    request.setAttribute("paymentName", paymentName);
                }

                Consume consumeStart = new ConsumeDAO().getConsumeByID(consumeIDStart);
                Consume consumeEnd = new ConsumeDAO().getConsumeByID(consumeIDEnd);

                request.setAttribute("consumeStart", consumeStart);
                request.setAttribute("consumeEnd", consumeEnd);

                int billDetailID = billDetail.getBillDetailID();
                List<ServiceInfo> serviceInfos = new ServiceInfoDAO().getServiceOfBill(billDetailID, hostelID);
                request.setAttribute("serviceInfo", serviceInfos);

                int accountHOID = billDetail.getAccountHostelOwnerID();
                int accountRenterID = billDetail.getAccountRenterID();
                AccountInfo accountHOInfo = accountDAO.getAccountInformationById(accountHOID);
                AccountInfo accountRenterInfo = accountDAO.getAccountInformationById(accountRenterID);

                request.setAttribute("billMakerFullName", accountHOInfo.getInformation().getFullname());
                request.setAttribute("billPaymenterFullName", accountRenterInfo.getInformation().getFullname());
            }

            List<Infrastructures> infrastructures = infrastructureDAO.getRoomInfrastructures(roomId);
            request.setAttribute("infrastructures", infrastructures);
            session.setAttribute("CURRENT_PAGE", "room");
            request.setAttribute("CREATE_BILL_MSG", request.getAttribute("CREATE_BILL_MSG"));
            request.setAttribute("RENTER_ID", request.getAttribute("RENTER_ID"));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }
}
