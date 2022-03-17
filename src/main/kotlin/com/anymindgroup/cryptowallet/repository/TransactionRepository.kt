package com.anymindgroup.cryptowallet.repository

import com.anymindgroup.cryptowallet.model.Transaction
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import java.sql.Timestamp

@Repository
interface TransactionRepository : ReactiveCrudRepository<Transaction, Long> {
	fun findByDatetimeBetween(from: Timestamp, to: Timestamp): Flux<Transaction>
}