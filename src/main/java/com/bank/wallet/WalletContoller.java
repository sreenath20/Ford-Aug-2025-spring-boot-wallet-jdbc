package com.bank.wallet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    //@ResponseStatus(HttpStatus.CREATED)
    // ResponseEntity
    public ResponseEntity<Wallet> registerNewWalletuser(@RequestBody Wallet newWallet) {
        try {
            Wallet wallet = this.walletService.registerNewUserWallet(newWallet);
            return new ResponseEntity<>(wallet, HttpStatus.CREATED);

        } catch (WalletException e) {
            throw new RuntimeException(e);
        }
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
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
    public Double withdrawFundsFromWalletByEmailId(@RequestBody WalletDto walletDto) throws WalletException {
        try {
            return this.walletService.withdrawFromWalletByEmailId(walletDto.getFromEmailId(), walletDto.getAmount());
        } catch (WalletException e) {
            // throw new RuntimeException(e);
            throw e;
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

    // @RequestParm
    // 1. we can default values
    // 2. we can make parameters optional
    // demo
    // localhost:8080/api/v1/wallet?name=ford&amount=555

    @GetMapping
    public String getInfo(@RequestParam(required = false, name = "name") String userName,
                          @RequestParam(required = false) String amount) {
        return "Request param name" + userName + " amount :" + amount;
    }


}
