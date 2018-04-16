/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientwsconverter;

import conv.NJC;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafael
 */
public class ClientWSConverter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NJC njc = new NJC();
        System.out.println(njc.conversorApplication(10));
        System.out.println(factorial(10));
        System.out.println(converter(10));
    }

    private static int factorial(int number) {
        fact.WSFactorial_Service service = new fact.WSFactorial_Service();
        fact.WSFactorial port = service.getWSFactorialPort();
        return port.factorial(number);
    }
    
    private static String converter(int number) {
        try {
            URL url = new URL("http://ws.docencia.ces.siani.es/a06/WSConverter/webresources/generic?number=" + number);
            URLConnection ur = url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(ur.getInputStream()));

            String line, res="";
            while ((line = br.readLine()) != null) {
                res += line;
            }
            br.close();
            return res;
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClientWSConverter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClientWSConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
