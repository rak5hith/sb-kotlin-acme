package com.tcs.service.service

import com.tcs.service.error.customexception.DataNotFoundException
import com.tcs.service.model.OrderModel
import com.tcs.service.repository.OrderRepository
import org.apache.catalina.User
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class OrderService(val orderRepository: OrderRepository){

    val nof = "No Order Found"
    fun getAllOrders(): MutableList<OrderModel> {
        return orderRepository.findAll().collectList().block()
                ?: throw DataNotFoundException(nof)
    }

    fun createOrder(orderModel: OrderModel){
       orderRepository.save(orderModel).block()
    }

    fun getOrder(id:Int): OrderModel? {
            return orderRepository.findById(id).block()
    }


}
