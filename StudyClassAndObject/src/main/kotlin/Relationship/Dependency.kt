package Relationship

/**
 * 한 클래스가 다른 클래스에 의존되어 있어 영향을 주는 경우 의존(Dependency) 관계라고 한다.
 */

class Patient2(val name: String, var id: Int) {
    fun doctorList(d: Doctor2) {
        println("Patient: $name, Doctor: ${d.name}")
    }
}

class Doctor2(val name: String, val p: Patient2) {
    val customerId: Int = p.id

    fun patientList() {
        println("Doctor: $name, Patient: ${p.name}")
        println("Patient Id: $customerId")
    }
}

fun main() {
    val patient1 = Patient2("Kildong", 1234)
    val doc1 = Doctor2("KimSabu", patient1)
    doc1.patientList()
}