import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.io.InputStream;
import java.net.UnknownHostException;


class DateTime {

    public static void main(String[] args) throws IOException {

        String address = "time.nist.gov";
        int port = 13;

        /*
        Utwórz gniazdo na porcie przypisanym dla protokołu  DAYTIME, pobierz z niego strumień wejściowy i odczytaj odpowiedź serwera.
        Nie zapomnij o zamknięciu strumienia i gniazda.
        */

        try {
            Socket socket = new Socket(address,port);

            InputStream timeStream = socket.getInputStream();
            StringBuffer time = new StringBuffer();

            int c;
            while ((c = timeStream.read()) != -1)
                time.append((char) c);

            String timeString = time.toString().trim();
            System.out.println(timeString);

            socket.shutdownInput();
            socket.close();

        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
