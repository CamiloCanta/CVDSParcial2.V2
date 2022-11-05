package edu.eci.pdsw.samples;

import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.entities.TipoIdentificacion;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import edu.eci.pdsw.samples.services.ExcepcionServiciosSuscripciones;
import edu.eci.pdsw.samples.services.ServiciosPaciente;
import edu.eci.pdsw.samples.services.ServiciosPacientesFactory;

import java.sql.Date;

public class main {
    public static void main(String[] args) throws ExcepcionServiciosSuscripciones, PersistenceException {
        ServiciosPaciente serviciosPaciente = ServiciosPacientesFactory.getInstance().getServiciosPaciente();

        System.out.println("Search Patients");
        System.out.println(serviciosPaciente.consultarPacientes());
        System.out.println("Search Patients by ID");
        System.out.println(serviciosPaciente.consultarPacientesPorId(9877,TipoIdentificacion.TI));
        System.out.println("Search consults");
        System.out.println(serviciosPaciente.consultarConsultas());
        System.out.println("Search minors by sickness");
        System.out.println(serviciosPaciente.consultarMenoresConEnfermedadContagiosa());
    }
}

