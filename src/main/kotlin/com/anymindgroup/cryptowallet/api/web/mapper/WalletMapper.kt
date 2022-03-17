package com.anymindgroup.cryptowallet.api.web.mapper

import com.anymindgroup.cryptowallet.api.web.model.DepositRequest
import com.anymindgroup.cryptowallet.api.web.model.TransactionsResponse
import com.anymindgroup.cryptowallet.model.Deposit
import com.anymindgroup.cryptowallet.model.Transaction
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Named
import java.sql.Timestamp
import java.time.ZoneId
import java.time.ZonedDateTime

@Mapper(componentModel = "spring")
interface WalletMapper {
	fun toDeposit(chargeRequest: DepositRequest): Deposit

	@Mapping(target = "datetime", source = "datetime", qualifiedByName = ["toZonedDateTime"])
	fun toTransactionsResponse(transaction: Transaction): TransactionsResponse

	@Named("toZonedDateTime")
	fun toZonedDateTime(datetime: Timestamp): ZonedDateTime {
		return ZonedDateTime.of(datetime.toLocalDateTime(), ZoneId.of("UTC"))
	}
}