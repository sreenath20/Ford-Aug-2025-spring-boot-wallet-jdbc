package com.bank.wallet;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class WalletControllerAdvice {

    // handle wallet excetion
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(WalletException.class)
    public String handleWalletException(WalletException e) {
        return e.getMessage();
    }

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(WalletFundsException.class)
//    public String handleFundTransferWalletException(WalletFundsException e) {
//        return e.getMessage();
//    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public String generalExceptionHandler(Exception e) {
        return e.getMessage();
    }

}
