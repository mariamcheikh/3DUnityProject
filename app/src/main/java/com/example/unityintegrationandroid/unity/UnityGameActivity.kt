package com.example.unityintegrationandroid.unity

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.view.plusAssign
import com.google.android.material.button.MaterialButton
import com.example.unityintegrationandroid.MainActivity
import com.example.unityintegrationandroid.R
import com.unity3d.player.UnityPlayer
import com.unity3d.player.UnityPlayerActivity


class UnityGameActivity : UnityPlayerActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mUnityPlayer += MaterialButton(this).apply {
            layoutParams = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.TOP or Gravity.CENTER_HORIZONTAL
            }
            text = "RANDOMIZE COLOR"

            setOnClickListener {
                val color = listOf("blue", "green", "red", "yellow").random()
               // UnityPlayer.UnitySendMessage("Plant", "ChangeColor", color)
            }
        }

        mUnityPlayer += MaterialButton(this).apply {
            layoutParams = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.TOP or Gravity.CENTER_HORIZONTAL or Gravity.END
            }
            text = "QUIT"

            setOnClickListener {
                val intent = Intent(context, MainActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT or Intent.FLAG_ACTIVITY_SINGLE_TOP
                }
                startActivity(intent)
            }
        }

        mUnityPlayer += JoystickView(this).apply {
            layoutParams = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL
            }

            findViewById<View>(R.id.forward).setOnClickListener {
                UnityPlayer.UnitySendMessage("Plant", "MoveUp", "")
            }

            findViewById<View>(R.id.backward).setOnClickListener {
                UnityPlayer.UnitySendMessage("Plant", "MoveDown", "")
            }

            findViewById<View>(R.id.left).setOnClickListener {
                UnityPlayer.UnitySendMessage("Plant", "MoveLeft", "")
            }

            findViewById<View>(R.id.right).setOnClickListener {
                UnityPlayer.UnitySendMessage("Plant", "MoveRight", "")
            }
        }
    }
}