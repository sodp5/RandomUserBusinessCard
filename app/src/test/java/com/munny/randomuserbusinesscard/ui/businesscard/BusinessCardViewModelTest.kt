package com.munny.randomuserbusinesscard.ui.businesscard

import com.munny.randomuserbusinesscard.BaseTest
import com.munny.randomuserbusinesscard.model.UserInfo
import org.junit.Assert.assertEquals
import org.junit.Test

class BusinessCardViewModelTest : BaseTest() {
    @Test
    fun `businessCardState_올바르게_데이터가_초기화_되는지_확인`() {
        val userInfo = UserInfo(name = "mr.doNothing")
        val vm = BusinessCardViewModel(userInfo)

        assertEquals(userInfo.name, vm.businessCardState.value?.userInfo?.name)
    }
}