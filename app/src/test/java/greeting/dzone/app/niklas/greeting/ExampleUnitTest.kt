package greeting.dzone.app.niklas.greeting

import greeting.dzone.app.niklas.greeting.MainActivity.Companion.greeting
import org.junit.Test

import org.junit.Assert.*
class ExampleUnitTest {
    @Test
    fun testNormalGreeting() {
        greeting(firstName = "first", lastName = "last") equals "Hello first last!"
    }

    @Test
    fun testEmptyFirstName() {
        greeting(firstName = "", lastName = "last") equals ""
    }

    @Test
    fun testEmptyLastName() {
        greeting(firstName = "first", lastName = "") equals ""
    }
}
infix fun Any?.equals(o2: Any?) = assertEquals(this, o2)






