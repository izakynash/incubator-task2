package presenter

import model.Employee

interface IEmployee {

    fun addNewEmp(emp: Employee): Boolean

    fun listEmpsBySurname(surname: String): MutableList<Employee>

    fun listEmpsByPosition(position: String): MutableList<Employee>

    fun deleteEmp(id: Long)

}