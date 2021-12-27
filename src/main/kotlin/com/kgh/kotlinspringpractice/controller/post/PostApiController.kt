package com.kgh.kotlinspringpractice.controller.post

import com.kgh.kotlinspringpractice.model.UserRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class PostApiController {

    // post mapping request
    @PostMapping("/v1")
    fun postMapping(): String{
        return "post mapping v1";
    }

    @RequestMapping(method=[RequestMethod.POST], path=["/v2"])
    fun requestMapping(): String{
        return "request mapping"
    }

    @PostMapping("/v3")
    fun postMappingObject(@RequestBody userRequest: UserRequest): UserRequest {
        println(userRequest)
        return userRequest;
    }
}
