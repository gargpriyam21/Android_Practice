package com.example.neera.mediaplayer

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.MediaController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        videoView.setVideoURI(Uri.parse(
                "android.resource://${packageName}/${R.raw.video1}"
        ))
        videoView.start()
        videoView.setMediaController(MediaController(this))

        val mp = MediaPlayer.create(this, R.raw.crowd)

        btnPlay.setOnClickListener(View.OnClickListener { mp.start() })

        btnPause.setOnClickListener(View.OnClickListener { mp.pause() })


    }
}
