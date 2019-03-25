package alzaichsank.com.simplematch

import alzaichsank.com.simplematch.view.main.MainActivity
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class SimpleMathTest {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testButtonSum() {
        Thread.sleep(1000)
        onView(withId(R.id.button_sum)).perform(click())

        Thread.sleep(1000)
        Espresso.pressBack()
    }

    @Test
    fun testButtonMulty() {
        Thread.sleep(1000)
        onView(withId(R.id.button_multiply)).perform(click())

        Thread.sleep(1000)
        Espresso.pressBack()
    }

    @Test
    fun testButtonFib() {
        Thread.sleep(1000)
        onView(withId(R.id.button_fibo)).perform(click())

        Thread.sleep(1000)
        Espresso.pressBack()
    }

    @Test
    fun testButtonPrime() {
        Thread.sleep(1000)
        onView(withId(R.id.button_prime)).perform(click())

        Thread.sleep(1000)
        Espresso.pressBack()
    }
}
