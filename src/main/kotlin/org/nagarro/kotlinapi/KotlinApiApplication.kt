/**
 * Copyright 2022 Harsh Pratyush

 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at

 * http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package org.nagarro.kotlinapi

import org.flywaydb.core.Flyway
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean


@SpringBootApplication(exclude = [ SecurityAutoConfiguration::class])
class KotlinApiApplication{
	@Bean
	fun flywayMigrationStrategy(): FlywayMigrationStrategy {
		return FlywayMigrationStrategy { flyway: Flyway ->
			flyway.repair()
			flyway.migrate()
		}
	}
}

fun main(args: Array<String>) {
	runApplication<KotlinApiApplication>(*args)
}


