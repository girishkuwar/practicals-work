import java.util.ArrayList;
class CurrentConditionsDisplay implements Observer, DisplayElement 
{
	private float temperature;
    	private float humidity;
    	private Subject weatherData;
    	public CurrentConditionsDisplay(Subject weatherData) 
	{
        		this.weatherData = weatherData;
        		weatherData.registerObserver(this);
    	}
    	public void update(float temperature, float humidity, float pressure) 
	{
        		this.temperature = temperature;
        		this.humidity = humidity;
        		display();
    	}
    	public void display() 
	{
        		System.out.println("Current conditions: " + temperature+ "F degrees and " + humidity + "% humidity");
    	}
}
interface DisplayElement 
{
    	public void display();
}
class ForecastDisplay implements Observer, DisplayElement 
{
    	private float currentPressure = 29.92f;
    	private float lastPressure;
    	private WeatherData weatherData;
    	public ForecastDisplay(WeatherData weatherData) 
	{
        		this.weatherData = weatherData;
        		weatherData.registerObserver(this);
    	}
    	public void update(float temp, float humidity, float pressure) 
	{
        		lastPressure = currentPressure;
        		currentPressure = pressure;
       		display();
    	}
    	public void display() 
	{
        		System.out.print("Forecast: ");
        		if (currentPressure > lastPressure) 
		{
            			System.out.println("Improving weather on the way!");
        		} 
		else if (currentPressure == lastPressure) 
		{
            			System.out.println("More of the same");
        		} 
		else if (currentPressure < lastPressure) 
		{
            			System.out.println("Watch out for cooler, rainy weather");
        		}
    	}
}
interface Observer 
{
   	public void update(float temp, float humidity, float pressure);
}
class StatisticsDisplay implements Observer, DisplayElement 
{
    	private float maxTemp = 0.0f;
    	private float minTemp = 200;
    	private float tempSum = 0.0f;
    	private int numReadings;
    	private WeatherData weatherData;
    	public StatisticsDisplay(WeatherData weatherData) 
	{
        		this.weatherData = weatherData;
        		weatherData.registerObserver(this);
    	}
	public void update(float temp, float humidity, float pressure) 
	{
        		tempSum += temp;
        		numReadings++;
	        	if (temp > maxTemp) 
		{
            			maxTemp = temp;
        		}
        		if (temp < minTemp) 
		{
            			minTemp = temp;
        		}
        		display();
    	}
    	public void display() 
	{
        		System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings)+ "/" + maxTemp + "/" + minTemp);
    	}
}
interface Subject 
{
    	public void registerObserver(Observer o);
    	public void removeObserver(Observer o);
    	public void notifyObservers();
}
class WeatherData implements Subject 
{
    	private ArrayList<Observer> observers;
    	private float temperature;
    	private float humidity;
    	private float pressure;
    	public WeatherData() 
	{
        		observers = new ArrayList<>();
    	}
    	public void registerObserver(Observer o) 
	{
        		observers.add(o);
    	}
    	public void removeObserver(Observer o) 
	{
        		int i = observers.indexOf(o);
        		if (i >= 0) 
		{
            			observers.remove(i);
        		}
    	}
    	public void notifyObservers() 	
	{
        		for (int i = 0; i < observers.size(); i++) 
		{
            			Observer observer = (Observer) observers.get(i);
            			observer.update(temperature, humidity, pressure);
        		}
    	}
    	public void measurementsChanged() 
	{
        		notifyObservers();
    	}
    	public void setMeasurements(float temperature, float humidity, float pressure) 
	{
        		this.temperature = temperature;
        		this.humidity = humidity;
        		this.pressure = pressure;
        		measurementsChanged();
    	}
    	public float getTemperature() 
	{
        		return temperature;
    	}
    	public float getHumidity() 
	{
        		return humidity;
    	}
    	public float getPressure() 
	{
        		return pressure;
    	}
}
public class WeatherStation 
{
    	public static void main(String[] args) 
	{
        		WeatherData weatherData = new WeatherData();
        		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
        		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        		weatherData.setMeasurements(80, 65, 30.4f);
        		weatherData.setMeasurements(82, 70, 29.2f);
        		weatherData.setMeasurements(78, 90, 29.2f);
    	}
}
