package com.tcs.service.component

import com.nhaarman.mockito_kotlin.whenever
import com.tcs.service.service.OrderService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.skyscreamer.jsonassert.JSONAssert
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.get
import java.io.File


@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension::class, MockitoExtension::class)
class OrderServiceTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var service: OrderService

    fun getOrder(){
      "{}"
    }

    /**
     * Preparing Mock Stub For service class
     **/
    @BeforeEach
    fun setup() {
        whenever(service.getOrder(1)).thenAnswer { getOrder() }
    }

    @Test
    fun getOrderTest() {
        var expected = File("./src/test/resources/contract/sample.json").readText(Charsets.UTF_8)
        var result: MvcResult =
                mockMvc.get("/api/v1/acme/orders").andExpect { status { isOk } }.andReturn()
        JSONAssert.assertEquals(expected, result.response.contentAsString, false)
    }


}