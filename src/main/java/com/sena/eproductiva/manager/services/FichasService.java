package com.sena.eproductiva.manager.services;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sena.eproductiva.manager.models.dto.FichaDto;
import com.sena.eproductiva.manager.models.dto.PageDto;
import com.sena.eproductiva.manager.models.entitys.Ficha;
import com.sena.eproductiva.manager.repositories.FichasRepository;

@Service
public class FichasService {

    @Autowired
    private FichasRepository fichasRepository;

    @Autowired
    ProgramasFormacionService programasFormacionService;

    @Autowired
    CentroFormacionService centroFormacionService;

    @Autowired
    InstructorService instructorService;

    /**
     * 
     * @return
     */
    public List<Ficha> getAllFichas() {
        return fichasRepository.findAll();
    }

    /**
     * 
     * @param id
     * @return
     */
    public Ficha getFichaById(String id) {
        return fichasRepository.findFichaByAnyId(id).orElse(null);
    }


    private Date castDate(String date){
        Date fecha;
        try {
            fecha = new SimpleDateFormat("dd/MM/yyyy").parse(date);
            return fecha;
        } catch (ParseException e) {
            fecha = new Date();
        }
        return fecha;

    }
    /**
     * 
     * @param fichaDto
     * @param id
     * @return
     */
    public Ficha updateFicha(FichaDto fichaDto, String id) {
        Ficha ficha = getFichaById(id);
        if (Objects.isNull(ficha))
            ficha = new Ficha();
        ficha.setId(fichaDto.getId());
        ficha.setProgramaFormacionEntity(
            programasFormacionService.getProgramasFormacionByName(fichaDto.getProgramaId()));
        ficha.setCentroFormacionEntity(
            centroFormacionService.getCentroFormacionById(fichaDto.getCentroId()));
        ficha.setInstructorEntity(instructorService.getInstructorByDocumento(fichaDto.getInstructor()));
        ficha.setModalidad(fichaDto.getModalidad());
        ficha.setInicio(castDate(fichaDto.getInicio()));
        ficha.setFin(castDate(fichaDto.getFin()));
        ficha.setEnabled(fichaDto.isEnabled());
        return fichasRepository.save(ficha);
    }

    /**
     * 
     * @param fichaDto
     * @return
     */
    public Ficha createFicha(FichaDto fichaDto) {
        return updateFicha(fichaDto, null);
    }


    private String castString(Date fecha){
        try {
            DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
            String finalDate = date.format(fecha);
            return finalDate;
        } catch (Exception e) {
            Date localDate = new Date();
            DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
            String finalDate = date.format(localDate);
            return finalDate;
        }
    }
    /**
     * 
     * @param ficha
     * @return
     */
    public FichaDto transfomrDto(Ficha ficha) {
        FichaDto dto = new FichaDto();
        dto.setId(ficha.getId());
        dto.setProgramaId(ficha.getProgramaFormacionEntity().getId());
        // System.out.println("valor centro" + ficha.getCentroFormacionEntity().getUuid());
        dto.setCentroId(ficha.getCentroFormacionEntity().getUuid());
        dto.setInstructor(ficha.getInstructorEntity().getDocumento());
        dto.setModalidad(ficha.getModalidad());
        dto.setInicio(castString(ficha.getInicio()));
        dto.setFin(castString(ficha.getFin()));
        dto.setEnabled(ficha.isEnabled());
        return dto;
    }

    /**
     * 
     * @param fichas
     * @return
     */
    public List<FichaDto> transformListDto(List<Ficha> fichas) {
        return fichas.stream().map(this::transfomrDto).collect(Collectors.toList());
    }

    /**
     * 
     * @param pageable
     * @return
     */
    public Page<Ficha> getPageFicha(Pageable pageable) {
        return fichasRepository.findAll(pageable);
    }

    /**
     * 
     * @param page
     * @param size
     * @return
     */
    public PageDto<FichaDto> getFichasDtoPage(int page, int size) {
        Page<Ficha> ficha = getPageFicha(PageRequest.of(page, size));
        PageDto<FichaDto> pageDto = new PageDto<>();
        pageDto.setContent(this.transformListDto(ficha.getContent()));
        return pageDto;
    }

    /**
     * 
     * @param fichaDto
     * @return
     */

    public boolean validateExist(FichaDto fichaDto) {
        return Objects.isNull(fichaDto.getId()) ||
                Objects.isNull(fichaDto.getCentroId()) ||
                Objects.isNull(fichaDto.getProgramaId()) ||
                Objects.isNull(fichaDto.getInstructor());
    }

    /**
     * 
     * @param id
     */
    public void disabledFicha(String id) {
        Ficha ficha = this.getFichaById(id);
        ficha.setEnabled(false);
        fichasRepository.save(ficha);
    }
}