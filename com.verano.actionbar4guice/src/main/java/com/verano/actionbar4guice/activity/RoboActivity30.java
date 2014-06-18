/*
 * Copyright 2009 Michael Burton
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 */
package com.verano.actionbar4guice.activity;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import roboguice.RoboGuice;
import roboguice.activity.RoboActivity;

import java.lang.reflect.Constructor;

/**
 * A {@link RoboActivity} extends from {@link Activity} to provide dynamic
 * injection of collaborators, using Google Guice.<br />
 * <br />
 * Your own activities that usually extend from {@link Activity} should now
 * extend from {@link RoboActivity}.<br />
 * <br />
 * If your activities extend from subclasses of {@link Activity} provided by the
 * Android SDK, we provided Guice versions as well for the most used : see
 * {@link RoboExpandableListActivity}, {@link RoboListActivity}, and other
 * classes located in package <strong>roboguice.activity</strong>.<br />
 * <br />
 * If we didn't provide what you need, you have two options : either post an
 * issue on <a href="http://code.google.com/p/roboguice/issues/list">the bug
 * tracker</a>, or implement it yourself. Have a look at the source code of this
 * class ({@link RoboActivity}), you won't have to write that much changes. And
 * of course, you are welcome to contribute and send your implementations to the
 * RoboGuice project.<br />
 * <br />
 * Please be aware that collaborators are not injected into this until you call
 * {@link #setContentView(int)} (calling any of the overloads of this methods
 * will work).<br />
 * <br />
 *
 * @author Mike Burton
 */
public class RoboActivity30 extends RoboActivity {

    /**
     * @return true if name begins with a lowercase character (indicating a package) and it doesn't start with com.android
     */
    protected static boolean shouldInjectOnCreateView(String name) {
        return Character.isLowerCase(name.charAt(0)) && !name.startsWith("com.android") && !name.equals("fragment");
    }

    protected static View injectOnCreateView(String name, Context context, AttributeSet attrs) {
        try {
            final Constructor<?> constructor = Class.forName(name).getConstructor(Context.class, AttributeSet.class);
            final View view = (View) constructor.newInstance(context, attrs);
            RoboGuice.injectMembers(context, view);
            return view;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
