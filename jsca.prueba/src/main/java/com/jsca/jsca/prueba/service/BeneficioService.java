package com.jsca.jsca.prueba.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsca.jsca.prueba.model.Beneficio;
import com.jsca.jsca.prueba.repository.BeneficioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.*;

@Service
public class BeneficioService {
    @Autowired
    BeneficioRepository beneficioRepository;
    private final ObjectMapper objectMapper;

    public BeneficioService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public void cargarBeneficiosDesdeJSON(String rutaArchivoJSON) {
        try {
            Beneficio[] beneficios = objectMapper.readValue(new File(rutaArchivoJSON), Beneficio[].class);
            beneficioRepository.saveAll(Arrays.asList(beneficios));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Beneficio> cargarBeneficiosDesdeXML(String rutaArchivoXML) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File(rutaArchivoXML));
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("beneficio");
            List<Beneficio> beneficios = new ArrayList<>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                String nombreBeneficio = element.getTextContent();
                Beneficio beneficio = new Beneficio();
                beneficio.setBeneficio(nombreBeneficio);
                beneficios.add(beneficio);
            }
            return beneficios;
        } catch (Exception e) {
            return List.of();
        }
    }

    public String asignarBeneficio() {
        List<Beneficio> beneficiosDisponibles = beneficioRepository.findAll(); // Obtener todos los beneficios disponibles

        if (!beneficiosDisponibles.isEmpty()) {
            Beneficio beneficioAsignado = beneficiosDisponibles.get(0);
            beneficiosDisponibles.remove(0);
            beneficioRepository.saveAll(beneficiosDisponibles);
            return beneficioAsignado.getBeneficio(); // Devuelve el nombre del beneficio asignado
        } else {
            return "Sin beneficios disponibles";
        }
    }
}
