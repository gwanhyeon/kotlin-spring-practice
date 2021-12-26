package com.kgh.kotlinspringpractice.model

data class UserRequest (
    var name:String?=null,
    var age:Int?=null,
    var email:String?=null,
    var address:String?=null,
    // You can't use a hyphen
    // not able to var phone-number:String?=null
)