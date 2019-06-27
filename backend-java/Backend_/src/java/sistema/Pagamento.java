package sistema;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import org.json.JSONArray;
import sistema.dao.pagamentoDAO;

public class Pagamento {

    private int id;
    private Date dataPagto;
    private Date dataRegistro;
    private int OSId;

    private static pagamentoDAO dao;

    public Pagamento() {
    }

    public Pagamento(Date dataPagto, Date dataRegistro, int OSId) {
        this.dataPagto = dataPagto;
        this.dataRegistro = dataRegistro;
        this.OSId = OSId;
    }

    public String getDataPagto() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(dataPagto);
    }

    public void setDataPagto(Date dataPagto) throws ParseException {
        this.dataPagto = dataPagto;
    }

    public String getDataRegistro() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(dataRegistro);
    }

    public void setDataRegistro(Date dataRegistro) throws ParseException {
        this.dataRegistro = dataRegistro;
    }

    public int getOSId() {
        return OSId;
    }

    public void setOSId(int OSId) {
        this.OSId = OSId;
    }

    public static JSONArray methods(String method, Pagamento pgto) {
        JSONArray jsRet = new JSONArray();
        Pagamento.dao = new pagamentoDAO();
        switch (method) {
            case "getAll":
                jsRet = dao.getAll();
                break;
            case "insert":
                jsRet = dao.insert();
                break;
        }

        return jsRet;
    }

}
