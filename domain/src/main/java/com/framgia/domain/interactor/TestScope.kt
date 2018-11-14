package com.framgia.domain.interactor

import com.framgia.domain.scope.CustomScope
import javax.inject.Inject

/**
 * Created by GianhTran on 14/11/2018.
 * tran.nguyen.song.gianh@framgia.com
 */
@CustomScope
class TestScope @Inject constructor() {
    fun printSth() {
        println("Custom scope is working")
    }
}
