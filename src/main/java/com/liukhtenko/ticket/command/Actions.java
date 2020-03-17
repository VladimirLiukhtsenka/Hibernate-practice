package com.liukhtenko.ticket.command;

import javax.servlet.http.HttpServletRequest;

public class Actions {
    private enum Command {
        LOGIN,
        LOGOUT,
        SIGNUP,
        PROFILE,
        ERROR
    }

    public static Action defineFrom(HttpServletRequest request) {
        String nameCommand = request.getParameter("command").toUpperCase();
        Command command;
        try {
            command = Command.valueOf(nameCommand);
        } catch (IllegalArgumentException e) {
            return new CmdError();
        }
        switch (command) {
            case LOGIN:
                return new CmdLogin();
            case LOGOUT:
                return new CmdLogOut();
            case SIGNUP:
                return new CmdSignUp();
            case PROFILE:
                return new CmdProfile();
            default:
                return new CmdError();
        }
    }
}
