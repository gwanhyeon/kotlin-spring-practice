package com.kgh.kotlinspringpractice.controller.put

import com.kgh.kotlinspringpractice.model.Result
import com.kgh.kotlinspringpractice.model.UserRequest
import com.kgh.kotlinspringpractice.model.UserResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class putApiController {
    @PutMapping("v1")
    fun putMapping(): String{
        return "put Mapping request"
    }
    @RequestMapping(method = [RequestMethod.PUT], path=["/v2"])
    fun function2(): String {
        return "request mapping put method"
    }
    @PutMapping(path=["v3"])
    fun putMappingObject(@RequestBody userRequest: UserRequest): UserResponse {

        // Reponse
        return UserResponse().apply {
            // result
            this.result = Result().apply {
                this.resultCode = "201"
                this.resultMessage = "success"
            }
        }.apply {
            // description
            this.description = "message"
        }.apply {
            // user mutable list
            var userList = mutableListOf<UserRequest>()
            userList.add(userRequest)
            userList.add(UserRequest().apply {
                this.name = "gwanhyeon"
                this.age = 29
                this.address = "address1"
                this.email = "@gmail.com"
                this.phoneNumber = "010-0000-0000"
            })
            userList.add(UserRequest().apply {
                this.name = "gwanhyeon"
                this.age = 29
                this.address = "address2"
                this.email = "@gmail.com"
                this.phoneNumber = "010-0000-0000"
            })
            this.userRequest = userList;
        }
    }


}