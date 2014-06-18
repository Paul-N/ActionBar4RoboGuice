package com.verano.actionbar4guice.activity.event;

import android.app.Activity;

/**
 * Class representing the event raised by RoboActivity.onResume()
 *
 * @author Adam Tybor
 * @author John Ericksen
 */
public class OnResumeEvent {
    protected Activity activity;

    public OnResumeEvent(Activity activity) {
        this.activity = activity;
    }

    public Activity getActivity() {
        return activity;
    }
}
