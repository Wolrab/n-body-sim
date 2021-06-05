package com.github.wolrab.nbodysim

/**
 * Simple 2D Floating point vector class
 */
class Vector() {
    // Either receive internal array or initialize one at <0,0>
    private lateinit var v: Array<Float>
    constructor(v: Array<Float>) {
        this.v = v
    }

    init {
        if ( !this::v.isInitialized ) {
            v = arrayOf(0f, 0f)
        }
    }

    // Convenient getter and setters
    var x: Float
        get() = v[0]
        set(x) { v[0] = x }
    var y: Float
        get() = v[1]
        set(y) { v[1] = y }

    operator fun plus(v: Vector): Vector {
        return Vector(arrayOf(x + v.x, y + v.y))
    }

    operator fun times(s: Float): Vector {
        return Vector(arrayOf(x * s, y * s))
    }
}
