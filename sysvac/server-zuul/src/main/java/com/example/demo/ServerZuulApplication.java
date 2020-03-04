package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class ServerZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerZuulApplication.class, args);
	}

}

// SERVICIOS A URLS DIRECTAS Y CON EUREKA
// localhost:PTO//empleados
// localhost:PTO//empleados/{id}
// localhost:PTO//vacaciones
// localhost:PTO//vacaciones/{id}

// URLs ATRAVEZ DE zuul (y zuul es  cliente eureka)
// localhost:8490/api/empleados/empleados
// localhost:8490/api/empleados/empleados/{id}
// localhost:8490/api/vacaciones/vacaciones
// localhost:8490/api/vacaciones/vacaciones/{id}

/*
 * 
 * Vista Uno y Dos
 *  api/empleados/todo
  public List<Employee> getEmployees(string query);
   api/empleados/id/{id}
  public Employee getEmployeeById(string employeeId);
  api/vacaciones/todos
  public Vacaciones getVacaciones();
  
  api/empleados/nombre/{nombre}/ingreso/{ingreso}/sueldo/generados/antiguedad/vigenciaini/vigenciafin
  public addEmployee(nombre, ingreso, sueldo, generados, antiguedad, vigencia);
 * 
 * Vista Modificar
 * api/vacaciones/{id}
  List<Disfrutados> getDatesDetailsById()

  Vista Tres
  api/sueldos
  List<Sueldos> getSueldoEmployees()

  Vista Config
  api/config/constantes
  api/config/generados
  List<Constante> getConstantes()
  List<Constante> getGenerados()
 * 
 * */
