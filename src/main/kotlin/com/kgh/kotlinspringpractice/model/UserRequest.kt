package com.kgh.kotlinspringpractice.model

import java.lang.Exception
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.validation.constraints.*

// @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class UserRequest (
    @field:NotEmpty
    @field:Size(min = 2, max = 8, message = "")

    var name:String?=null,

    @field:PositiveOrZero
    var age:Int?=null,

    @field:Email
    var email:String?=null,

    @field:NotBlank
    var address:String?=null,

    // @JsonProperty("phone_number")
    @field:Pattern(regexp = "^\\d{2,3}--\\d{3,4}-\\d{4}\$")
    var phoneNumber:String?=null,

    var createdAt:String?=null // yyyy-MM-dd HH:mm:ss


    // You can't use a hyphen
    // not able to var phone-number:String?=null
){
    @AssertTrue(message = "this is pattern yyyy-mm-dd")
    private fun isValidCreateAt():Boolean{
        return try {
            LocalDateTime.parse(this.createdAt, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            true;
        }catch (e:Exception){
            false;
        }
    }
}