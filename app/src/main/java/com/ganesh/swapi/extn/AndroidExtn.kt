package com.ganesh.swapi.extn

import android.content.Intent

/**
 * Created by ganeshkumarraja on 3/15/20.
 */

fun Intent.extraBundle(key: String, value: String) {
    putExtra(key, value)
}
