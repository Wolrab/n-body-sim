package com.github.wolrab.nbodysim.simulation

/**
 * Overloading responsibility for simplicity
 */
class Body(val mass: Double, var position: Vector, var velocity: Vector = Vector(), var acceleration: Vector = Vector()) {
    fun distTo(body: Body): Double {
        return (body.position - position).magnitude
    }

    fun getAcceleration(force: Vector) = force * (1.0/mass)
}
