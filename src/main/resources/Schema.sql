create schema if not exists leggodb;
set schema leggodb;

create table subject (
    subjectName varchar(50) not null,
    dniTeacherInCharge varchar(20) not null,
    idSubject varchar (20) not null,
    PRIMARY KEY (idSubject)
);

create table student (
    studentName varchar(50) not null,
    studentDni varchar(20),
    PRIMARY KEY (studentDni)
);

create table teacher (
    teacherName varchar(50) not null,
    dni varchar(20),
    PRIMARY KEY (dni)
);

create table teacherToSubject (
    dni_Teacher varchar(20),
    id_subject varchar(20),
    PRIMARY KEY (dni_Teacher, id_subject),
    FOREIGN KEY (dni_Teacher) REFERENCES teacher(dni),
    FOREIGN KEY (id_subject) REFERENCES subject(idSubject)
);

create table StudentToSubject (
    student_Dni varchar(20),
    id_subject varchar(20),
    PRIMARY KEY (student_Dni, id_subject),
    FOREIGN KEY (student_Dni) REFERENCES student(studentDni),
    FOREIGN KEY (id_subject) REFERENCES subject(idSubject)
);