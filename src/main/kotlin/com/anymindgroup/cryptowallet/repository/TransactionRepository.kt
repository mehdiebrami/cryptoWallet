package com.anymindgroup.cryptowallet.repository

import com.anymindgroup.cryptowallet.model.Transaction
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux
import java.time.ZonedDateTime

interface TransactionRepository : ReactiveCrudRepository<Transaction, Long> {
	fun findByDatetimeBetween(from: ZonedDateTime, to: ZonedDateTime): Flux<Transaction>
}