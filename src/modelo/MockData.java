package modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MockData {
    // - Parámetros para datos
    // Parámetros para Candidatos
    ArrayList<String> nacionalidadesPrimerCandidato = new ArrayList<>(Arrays.asList("Argentino", "Italiano"));
    ArrayList<String> nacionalidadesSegundoCandidato = new ArrayList<>(Arrays.asList("Uruguayo"));

    ArrayList<String> idiomasPrimerCandidato = new ArrayList<>(Arrays.asList("Español", "Inglés", "Italiano"));
    ArrayList<String> idiomasSegundoCandidato = new ArrayList<>(Arrays.asList("Español"));

    ArrayList<String> interesesPrimerCandidato = new ArrayList<>(Arrays.asList("Informática", "Sistemas", "Videojuegos"));
    ArrayList<String> interesesSegundoCandidato = new ArrayList<>(Arrays.asList("Música", "Arquitectura"));

    // Parámetros para Empresas
    ArrayList<Publicacion> publicacionesPrimeraEmpresa = new ArrayList<>(Arrays.asList());
    ArrayList<Publicacion> publicacionesSegundaEmpresa = new ArrayList<>(Arrays.asList());

    // Parámetros para Publicaciones
    List<String> requisitosPrimeraPublicacion = Arrays.asList("+3 años de experiencia", "Buenas prácticas de programación");
    List<String> requisitosSegundaPublicacion = Arrays.asList("Inglés avanzado");
    List<String> requisitosTerceraPublicacion = Arrays.asList("Inglés avanzado", "Proactividad");

    List<Postulacion> postulacionesPrimeraPublicacion = Arrays.asList();
    List<Postulacion> postulacionesSegundaPublicacion = Arrays.asList();

    List<String> tareas = Arrays.asList("Desarrollo de funcionalidades", "Comunicación con el cliente");

    // - Datos mockeados
    Candidato primerCandidato = new Candidato("Juan", "Pérez", new Date(1997, 2, 24), 30172645, nacionalidadesPrimerCandidato, idiomasPrimerCandidato, interesesPrimerCandidato);
    Candidato segundoCandidato = new Candidato("Pedro", "González", new Date(1997, 2, 24), 30172645, nacionalidadesSegundoCandidato, idiomasSegundoCandidato, interesesSegundoCandidato);

    Empresa primeraEmpresa = new Empresa("UADE S.R.L", 53918765, publicacionesPrimeraEmpresa);
    Empresa segundaEmpresa = new Empresa("Grupo 6 S.A", 1234567, publicacionesSegundaEmpresa);

    Publicacion primeraPublicacion = new Publicacion(postulacionesPrimeraPublicacion, "Desarrollador front-end", tareas, Publicacion.ModalidadContrato.FULL_TIME, Publicacion.TipoTrabajo.REMOTO, "Casa", "Sistemas", requisitosPrimeraPublicacion, new Float(150000.87), true);
    Publicacion segundaPublicacion = new Publicacion(postulacionesSegundaPublicacion, "Arquitecto de software", tareas, Publicacion.ModalidadContrato.PART_TIME, Publicacion.TipoTrabajo.PRESENCIAL, "Oficina", "Sistemas", requisitosSegundaPublicacion, new Float(150000.87), true);

    Postulacion primeraPostulacion = new Postulacion(new Date(2021, 11, 14), primerCandidato, new Float(100000.01));
    Postulacion segundaPostulacion = new Postulacion(new Date(2021, 12, 25), primerCandidato, new Float(125000.13));
    Postulacion terceraPostulacion = new Postulacion(new Date(2021, 12, 25), segundoCandidato, new Float(125000.13));
}