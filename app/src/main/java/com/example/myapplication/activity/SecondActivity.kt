package com.example.myapplication.activity

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.myapplication.Router
import com.example.myapplication.viewmodel.SecondViewModel
import com.example.myapplication.adapter.MoneyAdapter
import com.example.myapplication.base.BaseViewBindingActivity
import com.example.myapplication.bean.Money
import com.example.myapplication.dao.MoneyDatabase
import com.example.myapplication.databinding.ActivitySecondBinding

@Route(path = Router.SECOND_ACTIVITY)
class SecondActivity : BaseViewBindingActivity<SecondViewModel, ActivitySecondBinding>() {
    @JvmField
    @Autowired
    var money: String = ""

    @JvmField
    @Autowired
    var time: String = ""
    override fun onCreate() {
        var room = Room.databaseBuilder(this, MoneyDatabase::class.java, "money").allowMainThreadQueries().build()
        var money2 = money.toInt() * time.toInt()
        room.getMoney().add(Money(money = money2.toString()))
        var list = room.getMoney().query()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = MoneyAdapter(this, list)



    }


    override fun destroy() {
    }

    override fun getViewBinding(): ActivitySecondBinding {
        return ActivitySecondBinding.inflate(layoutInflater)
    }


}