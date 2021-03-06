package com.skillshare.xkcd.view.fullscreen

import androidx.appcompat.app.AppCompatActivity
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.skillshare.xkcd.R

class FullscreenActivity : AppCompatActivity() {
    private lateinit var fullscreenImage: ImageView
    private lateinit var titleView: TextView
    private lateinit var altTextView: TextView
    private lateinit var fullscreenOverlay: ViewGroup
    private lateinit var fullScreenHandler: FullScreenHandler

    companion object {
        private const val EXTRA_COMIC_ID = "comic_id"
        @JvmStatic
        fun getLaunchIntent(context: Context, comicId: Int): Intent {
            val intent = Intent(context, FullscreenActivity::class.java)
            intent.putExtra(EXTRA_COMIC_ID, comicId)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_fullscreen)

        fullscreenImage = findViewById(R.id.fullscreen_image)
        fullscreenOverlay = findViewById(R.id.fullscreen_content_controls)
        fullScreenHandler = FullScreenHandler(fullscreenImage, fullscreenOverlay)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
        fullScreenHandler.hide()
    }
}