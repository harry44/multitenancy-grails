package it.myrent.ee.api.utils;

/**
 * Created by shivangani on 15/01/2019.
 */

import org.grails.web.json.JSONObject;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class EmailVaildatorUtils {

    public static boolean isAddressValid(String address, String contract, Integer userId) {

        if (address == null || address.equals("")) {
            return false;
        }
        try{
            String requestUrl="";
            requestUrl = "https://www.b-rent.it/api/app.php";

            String token ="$1$qjox11QF$Vl9zQipQNR0azM6ZFhosv/";
            String mail = address;
            Integer operatoro = 60;
            String contratto = contract;

            JSONObject json = new JSONObject();
            json.put("mail", mail);
            json.put("tok", token);
            if (userId != null && userId != 0) {
                json.put("operatore", userId);
            } else {
                //default scenario
                json.put("operatore", operatoro);
            }

            json.put("contratto", contratto);

            StringBuffer serverUrl = new StringBuffer();
            serverUrl.append(requestUrl);
            URL toGo = new URL(serverUrl.toString());
            HttpURLConnection conn = (HttpURLConnection) toGo.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            bw.write(json.toString());
            bw.close();
            System.out.print("request params:::"+json);
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String result = "";
            String output;
            while ((output = br.readLine()) != null) {
                result += output;
            }
            System.out.print("response:::"+result);
            br.close();
            conn.disconnect();
            JSONObject jobject = new JSONObject(result);
            if (jobject.has("status") && jobject.getBoolean("status")) {
                return true;
            } else {
                if(jobject.has("status") && !jobject.getBoolean("status")){
                    if(jobject.has("messaggio") && jobject.getString("messaggio").equalsIgnoreCase("Mail Non Valida!")){
                        System.out.println("Email is not valid");
                        return false;
                    }  else if(jobject.has("messaggio") && jobject.getString("messaggio").equalsIgnoreCase("Token non Valido!")){
                        System.out.println("Token is not valid");
                        return false;
                    } else {
                        System.out.println("Something went wrong");
                        return false;
                    }
                } else{
                    System.out.println("Something went wrong");
                    return false;
                }

            }
        } catch(Exception ex){
            System.out.println("Something went wrong");
            return false;
        }





//
//        // Find the separator for the domain name
//        int pos = address.indexOf('@');
//        // If the address does not contain an '@', it's not valid
//        if (pos == -1) {
//            return false;
//        }
//        // Isolate the domain/machine name and get a list of mail exchangers
//        String domain = address.substring(++pos);
//        ArrayList mxList = null;
//        try {
//            mxList = getMX(domain);
//        } catch (NamingException ex) {
//            return false;
//        }
//        // Just because we can send mail to the domain, doesn't mean that the
//        // address is valid, but if we can't, it's a sure sign that it isn't
//        if (mxList.size() == 0) {
//            return false;
//        }
//        // Now, do the SMTP validation, try each mail exchanger until we get
//        // a positive acceptance. It *MAY* be possible for one MX to allow
//        // a message [store and forwarder for example] and another [like
//        // the actual mail server] to reject it. This is why we REALLY ought
//        // to take the preference into account.
//        for (int mx = 0; mx < mxList.size(); mx++) {
//            boolean valid = false;
//            try {
//                int res;
//                Socket skt = new Socket((String) mxList.get(mx), 25);
//                BufferedReader rdr = new BufferedReader(new InputStreamReader(skt.getInputStream()));
//                BufferedWriter wtr = new BufferedWriter(new OutputStreamWriter(skt.getOutputStream()));
//                res = hear(rdr);
//                if (res != 220) {
//                    throw new Exception("Invalid header");
//                }
//                say(wtr, "EHLO Test");
//                res = hear(rdr);
//                if (res != 250) {
//                    throw new Exception("Not ESMTP");
//                }
//                // validate the sender address
//                say(wtr, "MAIL FROM: <noreply@dogmasystems.com>");
//                res = hear(rdr);
//                if (res != 250) {
//                    throw new Exception("Sender rejected");
//                }
//                say(wtr, "RCPT TO: <" + address + ">");
//                res = hear(rdr);
//                // be polite
//                say(wtr, "RSET");
//                hear(rdr);
//                say(wtr, "QUIT");
//                hear(rdr);
//                if (res != 250) {
//                    throw new Exception("Address is not valid!");
//                }
//                valid = true;
//                rdr.close();
//                wtr.close();
//                skt.close();
//            } catch (Exception ex) {
//                // Do nothing but try next host
//            } finally {
//                if (valid) {
//                    return true;
//                }
//            }
//        }
//        return false;
    }

//    private static int hear(BufferedReader in) throws IOException {
//        String line = null;
//        int res = 0;
//        while ((line = in.readLine()) != null) {
//            String pfx = line.substring(0, 3);
//            try {
//                res = Integer.parseInt(pfx);
//            } catch (Exception ex) {
//                res = -1;
//            }
//            if (line.charAt(3) != '-') {
//                break;
//            }
//        }
//        return res;
//    }
//
//    private static void say(BufferedWriter wr, String text)
//            throws IOException {
//        wr.write(text + "\r\n");
//        wr.flush();
//        return;
//    }
//
//    private static ArrayList getMX(String hostName)
//            throws NamingException {
//        // Perform a DNS lookup for MX records in the domain
//        Hashtable env = new Hashtable();
//        env.put("java.naming.factory.initial",
//                "com.sun.jndi.dns.DnsContextFactory");
//        DirContext ictx = new InitialDirContext(env);
//        Attributes attrs = ictx.getAttributes(hostName, new String[]{"MX"});
//        Attribute attr = attrs.get("MX");
//        // if we don't have an MX record, try the machine itself
//        if ((attr == null) || (attr.size() == 0)) {
//            attrs = ictx.getAttributes(hostName, new String[]{"A"});
//            attr = attrs.get("A");
//            if (attr == null) {
//                throw new NamingException("No match for name '" + hostName + "'");
//            }
//        }
//        // Huzzah! we have machines to try. Return them as an array list
//        // NOTE: We SHOULD take the preference into account to be absolutely
//        //   correct. This is left as an exercise for anyone who cares.
//        ArrayList res = new ArrayList();
//        NamingEnumeration en = attr.getAll();
//        while (en.hasMore()) {
//            String x = (String) en.next();
//            String f[] = x.split(" ");
//            if (f[1].endsWith(".")) {
//                f[1] = f[1].substring(0, (f[1].length() - 1));
//            }
//            res.add(f[1]);
//        }
//        return res;
//    }

}
