package com.tcs.service.service

import com.tcs.service.error.customexception.DataNotFoundException
import com.tcs.service.model.ProductModel
import com.tcs.service.repository.ProductContainerRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class ProductService(private val productContainerRepository: ProductContainerRepository) {

    val ndf = "No Data Found"
    fun getAllProducts(): MutableList<ProductModel> {
        return productContainerRepository.findAll().collectList().block()
                ?: throw DataNotFoundException(ndf)
    }

    fun getProductById(id: Int): ProductModel {
        return productContainerRepository.findById(id).block()
                ?: throw DataNotFoundException(ndf)
    }

    fun saveModel(productModel: ProductModel) {
        productContainerRepository.save(productModel).block()

    }

    fun updateModel(productModel: ProductModel){
        productContainerRepository.save(productModel).block()
    }


}
