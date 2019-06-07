package provider

import model.Employee

class EmployeeProvider {

    companion object {

        val employeeList: MutableList<Employee> = mutableListOf(
            Employee(1, "Ivan", "Ivanov", "Plumber"),
            Employee(2, "Peter", "First", "Czar"),
            Employee(3, "Gennadiy", "Bukin", "Plumber"),
            Employee(4, "Ivan", "Ivanov", "KillerMotherF"),
            Employee(5, "Boris", "Ivanov", "Plumber")
        )

        val employeeListWithoutPos: MutableList<Employee> = mutableListOf(
            Employee(1, "Ivan", "Ivanov"),
            Employee(2, "Peter", "First"),
            Employee(3, "Gennadiy", "Bukin"),
            Employee(4, "Ivan", "Ivanov"),
            Employee(5, "Boris", "Ivanov")
        )
    }

}