package com.github.wolrab.nbodysim.simulation

import java.lang.Math.sqrt
import kotlin.math.pow

/**
 * Simple 3D Doubleing point vector class
 */
class Vector() {
    // Either receive internal array or initialize one at [0f,0f,0f]
    private lateinit var v: Array<Double>
    constructor(v: Array<Double>) {
        if (v.size == 3) this.v = v
    }

    init {
        if ( !this::v.isInitialized ) {
            v = arrayOf(0.0, 0.0, 0.0)
        }
    }

    private var magStale = true
    private fun calcMag() = sqrt(x.pow(2)+y.pow(2)+z.pow(2))
    private var _magnitude = -1.0

    val magnitude: Double
        get(): Double {
            if (magStale) {
                _magnitude = calcMag()
                magStale = false
            }
            return _magnitude
        }

    private fun setCordStale(i: Int, cord: Double) {
        if (v[i] != cord) {
            v[i] = cord
            magStale = true
        }
    }

    // Convenient getter and setters
    var x: Double
        get() = v[0]
        set(cord) = setCordStale(0, cord)
    var y: Double
        get() = v[1]
        set(cord) = setCordStale(1, cord)

    var z: Double
        get() = v[2]
        set(cord) = setCordStale(2, cord)

    operator fun plus(v: Vector): Vector {
        return Vector(
            arrayOf(
                x + v.x,
                y + v.y,
                z + v.z
            )
        )
    }

    operator fun minus(v: Vector): Vector {
        return Vector(
            arrayOf(
                x + v.x,
                y + v.y,
                z + v.z
            )
        )
    }

    operator fun times(s: Double): Vector {
        return Vector(
            arrayOf(
                x * s,
                y * s,
                z * s
            )
        )
    }

    operator fun plusAssign(v: Vector) {
        x += v.x
        y += v.y
        z += v.z

    }

    operator fun minusAssign(v: Vector) {
        x -= v.x
        y -= v.y
        z -= v.z
    }

    operator fun timesAssign(s: Double) {
        x *= s
        y *= s
        z *= s
    }
}
