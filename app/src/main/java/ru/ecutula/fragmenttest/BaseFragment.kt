package ru.ecutula.fragmenttest

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.textview.MaterialTextView

open class BaseFragment: Fragment() {
    val TAG: String = this.javaClass.simpleName
    open val layoutId: Int = 0
    private var offset: Int = 0
    private var count: Int = 0
    init {
        globalCount++
        globalOffset += 100
        if(globalOffset>800) globalOffset=0
        offset = globalOffset
        count = globalCount
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutId, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        Log.d(TAG, "onViewCreated")
        view.x = view.x + offset
        view.y = view.y + offset
        view.invalidate()
        val text = view.findViewById<MaterialTextView>(R.id.text)
            text.text = TAG + this.count
    }


    override fun onPause() {
        Log.d(TAG, "onPause")
        super.onPause()
    }

    override fun onResume() {
        Log.d(TAG, "onResume")
        super.onResume()
    }

    override fun onDestroyView() {
        Log.d(TAG, "onDestroyView")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy")
        super.onDestroy()
    }
    companion object{
        var globalOffset =0
        var globalCount = 0
    }
}