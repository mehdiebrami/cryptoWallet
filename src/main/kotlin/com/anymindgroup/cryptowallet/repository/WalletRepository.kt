package com.anymindgroup.cryptowallet.repository

import com.anymindgroup.cryptowallet.model.Wallet
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface WalletRepository : ReactiveCrudRepository<Wallet, Long> {
}