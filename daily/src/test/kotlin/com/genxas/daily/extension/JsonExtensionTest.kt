package com.genxas.daily.extension

import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Test

class JsonExtensionTest {

    data class User(val name: String)

    @Test
    fun deserializeObject() {
        val user = "{\"name\": \"john doe\"}".toObject<User>()

        assertNotNull(user)
        assertEquals("john doe", user.name)
    }

    @Test
    fun deserializeObjects() {
        val users = "[{\"name\": \"john doe\"}, {\"name\": \"jane doe\"}]".toObjects<User>()

        assertNotNull(users)
        assertEquals(2, users.size)
        assertEquals("john doe", users[0].name)
        assertEquals("jane doe", users[1].name)
    }
}