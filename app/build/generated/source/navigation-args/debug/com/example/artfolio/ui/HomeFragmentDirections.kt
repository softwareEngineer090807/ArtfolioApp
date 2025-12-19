package com.example.artfolio.ui

import android.os.Bundle
import androidx.navigation.NavDirections
import com.example.artfolio.R
import kotlin.Int

public class HomeFragmentDirections private constructor() {
  private data class ActionHomeFragmentToFullScreenFragment(
    public val imageResId: Int,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_homeFragment_to_fullScreenFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putInt("imageResId", this.imageResId)
        return result
      }
  }

  public companion object {
    public fun actionHomeFragmentToFullScreenFragment(imageResId: Int): NavDirections =
        ActionHomeFragmentToFullScreenFragment(imageResId)
  }
}
