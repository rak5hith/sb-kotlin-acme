package com.tcs.service.controller

import com.tcs.service.model.OrderModel
import com.tcs.service.model.ServiceResponse
import com.tcs.service.repository.OrderRepository
import com.tcs.service.service.OrderService
import org.springframework.core.annotation.Order
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/acme")
class OrderController(val orderService: OrderService){

    @PostMapping("/orders/{id}")
    fun createOrder(@RequestBody orderModel: OrderModel){
        orderService.createOrder(orderModel)

    }

    @GetMapping("/orders/{id}")
    fun getAllOrders(): ResponseEntity<ServiceResponse> {
     println ("Inside GetMapping")
        return ResponseEntity.ok(ServiceResponse("200",
                "SUCCESS", orderService.getAllOrders()))
    }

    @PutMapping("/orders/{id}")
    fun updateOrder(){

    }
    @DeleteMapping("/orders/{id}")
    fun deleteOrder(){

    }
}