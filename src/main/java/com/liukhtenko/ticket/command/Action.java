package com.liukhtenko.ticket.command;

import javax.servlet.http.HttpServletRequest;

public abstract class Action {
    public abstract Action execute(HttpServletRequest request);

    public String getJsp() {
        return "/" + this.toString() + ".jsp";
    }

    @Override
    public String toString() {
        String nameCommand = this
                .getClass()
                .getSimpleName()
                .replace("Cmd", "")
                .toLowerCase();
        return nameCommand;
    }
}
