package com.anymindgroup.cryptowallet.model

import org.springframework.data.annotation.Id
import java.math.BigDecimal

data class Wallet(
	var balance: BigDecimal?
) {
	@Id
	var id: Long? = null
}