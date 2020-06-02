package com.userbanklist.servlets;

import com.userbanklist.User;
import com.userbanklist.service.AccountService;
import com.userbanklist.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RichestUserAndBankAccountAmount extends HttpServlet {

    private UserService userService = UserService.getUserService();
    private AccountService accountService = AccountService.getAccountService();

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        User user = userService.findRichestUser();
        req.setAttribute("nameUser", user.getName() + " " + user.getSureName());
        req.setAttribute("account", accountService.sumAccounts());


        req.getRequestDispatcher("servletAndJSP.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

}
