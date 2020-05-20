package com.telecom.telecom.service;

import java.util.Optional;

import com.telecom.telecom.model.Barrio;
import com.telecom.telecom.model.Domicilio;
import com.telecom.telecom.model.Localidad;
import com.telecom.telecom.model.Partido;
import com.telecom.telecom.model.Provincia;
import com.telecom.telecom.persistencia.BarrioPersistencia;
import com.telecom.telecom.persistencia.DomicilioPersistencia;
import com.telecom.telecom.persistencia.LocalidadPersistencia;
import com.telecom.telecom.persistencia.PartidoPersistencia;
import com.telecom.telecom.repository.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasePropiaService {

    @Autowired
    ProvinciaRepository provinciaRepository;

    @Autowired
    PartidoPersistencia partidoPersistencia;

    @Autowired
    LocalidadPersistencia localidadPersistencia;

    @Autowired
    BarrioPersistencia barrioPersistencia;

    @Autowired
    DomicilioPersistencia domicilioPersistencia;

    public boolean buscarEnNuestraBase(long idProvincia, String partido, String localidad, String barrio, String calle,
            Integer numeroDomicilio) {
        if (domicilioPersistencia.getDomicilio(idProvincia, partido, localidad, barrio, calle,
                numeroDomicilio) == null) {
            Optional<Provincia> provinciaEncontrada = provinciaRepository.findById(idProvincia);
            Partido partidoEncontrado = partidoPersistencia.getPartidoByNameAndIdProvincia(provinciaEncontrada.get(),
                    partido);
            Localidad localidadEncontrada = localidadPersistencia.getlocalidadByNameAndPartido(partidoEncontrado,
                    localidad);
            Barrio barrioEncontrado = barrioPersistencia.getBarrioByNameAndLocalidad(localidadEncontrada, barrio);
            Domicilio domicilioEncontrado = domicilioPersistencia.getDomicilioByBarrio(barrioEncontrado, calle,
                    numeroDomicilio);
                    return false;
          /*   if () {
                partidoEncontrado.setNombrePartido(partido);

            } else if (localidadEncontrada == null) {

            } else if (barrioEncontrado == null) {

            } else if (domicilioEncontrado == null) {

            } */
        } else {
            return true;
        }
    }

}