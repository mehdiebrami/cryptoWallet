package com.anymindgroup.cryptowallet.api.web.mapper

import com.anymindgroup.cryptowallet.model.Deposit
import com.anymindgroup.cryptowallet.model.Transaction
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface WalletServiceMapper {
	fun toTransaction(deposit: Deposit): Transaction
}