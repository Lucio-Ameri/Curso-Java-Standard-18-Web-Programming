package MODULO_6.Desafio.Ejercicio1;

public class CargadorDatosPrueba{
    private final PaisDAO paisDAO;
    private final CiudadDAO ciudadDAO;

    private static final String[][] PAISES_Y_CIUDADES = {
            {"Argentina", "Buenos Aires"},
            {"Brasil", "São Paulo"},
            {"Uruguay", "Montevideo"},
            {"Chile", "Santiago"},
            {"Paraguay", "Asunción"},
            {"Bolivia", "La Paz"},
            {"Perú", "Lima"},
            {"Ecuador", "Quito"},
            {"Colombia", "Bogotá"},
            {"Venezuela", "Caracas"},
            {"México", "Ciudad de México"},
            {"Estados Unidos", "Nueva York"},
            {"Canadá", "Toronto"},
            {"España", "Madrid"},
            {"Francia", "París"},
            {"Italia", "Roma"},
            {"Alemania", "Berlín"},
            {"Portugal", "Lisboa"},
            {"Reino Unido", "Londres"},
            {"Irlanda", "Dublín"},
            {"Países Bajos", "Ámsterdam"},
            {"Bélgica", "Bruselas"},
            {"Suiza", "Zúrich"},
            {"Austria", "Viena"},
            {"Polonia", "Varsovia"},
            {"República Checa", "Praga"},
            {"Hungría", "Budapest"},
            {"Grecia", "Atenas"},
            {"Turquía", "Estambul"},
            {"Rusia", "Moscú"},
            {"China", "Shanghái"},
            {"Japón", "Tokio"},
            {"Corea del Sur", "Seúl"},
            {"India", "Mumbai"},
            {"Pakistán", "Karachi"},
            {"Indonesia", "Yakarta"},
            {"Filipinas", "Manila"},
            {"Tailandia", "Bangkok"},
            {"Vietnam", "Hanói"},
            {"Australia", "Sídney"},
            {"Nueva Zelanda", "Auckland"},
            {"Sudáfrica", "Ciudad del Cabo"},
            {"Egipto", "El Cairo"},
            {"Marruecos", "Casablanca"},
            {"Nigeria", "Lagos"},
            {"Kenia", "Nairobi"},
            {"Arabia Saudita", "Riad"},
            {"Emiratos Árabes Unidos", "Dubái"},
            {"Israel", "Tel Aviv"},
            {"Suecia", "Estocolmo"}
    };

    public CargadorDatosPrueba(PaisDAO paisDAO, CiudadDAO ciudadDAO){
        this.paisDAO = paisDAO;
        this.ciudadDAO = ciudadDAO;
    }

    public void cargarPaisesYCiudades(){
        if(!InicializadorBD.crearBaseYTablas()){
            System.out.println("No se pudo preparar la base de datos. Revise la conexión.");
            return;
        }

        System.out.println("Cargando países y ciudades de prueba...");

        for(String[] dato : PAISES_Y_CIUDADES){
            String descripcionPais = dato[0];
            String descripcionCiudad = dato[1];

            Long paisId = paisDAO.guardarSiNoExiste(descripcionPais);

            if(paisId == null){
                System.out.println("No se pudo guardar el país: " + descripcionPais);
                continue;
            }

            Long ciudadId = ciudadDAO.guardarSiNoExiste(paisId, descripcionCiudad);

            if(ciudadId == null){
                System.out.println("No se pudo guardar la ciudad: " + descripcionCiudad);
                continue;
            }

            System.out.println("OK -> " + descripcionPais + " / " + descripcionCiudad);
        }

        System.out.println("Carga finalizada. Se aseguraron " + PAISES_Y_CIUDADES.length + " países y " + PAISES_Y_CIUDADES.length + " ciudades.");
    }
}
