package ru.sber.serialization

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class JsonSerializationTest {

    @Test
    fun `Не должны сериализовываться свойства с null значениям Настройка через аннотацию`() {
        // given
        val client = Client5()
        val objectMapper = ObjectMapper()

        // when
        val data = objectMapper.writeValueAsString(client)

        // then
        assertEquals("{}", data)
    }

    @Test
    fun `Не должны сериализовываться свойства с null значениям Настройка через ObjectMapper`() {
        // given
        val client = Client6()
        val objectMapper = ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL)

        // when
        val data = objectMapper.writeValueAsString(client)

        // then
        assertEquals("{}", data)
    }
}
