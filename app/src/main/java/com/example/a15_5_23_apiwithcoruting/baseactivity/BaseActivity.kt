package com.example.a15_5_23_apiwithcoruting.baseactivity

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.a15_5_23_apiwithcoruting.R

open class BaseActivity : AppCompatActivity() {
    fun loadFragment(fragment: Fragment, isAdd: Boolean, isAddToBackStack: Boolean) {
        var beginTransition = supportFragmentManager.beginTransaction()
        if (isAdd) {
            beginTransition.add(
                R.id.fragment_container_view_tag,
                fragment,
                fragment::class.java.simpleName
            )
        } else {
            beginTransition.replace(
                R.id.fragment_container_view_tag,
                fragment,
                fragment::class.java.simpleName
            )
        }
        if (isAddToBackStack) {
            beginTransition.addToBackStack(
                fragment::class.java.simpleName
            )
        }
        beginTransition.commit()
    }
}