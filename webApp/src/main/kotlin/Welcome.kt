import com.baseio.kmm.domain.model.GithubReposItem
import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import org.w3c.dom.HTMLInputElement
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.html.classes
import kotlinx.html.style
import react.*
import react.dom.*

external interface TrendingProps : Props

val scope = MainScope()

val TrendingUI = fc<TrendingProps> {
    var trendingRepos: List<GithubReposItem> by useState(emptyList())
    useEffectOnce {
        scope.launch {
           withContext(Dispatchers.Default){
               useCasesComponent.provideGetLocalReposUseCase().perform(null).collectLatest {
                  withContext(Dispatchers.Main){
                      trendingRepos = it
                  }
               }
           }
        }
    }

    useEffectOnce {
        scope.launch {
          withContext(Dispatchers.Default){
              val trendingReposLocal =
                  useCasesComponent.provideFetchTrendingReposUseCase().perform("kotlin")
              useCasesComponent.provideSaveTrendingReposUseCase().perform(trendingReposLocal)
          }
        }
    }

    h1 {
        +"Trending Kotlin Repositories"
    }
    div {
        for (repo in trendingRepos) {
            img(src = repo.avatar, classes = "img") {
                this.attrs.height = "100"
                this.attrs.width = "100"
            }
            div {
                p {
                    key = repo.url
                    +"${repo.name}: ${repo.author}"
                }
            }

        }
    }

}

