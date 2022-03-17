package com.anymindgroup.cryptowallet.model

import java.math.BigDecimal
import java.time.ZonedDateTime

class Deposit(
	val walletId: Long,
	val amount: BigDecimal,
	val datetime: ZonedDateTime
)