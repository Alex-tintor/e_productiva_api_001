package com.sena.eproductiva.manager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sena.eproductiva.manager.models.dto.CentroFormacionDto;
import com.sena.eproductiva.manager.models.dto.PageDto;
import com.sena.eproductiva.manager.models.entitys.Centro;
import com.sena.eproductiva.manager.repositories.CentroFormacionRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CentroFormacionService {

    @Autowired
    private CentroFormacionRepository centroFormacionRepository;

    /**
     * Metodo que devuelve todo de Centro
     * 
     * @return retorna una lista de tipo Centro
     */
    public List<Centro> getAllCentroFormacion() {
        return centroFormacionRepository.findAll();
    }

    /**
     * Metodo que devuelve un solo registro de Centro
     * 
     * @param id resive el id del Centro a consultar
     * @return retorna un tipo Centro
     */
    public Centro getCentroFormacionById(String id) {
        return centroFormacionRepository.findByName(id).orElse(null);
    }

    /**
     * Metodo que actualiza los atributos de un registro en la entidad Centro
     * 
     * @param centroFormacionDto recibe el Dto de CentroFormacion
     * @param id                 resive el identificador del Centro a actualizar
     * @return retorna el Centro con los cambios guardados
     */
    public Centro updateCentro(CentroFormacionDto centroFormacionDto, String id) {
        Centro centro = this.getCentroFormacionById(id);
        if (Objects.isNull(centro))
            centro = new Centro();
        centro.setUuid(centroFormacionDto.getUuid());
        centro.setNombre(centroFormacionDto.getNombre());
        centro.setEnabled(centroFormacionDto.isEnabled());
        return centroFormacionRepository.save(centro);
    }

    /**
     * Metodo que crea un nuevo Centro
     * 
     * @param centroFormacionDto resive el Dto de CentroFormacion
     * @return retorna el Centro creado
     */
    public Centro createCentro(CentroFormacionDto centroFormacionDto) {
        return updateCentro(centroFormacionDto, null);
    }

    /**
     * Metodo para transformar el Dto apartir de la entidad
     * 
     * @param centro resive la entidad Centro
     * @return retorna el Dto setiado
     */
    public CentroFormacionDto transformDto(Centro centro) {
        CentroFormacionDto dto = new CentroFormacionDto();
        dto.setUuid(centro.getUuid());
        dto.setNombre(centro.getNombre());
        dto.setEnabled(centro.isEnabled());
        return dto;
    }

    /**
     * Metodo que retorna una lista de CentroFormacionDto
     * 
     * @param centros resive una lista de la entidad Centro
     * @return retorna una lista de CentroFormacionDto
     */
    public List<CentroFormacionDto> transformListDtos(List<Centro> centros) {
        return centros.stream().map(this::transformDto).collect(Collectors.toList());
    }

    /**
     * Metodo para retornar las paginas de Centro
     * 
     * @param pageable resive un objeto Pageable
     * @return retorna las paginas de Centro
     */
    public Page<Centro> getPageCentro(Pageable pageable) {
        return centroFormacionRepository.findAll(pageable);
    }

    /**
     * Metodo para devlover la paginacion de CentroFormacion
     * 
     * @param page resive el numero de pagina
     * @param size resive el tamaño de la pagina
     * @return retorna la paginacion de CentroFormacion
     */
    public PageDto<CentroFormacionDto> getPageDtoCentro(int page, int size) {
        Page<Centro> centro = getPageCentro(PageRequest.of(page, size));
        PageDto<CentroFormacionDto> pageDto = new PageDto<>();
        pageDto.setContent(this.transformListDtos(centro.getContent()));
        return pageDto;
    }

    /**
     * Metodo para verificar la existencia de un CentroFormacion
     * 
     * @param centro resive un CentroFormacionDto
     * @return retorna falso si el objeto no existe y verdadero si existe
     */
    public boolean validateExist(CentroFormacionDto centro) {
        return Objects.isNull(centro.getNombre()) ||
                Objects.isNull(centro.getUuid());
    }

    /**
     * Metodo para deshabilitar un Centro por medio de un id
     * 
     * @param id resive el id de un CentroFormacion
     */
    public void disableCentro(String id) {
        Centro centro = this.getCentroFormacionById(id);
        centro.setEnabled(false);
        centroFormacionRepository.save(centro);
    }

}