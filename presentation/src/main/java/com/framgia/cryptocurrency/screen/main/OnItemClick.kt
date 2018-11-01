package com.framgia.cryptocurrency.screen.main

interface OnItemClick {
  fun onItemClicked(coinId: Int)
  fun onFavoriteClicked(coinId: Int)
}
