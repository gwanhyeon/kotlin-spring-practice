package com.kgh.kotlinspringpractice.controller.page

import com.kgh.kotlinspringpractice.model.UserRequest
import com.kgh.kotlinspringpractice.model.UserResponse
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

// static 하위 페이지 - 특정한 페이지를 내려줄때 사용 @Controller
@Controller
// @RestController
class PageController {

    @GetMapping("/main")
    fun main(): String{
        println("init main")
        return "main.html";
    }

    // @ResponseBody response body 를 통하여 json string 처리를 할 수 있다.
    @ResponseBody
    @GetMapping("/test")
    fun response() : String {
        return "main.html"
    }

    @ResponseBody
    @GetMapping("/test2")
    fun response2() : UserRequest {
        return UserRequest().apply {
            this.name = "kgh"
        }
    }

}