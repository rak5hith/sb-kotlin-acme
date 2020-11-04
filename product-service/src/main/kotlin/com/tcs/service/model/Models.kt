package com.tcs.service.model

import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document
import org.springframework.data.annotation.Id
import java.util.*

/**
 * This class will contain all the DTO Objects
 */
@Document(collection = "products")
data class ProductModel(@Id val id: Int,
                             val productName: String,
                             val description: String,
                             val beginDate: Date,
                             val endDate: Date)