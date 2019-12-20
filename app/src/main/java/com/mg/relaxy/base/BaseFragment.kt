package com.mg.relaxy.base

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.mg.util.helpers.AutoClearedValue
import com.mg.util.extensions.showFlashBar
import com.mg.widget.LoadingLottieDialog
import timber.log.Timber

abstract class BaseFragment<T : ViewDataBinding> : Fragment(), IBasePresenter {

    protected var binding: T by AutoClearedValue()

    private val dialog: AlertDialog by lazy {
        LoadingLottieDialog.Builder().setContext(requireContext())
            .setCancelable(false)
            .build()
    }

    @get:LayoutRes
    protected abstract val layoutId: Int

    protected abstract fun initPresenter()

    protected abstract fun bindingUI()

    protected abstract fun observeUI()

    protected abstract fun initUI(view: View, savedInstanceState: Bundle?)

    protected abstract fun initListener()

    override fun onAttach(context: Context) {
        logLifecycleEvents("onAttach")
        super.onAttach(context)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        logLifecycleEvents("onCreate")
        super.onCreate(savedInstanceState)
        observeUI()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        logLifecycleEvents("onCreateView")
        initPresenter()
        return DataBindingUtil.inflate<T>(
            inflater,
            layoutId,
            container,
            false
        ).apply { binding = this }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        logLifecycleEvents("onViewCreated")
        super.onViewCreated(view, savedInstanceState)
        bindingUI()
        initUI(view, savedInstanceState)
        initListener()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        logLifecycleEvents("onActivityCreated")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        logLifecycleEvents("onStart")
        super.onStart()
    }


    override fun onResume() {
        logLifecycleEvents("onResume")
        super.onResume()
    }

    override fun onPause() {
        logLifecycleEvents("onPause")
        super.onPause()
    }

    override fun onStop() {
        logLifecycleEvents("onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        logLifecycleEvents("onDestroyView")
        super.onDestroyView()
    }

    override fun onDestroy() {
        logLifecycleEvents("onDestroy")
        super.onDestroy()
    }

    override fun onDetach() {
        logLifecycleEvents("onDetach")
        super.onDetach()
    }

    override fun showLoading() {
        if (!dialog.isShowing)
            dialog.show()
    }

    override fun hideLoading() {
        if (dialog.isShowing)
            dialog.dismiss()
    }

    override fun onServerError(code: Int, message: String) {
        requireActivity().showFlashBar(message + "code: " + code)
    }

    override fun onServiceError(message: String) {
        requireActivity().showFlashBar(message)
    }

    private fun logLifecycleEvents(lifeCycleName: String) {
        Timber.d("$lifeCycleName $this")
    }
}