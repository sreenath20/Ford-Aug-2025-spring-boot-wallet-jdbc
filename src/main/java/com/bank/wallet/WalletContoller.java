package com.bank.wallet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/wallet") //
public class WalletContoller {


    @Autowired
    private WalletService walletService;
// CRUD on wallet resource

    @PostMapping
    public Wallet registerNewWalletuser(@RequestBody Wallet newWallet) {
        try {
            return this.walletService.registerNewUserWallet(newWallet);
        } catch (WalletException e) {
            throw new RuntimeException(e);
        }
    }


}
