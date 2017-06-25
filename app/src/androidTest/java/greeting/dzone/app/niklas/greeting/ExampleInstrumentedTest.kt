package greeting.dzone.app.niklas.greeting

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.RootMatchers.withDecorView
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.hamcrest.CoreMatchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumentation test, which will execute on an Android device.

 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @Rule @JvmField val activity = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    @Throws(Exception::class)
    fun testNormalGreeting() {
        val firstName = "first"
        val lastName = "lastName"
        val expected = "Hello $firstName $lastName!"
        onView(withId(R.id.firstNameView)).perform(typeText(firstName))
        onView(withId(R.id.lastNameView)).perform(typeText(lastName))
        R.id.messageButton.click()
        onView(withId(R.id.messageView)).check(matches(withText(expected)))
    }

    @Test
    @Throws(Exception::class)
    fun testEmptyFirstName() {
        R.id.firstNameView.write("")
        R.id.lastNameView.write("last")
        R.id.messageButton.click()
        R.id.messageView.textEquals("")
        activity containsToast "You forgot to write your full name!"
    }

    @Test
    @Throws(Exception::class)
    fun testEmptyLastName() {
        R.id.firstNameView.write("first")
        R.id.lastNameView.write("")
        R.id.messageButton.click()
        R.id.messageView.textEquals("")
        activity containsToast "You forgot to write your full name!"
    }
}
fun Int.click() = onView(withId(this)).perform(ViewActions.click())
fun Int.write(text: String) = onView(withId(this)).perform(typeText(text))
fun Int.textEquals(text: String) = onView(withId(this)).check(matches(withText(text)))
infix fun ActivityTestRule<MainActivity>.containsToast(message: String) =
        onView(withText(message))
        .inRoot(withDecorView(not(activity.window.decorView)))
        .check(matches(isDisplayed()))


