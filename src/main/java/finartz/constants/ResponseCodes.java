package finartz.constants;

public interface ResponseCodes {
	
	public static int SUCCESSFUL_RESPONSE_CODE = 0;
	public static int ROUTE_NOT_FOUND_CODE = 1;
	public static int REMAING_SEATS_EMPTY_CODE = 2;
	public static int FIELD_EMPTY_CODE = 3;
	public static int TICKET_NOT_FOUND_CODE = 4;
	public static int ERROR_RESPONSE_CODE = 999;
	
	public static String ROUTE_REMAIN_SEATS_EMPTY_MESSAGE = "Rota üzerinde boş koltuk yoktur!";
	public static String ROUTE_NOT_FOUND_MESSAGE = "İstediğiniz rota bulunamadı!";
	public static String TICKET_NOT_FOUND_MESSAGE = "İstediğiniz bilet bulunamadı!";
	public static String FIELD_EMPTY_MESSAGE = "Zorunlu alanları doldurmalısınız!";
	public static String SUCCESFUL_RESPONSE_MESSAGE = "Başarılı";
	public static String ERROR_RESPONSE_MESSAGE = "Hata!";
}
