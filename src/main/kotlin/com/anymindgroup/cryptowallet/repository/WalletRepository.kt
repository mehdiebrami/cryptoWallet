package com.anymindgroup.cryptowallet.repository

import com.anymindgroup.cryptowallet.model.Wallet
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface WalletRepository : ReactiveCrudRepository<Wallet, Long> {
}