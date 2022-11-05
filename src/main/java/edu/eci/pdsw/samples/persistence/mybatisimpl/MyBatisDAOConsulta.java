package edu.eci.pdsw.samples.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.pdsw.samples.entities.Consulta;
import edu.eci.pdsw.samples.persistence.DaoConsulta;
import edu.eci.pdsw.samples.persistence.mybatisimpl.mappers.ConsultaMapper;
import edu.eci.pdsw.samples.persistence.mybatisimpl.mappers.PacienteMapper;

import java.util.List;

public class MyBatisDAOConsulta implements DaoConsulta {

    @Inject
    ConsultaMapper consultaMapper;

    @Override
    public List<Consulta> getConsultas() {
        return consultaMapper.getConsultas();
    }
}
