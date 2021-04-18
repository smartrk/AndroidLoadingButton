package com.rk.progressbutton

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.view.ViewCompat
import androidx.core.widget.ImageViewCompat
import kotlinx.android.synthetic.main.rk_progress.view.*
import kotlin.math.roundToInt


/**
 * Created by Rahul Kansara (Rk) on 18-Apr-21,  rahul.kansara10@gmail.com
 */
class RkProgressButton(context: Context, attrs: AttributeSet?, defStyleAttr: Int) :
    LinearLayout(context, attrs, defStyleAttr), View.OnClickListener {

    init {
        initUi(attrs)
    }

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0) {
        initUi(attrs)
    }

    constructor(context: Context) : this(context, null, 0) {
        initUi(null)
    }


    private fun initUi(attrs: AttributeSet?) {
        val view = LayoutInflater.from(context).inflate(R.layout.rk_progress, this, true)
        setOnClickListener(this)

        backgroungColor?.let {
            if (it != -1) {
                ImageViewCompat.setImageTintList(buttonCons, ColorStateList.valueOf(it))
            }
        }


        progressColor?.let {
            if (it != -1) {
                progressBar2.indeterminateTintList = ColorStateList.valueOf(it)
            }
        }

        textColor?.let {
            if (it != -1) {
                appCompatTextView.setTextColor(ColorStateList.valueOf(it))
            }
        }

        customHeight?.let {
            if (it != -1f) {
                buttonCons.minimumHeight = it.roundToInt()
            }
        }




        appCompatTextView?.text = btnText

        clickView!!.setOnClickListener {
            event?.onClick(it)
        }

        inItAttribute(attrs)

    }

    private fun inItAttribute(attrs: AttributeSet?) {
        val attrsArray =
            context.obtainStyledAttributes(attrs, R.styleable.RkProgressButton, 0, 0)
        try {
            attrsArray.getDrawable(R.styleable.RkProgressButton_doneDrawable)?.let {
                doneImage = it
            }

            attrsArray.getDrawable(R.styleable.RkProgressButton_errorDrawable).let {
                errorImage = it
            }

            attrsArray.getColor(R.styleable.RkProgressButton_buttonColor, -1).let {
                backgroungColor = it
            }

            attrsArray.getColor(R.styleable.RkProgressButton_progressColor, -1).let {
                progressColor = it
            }

            attrsArray.getString(R.styleable.RkProgressButton_buttonText)?.let {
                btnText = it
                appCompatTextView?.text = btnText
            }

            attrsArray.getString(R.styleable.RkProgressButton_buttonErrorText)?.let {
                errorText = it
            }

            attrsArray.getColor(R.styleable.RkProgressButton_textColor,-1)?.let {
                textColor = it
            }

            attrsArray.getDimension(R.styleable.RkProgressButton_customHeight,-1f)?.let {
                customHeight = it
            }


        } finally {
            attrsArray.recycle()
        }
    }

    var doneImage: Drawable? = null
    var errorImage: Drawable? = null
    var backgroungColor: Int? = null
    var progressColor: Int? = null
    var textColor: Int? = null
    var customHeight: Float? = null

    var event: ProgressButtonClickListner? = null
    var currentId: Int = R.id.start
    var btnText: String? = null
    var errorText: String? = null


    fun setProgressButtonClickListener(eventq: ProgressButtonClickListner) {
        event = eventq
    }


    interface ProgressButtonClickListner {
        fun onClick(var1: View?)
    }


    override fun onClick(v: View?) {
    }


    fun progressAnimation() {
        mainLay!!.setTransition(R.id.start, R.id.end)
        mainLay!!.transitionToEnd()
        currentId = R.id.end
    }

    fun doneAnimation() {
        if (doneImage == null) {
            doneImage = getDrawable(context, R.drawable.ic_done_img)
        }

        shapeableImageView6?.setImageDrawable(doneImage)

        mainLay!!.setTransition(currentId, R.id.done)
        mainLay!!.transitionToEnd()
        currentId = R.id.done
        Handler(Looper.getMainLooper()).postDelayed({
            mainLay!!.setTransition(R.id.done, R.id.start)
            mainLay!!.transitionToEnd()
        }, 1500)
    }

    fun errorAnimation() {
        if (errorImage == null) {
            errorImage = getDrawable(context, R.drawable.error_image)
        }

        errorText?.let {
            appCompatTextView.text = it
        }

        shapeableImageView6?.setImageDrawable(errorImage)
        mainLay!!.setTransition(currentId, R.id.done)
        mainLay!!.transitionToEnd()
        currentId = R.id.done
        Handler(Looper.getMainLooper()).postDelayed({
            mainLay!!.setTransition(R.id.done, R.id.start)
            mainLay!!.transitionToEnd()
            currentId = R.id.start
        }, 1500)
    }


    fun stopAnimation() {
        mainLay!!.setTransition(currentId, R.id.start)
        mainLay!!.transitionToEnd()
        currentId = R.id.start
    }
}