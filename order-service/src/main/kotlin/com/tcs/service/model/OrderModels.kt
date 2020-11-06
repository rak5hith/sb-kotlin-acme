package com.tcs.service.model
import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document
import org.springframework.data.annotation.Id
import java.util.*


/**
 * This class will contain all the DTO Objects
 */
@Document(collection = "orders")
data class OrderModel(@Id val id:Int,
                 val userId:String,
                 val productId:Int)