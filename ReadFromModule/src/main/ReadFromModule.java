package main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import com.fazecast.jSerialComm.SerialPort;

public class ReadFromModule
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int numberOfModules = 2;
		Module arduinoModule = new Module();
		Module dbModule = new Module();
		StringBuilder concatenatedData = new StringBuilder();
		ArrayList<Module> modulesRecieved = new ArrayList<Module>();
		ArrayList<Module> modulesFromDB = new ArrayList<Module>();

		// SerialPort.getCommPorts() returneaza toate porturile seriale de pe
		// calcullator
		for (SerialPort x : SerialPort.getCommPorts()) // itereaza printre porturile seriale returnate
		{
			if (x.getSystemPortName().equals("COM2")) // verifica daca portul din momentul de fata este COM2
			{
				x.openPort(); // il deschide pentru a comunica pe el
				while (modulesRecieved.size() < numberOfModules) // cat timp nu am primit cele 2 seturi/module de la
																	// Arduino
				{
					// System.out.println(modulesRecieved.size());
					byte[] buffer = new byte[1024]; // initializez buffer ul

					// se initializeaza variabila "len" cu o valoare foarte mica
					int len = -1;
					try
					{
						try
						{
							// variabila in este folosita pentru a se citi ce se primeste pe seriala
							InputStream in = x.getInputStream();
							// aceasta bucla ruleaza la infinit sau pana cand se ajunge la comanda break
							while ((len = in.read(buffer)) > -1)
							{
								// daca am ajuns la numarul dorit de module primite de la arduino, parasim bucla
								// while
								if (modulesRecieved.size() >= numberOfModules)
								{
									break;
								}
								// in recievedData se pune byte ul primit pe seriala convertit in string
								String recievedData = new String(buffer, 0, len);
								// daca am primit caracterul "!" de la arduino, atunci s-au primit toate datele
								// modulului
								if (recievedData.equals("!"))
								{
									// concatenatedData este un obiect de tip StringBuilder in care se pun toti
									// bytii primiti de la arduino
									// Aici se imparte in substringuri in functie de caracterul "-"
									String[] splitData = concatenatedData.toString().split("-");
									// se itereaza printre aceste substringuri
									for (String splitString : splitData)
									{
										// fiecare substring este impartit la randul lui in alte stringuri mai mici in
										// functie de ": "
										// se verifiaca carui atribut al modulului corespunde fiecare String
										// apoi atributului corespunzator din arduinoModule i se da valoarea din al doilea string
										String[] splitLine = splitString.split(": ");
										if (splitLine[0].equals("ModuleName"))
										{
											System.out.print(splitLine[1]);
											arduinoModule.setModuleName(splitLine[1]);
										} else if (splitLine[0].equals("ModuleID"))
										{
											arduinoModule.setModuleID(splitLine[1]);
										} else if (splitLine[0].equals("ResistorID"))
										{
											arduinoModule.setResistorID(splitLine[1]);
										} else if (splitLine[0].equals("QtyResistor"))
										{
											arduinoModule.setQtyResistor(splitLine[1]);
										} else if (splitLine[0].equals("CapacitorID"))
										{
											arduinoModule.setCapacitorID(splitLine[1]);
										} else if (splitLine[0].equals("QtyCapacitor"))
										{
											// in momentul in care se ajunge la acest else if, s-au adaugat toate
											// atributele lui arduinoModule
											// se adauga arduinoModule in ArrayList-ul nostru de module
											arduinoModule.setQtyCapacitor(splitLine[1]);
											modulesRecieved.add(arduinoModule);
											// se printeaza in consola dimensiunea curenta a ArrayList-ului
											System.out.println(modulesRecieved.size());
										}
									}
									// se reinitializeaza StringBuilder-ul si arduinoModule
									concatenatedData = new StringBuilder();
									arduinoModule = new Module();

								} else
								{
									// adauga fiecare byte primit pe seriala la un obiect StringBuilder
									concatenatedData.append(recievedData);
									System.out.println(concatenatedData.toString());
								}
							}
							System.out.println("Buffer was read!");

						} catch (com.fazecast.jSerialComm.SerialPortTimeoutException e)
						{
							// System.out.println("No data recieved! \n");
						}
					} catch (Exception e)
					{
						e.printStackTrace();
					}
				}
				System.out.println("Port was closed!");
				// se inchide portul de comunicatie
				x.closePort();

			}
		}

		try

		{

			// se citeste din fisier
			File myObj = new File("inputDB");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine())
			{
				String data = myReader.nextLine();
				String[] splitDBData = data.split(": "); //
				// System.out.println(splitDBData[splitDBData.length - 1]);
				if (splitDBData[0].equals("ModuleName"))
				{
					System.out.print(splitDBData[1]);
					dbModule.setModuleName(splitDBData[1]);
				} else if (splitDBData[0].equals("ModuleID"))
				{
					dbModule.setModuleID(splitDBData[1]);
				} else if (splitDBData[0].equals("ResistorID"))
				{
					dbModule.setResistorID(splitDBData[1]);
				} else if (splitDBData[0].equals("QtyResistor"))
				{
					dbModule.setQtyResistor(splitDBData[1]);
				} else if (splitDBData[0].equals("CapacitorID"))
				{
					dbModule.setCapacitorID(splitDBData[1]);
				} else if (splitDBData[0].equals("QtyCapacitor"))
				{
					dbModule.setQtyCapacitor(splitDBData[1]);
					modulesFromDB.add(dbModule);
					dbModule = new Module();
					System.out.println(modulesFromDB.size());
				}
			}
			myReader.close();
		} catch (Exception e)
		{
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		//compararea datelor
		for (Module x : modulesRecieved)
		{
			// System.out.println(x.toString());
			for (Module y : modulesFromDB)
			{
				// System.out.println(x.toString());
				if (x.getModuleID().equals(y.getModuleID()))
				{
					if (x.getQtyResistor().equals(y.getQtyResistor()))
					{
						System.out.println("Module" + x.getModuleID() + " has no faulty resistor!");
					} else
					{
						System.out.println("Module" + x.getModuleID() + " is faulty! Resistors broken!");
					}

					if (x.getQtyCapacitor().equals(y.getQtyCapacitor()))
					{
						System.out.println("Module" + x.getModuleID() + " has no faulty capacitor!");
					} else
					{
						System.out.println("Module" + x.getModuleID() + " is faulty! Capacitors broken!");
					}
				}
			}
		}
	}
}
