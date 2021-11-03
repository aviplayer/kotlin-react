package dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    var login: String? = null,
    var id: Int? = null,
    @SerialName("node_id")
    var nodeId: String? = null,
    @SerialName("avatar_url")
    var avatarUrl: String? = null,
    @SerialName("site_admin")
    var siteAdmin: Boolean? = null
)
