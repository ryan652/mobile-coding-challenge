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
package com.pvryan.mobilecodingchallenge.data.source

import com.pvryan.mobilecodingchallenge.data.Image
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Unsplash {
    @GET("photos")
    fun getLatestImages(@Query("client_id") clientId: String,
                        @Query("page") page: Int = 1,
                        @Query("per_page") perPage: Int = 10,
                        @Query("order_by") orderBy: String = "latest"): Call<List<Image>>
}