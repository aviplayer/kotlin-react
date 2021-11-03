import kotlinx.css.*
import styled.StyleSheet

object UsersStyles : StyleSheet("Styles", isStatic = true) {
    val usersContainer by css {
        padding(5.px)
        display = Display.flex
        flexDirection = FlexDirection.column
        alignItems = Align.center
        border = "1px"
        color = rgb(56, 246, 137)
    }

    val userLink by css {
            margin(2.px)
            padding(5.px)
            border = "1px solid grey"
            width = LinearDimension("100%")
        }

} 
