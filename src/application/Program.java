package application;

import model.entities.Reservation;
import model.exceptions.DomainExceptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args){

        Scanner dg = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("***** hotel sono tranquilo *****".toUpperCase());
        System.out.println();

        try {
            //cadastro
            System.out.print("Número do quarto: ");
            int numero = dg.nextInt();
            System.out.print("Check-in (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(dg.next());
            System.out.print("Check-out (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(dg.next());

            Reservation reservation = new Reservation(numero,checkIn,checkOut);
            System.out.println("Reservation: " + reservation);

            //atualização
            System.out.println();
            System.out.println("Digite as datas para atualização da reserva:");
            System.out.print("Check-in (dd/MM/yyyy): ");
            checkIn = sdf.parse(dg.next());
            System.out.print("Check-out (dd/MM/yyyy): ");
            checkOut = sdf.parse(dg.next());

            reservation.updateDates(checkIn,checkOut);
            System.out.println("Reservation: " + reservation);
gi
        } catch (ParseException e) {
            System.out.println("Formato de data inválido!");;
        } catch(DomainExceptions e){
            System.out.println("Erro na reserva: " + e.getMessage());
        } catch(RuntimeException e){
            System.out.println("Erro inesperado!");
        }
        dg.close();
    }
}
