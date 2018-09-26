package com.example.muhtadi.footballclub

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        UiDetail().setContentView(this)

        val img_fc = findViewById<ImageView>(R.id.img_fc)
        val tv_title = findViewById<TextView>(R.id.tv_title)
        val tv_desc = findViewById<TextView>(R.id.tv_desc)

        val title_dtl:String = intent.getStringExtra("title")
        val img_dtl:Int = intent.getIntExtra("image",1)
        val desc_dtl:String = intent.getStringExtra("desc")

        tv_title.text = title_dtl
        tv_desc.text = desc_dtl
        Glide.with(this)
                .load(img_dtl)
                .into(img_fc)

    }

    class UiDetail : AnkoComponent<DetailActivity>{
        override fun createView(ui: AnkoContext<DetailActivity>)= with(ui) {
            verticalLayout{

                imageView{
                    id = R.id.img_fc
                }.lparams(350,350)

                textView{
                    id = R.id.tv_title
                }.textSize = 18f

                textView{
                    id = R.id.tv_desc
                }
            }

        }

    }
}
