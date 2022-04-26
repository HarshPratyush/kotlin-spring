package org.nagarro.kotlinapi.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.server.ResponseStatusException

@ResponseStatus(value = HttpStatus.NOT_FOUND)
class DataNotFound(status:HttpStatus=HttpStatus.NOT_FOUND, message: String) : ResponseStatusException(status,message) {
    override fun toString(): String {
        return " {\"status\" : $status , \"message\":$message}";
    }
}