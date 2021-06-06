package com.github.wolrab.nbodysim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.github.wolrab.nbodysim.simulation.Body
import com.github.wolrab.nbodysim.simulation.Vector

/**
 * N-BODY SIMULATION
 * NOT SIMULATING ANYTHING ELSE c:
 */

class BodyModel : ViewModel() {
    /**
     * Caution:
     *  A ViewModel must never reference a view, Lifecycle,
     *      or any class that may hold a reference to
     *      the activity context.
     */
    private val bodies = arrayListOf<Body>()

    fun appendBodies(bodies: ArrayList<Body>) {
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

        // TODO: Remove placeholder initialization
        val model: BodyModel by viewModels()
        model.clearBodies()
        model.appendBodies( arrayListOf( Body(10.0, Vector(arrayOf(0.5, 0.5, 0.0))), Body(1.0, Vector(arrayOf(-1.0, -0.2, 0.0))) ) )
    }
}