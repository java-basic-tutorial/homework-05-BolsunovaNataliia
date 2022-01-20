package com.softserveinc.task01;

public class NotMoneyEnoughException extends RuntimeException{

//    protected long amount;

    public NotMoneyEnoughException(String message) {
        super(message);
    }

}
