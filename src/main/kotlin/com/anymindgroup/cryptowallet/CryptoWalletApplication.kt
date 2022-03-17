package com.anymindgroup.cryptowallet

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@EnableR2dbcRepositories
@SpringBootApplication
class CryptoWalletApplication

fun main(args: Array<String>) {
	runApplication<CryptoWalletApplication>(*args)
}
