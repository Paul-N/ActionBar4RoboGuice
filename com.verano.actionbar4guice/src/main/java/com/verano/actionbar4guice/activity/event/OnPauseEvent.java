package com.verano.actionbar4guice.activity.event;

import android.app.Activity;

/**
 * Class representing the event raised by RoboActivity.onPause()
 *
 * @author Adam Tybor
 * @author John Ericksen
 */
public class OnPauseEvent {
    protected Activity activity;

    public OnPauseEvent(Activity activity) {
        this.activity = activity;
    }

    public Activity getActivity() {
        return activity;
    }
}
