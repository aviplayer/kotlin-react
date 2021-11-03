import components.renderUserComponent
import kotlinx.browser.document
import kotlinx.browser.window
import react.RProps
import react.child
import react.dom.div
import react.dom.render
import react.router.dom.browserRouter
import react.router.dom.route
import react.router.dom.routeLink
import react.router.dom.switch

interface IdProps : RProps {
    var id: Int
}

fun main() {
    window.onload = {
        render(document.getElementById("root")) {
            browserRouter {
                switch {
                    route("/", exact = true) {
                        child(UserContainer) {}
                    }
                    route<IdProps>("/:id") { props ->
                        div {
                            routeLink("/") {
                                +"Go back"
                            }
                            renderUserComponent(props.match.params.id)
                        }
                    }
                }
            }
        }
    }
}
