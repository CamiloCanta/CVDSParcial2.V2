package edu.eci.pdsw.samples.managedbeans;

import com.google.inject.Inject;
import edu.eci.pdsw.samples.services.ServiciosPaciente;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@SuppressWarnings("deprecation")
@ManagedBean(name = "consulta")
@RequestScoped
public class ConsultasBean extends BasePageBean{

    @Inject
    ServiciosPaciente serviciosPaciente;
}
