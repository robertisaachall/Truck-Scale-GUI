/**
 *
 * @author Joseph Edward
 * @ID:tyv379
 * @Date:02/19/2020
 * @version: 1.0
 */
public class TruckScale {
public static final double TRUCKCLASSA = 80;
public static final double TRUCKCLASSB = 120;
public static final double TRUCKCLASSC = 180;
private double truckWeight;
private double truckSize;
private double axelNumber;
private double toPrice;
private int truckClassWeight;

    
    public TruckScale(double newWeight, double newSize, int newAxel, int classWeight)
    {
        truckWeight = newWeight;
        truckSize = newSize;
        axelNumber = newAxel;
        truckClassWeight = classWeight;
        
    }
        public TruckScale()
    {
        truckWeight = 18000.0;
        truckSize = 11.0;
        axelNumber = 3.0;
        
    }
    public void setTruckWeight(double newWeight)
    {
        this.truckWeight = newWeight;
    }
    public double getTruckWeight()
    {
        return truckWeight;
    }
    public void setTruckSize(double newSize)
    {
        this.truckSize = newSize;
    }
    public double getTruckSize()
    {
        return truckSize;
    }
    public void setAxelNumber(double newAxel)
    {
        this.axelNumber = newAxel;
    }
    public double getAxelNumber()
    {
        return axelNumber;
    }
 
    public double ToFinal(double toPrice)
    {
        toPrice = (axelNumber/(truckWeight * truckSize));
        return toPrice;
    }
    public double ToPrice()
    {
      double toTruck = truckWeight / axelNumber * (truckSize / truckClassWeight);
      return toTruck;
      
    }
}