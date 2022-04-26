package org.nagarro.kotlinapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [ SecurityAutoConfiguration::class])
class KotlinApiApplication

fun main(args: Array<String>) {
	runApplication<KotlinApiApplication>(*args)
}
