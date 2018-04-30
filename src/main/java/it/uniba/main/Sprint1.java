package it.uniba.main;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import net.lingala.zip4j.core.ZipFile;
//import net.lingala.zip4j.exception.ZipException;
//import net.lingala.zip4j.model.ZipParameters;
//import net.lingala.zip4j.util.Zip4jConstants;

public class Sprint1 {
	
	private ZipFile zip;
	private String namepath="\\"; // = "F:\\\\Workspaces\\\\Java-workspace\\\\allen\\\\resources\\\\";
	Scanner input;
	
	
	public Sprint1() {	
		
	}
	
	
	public Sprint1(String finalpath) {
		namepath = finalpath.concat(namepath);
		try {
			zip = new ZipFile(namepath+"ingsw1718 Slack export Apr 20 2018.zip");
			zip.extractAll(namepath);
		}catch(Exception e) {
			System.out.println("File zip non trovato, riprovare");
			System.exit(1);
		}
	}
	
	void issue1() {
		System.out.println("\n\nLista dei MEMBERS:");
		String path = namepath+"users.json";
		JSONParser parser = new JSONParser();
        {
        	try {
        		 JSONArray a = (JSONArray) parser.parse(new FileReader(path));

        		  for (Object o : a)
        		  {
        		    JSONObject person = (JSONObject) o;

        		    String strFound = (String) person.get("real_name");
        		    System.out.println(strFound );
        		  }
                
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            } catch (ParseException e3) {
                e3.printStackTrace();
            }
        }
	}
	
	void issue2() {
		System.out.println("\n\nLista dei CHANNELS:");
		String path = namepath+"channels.json";
		JSONParser parser = new JSONParser();
        {
        	try {
        		 JSONArray a = (JSONArray) parser.parse(new FileReader(path));

        		  for (Object o : a)
        		  {
        		    JSONObject person = (JSONObject) o;

        		    String strFound = (String) person.get("name");
        		    System.out.println(strFound );
        		  }
                
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            } catch (ParseException e3) {
                e3.printStackTrace();
            }
        }
	}
	
	void issue3() {
		System.out.println("\n\nLista dei MEMBERS raggruppati per CHANNELS:");
		String pathCh = namepath + "channels.json";
		String pathUs = namepath + "users.json";
		JSONParser parser = new JSONParser();
        {
        	try {
        		 JSONArray channels = (JSONArray) parser.parse(new FileReader(pathCh));
        		 JSONArray users = (JSONArray) parser.parse(new FileReader(pathUs));
        		  for (Object objCh : channels)
        		  {
        		    JSONObject personCh = (JSONObject) objCh;
        		    String strFound = (String) personCh.get("name");
        		    System.out.println("\nI membri del gruppo "+strFound.toUpperCase()+" sono: " );
        		    JSONArray b = (JSONArray) personCh.get("members");
        		    for(int i=0; i<b.size(); i++) {
        		    	for(Object objUs : users) {
        		    		JSONObject personUs = (JSONObject) objUs;
        		    		if(b.get(i).toString().equals((String) personUs.get("id")))
        		    			System.out.println((String) personUs.get("real_name"));
            		    }
        		    }
        		  }
                
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            } catch (ParseException e3) {
                e3.printStackTrace();
            }
        }
	}
	
	
	
   void issue4(String findChannel) {
		
		String pathCh = namepath + "channels.json";
		String pathUs = namepath + "users.json";
		JSONParser parser = new JSONParser();
		JSONObject JSONChannel;
		String channel;
//		String channelInput;
		boolean find = false;
    		try {
//    			System.out.println("\n\nImmettere il nome del canale da scegliere ");
//    			input = new Scanner(System.in);
//    			channelInput =  input.nextLine();
    			JSONArray arreyJSONUsers = (JSONArray) parser.parse(new FileReader(pathUs ));
    			JSONArray arreyJSONChannel = (JSONArray) parser.parse(new FileReader(pathCh));
    			for (Object objChannel : arreyJSONChannel ){
    				JSONChannel= (JSONObject) objChannel ;
    				channel =(String) JSONChannel.get("name");
    				if(channel.equals(findChannel)){
    					System.out.println("\nI membri del canale "+findChannel+" sono: " );
    					JSONArray JSONMembers =  (JSONArray) JSONChannel.get("members");
    					for(int i=0; i<JSONMembers.size(); i++) {
    						for(Object objMember : arreyJSONUsers  ){
    							JSONObject personUser = (JSONObject) objMember;
    							if(JSONMembers.get(i).toString().equals((String) personUser.get("id"))){
    								System.out.println((String) personUser.get("real_name"));
    								find = true;
    								break;    								
    							}
    						}
    					}
    				}
    			}
    			if(find == false) {
    				System.out.println("\nNessun membro trovato del canale "+ findChannel);
    			}
    		}
    		catch (FileNotFoundException e1) {
    			e1.printStackTrace();
    			} catch (IOException e2) {
    				e2.printStackTrace();
    				} catch (ParseException e3) {
    					e3.printStackTrace();
    					}
    		}
   
   
   
   void issue5() {
//	   String name;
//	   System.out.println("\nPremere h o H per richiamare l'help ");
//	   input = new Scanner(System.in);
//	   input.hasNextLine();
//	   name = input.nextLine();
//	   if(name.equals("h")||name.equals("H")) {
		   System.out.println("\nQuesto è l'help,tramite il quale è possibile visionare la notazione dei comandi e la loro descrizione."
		     + "\n-issue1 : Questo comando permette di visualizzare l'elenco dei membri della workspace.\n Per eseguirlo inserire da linea di comando: \"nomejar.jar\" issue1 "
			 + "\n-issue2 : questo comando permette di visualizzare l'elenco dei canali della workspace.\n Per eseguirlo inserire da linea di comando: \"nomejar.jar\" issue2"
			 + "\n-issue3 : questo comando permette di visualizzare l'elenco dei membri della workspace raggruppatti per canale.\n Per eseguirlo inserire da linea di comando: \"nomejar.jar\" issue3"
			 + "\n-issue4 : questo comando permette di visualizza di visualizzare i membri di un canale scelto dall'utente.\n Per eseguirlo inserire da linea di comando: \"nomejar.jar\" issue4 \"nomeCanale\""
			 + "\n-issue5 : questo comando permette di visualizzare l'help, una descrizione dettagliata degli altri comandi.\n Per eseguirlo inserire da linea di comando: \"nomejar.jar\""
			 + "\nN.B.: I comandi devono essere inseriti in minuscolo senza il trattino");
//	   }else {
//		   System.out.println("Pulsante digitato errato.");
//	   }
//	   input.close();
	}
   }

