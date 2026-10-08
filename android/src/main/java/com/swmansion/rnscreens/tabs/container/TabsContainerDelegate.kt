package com.swmansion.rnscreens.tabs.container

import android.view.View
import androidx.fragment.app.FragmentManager

internal interface TabsContainerDelegate {
    /**
     * Resolves the fragment manager the container should run its operations on. Called every time the container
     * is attached to a window, as the result may differ between attachments.
     */
    fun resolveFragmentManager(): FragmentManager

    /**
     * Pops the navigation stack nested in the given tab's content to its root. Called on repeated selection of a tab
     * that has the pop-to-root special effect enabled.
     *
     * @return `true` if anything was popped, `false` otherwise.
     */
    fun popToRootInTab(tabContent: View): Boolean
}
