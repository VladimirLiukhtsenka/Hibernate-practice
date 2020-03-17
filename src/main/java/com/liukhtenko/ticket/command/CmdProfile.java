package com.liukhtenko.ticket.command;

import com.liukhtenko.ticket.validator.CustomPattern;
import com.liukhtenko.ticket.validator.Form;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CmdProfile extends Action {
    @Override
    public Action execute(HttpServletRequest request) {
        if (Form.isPost(request) && request.getParameter("logout") != null) {
            HttpSession session = request.getSession();
            session.invalidate();
            return new CmdLogin();
        }
        return null;
    }
}
