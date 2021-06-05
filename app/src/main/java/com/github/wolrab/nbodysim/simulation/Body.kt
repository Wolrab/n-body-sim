package com.github.wolrab.nbodysim.simulation

class Body(val mass: Double, var position: Vector, var velocity: Vector = Vector(arrayOf(0f, 0f, 0f)), var acceleration: Vector = Vector(arrayOf(0f, 0f, 0f))) {

    fun distTo(body: Body) {
        val distSquared = body.position.x
    }
}
