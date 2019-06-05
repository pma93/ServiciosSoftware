package es.unican.ss.cliente;

import es.unican.ss.usweatherservice.GetHumidityRequest;
import es.unican.ss.usweatherservice.GetHumidityResponse;
import es.unican.ss.usweatherservice.GetTemperatureRequest;
import es.unican.ss.usweatherservice.GetTemperatureResponse;
import es.unican.ss.usweatherservice.USWeatherService;
import es.unican.ss.usweatherservice.USWeatherServicePortType;

public class Runner {

	public static void main(String[] args) {
		
		USWeatherService service = new USWeatherService();
		USWeatherServicePortType port = service.getUSWeatherServicePort();
		
		//Preguntamos por la temperatura de una ciudad
		GetTemperatureRequest gtrq = new GetTemperatureRequest();
		gtrq.setCity("Chicago");
		//Obtenemos la temperatura de esa ciudad
		GetTemperatureResponse gtrp = port.getTemperature(gtrq);
		System.out.println("Temperatura: "+gtrp.getTemperature());
		
		//Preguntamos por la huemedad relativa de una ciudad
		GetHumidityRequest ghrq = new GetHumidityRequest();
		ghrq.setCity("New York");
		//Obtenemos la humedad de esa ciudad
		GetHumidityResponse ghrp = port.getHumidity(ghrq);
		System.out.println("Humedad relativa: "+ghrp.getHumidity());

	}
}