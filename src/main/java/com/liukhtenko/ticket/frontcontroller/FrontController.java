package com.liukhtenko.ticket.frontcontroller;

import com.liukhtenko.ticket.command.Action;
import com.liukhtenko.ticket.command.Actions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FrontController", urlPatterns = {"/do"})
public class FrontController extends HttpServlet {
    static Logger logger = LogManager.getLogger(FrontController.class);

    private RequestDispatcher dispatcher(Action action) {
        return getServletContext().getRequestDispatcher(action.getJsp());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Action action = Actions.defineFrom(req);
         action.execute(req);// FIXME: 25.01.2020
        dispatcher(action).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Action action = Actions.defineFrom(req);
        Action nextAction = action.execute(req);
        if (nextAction != null) {
            resp.sendRedirect("do?command=" + nextAction);
        } else {
            dispatcher(action).forward(req, resp);
        }
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ServletContext servletContext = getServletContext();
//        RequestDispatcher disp = servletContext.getRequestDispatcher("/index.jsp");
//        disp.forward(req,resp);

    }
}
