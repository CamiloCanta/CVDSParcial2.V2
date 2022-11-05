/*
 * Copyright (C) 2016 hcadavid
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
package edu.eci.pdsw.samples.managedbeans;

import com.google.inject.Inject;
import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.entities.TipoIdentificacion;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import edu.eci.pdsw.samples.services.ExcepcionServiciosSuscripciones;
import edu.eci.pdsw.samples.services.ServiciosPaciente;
import edu.eci.pdsw.samples.services.ServiciosPacientesFactory;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author hcadavid
 */
@SuppressWarnings("deprecation")
@ManagedBean(name = "mb")
@RequestScoped
public class PacientesBean extends BasePageBean {


    @Inject
    ServiciosPaciente serviciosPaciente;

    TipoIdentificacion tipoIdentificacion = TipoIdentificacion.CC;

    public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public TipoIdentificacion getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public TipoIdentificacion[] getTiposIdentificacion() {
        return TipoIdentificacion.values();
    }

    public List<Paciente> getData() throws Exception {
        try {
            return serviciosPaciente.consultarPacientes();
        } catch (ExcepcionServiciosSuscripciones ex) {
            throw ex;
        }

    }

    public Paciente getPacienteForName(int id, TipoIdentificacion tipo) throws PersistenceException, ExcepcionServiciosSuscripciones {
        return serviciosPaciente.consultarPacientesPorId(id, tipo);
    }

    public List<Paciente> getconsultarMenoresConEnfermedadContagiosa() throws PersistenceException, ExcepcionServiciosSuscripciones {
        return serviciosPaciente.consultarMenoresConEnfermedadContagiosa();
    }
}


    

