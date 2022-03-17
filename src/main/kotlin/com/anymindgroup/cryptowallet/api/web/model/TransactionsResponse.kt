package com.anymindgroup.cryptowallet.api.web.model

import java.math.BigDecimal
import java.time.ZonedDateTime

class TransactionsResponse(
	val amount: BigDecimal,
	val datetime: ZonedDateTime,
)
