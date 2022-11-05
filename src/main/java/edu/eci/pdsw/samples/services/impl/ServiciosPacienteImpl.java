/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.services.impl;

import com.google.inject.Inject;
import edu.eci.pdsw.samples.entities.Consulta;
import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.entities.TipoIdentificacion;
import edu.eci.pdsw.samples.persistence.DaoConsulta;
import edu.eci.pdsw.samples.persistence.DaoPaciente;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import edu.eci.pdsw.samples.services.ExcepcionServiciosSuscripciones;
import edu.eci.pdsw.samples.services.ServiciosPaciente;
import java.util.List;

/**
 *
 * @author hcadavid
 */
public class ServiciosPacienteImpl implements ServiciosPaciente {

    @Inject
    private DaoPaciente daoPaciente;

    @Inject
    private DaoConsulta daoConsulta;



    @Override
    public void crearPaciente(Paciente e) throws PersistenceException {
        daoPaciente.save(e);
    }

    @Override
    public List<Paciente> consultarPacientes() throws ExcepcionServiciosSuscripciones {
        try {
            return daoPaciente.getPacientes();
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosSuscripciones("Error al realizar la consulta:"+ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public Paciente consultarPacientesPorId(int id, TipoIdentificacion tipoIdentificacion) throws  PersistenceException {
         return daoPaciente.getPacientesForId(id,tipoIdentificacion);
    }

    @Override
    public List<Paciente> consultarMenoresConEnfermedadContagiosa() throws PersistenceException {
       return daoPaciente.getMenoresConEnfermedad();
    }

    @Override
    public List<Consulta> consultarConsultas() {
        return daoConsulta.getConsultas();
    }
}
