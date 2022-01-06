package com.kgh.kotlinspringpractice.controller.get

import com.kgh.kotlinspringpractice.model.UserRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class GetApiController {

    // basic
    @GetMapping(path=["/orders", "/orderItems"])
    fun getOrderList(): String {
        return "this is the basic request"
    }

    // base url + request url
    @RequestMapping(method=[RequestMethod.GET], path = ["/request-mapping"])
    fun requestMapping(): String{
        return "this is the request mapping"
    }

    // path variable
    @GetMapping("/v1/{name}/{age}")
    fun pathVariable(@PathVariable name: String, @PathVariable age: Int): String{
        println("name => " + name + " age => "+ age);
        return name + " " + age;
    }
    // path variable multi
    @GetMapping("/v2/{name}/{age}")
    fun pathVariable2(@PathVariable(value="name") _name: String, @PathVariable(name="age") age: Int): String{
        val name = "kotlin"
        println("name => ${name} age => ${age}");
        return _name + " " + age;
    }
    // request params
    @GetMapping("/v3")
    fun queryParam(
        @RequestParam(value="name") name:String,
        @RequestParam(value="age") age:Int
    ): String{
        println("name: ${name}, age: ${age}")
        return name + " " + age
    }

    // request params object
    @GetMapping("/v4")
    fun queryParamObject(userRequest: UserRequest): UserRequest{
        println(userRequest);
        return userRequest
    }

    // request params maps
    @GetMapping("/v5")
    fun queryParamMap(@RequestParam map: Map<String, Any>): Map<String, Any>{
        println(map)
        println(map.get("phone-number"))
        return map
    }
}