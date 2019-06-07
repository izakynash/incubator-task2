package model

data class Employee(val id: Long,
                    var name: String,
                    val surname: String,
                    var position: String? = null)