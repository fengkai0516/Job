package com.example.myapplication.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.alibaba.android.arouter.launcher.ARouter
import java.lang.reflect.ParameterizedType


abstract class BaseViewBindingActivity<VM : ViewModel, BV : ViewBinding> : AppCompatActivity(),
    BaseActivityView<BV> {


    protected lateinit var binding: BV


    protected lateinit var mViewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this)
        binding = getViewBinding()
        setContentView(binding?.root)
        mViewModel = createViewModel()
        onCreate()
    }


    override fun onDestroy() {
        super.onDestroy()
        destroy()
    }


    private fun createViewModel(): VM {
        return ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(getVmClazz(this))
    }


    private fun <VM> getVmClazz(obj: Any): VM {
        return (obj.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as VM
    }

}



