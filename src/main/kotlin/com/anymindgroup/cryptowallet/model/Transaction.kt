package com.anymindgroup.cryptowallet.model

import java.math.BigDecimal
import java.sql.Timestamp
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "walletTransactions")
class Transaction(
	val amount: BigDecimal,
	val datetime: Timestamp,
	val type: TransactionType
) {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	val id: Long? = null

}

enum class TransactionType(i: Int) {
	DEPOSIT(0)
}