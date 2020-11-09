package com.tcs.service.controller

import com.microsoft.applicationinsights.TelemetryClient
import com.tcs.service.model.BaseModel
import com.tcs.service.model.ServiceResponse
import com.tcs.service.model.ProductModel
import com.tcs.service.repository.ProductContainerRepository
import com.tcs.service.service.ProductService
import org.apache.logging.log4j.kotlin.logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/acme/product-service/v1")
class ProductController(private val service: ProductService) {

    val logger = logger()
    /**
     * TelemetryClient is responsible for sending events to App Insights
     */
    @Autowired
    lateinit var telemetryClient: TelemetryClient

    /**
     * This is a sample of the GET Endpoint
     */
    @RequestMapping(value = ["/products"], method = [RequestMethod.GET], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllProducts(): MutableList<ProductModel> {
        logger.info("Inside getAllProducts Controller")
        telemetryClient.trackEvent("URI /products is triggered");
        return service.getAllProducts()
    }

    @RequestMapping(value = ["/products/{id}"], method = [RequestMethod.GET], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getProductById(@PathVariable("id") id: Int ): ProductModel {
        logger.info("Inside getProductById Controller")
        telemetryClient.trackEvent("URI /products/{id} is triggered");
        return  service.getProductById(id = id)
    }

    @PostMapping("/product")
    fun saveModel(@RequestBody productModel: ProductModel): ResponseEntity<ServiceResponse>? {
        logger.info("Inside saveModel Controller")
        telemetryClient.trackEvent("URI POST /product is triggered");
        service.saveModel(productModel)
        return ResponseEntity.ok(ServiceResponse("200",
                "SUCCESS", "Data Successfully Inserted"))

    }

    @PutMapping("/product")
    fun updateModel(@RequestBody productModel: ProductModel): ResponseEntity<ServiceResponse>? {
        logger.info("Inside updateModel Controller")
        telemetryClient.trackEvent("URI PUT /product is triggered");
        service.updateModel(productModel)
        return ResponseEntity.ok(ServiceResponse("200",
                "SUCCESS", "Data Successfully Updated"))
    }

    /**
     * This is a sample of the GET Endpoint
     */
/*    @RequestMapping(value = ["/products/{id}"], method = [RequestMethod.GET], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getProductById(@PathVariable id:Int): ResponseEntity<ServiceResponse> {
        logger.info("Inside getProductById Controller")
        telemetryClient.trackEvent("URI /products/$id is triggered");
        return ResponseEntity.ok(ServiceResponse("200",
                "SUCCESS", service.ge))
    }*/

    /**
     * This is a sample of the POST Endpoint
     */

}
