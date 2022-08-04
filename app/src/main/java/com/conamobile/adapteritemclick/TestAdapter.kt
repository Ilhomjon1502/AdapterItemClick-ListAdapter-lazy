package com.conamobile.adapteritemclick

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.conamobile.adapteritemclick.databinding.TestitemBinding

class TestAdapter : ListAdapter<TestModel,
        TestAdapter.Vh>(MyDiffUtil()) {
    lateinit var itemCLick: ((TestModel) -> Unit)

    inner class Vh(
        private var itemTestBinding: TestitemBinding,
    ) :
        RecyclerView.ViewHolder(itemTestBinding.root) {

        fun onBind(test: TestModel) {
            itemTestBinding.apply {
                text.text = test.text

                card.setOnClickListener {
                    itemCLick(test)
                }
            }
        }
    }

    class MyDiffUtil : DiffUtil.ItemCallback<TestModel>() {
        override fun areItemsTheSame(oldItem: TestModel, newItem: TestModel): Boolean {
            return oldItem.text == newItem.text
        }

        override fun areContentsTheSame(oldItem: TestModel, newItem: TestModel): Boolean {
            return oldItem.text == newItem.text
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(TestitemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(getItem(position))
    }
}