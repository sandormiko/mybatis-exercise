# mybatis-exercise
Demonstration of using MyBatis with Spring.
The project consist of 2 subprojects.The persistence module is responsible for operations on the in-memory DB,
it also holds MyBatis mapper xmls and configurations. The business subproject relies on the persistence module,
and includes services, that implement the logic of our demo business case.
