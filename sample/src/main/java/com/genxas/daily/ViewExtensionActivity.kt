package com.genxas.daily

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.genxas.daily.extension.click
import kotlinx.android.synthetic.main.activity_view_extension.*

class ViewExtensionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_extension)

        btnClick.click {
            Snackbar.make(btnClick, "Clicked!!!", Snackbar.LENGTH_LONG).show()
        }
    }
}