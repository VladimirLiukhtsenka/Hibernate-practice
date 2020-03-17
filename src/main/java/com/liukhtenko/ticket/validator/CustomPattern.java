package com.liukhtenko.ticket.validator;

public interface CustomPattern {
    String Login = "^[\\wа-яА-ЯёЁ]{3,20}$";
    String Email = "^[\\w-\\+]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-zA-Z]{2,})$";
    String Password = "^[\\wа-яА-ЯёЁ]{8,40}$";
    String Phone = "^([+])*[\\d]{12,13}$";
}
