package com.genxas.daily.extension

import android.content.Context
import android.widget.Button
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ViewExtensionKtTest {

    @Mock private lateinit var context: Context

    @Test
    fun testClick() {
        var count = 0

        val btn = Button(context)

        btn.click {
            count = 1
        }

        btn.performClick()

//        Assert.assertEquals(1, count)
    }
}