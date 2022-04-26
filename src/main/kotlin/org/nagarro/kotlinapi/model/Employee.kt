package org.nagarro.kotlinapi.model

import com.fasterxml.jackson.annotation.JsonIgnore
import java.text.MessageFormat
import java.time.LocalDate

data class Employee(val employeeId:Int?,val firstName: String,val lastName:String,
                    val middleName:String?,val dob:LocalDate,val contactNumber: String,val email:String){

    companion object{
        const val TABLE_NAME = "employee";
        const val INSERT_QUERY = "INSERT INTO  $TABLE_NAME (first_name, last_name, middle_name, dob, contact_number, email) VALUES({0}, {1}, {2}, {3}, {4}, {5});";
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Employee

        if (firstName != other.firstName) return false
        if (lastName != other.lastName) return false
        if (middleName != other.middleName) return false
        if (dob != other.dob) return false
        if (contactNumber != other.contactNumber) return false
        if (email != other.email) return false

        return true
    }

    override fun hashCode(): Int {
        var result = firstName.hashCode()
        result = 31 * result + lastName.hashCode()
        result = 31 * result + (middleName?.hashCode() ?: 0)
        result = 31 * result + dob.hashCode()
        result = 31 * result + contactNumber.hashCode()
        result = 31 * result + email.hashCode()
        return result
    }

    override fun toString(): String {
        return "Employee(firstName='$firstName', lastName='$lastName', middleName=$middleName, dob=$dob, contactNumber='$contactNumber', email='$email')"
    }

    @JsonIgnore
    fun getInsertQuery():String{
        return  MessageFormat.format(INSERT_QUERY,"'${this.firstName}'","'${this.lastName}'",
            "'${this.middleName}'","'${this.dob}'","'${this.contactNumber}'","'${this.email}'")
    }
}
