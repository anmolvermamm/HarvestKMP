import com.mutualmobile.harvestKmp.db.DriverFactory
import com.mutualmobile.harvestKmp.di.SharedComponent
import com.mutualmobile.harvestKmp.di.initSqlDelightExperimentalDependencies
import harvest.*
import kotlinx.browser.document
import kotlinx.browser.window
import react.create
import react.router.Route
import react.router.Routes
import react.dom.client.createRoot
import react.router.dom.BrowserRouter


val sharedComponent = SharedComponent()

fun main() {
    initSqlDelightExperimentalDependencies()
    window.onload = { _ ->
        createRoot(document.getElementById("root")!!).render(

            JSLoginScreen.create())
       /* BrowserRouter.apply {
            react.router.Routes {
                Route {
                    attrs.index = true
                    attrs.element = JSHomePage.create()
                }
                Route {
                    attrs.path = "/login"
                    attrs.element = JSLoginScreen.create()
                }
                Route {
                    attrs.path = "/trendingui"
                    attrs.element = TrendingUI.create()
                }
                Route {
                    attrs.path = "/signup"
                    attrs.element = JSSignupScreen.create()
                }
            }
        }.create())*/

    }
}

suspend fun setupDriver() {
    sharedComponent.provideGithubTrendingLocal().driver?.let {} ?: run {
        setupDriverInternal()
    }

}

private suspend fun setupDriverInternal() {
    try {
        val driver = DriverFactory().createDriverBlocking()
        val trendingLocal = sharedComponent.provideGithubTrendingLocal()
        trendingLocal.driver = driver
    } catch (ex: Exception) {
        console.log(ex.message)
        console.log("Exception happened here.")
        console.log(ex)
    }
}
