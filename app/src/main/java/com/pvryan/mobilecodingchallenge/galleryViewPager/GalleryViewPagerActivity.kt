/*
 * Copyright 2018 Priyank Vasa
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.pvryan.mobilecodingchallenge.galleryViewPager

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.pvryan.mobilecodingchallenge.R
import com.pvryan.mobilecodingchallenge.extensions.obtainViewModel
import com.pvryan.mobilecodingchallenge.galleryGrid.GalleryViewModel
import kotlinx.android.synthetic.main.activity_gallery_view_pager.*

class GalleryViewPagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery_view_pager)
        setSupportActionBar(toolbarViewPager)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        if (savedInstanceState != null) {
            supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.container,
                            GalleryViewPagerFragment.newInstance(intent.extras))
                    ?.commit()
        }
    }

    /*private fun setupViewModel() {
        if (!isNetworkAvailable()) {
            container.snackIndefinite(Constants.Errors.noNetwork,
                    R.string.text_try_again, View.OnClickListener {
                setupViewModel()
            })
            return
        }
        viewModel = obtainViewModel().apply {
            fullScreen.observe( this@GalleryViewPagerActivity,
                    Observer<Boolean> {
                        if (it == true) {
                            supportActionBar?.hide()
                            hideStatusBar()
                        } else {
                            showStatusBar()
                            supportActionBar?.show()
                        }
                    })
        }
    }*/

    fun obtainViewModel() = obtainViewModel(GalleryViewModel::class.java)
}