package com.anymindgroup.cryptowallet.model

import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Wallet(
	var balance: BigDecimal?
) {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	var id: Long? = null
}