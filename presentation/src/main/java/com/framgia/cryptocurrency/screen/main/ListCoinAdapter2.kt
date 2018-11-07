package com.framgia.cryptocurrency.screen.main

import android.annotation.SuppressLint
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.framgia.cryptocurrency.R
import com.framgia.cryptocurrency.utils.Const
import com.framgia.domain.entity.CoinDetailResult
import kotlinx.android.synthetic.main.list_coin_row.view.*
import java.text.SimpleDateFormat

// them 2 event click
class ListCoinAdapter2(val itemClickListener: (String) -> Unit, val favouriteClick: (String) -> Unit)
    : RecyclerView.Adapter<ListCoinAdapter2.MainViewHolder>() {

    var mList: MutableList<CoinDetailResult>? = null

    fun onUpdateAdapter(list: MutableList<CoinDetailResult>) {
        mList = list
        notifyDataSetChanged()
    }

    fun onLoadMore(list: MutableList<CoinDetailResult>) {
        mList!!.addAll(list)
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_coin_row, parent,
                false)
        return MainViewHolder(itemView, itemClickListener, favouriteClick)
    }

    override fun getItemCount(): Int {
        return mList?.size ?: 0
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.setData()
    }

    //truyen xuong holder , String la kieu tra ve khi call back
    inner class MainViewHolder(var itemRow: View,
                               val itemClick: (String) -> Unit, val favouriteClick: (String) -> Unit)
        : RecyclerView.ViewHolder(itemRow) {

        fun setData() {
            loadImage(itemRow.image_coin, mList!![adapterPosition].symbol.toString().trim())
            itemRow.text_symbol.text = mList!![adapterPosition].symbol.toString()
            itemRow.text_coin_name.text = mList!![adapterPosition].name.toString()
            if (mList!![adapterPosition].quote!!.usd != null) {
                itemRow.text_price.text = mList!![adapterPosition].quote!!.usd!!.price.toString()
                checkChage1h(itemRow.text_change_1h, mList!![adapterPosition].quote!!.usd!!.percentChange1h!!)
            }
            itemRow.text_time.text = formatTime(mList!![adapterPosition].lastUpdated.toString())

            itemRow.image_favorite.setOnClickListener {
                favouriteClick(mList!![adapterPosition].symbol ?: "")
            }
            itemRow.setOnClickListener {
                itemClick(mList!![adapterPosition].symbol ?: "")
            }
        }

        @SuppressLint("SimpleDateFormat")
        private fun formatTime(orginApi: String): String {
            val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
            val date = formatter.parse(orginApi)
            val outputFormat = SimpleDateFormat("dd/MM--hh:MM")
            return outputFormat.format(date)
        }

        private fun loadImage(imageView: ImageView, symbol: String) {
            Glide.with(imageView.context).setDefaultRequestOptions(
                    RequestOptions().centerCrop().placeholder(R.drawable.ic_loading).error(
                            R.drawable.ic_empty)
            ).load(
                    StringBuilder(Const.IMAGE_LINK).append(symbol.toLowerCase()).append(
                            ".png").toString()).into(imageView)
        }

        @SuppressLint("ResourceAsColor", "SetTextI18n")
        private fun checkChage1h(textView: TextView, value: Double) {
            if (value > 0) {
                textView.setTextColor(ContextCompat.getColor(itemView.context, R.color.color_green_100))
                textView.text = itemView.context.getString(R.string.text_plus) + value.toString()
            } else if (value < 0) {
                textView.setTextColor(ContextCompat.getColor(itemView.context, R.color.color_red_100))
                textView.text = value.toString()
            } else {
                textView.text = value.toString()
            }
        }
    }
}
