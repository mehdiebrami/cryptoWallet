package com.anymindgroup.cryptowallet.api.web.model

import java.math.BigDecimal
import java.time.ZonedDateTime
import javax.validation.constraints.NotEmpty

class DepositRequest(
	@NotEmpty
	val amount: BigDecimal,
	val datetime: ZonedDateTime
)