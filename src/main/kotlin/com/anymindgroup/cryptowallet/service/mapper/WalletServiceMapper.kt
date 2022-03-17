package com.anymindgroup.cryptowallet.api.web.mapper

import com.anymindgroup.cryptowallet.model.Deposit
import com.anymindgroup.cryptowallet.model.Transaction
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface WalletServiceMapper {
	@Mapping(target = "type", constant = "DEPOSIT")
	fun toTransaction(deposit: Deposit): Transaction

}