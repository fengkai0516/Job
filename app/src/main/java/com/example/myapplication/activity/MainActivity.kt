package com.example.myapplication.activity

import android.text.TextUtils
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.myapplication.viewmodel.MainViewModel
import com.example.myapplication.Router
import com.example.myapplication.util.TimeUtil
import com.example.myapplication.base.BaseViewBindingActivity
import com.example.myapplication.databinding.ActivityMainBinding

@Route(path = Router.MAIN_ACTIVITY)
class MainActivity : BaseViewBindingActivity<MainViewModel, ActivityMainBinding>() {
    override fun onCreate() {
        binding.etMoney.addTextChangedListener {
            mViewModel.moneyData.value = it.toString()

        }
        mViewModel.moneyData.observe(this) {
            if (TextUtils.isEmpty(it)) {
                binding.textMoney.text = "Account："
            } else {
                binding.textMoney.text = "Account￥$it"

            }
        }

        binding.etTime.addTextChangedListener {
            mViewModel.timeData.value = it.toString()
        }

        mViewModel.timeData.observe(this) {
            if (TextUtils.isEmpty(it)) {
                binding.textTime.text = "Time："
            } else {
                if (it.toLong() > Int.MAX_VALUE || it.toLong() < Int.MIN_VALUE) {
                    binding.textTime.text = "请输入正确的时间"
                } else {
                    binding.textTime.text = "Time：" + TimeUtil.getTime(it.toInt())

                }


            }
        }

        binding.buttonJump.setOnClickListener {

            if (TextUtils.isEmpty(mViewModel.moneyData.value)) {
                Toast.makeText(this, "请输入正确的价格", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(mViewModel.timeData.value)) {
                Toast.makeText(this, "请输入正确的时间", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            ARouter.getInstance().build(Router.SECOND_ACTIVITY)
                .withString("money", mViewModel.moneyData.value)
                .withString("time", mViewModel.timeData.value).navigation()
        }
    }

    override fun destroy() {
    }

    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }


}