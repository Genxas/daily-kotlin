package com.genxas.daily.extension

import junit.framework.Assert.assertEquals
import org.junit.Test

class NumberExtensionTest {

    @Test
    fun thousandsWithNoDecimal() {
        assertEquals("1,000", 1000.0.thousands())
        assertEquals("10,000", 10000.0.thousands())
        assertEquals("1,000,000", 1000000.0.thousands())
    }

    @Test
    fun thousandsWithDecimal() {
        assertEquals("1,000.1", 1000.1.thousands())
        assertEquals("10,000.1", 10000.1.thousands())
        assertEquals("1,000,000.1", 1000000.1.thousands())
    }

}
