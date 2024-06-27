package model.entities;

import model.exceptions.DomainExceptions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer numeroQuarto;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer numeroQuarto, Date checkIn, Date checkOut) {
        if(!checkOut.after(checkIn)){
            throw new DomainExceptions("O check-out só pode ser depois do check-in!");
        }

        this.numeroQuarto = numeroQuarto;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    //conversão de millisegundos para dias
    public long duration(){
        Date agora = new Date();
        if(checkIn.before(agora) || checkOut.before(agora)){
            throw new DomainExceptions("Somente datas futuras!");
        }
        long diff = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkIn, Date checkOut){
        Date agora = new Date();
        if(checkIn.before(agora) || checkOut.before(agora)){
            throw new DomainExceptions("Cadastrar somente datas futuras!");
        }
        if(!checkOut.after(checkIn)){
            throw new DomainExceptions("O check-out só pode ser depois do check-in!");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString(){
        return "Quarto: " +
                numeroQuarto +
                ", Check-in: " +
                sdf.format(checkIn) +
                ", Check-out: "
                + sdf.format(checkOut) +
                ", " + duration() + " noites";
    }
}
