package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class CalculatorA {

    private double seats;
    private String classseat;
    private double economybasefare;
    private double preeconomybasefare;
    private double buisnessbasefare;
    private double firstclassbasefare;
    private double mindouble;
    private double maxdouble;
    private double fareps;
    private double totalfarebs;
    private double tax;
    private double basefstax;
    private double fstax;
    private double passfc;
    private double passfcX;
    private double chargeperkg;
    private double total;
    private double luggageweight;
    private double luggagecost;

    Random random = new Random();

    public CalculatorA() {
        seats=0;
        classseat="not initialized";

        economybasefare=500.0;
        preeconomybasefare=750.0;
        buisnessbasefare=1500.0;
        firstclassbasefare=2500.0;
        mindouble =100.0;
        maxdouble=500.0;
        basefstax=4.50;
        passfc=4.50;
        chargeperkg=3.00;
        fareps=0.0;
        totalfarebs=0.0;
        tax=0.0;
        total=0.0;
        luggageweight=0.0;
        luggagecost=0.0;
    }
    

    public void initinput(){
        try {
            BufferedReader reader=new BufferedReader(new FileReader("TempInfo.txt"));
            String line;
            int linenum=0;
            while ((line=reader.readLine())!=null) {
                linenum++;
                if(linenum==10) {
                    this.seats=Double.parseDouble(line);
                    
                }
                if(linenum==16) {
                    this.classseat=line;
                    
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




    public void fareCalculate() {

        if(classseat.equalsIgnoreCase("Economy")) {
            double randomDouble = mindouble + (maxdouble - mindouble) * random.nextDouble();
            this.fareps=economybasefare+randomDouble;
            this.totalfarebs=fareps*seats;
        }

        else if(classseat.equalsIgnoreCase("Premium Economy")) {
            double randomDouble = mindouble + (maxdouble - mindouble) * random.nextDouble();
            this.fareps=preeconomybasefare+(randomDouble*2.0);
            this.totalfarebs=fareps*seats;
        }

        else if(classseat.equalsIgnoreCase("Business")) {
            double randomDouble = mindouble + (maxdouble - mindouble) * random.nextDouble();
            this.fareps=buisnessbasefare+(randomDouble*4.0);
            this.totalfarebs=fareps*seats;
        }

        else if(classseat.equalsIgnoreCase("First Class")) {
            double randomDouble = mindouble + (maxdouble - mindouble) * random.nextDouble();
            this.fareps=firstclassbasefare+(randomDouble*8.0);
            this.totalfarebs=fareps*seats;
        }

    }
        public void luggagecount(){
            if(luggageweight>30.0) {
                this.luggagecost=(this.luggageweight-30)*chargeperkg;
               
            }
            else {
                this.luggagecost=0.0;
            }
        }
    public void totalCalculate(){
        this.tax=totalfarebs*(15.0/100.0);
        this.fstax=basefstax*seats;
         this.passfcX=passfc*seats;
        this.total=totalfarebs+tax+fstax+luggagecost+passfcX;
    }

    public double getSeats() {
        return seats;
    }

    public void setSeats(double seats) {
        this.seats = seats;
    }

    public String getClassseat() {
        return classseat;
    }

    public void setClassseat(String classseat) {
        this.classseat = classseat;
    }

    public double getEconomybasefare() {
        return economybasefare;
    }

    public void setEconomybasefare(double economybasefare) {
        this.economybasefare = economybasefare;
    }

    public double getPreeconomybasefare() {
        return preeconomybasefare;
    }

    public void setPreeconomybasefare(double preeconomybasefare) {
        this.preeconomybasefare = preeconomybasefare;
    }

    public double getBuisnessbasefare() {
        return buisnessbasefare;
    }

    public void setBuisnessbasefare(double buisnessbasefare) {
        this.buisnessbasefare = buisnessbasefare;
    }

    public double getFirstclassbasefare() {
        return firstclassbasefare;
    }

    public void setFirstclassbasefare(double firstclassbasefare) {
        this.firstclassbasefare = firstclassbasefare;
    }

    public double getMindouble() {
        return mindouble;
    }

    public void setMindouble(double mindouble) {
        this.mindouble = mindouble;
    }

    public double getMaxdouble() {
        return maxdouble;
    }

    public void setMaxdouble(double maxdouble) {
        this.maxdouble = maxdouble;
    }

    public double getFareps() {
        return fareps;
    }

    public void setFareps(double fareps) {
        this.fareps = fareps;
    }

    public double getTotalfarebs() {
        return totalfarebs;
    }

    public void setTotalfarebs(double totalfarebs) {
        this.totalfarebs = totalfarebs;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getBasefstax() {
        return basefstax;
    }

    public void setBasefstax(double basefstax) {
        this.basefstax = basefstax;
    }

    public double getFstax() {
        return fstax;
    }

    public void setFstax(double fstax) {
        this.fstax = fstax;
    }

    public double getPassfc() {
        return passfc;
    }

    public void setPassfc(double passfc) {
        this.passfc = passfc;
    }

    public double getPassfcX() {
        return passfcX;
    }

    public void setPassfcX(double passfcX) {
        this.passfcX = passfcX;
    }

    public double getChargeperkg() {
        return chargeperkg;
    }

    public void setChargeperkg(double chargeperkg) {
        this.chargeperkg = chargeperkg;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getLuggageweight() {
        return luggageweight;
    }

    public void setLuggageweight(double luggageweight) {
        this.luggageweight = luggageweight;
    }

    public double getLuggagecost() {
        return luggagecost;
    }

    public void setLuggagecost(double luggagecost) {
        this.luggagecost = luggagecost;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }
}
