package com.anymindgroup.cryptowallet

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CryptoWalletApplication

fun main(args: Array<String>) {
	runApplication<CryptoWalletApplication>(*args)
}
