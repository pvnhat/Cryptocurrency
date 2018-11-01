package com.framgia.data.entity.mapper

import com.framgia.data.entity.model.Quote
import com.framgia.data.entity.model.QuoteData
import javax.inject.Inject

class QuoteMapper @Inject constructor(private val usdMapper: UsdMapper) {
  fun transform(quoteData: QuoteData?): Quote? {
    if (quoteData == null) {
      return null
    }
    return Quote(usd = usdMapper.transform(quoteData.usd))
  }
}
