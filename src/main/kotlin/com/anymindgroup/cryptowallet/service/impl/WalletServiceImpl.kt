package com.anymindgroup.cryptowallet.service.impl

import com.anymindgroup.cryptowallet.api.web.mapper.WalletServiceMapper
import com.anymindgroup.cryptowallet.model.Deposit
import com.anymindgroup.cryptowallet.model.Transaction
import com.anymindgroup.cryptowallet.repository.TransactionRepository
import com.anymindgroup.cryptowallet.repository.WalletRepository
import com.anymindgroup.cryptowallet.service.WalletService
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.sql.Timestamp
import java.time.LocalDateTime
import javax.transaction.Transactional

@Service
class WalletServiceImpl(
	private val walletRepository: WalletRepository, private val transactionRepository: TransactionRepository,
	private val walletServiceMapper: WalletServiceMapper
) :
	WalletService {

	@Transactional
	override fun deposit(deposit: Deposit): Mono<Transaction> {
		return walletRepository.findById(deposit.walletId).flatMap { wallet ->
			wallet.balance = wallet.balance?.plus(deposit.amount)
			walletRepository.save(wallet)
		}.then(createTransaction(walletServiceMapper.toTransaction(deposit))).log()
	}

	fun createTransaction(transaction: Transaction): Mono<Transaction> {
		return transactionRepository.save(transaction)
	}

	override fun getTransactions(from: LocalDateTime, to: LocalDateTime): Flux<Transaction> {
		return transactionRepository.findByDatetimeBetween(Timestamp.valueOf(from), Timestamp.valueOf(to))
	}
}
