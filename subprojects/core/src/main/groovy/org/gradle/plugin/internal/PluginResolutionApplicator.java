/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.plugin.internal;

import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.plugins.PluginAware;
import org.gradle.plugin.resolve.internal.PluginResolution;

class PluginResolutionApplicator implements Action<PluginResolution> {
    private final PluginAware target;

    public PluginResolutionApplicator(PluginAware target) {
        this.target = target;
    }

    public void execute(PluginResolution pluginResolution) {
        Class<? extends Plugin> pluginClass = pluginResolution.resolve(this.getClass().getClassLoader());
        target.getPlugins().apply(pluginClass);
    }
}
