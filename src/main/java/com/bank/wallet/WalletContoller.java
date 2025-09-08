package com.bank.wallet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/v1/wallet") //
public class WalletContoller {


    // @Autowired
    private WalletService walletService;

    @Autowired
    public WalletContoller(WalletService walletService) {
        this.walletService = walletService;
    }
    // CRUD on wallet resource

    @PostMapping
    public Wallet registerNewWalletuser(@RequestBody Wallet newWallet) {
        try {
            return this.walletService.registerNewUserWallet(newWallet);
        } catch (WalletException e) {
            throw new RuntimeException(e);
        }

    }

    @PatchMapping("/{email}/amount/{amount}")
    public Double addFundsToWalletByEmail(@PathVariable("email") String email, @PathVariable Double amount) {
        try {
            return this.walletService.addFundsToWalletByEmailId(email, amount);
        } catch (WalletException e) {
            throw new RuntimeException(e);
        }

    }

    // handler methods
    @PatchMapping("/amount")
    public Double withdrawFundsFromWalletByEmailId(@RequestBody WalletDto walletDto) {
        try {
            return this.walletService.withdrawFromWalletByEmailId(walletDto.getFromEmailId(), walletDto.getAmount());
        } catch (WalletException e) {
            throw new RuntimeException(e);
        }
    }


    @GetMapping("/all")
    public Collection<Wallet> getAllWallets() {
        try {
            return this.walletService.getAllCustomerWallets();
        } catch (WalletException e) {
            throw new RuntimeException(e);
        }
    }


}
