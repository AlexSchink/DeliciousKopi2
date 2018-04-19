package com.example.alexanderschink.deliciouskopi;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.Button;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> rule =
            new ActivityTestRule<MainActivity>(MainActivity.class);

    public ActivityTestRule<newPrices> rule2 =
            new ActivityTestRule<newPrices>(newPrices.class);

    @Test
    public void additionTest() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.alexanderschink.deliciouskopi", appContext.getPackageName());
    }


    @Test
    public void changePrice() throws Exception {
        onView(withId(R.id.price0)).perform(typeText("1.20"));

    }

    @Test
    public void pressImage0() throws Exception {

        onView(withId(R.id.imageButton0)).perform(click());
        onView(withId(R.id.sumText)).check(matches(withText("Total: 1.5")));
    }

    @Test
    public void pressImage01() throws Exception {

        onView(withId(R.id.imageButton0)).perform(click());
        onView(withId(R.id.imageButton1)).perform(click());
        onView(withId(R.id.sumText)).check(matches(withText("Total: 3.5")));
    }

    @Test
    public void pressImage012() throws Exception {

        onView(withId(R.id.imageButton0)).perform(click());
        onView(withId(R.id.imageButton1)).perform(click());
        onView(withId(R.id.imageButton2)).perform(click());
        onView(withId(R.id.sumText)).check(matches(withText("Total: 4.3")));
    }

    @Test
    public void pressImage0123() throws Exception {

        onView(withId(R.id.imageButton0)).perform(click());
        onView(withId(R.id.imageButton1)).perform(click());
        onView(withId(R.id.imageButton2)).perform(click());
        onView(withId(R.id.imageButton3)).perform(click());
        onView(withId(R.id.sumText)).check(matches(withText("Total: 7.8")));
    }

    @Test
    public void pressImage01234() throws Exception {

        onView(withId(R.id.imageButton0)).perform(click());
        onView(withId(R.id.imageButton1)).perform(click());
        onView(withId(R.id.imageButton2)).perform(click());
        onView(withId(R.id.imageButton3)).perform(click());
        onView(withId(R.id.imageButton4)).perform(click());
        onView(withId(R.id.sumText)).check(matches(withText("Total: 8.8")));
    }

    @Test
    public void pressImage012345() throws Exception {

        onView(withId(R.id.imageButton0)).perform(click());
        onView(withId(R.id.imageButton1)).perform(click());
        onView(withId(R.id.imageButton2)).perform(click());
        onView(withId(R.id.imageButton3)).perform(click());
        onView(withId(R.id.imageButton4)).perform(click());
        onView(withId(R.id.imageButton5)).perform(click());
        onView(withId(R.id.sumText)).check(matches(withText("Total: 10.1")));
    }


    @Test
    public void changePrice0() throws Exception {

        onView(withId(R.id.buttonSettings)).perform(click());
        onView(withId(R.id.price0)).perform(typeText("1.20"));
        pressBack();
        pressBack();
        onView(withId(R.id.imageButton0)).perform(click());
        onView(withId(R.id.sumText)).check(matches(withText("Total: 1.2")));
    }
    @Test
    public void changePrice012345Reset() throws Exception {

        onView(withId(R.id.imageButton0)).perform(click());
        onView(withId(R.id.imageButton1)).perform(click());
        onView(withId(R.id.imageButton2)).perform(click());
        onView(withId(R.id.imageButton3)).perform(click());
        onView(withId(R.id.imageButton4)).perform(click());
        onView(withId(R.id.imageButton5)).perform(click());
        onView(withId(R.id.sumText)).check(matches(withText("Total: 10.1")));
        onView(withId(R.id.newCust)).perform(click());

        onView(withId(R.id.buttonSettings)).perform(click());
        onView(withId(R.id.price0)).perform(typeText("1.20"));
        pressBack();
        onView(withId(R.id.price1)).perform(click());
        onView(withId(R.id.price1)).perform(typeText("1.30"));
        pressBack();
        onView(withId(R.id.price2)).perform(click());
        onView(withId(R.id.price2)).perform(typeText("1.80"));
        pressBack();
        onView(withId(R.id.price3)).perform(click());
        onView(withId(R.id.price3)).perform(typeText("2.10"));
        pressBack();
        onView(withId(R.id.price4)).perform(click());
        onView(withId(R.id.price4)).perform(typeText("0.90"));
        pressBack();
        onView(withId(R.id.price5)).perform(click());
        onView(withId(R.id.price5)).perform(typeText("1.10"));
        pressBack();
        pressBack();
        onView(withId(R.id.imageButton0)).perform(click());
        onView(withId(R.id.imageButton1)).perform(click());
        onView(withId(R.id.imageButton2)).perform(click());
        onView(withId(R.id.imageButton3)).perform(click());
        onView(withId(R.id.imageButton4)).perform(click());
        onView(withId(R.id.imageButton5)).perform(click());
        onView(withId(R.id.sumText)).check(matches(withText("Total: 8.4")));
        onView(withId(R.id.newCust)).perform(click());
        onView(withId(R.id.sumText)).check(matches(withText("Total: 0.0")));

    }

}
