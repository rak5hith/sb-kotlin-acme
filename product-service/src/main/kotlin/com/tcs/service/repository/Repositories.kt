package com.tcs.service.repository

import org.springframework.stereotype.Repository
import com.microsoft.azure.spring.data.cosmosdb.repository.ReactiveCosmosRepository
import com.tcs.service.model.ProductModel

/**
 * This file will contain all the repositories interfaces.
 */

@Repository
interface ProductContainerRepository : ReactiveCosmosRepository<ProductModel, Int>