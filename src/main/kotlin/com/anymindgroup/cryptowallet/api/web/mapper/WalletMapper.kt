package com.anymindgroup.cryptowallet.api.web.mapper

import com.anymindgroup.cryptowallet.api.web.model.DepositRequest
import com.anymindgroup.cryptowallet.api.web.model.TransactionsResponse
import com.anymindgroup.cryptowallet.model.Deposit
import com.anymindgroup.cryptowallet.model.Transaction
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface WalletMapper {
	fun toDeposit(chargeRequest: DepositRequest): Deposit

	fun toTransactionsResponse(transaction: Transaction): TransactionsResponse
}