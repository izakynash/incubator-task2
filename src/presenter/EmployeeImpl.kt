package presenter

import model.Employee
import provider.EmployeeProvider

class EmployeeImpl: IEmployee {

    val employeeList = EmployeeProvider.employeeList


    override fun addNewEmp(emp: Employee): Boolean {

        employeeList.forEach { e ->
            if (e.name == emp.name)
                return false
        }

        employeeList.add(emp)
        return true
    }


    override fun listEmpsBySurname(surname: String): MutableList<Employee> {

        val employeeListWithoutPos = EmployeeProvider.employeeListWithoutPos

        val listEmpsSameSurname: MutableList<Employee> = mutableListOf()

        for (e in employeeListWithoutPos) {
            if (e.surname == surname)
                listEmpsSameSurname.add(e)
            if (listEmpsSameSurname.size == 10) break
        }

        if (listEmpsSameSurname.isNotEmpty())
            for (i in 0 until listEmpsSameSurname.size)
                for (j in 0 until listEmpsSameSurname.size) {
                    if (i == j) continue
                    if (listEmpsSameSurname[i].name == listEmpsSameSurname[j].name) {
                        for (e in employeeList)
                            if (e.id == listEmpsSameSurname[i].id) {
                                listEmpsSameSurname[i].position = e.position
                                break
                            }
                    break
                    }
                }

        return listEmpsSameSurname
    }


    override fun listEmpsByPosition(position: String): MutableList<Employee> {

        var employeeListSamePos: MutableList<Employee> = mutableListOf()

        for (e in employeeList) {
            if (e.position == position)
                employeeListSamePos.add(e)
            if (employeeListSamePos.size == 10) break
        }

       employeeListSamePos = employeeListSamePos.sortedWith(compareBy(Employee::name, Employee::surname)).toMutableList()

        return employeeListSamePos
    }


    override fun deleteEmp(id: Long) {

        for (i in 0 until employeeList.size)
            if (employeeList[i].id == id) {
                employeeList.removeAt(i)
                break
            }
    }

}
