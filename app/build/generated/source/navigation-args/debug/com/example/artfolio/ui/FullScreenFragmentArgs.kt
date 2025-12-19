package com.example.artfolio.ui

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Int
import kotlin.jvm.JvmStatic

public data class FullScreenFragmentArgs(
  public val imageResId: Int,
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putInt("imageResId", this.imageResId)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("imageResId", this.imageResId)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): FullScreenFragmentArgs {
      bundle.setClassLoader(FullScreenFragmentArgs::class.java.classLoader)
      val __imageResId : Int
      if (bundle.containsKey("imageResId")) {
        __imageResId = bundle.getInt("imageResId")
      } else {
        throw IllegalArgumentException("Required argument \"imageResId\" is missing and does not have an android:defaultValue")
      }
      return FullScreenFragmentArgs(__imageResId)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): FullScreenFragmentArgs {
      val __imageResId : Int?
      if (savedStateHandle.contains("imageResId")) {
        __imageResId = savedStateHandle["imageResId"]
        if (__imageResId == null) {
          throw IllegalArgumentException("Argument \"imageResId\" of type integer does not support null values")
        }
      } else {
        throw IllegalArgumentException("Required argument \"imageResId\" is missing and does not have an android:defaultValue")
      }
      return FullScreenFragmentArgs(__imageResId)
    }
  }
}
