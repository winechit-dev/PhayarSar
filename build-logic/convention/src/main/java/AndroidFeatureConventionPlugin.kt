/*
 * Copyright 2022 The Android Open Source Project
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

import com.phayarsar.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("phayarsar.android.library")
                apply("phayarsar.android.hilt")
            }

            dependencies {
                //add("implementation", project(":core:ui"))
                add("implementation", project(":core:design-system"))
                add("implementation", project(":core:localization"))

                add("implementation", libs.findLibrary("androidx.hilt.navigation.compose").get())
                add("implementation", libs.findLibrary("androidx.lifecycle.runtimeCompose").get())
                add("implementation", libs.findLibrary("androidx.lifecycle.viewModelCompose").get())

                add("androidTestImplementation", libs.findLibrary("androidx.lifecycle.runtimeTesting").get())
                add("androidTestImplementation", libs.findLibrary("androidx.junit").get())
                add("testImplementation", libs.findLibrary("junit").get())
            }
        }
    }
}
