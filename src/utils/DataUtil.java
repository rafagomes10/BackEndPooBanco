package src.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {

    public static String converterDateParaDataEHora(Date data){

        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/YYYY HH:mm");
        return formatador.format(data);

    }
    public static String converterDateParaData(Date data){

        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/YYYY");
        return formatador.format(data);

    }
    public static String converterDateParaHora(Date data){

        SimpleDateFormat formatador = new SimpleDateFormat("HH:mm:ss");
        return formatador.format(data);

    }
}
