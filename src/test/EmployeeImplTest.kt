package test

import model.Employee
import org.junit.Assert.assertEquals
import org.junit.Test
import presenter.EmployeeImpl
import kotlin.test.assertFalse

class EmployeeImplTest {

    private val employeeImpl = EmployeeImpl()


    @Test
    fun addNewEmpTest() {
        val emp = Employee(5, "Ivan", "Petrov", "Plumber")

        val b = employeeImpl.addNewEmp(emp)

        assertFalse(b, "adding new employee not completed")
    }

    @Test
    fun listEmpsBySurnameTest() {

        val listActual = employeeImpl.listEmpsBySurname("Ivanov")

        val listExpected: MutableList<Employee> = mutableListOf(
            Employee(1, "Ivan", "Ivanov", "Plumber"),
            Employee(4, "Ivan", "Ivanov", "KillerMotherF"),
            Employee(5, "Boris", "Ivanov")
        )

        assertEquals(listExpected, listActual)
    }

    @Test
    fun listEmpsByPositionTest() {

        val listActual = employeeImpl.listEmpsByPosition("Plumber")

        val listExpected: MutableList<Employee> = mutableListOf(
            Employee(5, "Boris", "Ivanov", "Plumber"),
            Employee(3, "Gennadiy", "Bukin", "Plumber"),
            Employee(1, "Ivan", "Ivanov", "Plumber")
        )

        assertEquals(listExpected, listActual)
    }

    @Test
    fun deleteEmpTest() {

        employeeImpl.deleteEmp(3)

        val listExpected: MutableList<Employee> = mutableListOf(
            Employee(5, "Boris", "Ivanov", "Plumber"),
            Employee(3, "Gennadiy", "Bukin", "Plumber"),
            Employee(1, "Ivan", "Ivanov", "Plumber")
        )

        assertEquals(4, employeeImpl.employeeList.size)
    }







}
