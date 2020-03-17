package com.liukhtenko.ticket.command;

import com.liukhtenko.ticket.entity.User;
import com.liukhtenko.ticket.exception.DaoException;
import com.liukhtenko.ticket.exception.SiteException;
import com.liukhtenko.ticket.service.UserService;
import com.liukhtenko.ticket.validator.CustomPattern;
import com.liukhtenko.ticket.validator.Form;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdLogin extends Action {
    @Override
    public Action execute(HttpServletRequest request) {
        if (!Form.isPost(request)) {
            return null;
        } else {
            try {
                String mail = Form.getString(request,"textinputMail",CustomPattern.Email);
                String password = Form.getString(request,"passwordinput",CustomPattern.Password);
                UserService userService = new UserService();
                User user = userService.findUserByMailAndPassword(mail, password);
                if(user.getMail() !=null){
                    HttpSession session =request.getSession();
                    session.setAttribute("user",user);
                    return new CmdProfile();
                }else {
                    request.setAttribute(Messages.MESSAGE," Wrong data");
                    return null;
                }
            } catch (SiteException | DaoException e) {
                e.printStackTrace(); // FIXME: 27.01.2020
                request.setAttribute(Messages.MESSAGE_ERROR,e.toString()); // FIXME: 27.01.2020
            }
        }
        return null;
    }
}