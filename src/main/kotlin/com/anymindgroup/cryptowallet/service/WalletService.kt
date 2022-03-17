package com.anymindgroup.cryptowallet.service

import com.anymindgroup.cryptowallet.model.Deposit
import com.anymindgroup.cryptowallet.model.Transaction
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.LocalDateTime

interface WalletService {
	fun deposit(deposit: Deposit): Mono<Transaction>
	fun getTransactions(from: LocalDateTime, to: LocalDateTime): Flux<Transaction>
}