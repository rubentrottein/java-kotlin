package models

import javax.annotation.processing.Generated

data class Car(
    var id: Int,

    var model: String?,
    var brand: String?,
    var description: String?,
    var year: Int?
)