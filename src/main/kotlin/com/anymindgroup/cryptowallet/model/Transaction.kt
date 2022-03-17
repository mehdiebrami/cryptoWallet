package com.anymindgroup.cryptowallet.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.math.BigDecimal
import java.time.ZonedDateTime

@Table("walletTransactions")
data class Transaction(
	val amount: BigDecimal,
	val datetime: ZonedDateTime
) {
	@Id
	val id: Long? = null

}
