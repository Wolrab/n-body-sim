package com.github.wolrab.nbodysim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.github.wolrab.nbodysim.simulation.Vector

/**
 * Caution:
 *  A ViewModel must never reference a view, Lifecycle,
 *      or any class that may hold a reference to
 *      the activity context.
 */
class BodyModel : ViewModel() {
    private val bodies = arrayListOf<Vector>()

    fun appendBodies(bodies: ArrayList<Vector>) {
        this.bodies.addAll(bodies)
    }

    fun clearBodies() {
        bodies.clear()
    }
}


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model: BodyModel by viewModels()
        model.clearBodies()
        model.appendBodies()
    }
}