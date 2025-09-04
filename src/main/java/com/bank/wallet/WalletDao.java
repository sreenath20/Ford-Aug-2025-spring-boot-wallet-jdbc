package com.bank.wallet;

import java.util.Collection;

public interface WalletDao {
    // CRUD on wallet
    Wallet saveWallet(Wallet newWallet) throws WalletException;

    Wallet getWalletByEmail(String emailId) throws WalletException;

    Wallet updateWallet(Wallet wallet) throws WalletException;

    Wallet updateWalletBalance(Wallet wallet) throws WalletException;

    Wallet deleteWalletByEmail(String emailId) throws WalletException;

    Collection<Wallet> getAllWallets() throws WalletException;
}
