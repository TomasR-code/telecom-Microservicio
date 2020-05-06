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
            Long numeroDomicilio) {
        if (domicilioPersistencia.getDomicilio(idProvincia, partido, localidad, barrio, calle,
                numeroDomicilio) == null) {
            /*
             * Simulo que existe en MuCallejero entonces lo agrego, empezar a validar desde
             * arriba
             */
            Optional<Provincia> provinciaEncontrada = provinciaRepository.findById(idProvincia);
            Partido partidoEncontrado = partidoPersistencia.getPartidoByNameAndIdProvincia(provinciaEncontrada.get(),
                    partido);
            if (partidoEncontrado != null) {
                Localidad localidadEncontrada = localidadPersistencia.getlocalidadByNameAndPartido(partidoEncontrado,
                        localidad);
                if (localidadEncontrada != null) {
                    Barrio barrioEncontrado = barrioPersistencia.getBarrioByNameAndLocalidad(localidadEncontrada,
                            barrio);
                    if (barrioEncontrado != null) {
                        Domicilio domicilioEncontrado = domicilioPersistencia.getDomicilioByBarrio(barrioEncontrado,
                                calle, numeroDomicilio);
                        if (domicilioEncontrado != null) {
                            System.out.println("Todo correcto");
                            return true;
                        } else {
                            System.out.println("Fue el domicilio");
                            return false;
                        }
                    }else{
                        System.out.println("Fue el barrio");
                        return false;
                    }

                } else {
                    System.out.println("Fue la localidad");
                    return false;
                }
            } else {
                System.out.println("Fue el partido");
                return false;
            }
        } else {
            return true;
        }
    }

}