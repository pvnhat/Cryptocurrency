package com.framgia.cryptocurrency.screen.main

interface OnItemClick {
  fun onItemClicked(symbol: String)
  fun onFavoriteClicked(symbol: String)
}
