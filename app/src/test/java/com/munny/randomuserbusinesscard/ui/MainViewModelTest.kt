package com.munny.randomuserbusinesscard.ui

import com.munny.randomuserbusinesscard.BaseTest
import com.munny.randomuserbusinesscard.R
import com.munny.randomuserbusinesscard.api.response.RandomUserResponse
import com.munny.randomuserbusinesscard.ui.main.MainRepository
import com.munny.randomuserbusinesscard.ui.main.MainViewModel
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import io.reactivex.Single
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito
import org.mockito.internal.verification.Times

class MainViewModelTest : BaseTest() {
    @Test
    fun `requestRandomUser_유저_정보를_잘_받아온다`() {
        val repo = mock<MainRepository>()
        val response = RandomUserResponse(
            listOf(
                RandomUserResponse.Result(
                    RandomUserResponse.Name("", "", ""),
                    RandomUserResponse.Location("", ""),
                    "",
                    "",
                    RandomUserResponse.Picture("")
                )
            )
        )
        Mockito.`when`(repo.requestRandomUser()).thenReturn(Single.just(response))

        val vm = MainViewModel(repo)

        assertEquals(vm.mainState.value?.userInfo, null)

        vm.requestRandomUser()
        verify(repo, Times(1)).requestRandomUser()
        assertEquals(vm.mainState.value?.userInfo?.email, response.results[0].email)
    }

    @Test
    fun `createBusinessCard()_버튼_클릭시_올바른_command_를_가지고_있는다`() {
        val repo = mock<MainRepository>()
        val response = RandomUserResponse(
            listOf(
                RandomUserResponse.Result(
                    RandomUserResponse.Name("", "", ""),
                    RandomUserResponse.Location("", ""),
                    "",
                    "",
                    RandomUserResponse.Picture("")
                )
            )
        )
        Mockito.`when`(repo.requestRandomUser()).thenReturn(Single.just(response))

        val vm = MainViewModel(repo)

        assertEquals(vm.mainCommand.value?.peekContent(), null)

        vm.createBusinessCard()

        vm.mainCommand.value?.peekContent().let {
            assertEquals(
                (it as MainViewModel.MainCommand.ShowToast).messageId,
                R.string.main_request_random_user_toast
            )
        }

        vm.requestRandomUser()
        vm.createBusinessCard()
        assert(vm.mainCommand.value?.peekContent() is MainViewModel.MainCommand.CreateBusinessCard)
    }
}