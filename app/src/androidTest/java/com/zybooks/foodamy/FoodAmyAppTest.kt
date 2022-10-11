package com.zybooks.foodamy

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.zybooks.foodamy.di.AppModule
import com.zybooks.foodamy.ui.theme.FoodAmyTheme
import com.zybooks.foodamy.util.TestTags
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
@UninstallModules(AppModule::class)
class FoodAmyAppTest {


    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setup() {
        hiltRule.inject()
        composeRule.setContent {
            FoodAmyTheme { }
        }
    }
//TODO create test for individual composable views
    @Test
    fun enterEmail_CheckErrorStatus() {
        // Perform text inputs
        composeRule.onNodeWithTag(TestTags.Login_Email_Textfield).performTextInput("jonathangoris")
        //Perform Text Clicks
        composeRule.onNodeWithTag(TestTags.Login_Button).performClick()
        composeRule.onNodeWithTag(TestTags.Error_Message).assertIsDisplayed()

    }

    @Test
    fun enterPassword_CheckErrorStatus() {
        // Perform text inputs
        composeRule.onNodeWithTag(TestTags.Login_Password_Textfield).performTextInput("sl'dkgh")
        //Perform Text Clicks
        composeRule.onNodeWithTag(TestTags.Login_Button).performClick()
        composeRule.onNodeWithTag(TestTags.Error_Message).assertIsDisplayed()

    }

    @Test
    fun enterPasswordAndEmail_CheckErrorStatus() {
        // Perform text inputs
        composeRule.onNodeWithTag(TestTags.Login_Email_Textfield).performTextInput("jonathangoris")
        composeRule.onNodeWithTag(TestTags.Login_Password_Textfield).performTextInput("sl'dkgh")
        //Perform Text Clicks
        composeRule.onNodeWithTag(TestTags.Login_Button).performClick()
        composeRule.onNodeWithTag(TestTags.Error_Message).assertIsDisplayed()

    }

}