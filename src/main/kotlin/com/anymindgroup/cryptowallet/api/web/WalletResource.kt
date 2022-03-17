package com.anymindgroup.cryptowallet.api.web

import com.anymindgroup.cryptowallet.api.web.mapper.WalletMapper
import com.anymindgroup.cryptowallet.api.web.model.DepositRequest
import com.anymindgroup.cryptowallet.api.web.model.TransactionsResponse
import com.anymindgroup.cryptowallet.service.WalletService
import org.slf4j.LoggerFactory
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.ZonedDateTime
import javax.validation.Valid

@RestController
@RequestMapping("/wallet")
@Validated
class WalletController(val walletService: WalletService, val walletMapper: WalletMapper) {
	private val logger = LoggerFactory.getLogger(this::class.java)

	@PostMapping(name = "/deposit", produces = [MediaType.APPLICATION_JSON_VALUE])
	@ResponseBody
	fun deposit(@Valid @RequestBody request: DepositRequest): Mono<ResponseEntity<String>> {
		logger.info("Received request $request")
		return this.walletService.deposit(walletMapper.toDeposit(request))
			.flatMap { Mono.just(ResponseEntity.ok("Created")) }
	}


	@GetMapping(name = "/history", produces = [MediaType.APPLICATION_JSON_VALUE])
	@ResponseBody
	fun history(
		@RequestParam(required = true)
		@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd'T'HH:mm:ssxxx")
		startDatetime: ZonedDateTime,
		@RequestParam(required = true)
		@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd'T'HH:mm:ssxxx")
		endDatetime: ZonedDateTime
	): Flux<ResponseEntity<TransactionsResponse>> {
		logger.info("Received request to get history by startDateTime $startDatetime : endDateTime : $endDatetime")
		return walletService.getTransactions(startDatetime.toLocalDateTime(), endDatetime.toLocalDateTime())
			.flatMap { it -> Mono.just(ResponseEntity.ok(walletMapper.toTransactionsResponse(it))) }
	}
}