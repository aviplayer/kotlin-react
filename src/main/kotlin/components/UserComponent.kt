package components

import dto.UserDto
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.css.*
import react.*
import react.dom.img
import react.dom.label
import styled.css
import styled.styledDiv
import utils.fetchUser

external interface UserProps : RProps {
    var userId: Int
}

val UserComponent = functionalComponent<UserProps> { props ->
    var (user: UserDto?, setUser) = useState<UserDto?>(null)
    var (isLoading, setIsLoading) = useState(true)
    useEffect(listOf(props.userId)) {
        val mainScope = MainScope()
        mainScope.launch {
            val user = fetchUser(props.userId)
            setUser(user)
            setIsLoading(false)
        }
    }
    styledDiv {
        css {
            padding(vertical = 16.px)
            display = Display.flex
            flexDirection = FlexDirection.column
            alignItems = Align.center
            backgroundColor = Color.grey
        }
        label {
            +"User id: ${if (isLoading) "loading..." else user?.id}"
        }
        label {
            +"User login: ${if (isLoading) "loading..." else user?.login}"
        }
        label {
            +"User ${if (isLoading) "loading..." else (if (user?.siteAdmin!!) "is Admin" else "not an Admin")}"
        }
        styledDiv {
            if (isLoading) "loading..." else {
                img(
                    src = user?.avatarUrl
                ) {}
            }
        }
    }
}

fun RBuilder.renderUserComponent(id: Int) {
    console.log("User with $id")
    child(UserComponent) {
        attrs {
            userId = id
        }
    }
}

