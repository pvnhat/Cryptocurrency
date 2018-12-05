package com.framgia.domain.interactor

import com.framgia.domain.scope.CustomScope
import javax.inject.Inject

/**
 * Created by VanNhat on 14/11/2018.
 */
@CustomScope
class TestScope @Inject constructor() {
    fun printSth() {
        println("Custom scope is working")
    }
}
