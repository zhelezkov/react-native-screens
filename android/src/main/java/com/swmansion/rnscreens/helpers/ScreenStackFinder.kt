package com.swmansion.rnscreens.helpers

import android.view.View
import android.view.ViewGroup
import androidx.core.view.isNotEmpty
import com.swmansion.rnscreens.legacy.ScreenStack // legacy-compat: v5 tabs pop a nested v4 stack to root

internal object ScreenStackFinder {
    /**
     * Pops the legacy (v4) stack found in the first descendant chain of the given view to its root.
     *
     * @return `true` if anything was popped, `false` otherwise (also when there is no such stack).
     */
    fun popToRootInFirstDescendantChain(view: View): Boolean = findScreenStackInFirstDescendantChain(view)?.popToRoot() == true

    private fun findScreenStackInFirstDescendantChain(view: View): ScreenStack? {
        var currentView: View? = view

        while (currentView != null) {
            if (currentView is ScreenStack) {
                return currentView
            } else if (currentView is ViewGroup && currentView.isNotEmpty()) {
                currentView = currentView.getChildAt(0)
            } else {
                break
            }
        }

        return null
    }
}
