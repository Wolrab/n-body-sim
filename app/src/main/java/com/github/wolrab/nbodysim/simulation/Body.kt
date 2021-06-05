package com.github.wolrab.nbodysim.simulation

class Body(val mass: Double, var position: Vector, var velocity: Vector = Vector(arrayOf(0.0, 0.0, 0.0)), var acceleration: Vector = Vector(arrayOf(0.0, 0.0, 0.0))) {
    fun distTo(body: Body): Double {
        return (body.position - position).magnitude
    }
}
