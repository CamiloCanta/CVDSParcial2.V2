/*
 * Copyright (C) 2015 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.pdsw.samples.tests;

import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.entities.Consulta;
import edu.eci.pdsw.samples.entities.TipoIdentificacion;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import edu.eci.pdsw.samples.services.ExcepcionServiciosSuscripciones;
import edu.eci.pdsw.samples.services.ServiciosPacientesFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author hcadavid
 */
public class ServicesJUnitTest {

    public ServicesJUnitTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void clearDB() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://desarrollo.is.escuelaing.edu.co:3306/bdprueba?useSSL=false", "bdprueba", "prueba2019");
        Statement stmt = conn.createStatement();
        stmt.execute("delete from CONSULTAS WHERE idCONSULTAS = 2001");
        stmt.execute("delete from CONSULTAS WHERE idCONSULTAS = 2002");
        stmt.execute("delete from CONSULTAS WHERE idCONSULTAS = 2003");

        stmt.execute("delete from PACIENTES WHERE id = 1000");
        stmt.execute("delete from PACIENTES WHERE id = 1001");
        stmt.execute("delete from PACIENTES WHERE id = 1002");
        //conn.commit();
        conn.close();
    }

    /**
     * Obtiene una conexion a la base de datos de prueba
     * @return
     * @throws SQLException
     */
    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://desarrollo.is.escuelaing.edu.co:3306/bdprueba?useSSL=false", "bdprueba", "prueba2019");
    }

    @Test
    public void DadoPacientesConID() throws SQLException, ExcepcionServiciosSuscripciones, PersistenceException {
        //Insertar datos en la base de datos de pruebas, de acuerdo con la clase
        //de equivalencia correspondiente

        //arrange
        Connection conn=getConnection();
        Statement stmt=conn.createStatement();

        //act
        stmt.execute("INSERT INTO `PACIENTES` (`id`, `tipo_id`, `nombre`, `fecha_nacimiento`) VALUES (1000,'TI','Carlos','2010-07-10')");
        stmt.execute("INSERT INTO `PACIENTES` (`id`, `tipo_id`, `nombre`, `fecha_nacimiento`) VALUES (1001,'TI','Esteban','2010-07-10')");
        stmt.execute("INSERT INTO `PACIENTES` (`id`, `tipo_id`, `nombre`, `fecha_nacimiento`) VALUES (1002,'CC','Ivan','1995-07-10')");

        stmt.execute("INSERT INTO `CONSULTAS` (`idCONSULTAS`, `fecha_y_hora`, `resumen`, `PACIENTES_id`, `PACIENTES_tipo_id`) VALUES (2001,'2001-01-01 00:00:00','Tiene varicela',1000,'TI')");
        stmt.execute("INSERT INTO `CONSULTAS` (`idCONSULTAS`, `fecha_y_hora`, `resumen`, `PACIENTES_id`, `PACIENTES_tipo_id`) VALUES (2002,'2001-01-01 00:00:00','Tiene hepatitis',1001,'TI')");
        stmt.execute("INSERT INTO `CONSULTAS` (`idCONSULTAS`, `fecha_y_hora`, `resumen`, `PACIENTES_id`, `PACIENTES_tipo_id`) VALUES (2003,'2001-01-01 00:00:00','Gracias',1002,'CC')");
        //conn.commit();
        conn.close();

        //Realizar la operacion de la logica y la prueba
//        System.out.println("Incio de Prueba");
//        System.out.println("Consultar Todos los Pacientes");
        List<Paciente> pacientes = ServiciosPacientesFactory.getInstance().getServiciosPaciente().consultarPacientes();
//        for (Paciente paciente : pacientes){
//            System.out.println(paciente);
//        }
        boolean ver = false;
//        System.out.println("Consultar paciente por ID y TI");
//        System.out.println("Consultamos paciente con id = 1001, y Tipo de Identificacion = TI");
        Paciente paciente = ServiciosPacientesFactory.getInstance().getServiciosPaciente().consultarPacientesPorId(1001, TipoIdentificacion.TI);
//        System.out.println(paciente);
//        System.out.println("Consultar Pacientes menores de edad con enfermedad contagiosa hepatitis o varicela");
        List<Paciente> pacientesEnfermos = ServiciosPacientesFactory.getInstance().getServiciosPaciente().consultarMenoresConEnfermedadContagiosa();
        for (Paciente p : pacientesEnfermos){
            if(p.getId() == paciente.getId()){
                ver = true;
            }
        }
        System.out.println("Fin de la prueba");

        //Assert
        Assert.assertTrue(ver);
        List<Paciente> arrayPaciente = new ArrayList<>();

    }





}
