package com.framgia.cryptocurrency.screen.active

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.framgia.cryptocurrency.R
import com.framgia.cryptocurrency.utils.Const
import com.framgia.domain.entity.CoinDetailResult
import kotlinx.android.synthetic.main.list_coin_row.view.*

// them 2 event click
class ActiveCoinAdapter(private val itemClickListener: (String) -> Unit,
    private val favouriteClick: (String) -> Unit)
  : RecyclerView.Adapter<ActiveCoinAdapter.MainViewHolder>() {

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
    val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_coin_row_grid, parent,
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
      loadImage(itemRow.image_coin, mList?.get(adapterPosition)?.symbol.toString().trim())
      itemRow.text_coin_name.text = mList?.get(adapterPosition)?.name.toString()
      itemRow.setOnClickListener {
        itemClick(mList!![adapterPosition].symbol ?: "")
      }
    }

    private fun loadImage(imageView: ImageView, symbol: String) {
      Glide.with(imageView.context).setDefaultRequestOptions(
          RequestOptions().centerCrop().placeholder(R.drawable.ic_loading).error(
              R.drawable.ic_empty)
      ).load(
          StringBuilder(Const.IMAGE_LINK).append(symbol.toLowerCase()).append(
              ".png").toString()).into(imageView)
    }
  }
}
