package Relationship

/**
 * 연관 관계
 *
 * 연관(Association) 관계란?
 * 2개의 서로 분리된 클래스가 연결을 가지는 것!
 * 단뱡향 혹은 양방향으로 연결될 수 있다.
 */

class Patient(val name: String) {
    fun doctorList(d: Doctor) { // 인자로 참조
        println("Patient: $name, Doctor: ${d.name}")
    }
}

class Doctor(val name: String) {
    fun patientList(p: Patient) { // 인자로 참조
        println("Doctor: $name, Patient: ${p.name}")
    }
}

fun main() {
    val doc1 = Doctor("KimSabu")    // 객체가 따로 생성됨
    val patient1 = Patient("Kildong")
    doc1.patientList(patient1)
    patient1.doctorList(doc1)
}

/**
 * Doctor와 Patient 클래스의 객체는 따로 생성되며 서로 독립적인 생명주기를 가지고 있다.
 * 이 코드에서는 두 클래스가 서로의 객체를 참조하고 있으므로 양방향 참조를 가진다.
 * 단방향이든 양방향이든 각각의 객체의 생명주기에 영향을 주지 않을 때는 연관 관계라고 한다.
 */