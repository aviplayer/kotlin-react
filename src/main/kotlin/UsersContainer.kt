import dto.UserDto
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import react.RProps
import react.dom.li
import react.functionalComponent
import react.router.dom.routeLink
import react.useEffect
import react.useState
import styled.css
import styled.styledDiv
import utils.fetchUsers


val UserContainer = functionalComponent<RProps> { _ ->
    val (users, setUsers) = useState(emptyList<UserDto>())
    useEffect(users) {
        console.log("Fetching task")
        val mainScope = MainScope()
        mainScope.launch {
            val users = fetchUsers()
            setUsers(users.asList())
        }
    }
    styledDiv {
        css {
            +UsersStyles.usersContainer
        }
        users.toList()
            .map {
                styledDiv {
                    css {
                        +UsersStyles.userLink
                    }
                    li {
                        routeLink("/${it.id}") {
                            +"${it.login}"
                        }
                    }
                }
            }
    }
}


